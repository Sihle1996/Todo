package com.groupD.demo.service;

import com.groupD.demo.entity.Todo;
import com.groupD.demo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService{

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public List<Todo> getAllTodo() {
        return todoRepository.findAll();
    }

    @Override
    public void saveTodo(Todo todo) {
      this.todoRepository.save(todo);
    }

    @Override
    public void updateTodo(Long id, Todo todo) {
       Todo todoFromDb = todoRepository.findById(id).get();
       todoFromDb.setTaskName(todo.getTaskName());
       todoFromDb.setDescription(todo.getDescription());
       todoRepository.save(todoFromDb);
    }

    @Override
    public Todo getTodoById(Long id) {
        Optional<Todo> Optional = todoRepository.findById(id);
        Todo todo;

        if (Optional.isPresent()) {
            todo = Optional.get();
        }else {
            throw new RuntimeException("Todo id" + id + "is not Found");
        }
        return todo;
    }

    @Override
    public void DeleteTodo(Long id) {
       this.todoRepository.deleteById(id);
    }
}
