package com.hamza.bitma.util;

import java.nio.file.Path;
import java.nio.file.Paths;

public final class FileUtil {

    private FileUtil(){

    }
    public static final String folderPath =  "uploads//";
    public static final Path filePath = Paths.get(folderPath);

    public static String getExtension(String originalFilename) {
        return originalFilename.substring(originalFilename.lastIndexOf("."));
    }
}
