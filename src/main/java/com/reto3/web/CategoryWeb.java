package com.reto3.web;

import com.reto3.modelo.Category;
import com.reto3.service.CategoryApi;
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
@RequestMapping("/api/Category/")
public class CategoryWeb {
    @Autowired
    private CategoryApi categoryApi;

    @GetMapping("all")
    public List<Category> getAll(){
        return categoryApi.getAll();
    }

    @GetMapping("{id]")
    public Optional<Category> getCategory(@PathVariable("id") int id){
        return categoryApi.getCategory(id);
    }

    @PostMapping("save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category save(@RequestBody Category category){
        return categoryApi.save(category);
    }
}

