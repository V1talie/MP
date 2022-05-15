package mediaplayer;

import java.io.File;

public class getExtension {
    public static String getFileExtension(String fullName) {
        checkNotNull(fullName);
        String fileName = new File(fullName).getName();
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
    }

    private static void checkNotNull(String fullName) {
        if (fullName == null) {
            throw new NullPointerException("fullName");
        }
    }
}
