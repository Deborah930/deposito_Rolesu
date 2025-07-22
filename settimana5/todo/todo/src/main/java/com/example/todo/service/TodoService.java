package com.example.todo.service;


import com.example.todo.model.Todo;
import com.example.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

private final TodoRepository todoRepository;

public List<Todo> findAll() {
return todoRepository.findAll();
}

public List<Todo> findByUtenteId(Long utenteId) {
return todoRepository.findByUtenteId(utenteId);
}

public Todo findById(Long id) {
return todoRepository.findById(id).orElseThrow(() -> new RuntimeException("Todo non trovato"));
}

public Todo save(Todo todo) {
return todoRepository.save(todo);
}

public void delete(Long id) {
todoRepository.deleteById(id);
}
}