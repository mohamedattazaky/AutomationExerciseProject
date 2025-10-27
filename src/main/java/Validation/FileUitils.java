package Validation;

import logs.LogsManager;
import org.apache.commons.io.FileUtils;
import java.io.File;

public class FileUitils {
    private static final String USER_DIR = System.getProperty("user.dir") + File.separator;

    public static void cleanfile(File file) {
        try {
            FileUtils.deleteQuietly(file);
        } catch (Exception e) {
            LogsManager.error("failed to clean");
        }
    }

    public static void createdirectory(String path) {
        try {
            File file = new File(USER_DIR + path);
            if (!file.exists()) {
                file.mkdirs();
                LogsManager.info("CRETED FILE");
            }
        } catch (Exception e) {
            LogsManager.error("Failed to create");
        }
    }

    public static void renameFile(String oldname, String newname) {
        try {
            File oldfile = new File(USER_DIR + oldname);
            File namefile = new File(USER_DIR + newname);
            if (oldfile.renameTo(namefile)){LogsManager.info("Renamed Success");}
            else {LogsManager.error("failed to rename");}
        } catch (Exception e) {
            LogsManager.error("failed to rename");
        }
    }
}