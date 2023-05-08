package dev.abidino.schedular;

import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TimeZone;
import java.util.concurrent.ScheduledFuture;

@Service
public record TaskServiceImpl(TaskScheduler taskScheduler) implements TaskService {

    private static Map<String,ScheduledFuture<?>> taskMap = new HashMap<>();

    @Override
    public void addTask(TaskDefinition taskDefinition, Runnable runnable) {
        CronTrigger cronTrigger = new CronTrigger(taskDefinition.cronExpression(), TimeZone.getTimeZone(TimeZone.getDefault().getID()));
        ScheduledFuture<?> schedule = taskScheduler.schedule(runnable, cronTrigger);
        taskMap.put(taskDefinition.id(), schedule);
    }
    @Override
    public void removeTask(String taskId){
        ScheduledFuture<?> scheduledFuture = taskMap.get(taskId);
        if (Objects.nonNull(scheduledFuture)){
            scheduledFuture.cancel(true);
            taskMap.remove(taskId);
        }
    }
}
