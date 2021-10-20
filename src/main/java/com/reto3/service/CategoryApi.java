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

    public Category update(Category category){
        if(category.getId()!=null){
            Optional<Category>actualizar=categoryRepository.getCategory(category.getId());
            if(!actualizar.isEmpty()){
                if(category.getDescription()!=null){
                    actualizar.get().setDescription(category.getDescription());
                }
                if(category.getName()!=null){
                    actualizar.get().setName(category.getName());
                }
                return categoryRepository.save(actualizar.get());
            }
        }
        return category;
    }
    public boolean deleteCategory(int categoryId){
        Boolean borrar=getCategory(categoryId).map(category -> {
            categoryRepository.delete(category);
            return true;
        }).orElse(false);
        return borrar;
    }
}
