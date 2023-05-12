package dev.abidino.scheduler.data;

import dev.abidino.scheduler.business.TaskStatus;
import dev.abidino.scheduler.data.repo.TaskDefinitionEntity;

import java.util.List;

public interface DataService {
    TaskDefinitionEntity save(TaskDefinitionEntity taskDefinition);

    void update(TaskDefinitionEntity taskDefinition, Long id);

    boolean existById(Long id);

    TaskDefinitionEntity findById(Long id);

    List<TaskDefinitionEntity> findAll();

    List<TaskDefinitionEntity> findAllByTaskStatus(TaskStatus taskStatus);

    void delete(Long id);
}
