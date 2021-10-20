package com.reto3.repository;

// Importaciones
import com.reto3.modelo.Reservation;
import com.reto3.repository.crud.ReservationCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Alexander Sánchez Osorio
 */
@Repository
public class ReservationRepository {
    /**
     * Atributo autowired para reservation
     */
    @Autowired
    private ReservationCrudRepository reservationRepository;

    /**
     * método para obtener todos los reservation
     * @return
     */
    public List<Reservation> getAll(){
        return (List<Reservation>) reservationRepository.findAll();
    }

    /**
     * método para obtener reservation por id
     * @param id
     * @return
     */
    public Optional<Reservation> getReservation(int id){
        return reservationRepository.findById(id);
    }

    /**
     * método save para reservation
     * @param reservation
     * @return
     */
    public Reservation save(Reservation reservation){
        return reservationRepository.save(reservation);
    }
}
