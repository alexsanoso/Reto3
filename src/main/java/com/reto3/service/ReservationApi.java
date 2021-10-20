package com.reto3.service;

import com.reto3.modelo.Reservation;
import com.reto3.repository.ReservationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alexander
 */
@Service
public class ReservationApi {
    /**
     * atributo para autowired reservation
     */
    @Autowired
    private ReservationRepository reservationRepository;

    /**
     * método para obtener todos los reservation
     * @return
     */
    public List<Reservation> getAll(){
        return  reservationRepository.getAll();
    }

    /**
     * método para obtener reservation por id
     * @param id
     * @return
     */
    public Optional<Reservation> getReservation(int id){
        return reservationRepository.getReservation(id);
    }

    /**
     * método save para reservation
     * @param reservation
     * @return
     */
    public Reservation save(Reservation reservation){
        if (reservation.getIdReservation() == null){
            return reservationRepository.save(reservation);
        }else{
            Optional<Reservation> evt = reservationRepository.getReservation(reservation.getIdReservation());
            if (evt.isEmpty()){
                return reservationRepository.save(reservation);
            }else{
                return reservation;
            }
        }
    }
}

