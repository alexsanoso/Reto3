package com.reto3.repository;

import com.reto3.modelo.Category;
import com.reto3.repository.crud.CategoryCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Alexander
 */
@Repository
public class CategoryRepository {
    @Autowired
    private CategoryCrudRepository categoryCrudRepository;

    public List<Category> getAll(){
        return (List<Category>) categoryCrudRepository.findAll();
    }

    public Optional<Category> getCategory(int id){
        return categoryCrudRepository.findById(id);
    }

    public Category save(Category category){
        return categoryCrudRepository.save(category);
    }
}
