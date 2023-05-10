package dev.abidino.scheduler.business;

import java.util.List;

public interface TaskService {
    void save(TaskDefinition taskDefinition);

    void update(TaskDefinition taskDefinition, Long id);

    List<TaskDefinition> findAll();

    void delete(Long id);
}
