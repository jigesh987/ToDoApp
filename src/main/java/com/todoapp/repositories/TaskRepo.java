package com.todoapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todoapp.entity.Task;

@Repository
public interface TaskRepo extends JpaRepository<Task, Long>{
	List<Task> findByUserId(long user_id);
}
