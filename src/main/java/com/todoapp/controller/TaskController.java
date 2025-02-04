package com.todoapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.todoapp.entity.Task;
import com.todoapp.services.TaskService;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;
    

    @PostMapping("/addTask")
    public String addTask(@RequestParam Long userid,@RequestBody Task task) {
    	return taskService.addTask(userid, task);
    }

   
    @GetMapping("/user/{userId}")
    public List<Task> getTask(@PathVariable Long userId) {
        List<Task> task= taskService.getTaskByUserId(userId);
        return task;
    }


}

//Mark Task as Completed
/* @PostMapping("/{taskId}/complete")
 public String markTaskComplete(@PathVariable Long taskId, HttpSession session) {
     taskService.markTaskComplete(taskId);
     
     Long userId = (Long) session.getAttribute("userId"); // Get logged-in user ID
     return "redirect:/task/user/" + userId; // Redirect back to profile page
 }*/

 /*// Delete Task
 @PostMapping("/{taskId}/delete")
 public String deleteTask(@PathVariable Long taskId, HttpSession session) {
     taskService.deleteTask(taskId);
     
     Long userId = (Long) session.getAttribute("userId"); // Get logged-in user ID
     return "redirect:/task/user/" + userId; // Redirect back to profile page
    }*/