package org.example;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class DirectoryWatcher {
    private final File file;
    private Document[] documents;
    private int size;
    public DirectoryWatcher(String path) {
        file = new File(path);
        size = 0;
        documents = new Document[100];
        GetFiles(file);
        SortDocuments sortDocuments = new SortDocuments(documents);
        documents = sortDocuments.ReturnSorted();
        for (int i = 0; i < size; ++i) {
            System.out.println(documents[0].GetContents());
        }
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
            documents[size] = new Document(entry);
            size++;
        }
    }
}
