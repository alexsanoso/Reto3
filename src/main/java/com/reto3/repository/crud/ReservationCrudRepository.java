package com.reto3.repository.crud;

// importaciones
import com.reto3.modelo.Reservation;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Alexander Sánchez Osorio
 */
public interface ReservationCrudRepository extends CrudRepository <Reservation, Integer> {
}