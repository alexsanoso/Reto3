package com.reto3.repository.crud;

import com.reto3.modelo.Message;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Alexander
 */
public interface MessageCrudRepository extends CrudRepository<Message,Integer> {

}