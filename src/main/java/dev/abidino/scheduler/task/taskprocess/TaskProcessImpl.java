package dev.abidino.scheduler.task.taskprocess;

import dev.abidino.scheduler.business.TaskDefinition;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TimeZone;
import java.util.concurrent.ScheduledFuture;

@Service
record TaskProcessImpl(TaskScheduler taskScheduler) implements TaskProcess {

    private static Map<Long, ScheduledFuture<?>> taskMap = new HashMap<>();

    @Override
    public void addTask(TaskDefinition taskDefinition, Runnable runnable) {
        CronTrigger cronTrigger = new CronTrigger(taskDefinition.cronExpression(), TimeZone.getTimeZone(TimeZone.getDefault().getID()));
        ScheduledFuture<?> schedule = taskScheduler.schedule(runnable, cronTrigger);
        if (Objects.isNull(taskDefinition.id())) {
            throw new IllegalArgumentException("Id must be not null");
        }
        taskMap.put(taskDefinition.id(), schedule);
    }

    @Override
    public void removeTask(Long taskId) {
        ScheduledFuture<?> scheduledFuture = taskMap.get(taskId);
        if (Objects.nonNull(scheduledFuture)) {
            scheduledFuture.cancel(true);
            taskMap.remove(taskId);
        }
    }
}
