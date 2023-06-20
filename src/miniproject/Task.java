package miniproject;

import java.time.LocalDate;

public class Task {
    LocalDate taskDate;
    String taskDetails;

    public Task() {
    }

    public Task(LocalDate taskDate, String taskDetails) {
        this.taskDate = taskDate;
        this.taskDetails = taskDetails;
    }

    @Override
    public String toString() {
        return "Task[" +
                "taskDate=" + taskDate +
                ", taskDetails='" + taskDetails + '\'' +
                "]\n";
    }

    public LocalDate getTaskDate() {
        return taskDate;
    }

    public String getTaskDetails() {
        return taskDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Task)) return false;
        Task task = (Task) o;
        return task.getTaskDate().equals(this.getTaskDate()) && task.getTaskDetails().equals(this.getTaskDetails());
    }
}
