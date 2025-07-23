package mapper;

import com.example.todo.model.Utente;
import com.example.todo.model.UtenteDTO;

public class UtenteMapper {
    public static UtenteDTO toDTO(Utente utente) {
        return UtenteDTO.builder()
                .id(utente.getId())
                .nome(utente.getNome())
                .todoList(
                    utente.getTodoList().stream()
                        .map(TodoMapper::toDTO)
                        .toList()
                )
                .build();
    }
}
