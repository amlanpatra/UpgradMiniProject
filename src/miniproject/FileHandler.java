package miniproject;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.nio.file.Files;

public class FileHandler {
    String filePath;
    String fileContents;

    public FileHandler() {
    }

    public FileHandler(String taskFilePath) {
        this.filePath = filePath;
    }

    public void writeToFile(List<Task> tasks) {
//        2023-01-01='this is the task'\n   // format
        StringBuilder sb = new StringBuilder();
        for (Task t : tasks) {
            sb.append(t.getTaskDate()).append("=").append(t.getTaskDetails()).append('\n');
        }

        // Try block to check for exceptions
        try {
            System.out.println("Filepath : " + this.filePath);
            Path p = Paths.get(filePath);
            System.out.println("Path is " + p);
            Files.write(p, sb.toString().getBytes());
        } catch (Exception ex) {
            System.out.print("Exception : " + ex.getCause() + " " + ex.getMessage());
        }
    }

    public String getFileContents() {
        return fileContents;
    }

    public void setFileContents(String fileContents) {
        this.fileContents = fileContents;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    private void loadFileAsString() {

        if (this.filePath == null || this.filePath.isEmpty()) return;

        String fContents = null;
        try (FileInputStream fis = new FileInputStream(this.filePath)) {
            byte[] bytes = new byte[fis.available()];
            System.out.println("Size " + fis.read(bytes));
            fContents = new String(bytes);
            System.out.println(fContents);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        this.fileContents = fContents;
//
        if (this.fileContents == null || this.fileContents.isEmpty()) {
            System.out.println("file is empty");
        }
    }
}
