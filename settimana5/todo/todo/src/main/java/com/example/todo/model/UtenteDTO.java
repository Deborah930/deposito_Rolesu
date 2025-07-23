package com.example.todo.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UtenteDTO {
    private Long id;
    private String nome;
    private List<TodoDTO> todoList;
}
