package mapper;

import com.example.todo.model.Todo;
import com.example.todo.model.TodoDTO;
import com.example.todo.model.Utente;
import com.example.todo.model.UtenteDTO;

public class TodoMapper {
    public static TodoDTO toDTO(Todo todo) {
        return TodoDTO.builder()
                .id(todo.getId())
                .descrizione(todo.getDescrizione())
                .completato(todo.isCompletato())
                .utenteId(todo.getUtente().getId())
                .build();
    }

    public static Todo toEntity(TodoDTO dto, Utente utente) {
        return Todo.builder()
                .id(dto.getId())
                .descrizione(dto.getDescrizione())
                .completato(dto.isCompletato())
                .utente(utente)
                .build();
    }
}
