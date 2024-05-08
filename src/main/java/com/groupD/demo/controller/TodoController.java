package com.groupD.demo.controller;

import com.groupD.demo.entity.Todo;
import com.groupD.demo.service.TodoService;
import com.groupD.demo.service.TodoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todo")
public class TodoController {

    @Autowired
    private TodoServiceImpl todoService;

    @GetMapping("/{id}")
    public List<Todo> findAll() {
        return todoService.getAllTodo();
    }

    @PostMapping
    public Todo findOne(@PathVariable Long id, @RequestBody Long) {
       return todoService.getTodoById(id);
    }

    @PutMapping("/{id}")
    public void updateTodo(@PathVariable Long id, @RequestBody Todo todo){
        this.todoService.updateTodo(id, todo);
    }

    @DeleteMapping("/{id}")
    public void DeleteTodo(@PathVariable Long id) {
        this.todoService.DeleteTodo(id);
    }
}
