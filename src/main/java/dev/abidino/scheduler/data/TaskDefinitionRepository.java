package dev.abidino.scheduler.data;

import dev.abidino.scheduler.business.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskDefinitionRepository extends JpaRepository<TaskDefinitionEntity, Long> {
    boolean existsById(Long id);

    List<TaskDefinitionEntity> findAllByTaskStatus(TaskStatus taskStatus);
}
