package com.reto3.repository;

import com.reto3.modelo.Message;
import com.reto3.repository.crud.MessageCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Alexander
 */
@Repository
public class MessageRepository {
    @Autowired
    private MessageCrudRepository messageCrudRepository;

    public List<Message> getAll(){
        return (List<Message>) messageCrudRepository.findAll();
    }

    public Optional<Message> getMessage(int id){
        return messageCrudRepository.findById(id);
    }

    public Message save(Message message){
        return messageCrudRepository.save(message);
    }
}
