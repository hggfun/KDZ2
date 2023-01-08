package org.example;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class DirectoryWatcher {
    private final File file;
    private Document[] documents;
    public DirectoryWatcher(String path) {
        file = new File(path);
        GetFiles(file);
    }
    private void GetFiles(File file) {
        File[] directoryContents = file.listFiles();
        for (File entry : directoryContents)
        {
            if (entry.isDirectory())
            {
                GetFiles(entry);
                continue;
            }
            try {
                Scanner scanner = new Scanner(entry);
                String contents = scanner.
            } catch (java.io.FileNotFoundException fileNotFoundException) {
                System.out.println("Po idee takoe ne dolzhno vipadat");
            }
        }
    }
}
