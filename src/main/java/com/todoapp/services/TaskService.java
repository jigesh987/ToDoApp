package com.todoapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todoapp.entity.Task;
import com.todoapp.entity.User;
import com.todoapp.repositories.TaskRepo;
import com.todoapp.repositories.UserRepo;

@Service
public class TaskService {

    @Autowired
    private TaskRepo taskRepo;

    @Autowired
    private UserRepo userRepo;
    
    

    // Add Task
    public String addTask(Long userId, Task task) {
       Optional<User> user=userRepo.findById(userId);
        if(user.isEmpty()) {
        	return " no user found";
        }
        User new_user=user.get();
        task.setUser(new_user);
        taskRepo.save(task);
        return "Task added successfully for user"+userId;
        
    }

    // Get All Tasks for a User
    public List<Task> getTaskByUserId(Long userId) {
        return taskRepo.findByUserId(userId);
    }

    
}






//Mark Task as Completed
/*public boolean markTaskComplete(Long taskId) {
    Optional<Task> taskOpt = taskRepo.findById(taskId);
    if (taskOpt.isPresent()) {
        Task task = taskOpt.get();
        task.setComplete(true);
        taskRepo.save(task);
        return true;
    } else {
        return false; // Task not found
    }
}*/

/*// Delete Task
public boolean deleteTask(Long taskId) {
    Optional<Task> taskOpt = taskRepo.findById(taskId);
    if (taskOpt.isPresent()) {
        taskRepo.deleteById(taskId);
        return true;
    } else {
        return false; // Task not found
       }
    }*/