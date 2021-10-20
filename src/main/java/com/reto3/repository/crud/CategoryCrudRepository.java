package com.reto3.repository.crud;

// importaciones
import com.reto3.modelo.Category;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Alexander Sánchez Osorio
 */
public interface CategoryCrudRepository extends CrudRepository<Category, Integer> {
}
