package com.reto3.service;

import com.reto3.modelo.Client;
import com.reto3.repository.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alexander
 */
@Service
public class ClientApi {

    /**
     * Atributo autowired client
     */
    @Autowired
    private ClientRepository clientRepository;

    /**
     * método para obtener todos los client
     * @return
     */
    public List<Client> getAll(){
        return clientRepository.getAll();
    }

    /**
     * método para obtener client por id
     * @param id
     * @return
     */
    public Optional<Client> getClient(int id){
        return clientRepository.getClient(id);
    }

    /**
     * método save para client
     * @param client
     * @return
     */
    public Client save(Client client){
        if (client.getIdClient() == null){
            return clientRepository.save(client);
        }else{
            Optional<Client> evt = clientRepository.getClient(client.getIdClient());
            if(evt.isEmpty()){
                return clientRepository.save(client);
            }else{
                return client;
            }
        }
    }
}
