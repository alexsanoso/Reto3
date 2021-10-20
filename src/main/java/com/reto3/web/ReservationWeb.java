package com.reto3.web;

import com.reto3.modelo.Reservation;
import com.reto3.service.ReservationApi;
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
@RequestMapping("/api/Reservation/")
public class ReservationWeb {
    /**
     * atriuto autowired reservation
     */
    @Autowired
    private ReservationApi reservationApi;

    /**
     * método para obtener todos los reservation
     * @return
     */
    @GetMapping("all")
    public List<Reservation> getAll(){
        return reservationApi.getAll();
    }

    /**
     * método para obtener cada reservation por id
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") int id){
        return reservationApi.getReservation(id);
    }

    /**
     * método para guardar cada reservation
     * @param reservation
     * @return
     */
    @PostMapping("save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reservation){
        return reservationApi.save(reservation);
    }
}

