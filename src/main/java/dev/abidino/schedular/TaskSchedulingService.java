package dev.abidino.schedular;

import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import java.util.TimeZone;

@Service
public record TaskSchedulingService(TaskScheduler taskScheduler) implements TaskService {
    @Override
    public void schedule(TaskDefinition taskDefinition, Runnable runnable) {
        CronTrigger cronTrigger = new CronTrigger(taskDefinition.cronExpression(), TimeZone.getTimeZone(TimeZone.getDefault().getID()));
        taskScheduler.schedule(runnable, cronTrigger);
    }
}
