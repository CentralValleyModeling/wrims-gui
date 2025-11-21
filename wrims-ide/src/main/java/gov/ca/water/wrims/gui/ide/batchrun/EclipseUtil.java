package gov.ca.water.wrims.gui.ide.batchrun;

import java.io.File;
import java.nio.file.Path;
import java.util.Objects;

public class EclipseUtil {

    private static Path cachedJrePath = null;

    public static Path getJreRelativePath() {
        // Cached value
        if (cachedJrePath != null) {
            return cachedJrePath;
        }
        File pluginsFolder = new File(System.getProperty("user.dir"), "plugins");
        if (pluginsFolder.isDirectory()) {
            for (File file : Objects.requireNonNull(pluginsFolder.listFiles())) {
                if (file.isDirectory() && file.getName().contains("jre.full")) {
                    cachedJrePath = pluginsFolder.toPath().resolve(file.getName()).resolve("jre");
                    return cachedJrePath;
                }
            }
        }
        cachedJrePath = new File("jre").toPath();
        return cachedJrePath;
    }
}
