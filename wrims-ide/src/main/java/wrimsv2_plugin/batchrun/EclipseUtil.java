package wrimsv2_plugin.batchrun;

import java.io.File;
import java.util.Objects;

public class EclipseUtil {

    private static String cachedJrePath = null;

    public static String getJreRelativePath() {
        // Cached value
        if (cachedJrePath != null) {
            return cachedJrePath;
        }
        File pluginsFolder = new File(System.getProperty("user.dir"), "plugins");
        if (pluginsFolder.isDirectory()) {
            for (File file : Objects.requireNonNull(pluginsFolder.listFiles())) {
                if (file.isDirectory() && file.getName().contains("jre.full")) {
                    cachedJrePath = "plugins\\" + file.getName() + "\\jre";
                    return cachedJrePath;
                }
            }
        }
        cachedJrePath = "jre";
        return cachedJrePath;
    }
}
