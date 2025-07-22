package com.example.todo.repository;

import com.example.todo.model.Commento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentoRepository extends JpaRepository<Commento, Long> {
List<Commento> findByTodoId(Long todoId);
}