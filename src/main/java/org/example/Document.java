package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Document {
    public Document(File file) {
        this.file = file;
        fullPath = file.getAbsolutePath();
        FindParent();
    }
    private File file;
    private String fullPath;
    private String contents;
    private String parentFullPath;
    public String GetContents() {
        return contents;
    }
    public String GetElem() {
        return fullPath;
    }
    public String GetParent () {
        return parentFullPath;
    }
    private void FindParent() {
        try {
            Scanner scanner = new Scanner(file);
            String line;
            while (true) {
                try {
                    line = scanner.nextLine();
                } catch (NoSuchElementException ex) {
                    break;
                }
                if (line.substring(0, 7).equals("require")) {
                    parentFullPath = line.substring(8, line.length()-2);
                }
                contents += line;
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Problems with file access");
        }

    }
}
