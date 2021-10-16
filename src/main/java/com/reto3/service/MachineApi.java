package com.reto3.service;

import com.reto3.modelo.Machine;
import com.reto3.repository.MachineRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alexander
 */
@Service
public class MachineApi {
    @Autowired
    private MachineRepository machineRepository;

    public List<Machine> getAll(){
        return machineRepository.getAll();
    }

    public Optional<Machine> getMachine(int id){
        return machineRepository.getMachine(id);
    }

    public Machine save(Machine machine){
        if(machine.getId()==null){
            return machineRepository.save(machine);
        }else{
            Optional<Machine> evt = machineRepository.getMachine(machine.getId());
            if(evt.isEmpty()){
                return machineRepository.save(machine);
            }else{
                return machine;
            }
        }
    }
}

