package org.example;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = "com";
        while (!Objects.equals(command, "exit")) {
            System.out.println("Enter directory full path");
            String directoryPath = scanner.nextLine();
            DirectoryWatcher directoryWatcher = new DirectoryWatcher(directoryPath);
            System.out.println("Enter 'exit' to finish, other to continue");
            command = scanner.nextLine();
        }

    }
}