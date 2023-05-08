package dev.abidino.schedular;

public record PdfTaskService(TaskDefinition taskDefinition) implements Runnable {

    @Override
    public void run() {
        System.out.println("Pdf schedule is running : " + taskDefinition.data());
    }
}
