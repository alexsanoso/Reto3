package com.reto3.repository;

// Importaciones
import com.reto3.modelo.Message;
import com.reto3.repository.crud.MessageCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Alexander Sánchez Osorio
 */
@Repository
public class MessageRepository {
    /***
     * Atributo autowired message
     */
    @Autowired
    private MessageCrudRepository messageCrudRepository;

    /**
     * Método para obtener todos los message
     * @return
     */
    public List<Message> getAll(){
        return (List<Message>) messageCrudRepository.findAll();
    }

    /**
     * método para obtener message por id
     * @param id
     * @return
     */
    public Optional<Message> getMessage(int id){
        return messageCrudRepository.findById(id);
    }

    /**
     * método save para message
     * @param message
     * @return
     */
    public Message save(Message message){
        return messageCrudRepository.save(message);
    }
}
