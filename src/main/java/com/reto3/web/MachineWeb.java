package com.reto3.web;

import com.reto3.modelo.Machine;
import com.reto3.service.MachineApi;
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
@RequestMapping("/Machine/")
public class MachineWeb {
    @Autowired
    private MachineApi machineApi;

    @GetMapping("all")
    public List<Machine> getMachine(){
        return machineApi.getAll();
    }

    @GetMapping("{id}")
    public Optional<Machine> getMachine(@PathVariable("id") int id){
        return machineApi.getMachine(id);
    }
    @PostMapping("save")
    @ResponseStatus(HttpStatus.CREATED)
    public Machine save(@RequestBody Machine machine){
        return machineApi.save(machine);
    }
}

