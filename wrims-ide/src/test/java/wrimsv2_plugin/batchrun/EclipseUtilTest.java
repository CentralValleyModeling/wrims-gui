package wrimsv2_plugin.batchrun;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

public class EclipseUtilTest {

    @TempDir
    Path tempDir;

    private String originalUserDir;

    @BeforeEach
    void setUp() throws Exception {
        // Save and override user.dir for deterministic behavior
        originalUserDir = System.getProperty("user.dir");
        System.setProperty("user.dir", tempDir.toString());
        // Reset cachedJrePath between tests
        resetCache();
    }

    @AfterEach
    void tearDown() throws Exception {
        // Restore user.dir and clear cache to avoid cross-test contamination
        System.setProperty("user.dir", originalUserDir);
        resetCache();
    }

    private static void resetCache() {
        try {
            Field f = EclipseUtil.class.getDeclaredField("cachedJrePath");
            f.setAccessible(true);
            f.set(null, null);
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void returnsPluginsJrePathWhenJreFullPresent() throws IOException {
        // Arrange: create plugins/<something with jre.full>/jre
        Path plugins = tempDir.resolve("plugins");
        Path jreFullDir = plugins.resolve("org.vendor.jre.full.win32.x86_64");
        Path jreDir = jreFullDir.resolve("jre");
        Files.createDirectories(jreDir);

        // Act
        Path result = EclipseUtil.getJreRelativePath();

        // Assert
        assertEquals(jreDir, result, "Should return plugins/<jre.full>/jre path");

        // Also ensure caching returns the same instance on subsequent calls
        Path result2 = EclipseUtil.getJreRelativePath();
        assertSame(result, result2, "Expected cached Path instance to be returned on second call");
    }

    @Test
    void returnsRelativeJreWhenNoPluginsOrNoMatch() throws IOException {
        // No plugins directory created

        Path resultNoPlugins = EclipseUtil.getJreRelativePath();
        assertFalse(resultNoPlugins.isAbsolute(), "Expected relative path when no plugins folder");
        assertEquals("jre", resultNoPlugins.toString(), "Expected relative 'jre' path when no plugins folder");

        // Reset cache and create empty plugins directory (no jre.full)
        resetCache();
        Files.createDirectories(tempDir.resolve("plugins"));

        Path resultEmptyPlugins = EclipseUtil.getJreRelativePath();
        assertFalse(resultEmptyPlugins.isAbsolute(), "Expected relative path when plugins folder has no jre.full");
        assertEquals("jre", resultEmptyPlugins.toString(), "Expected relative 'jre' path when no jre.full directory is present");
    }

    @Test
    void cachePersistsAcrossUserDirChangeUntilReset() throws Exception {
        // Arrange first user.dir with matching structure
        Path plugins = tempDir.resolve("plugins");
        Path jreFullDir = plugins.resolve("org.vendor.jre.full.win32.x86_64");
        Path jreDir = jreFullDir.resolve("jre");
        Files.createDirectories(jreDir);

        Path first = EclipseUtil.getJreRelativePath();
        assertEquals(jreDir, first);

        // Change user.dir to a new temp
        Path otherRoot = Files.createTempDirectory("userDirChangeTest");
        try {
            System.setProperty("user.dir", otherRoot.toString());

            // Even after changing user.dir, the cached path should be returned
            Path second = EclipseUtil.getJreRelativePath();
            assertSame(first, second, "Cached path should be returned despite user.dir change");
        } finally {
            // Cleanup and restore
            System.setProperty("user.dir", tempDir.toString());
            Files.walk(otherRoot)
                 .sorted((a,b) -> b.getNameCount() - a.getNameCount())
                 .forEach(p -> {
                     try { Files.deleteIfExists(p); } catch (IOException ignored) {}
                 });
        }
    }
}
