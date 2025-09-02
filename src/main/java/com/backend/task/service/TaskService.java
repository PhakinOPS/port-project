package com.backend.task.service;

import com.backend.task.entity.Task;
import com.backend.task.repository.TaskRepository;
import com.backend.task.specification.TaskSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    // Create
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    // Read (with Pagination + Filtering)
    public Page<Task> getTasks(String status, String keyword,
                               int page, int size,
                               String sortBy, String sortDirection) {
        //ระบุว่า sort แบบใด
        Sort.Direction direction = sortDirection.equalsIgnoreCase("desc") ?
                Sort.Direction.DESC : Sort.Direction.ASC;

        Specification<Task> spec = TaskSpecification.hasStatus(status)
                .and(TaskSpecification.titleContains(keyword));


        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortBy));

        return taskRepository.findAll(spec, pageable);
    }

    // Read by ID
    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    // Update
    public Optional<Task> updateTask(Long id, Task updatedTask) {
        return taskRepository.findById(id).map(task -> {
            task.setTitle(updatedTask.getTitle());
            task.setStatus(updatedTask.getStatus());
            return taskRepository.save(task);
        });
    }

    // Delete
    public boolean deleteTask(Long id) {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
