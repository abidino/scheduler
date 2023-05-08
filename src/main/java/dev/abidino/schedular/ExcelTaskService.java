package dev.abidino.schedular;

public record ExcelTaskService(TaskDefinition taskDefinition) implements Runnable {

    @Override
    public void run() {
        System.out.println("Excel schedule is running : " + taskDefinition.data());
    }
}
