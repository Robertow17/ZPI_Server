package com.zpi.category;

import com.zpi.service.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService
{
    @Autowired
    private CategoryRepository categoryRepository;


    public List<Category> findAll()
    {
        return categoryRepository.findAll();
    }


    public Optional<Category> findById(int id)
    {
        return categoryRepository.findById(id);

    }


    public Category save(Category category)
    {
        return categoryRepository.save(category);
    }


    public void deleteById(int id)
    {
        categoryRepository.deleteById(id);
    }


}
