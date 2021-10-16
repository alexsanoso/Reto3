package com.reto3.web;

import com.reto3.modelo.Client;
import com.reto3.service.ClientApi;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Alexander
 */
@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/api/Client/")
public class ClientWeb {
    @Autowired
    private ClientApi clientApi;

    @GetMapping("all")
    public List<Client> getAll(){
        return clientApi.getAll();
    }

    @GetMapping("{id}")
    public Optional<Client> getClient(@PathVariable("id") int id){
        return clientApi.getClient(id);
    }

    @PostMapping("save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(@RequestBody Client client){
        return clientApi.save(client);
    }
}

