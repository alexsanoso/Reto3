package com.reto3.repository;

import com.reto3.modelo.Machine;
import com.reto3.repository.crud.MachineCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Alexander
 */
@Repository
public class MachineRepository {
    @Autowired
    private MachineCrudRepository machineCrudRepository;

    public List<Machine> getAll(){
        return (List<Machine>) machineCrudRepository.findAll();
    }

    public Optional<Machine> getMachine(int id){
        return machineCrudRepository.findById(id);
    }

    public Machine save(Machine machine){
        return machineCrudRepository.save(machine);
    }
}