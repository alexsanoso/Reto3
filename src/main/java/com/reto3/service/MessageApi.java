package com.reto3.service;

import com.reto3.modelo.Message;
import com.reto3.repository.MessageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alexander
 */
@Service
public class MessageApi {
    /**
     * Atributo autowired message
     */
    @Autowired
    private MessageRepository messageRepository;

    /**
     * método para obtener todos los message
     * @return
     */
    public List<Message> getAll(){
        return messageRepository.getAll();
    }

    /**
     * método para obtener message por id
     * @param id
     * @return
     */
    public Optional<Message> getMessage(int id){
        return messageRepository.getMessage(id);
    }

    /**
     * método save para message
     * @param message
     * @return
     */
    public Message save(Message message){
        if(message.getIdMessage() == null){
            return messageRepository.save(message);
        }else{
            Optional<Message> evt = messageRepository.getMessage(message.getIdMessage());
            if(evt.isEmpty()){
                return messageRepository.save(message);
            }else{
                return message;
            }
        }
    }
}
