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
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll(){
        return (List<Category>) categoryRepository.getAll();
    }

    public Optional<Category> getCategory(int id){
        return categoryRepository.getCategory(id);
    }

    public Category save(Category category){
        if (category.getIdCategory() == null){
            return categoryRepository.save(category);
        }else{
            Optional<Category> evt = categoryRepository.getCategory(category.getIdCategory());
            if(evt.isEmpty()){
                return categoryRepository.save(category);
            }else{
                return category;
            }
        }
    }
}
