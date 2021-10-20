package com.reto3.service;

import com.reto3.modelo.Category;
import com.reto3.repository.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Alexander
 */
@Service
public class CategoryApi {
    /**
     * Atributo autowired para category
     */
    @Autowired
    private CategoryRepository categoryRepository;

    /**
     * método para obtener todos los category
     * @return
     */
    public List<Category> getAll(){
        return (List<Category>) categoryRepository.getAll();
    }

    /**
     * método para obtener category por id
     * @param id
     * @return
     */
    public Optional<Category> getCategory(int id){
        return categoryRepository.getCategory(id);
    }

    /**
     * método save para category
     * @param category
     * @return
     */
    public Category save(Category category){
        if (category.getId() == null){
            return categoryRepository.save(category);
        }else{
            Optional<Category> evt = categoryRepository.getCategory(category.getId());
            if(evt.isEmpty()){
                return categoryRepository.save(category);
            }else{
                return category;
            }
        }
    }
}
