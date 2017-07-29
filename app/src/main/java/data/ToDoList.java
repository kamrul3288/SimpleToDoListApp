package data;
public class ToDoList {

    private String taskName;
    private String taskDescription;
    private String timeAndDateText;
    private String taskHintText;

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getTimeAndDateText() {
        return timeAndDateText;
    }

    public void setTimeAndDateText(String timeAndDateText) {
        this.timeAndDateText = timeAndDateText;
    }

    public String getTaskHintText() {
        return taskHintText;
    }

    public void setTaskHintText(String taskHintText) {
        this.taskHintText = taskHintText;
    }
}
