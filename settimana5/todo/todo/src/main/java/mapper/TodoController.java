package mapper;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.todo.model.Todo;
import com.example.todo.model.TodoDTO;
import com.example.todo.model.Utente;
import com.example.todo.repository.*;

public class TodoController {
    @PostMapping
public ResponseEntity<TodoDTO> createTodo(@RequestBody TodoDTO todoDTO) {
    Utente utente = utenteRepository.findById(todoDTO.getUtenteId())
                        .orElseThrow();
    Todo todo = TodoMapper.toEntity(todoDTO, utente);
    Todo saved = todoService.save(todo);
    return ResponseEntity.ok(TodoMapper.toDTO(saved));
}
}
