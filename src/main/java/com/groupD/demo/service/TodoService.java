package com.groupD.demo.service;

import com.groupD.demo.entity.Todo;

import java.util.List;

public interface TodoService {

    List<Todo> getAllTodo();

    void saveTodo(Todo todo);

    void updateTodo(Long id, Todo todo);

    Todo getTodoById(Long id);

    void DeleteTodo(Long id);





}
