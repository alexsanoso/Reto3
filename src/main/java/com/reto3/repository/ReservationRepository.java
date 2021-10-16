package com.reto3.repository;

import com.reto3.modelo.Reservation;
import com.reto3.repository.crud.ReservationCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Alexander
 */
@Repository
public class ReservationRepository {
    @Autowired
    private ReservationCrudRepository reservationRepository;

    public List<Reservation> getAll(){
        return (List<Reservation>) reservationRepository.findAll();
    }

    public Optional<Reservation> getReservation(int id){
        return reservationRepository.findById(id);
    }

    public Reservation save(Reservation reservation){
        return reservationRepository.save(reservation);
    }
}
