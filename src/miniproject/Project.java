package miniproject;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class Project {

    List<Task> tasks;
    String filePath;
    // = "D:\\OneDrive\\OneDrive - nucleusonline\\Desktop\\miniProjectUpgr\\UpgradMiniProject\\src\\miniproject\\savedTasks.txt";

    public Project() {

//            this.filePath = Paths.get(new java.io.File(".").getCanonicalPath().toString(), "miniproject", "savedTasks.txt").toString();
        this.filePath = "savedTasks.txt";
        tasks = new ArrayList<>();

    }

    public static void main(String[] args) {
        Project p = new Project();
        p.run();
    }

    public void run() {
        readListFromFile();
        boolean runProgram = true;
        while (runProgram) {
            homeScreen();
            String input = new java.util.Scanner(System.in).next();
            switch (input) {
                case "1":
                    process1();
                    break;
                case "2":
                    process2();
                    break;
                case "3":
                    process3();
                    break;
                case "4":
                    process4();
                    break;
                case "5":
                    runProgram = false;
                    break;

                default:
                    System.out.println("Invalid Response. Please try again");
                    break;
            }
            writeToFile();
        }
    }

    public void homeScreen() {
        System.out.print("Menu\n1. Add Note\n2. Show Note\n3.Print Calendar\n4. Find out the day\n5. Exit\nEnter your choice : ");
    }

    //    add a note
    public void process1() {
        LocalDate ld = getDateFromUser();
        if (ld == null) return;

        System.out.println("Enter the note : ");
        String msg = new java.util.Scanner(System.in).nextLine();
        this.tasks.add(new Task(ld, msg));
        System.out.println("Task added successfully\n");
    }

    //    show notes of a particular date
    public void process2() {
        LocalDate ld = getDateFromUser();
        if (ld == null) return;

        StringBuilder results = new StringBuilder();
        for (Task t : tasks) {
            if (t.getTaskDate().equals(ld)) {
                results.append(t.getTaskDetails()).append("\n");
            }
        }
        System.out.println(results);
    }

    //    show full year
    public void process3() {
        System.out.print("Enter year : ");
        Cal.showYearlyCalendar(Integer.parseInt(new java.util.Scanner(System.in).next()));
    }

    //    show day of week
    public void process4() {
        LocalDate ld = getDateFromUser();
        System.out.println("The day is  : " + ld.getDayOfWeek());
    }

    public LocalDate getDateFromUser() {

        System.out.print("Enter the year : ");
        String year = new java.util.Scanner(System.in).next();
        System.out.print("Enter the date : ");
        String date = new java.util.Scanner(System.in).next();
        date = date.length() == 1 ? ("0" + date) : date;
        System.out.print("Enter the month : ");
        String month = new java.util.Scanner(System.in).next();
        month = month.length() == 1 ? ("0" + month) : month;

        try {
            return LocalDate.parse(new String(year + "-" + month + "-" + date));
        } catch (DateTimeParseException dex) {
            System.out.println(dex.getMessage());
        }
        return null;
    }

    public void writeToFile() {
        StringBuilder sb = new StringBuilder();
        for (Task t : tasks) {
            sb.append(t.getTaskDate()).append("=").append(t.getTaskDetails()).append("\n");
        }
        try (PrintWriter out = new PrintWriter(this.filePath)) {
            out.println(sb.toString());
        } catch (FileNotFoundException fe) {
            System.out.println("File not found, " + fe.getMessage());
        }
    }

    public void readListFromFile() {

        try {
            File file = new File(this.filePath);
            if (!file.exists()) {
                System.out.println("File doesn't exist");
                System.out.println("New file being created : " + file.createNewFile());
                return;
            } else {
//                System.out.println("File exists");
            }
//            System.out.println("line 136");
            Path path = Paths.get(this.filePath);
//            System.out.println("line 137");
            List contents = Files.readAllLines(path);

            for (Object content : contents) {
                String t = content.toString();
                String stringTask[] = t.trim().split("=");
//                System.out.println(stringTask[0] + " " + stringTask[1]);
                this.tasks.add(new Task(LocalDate.parse(stringTask[0].trim()), stringTask[1]));
            }

        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//            ex.printStackTrace();
        }
    }
}
