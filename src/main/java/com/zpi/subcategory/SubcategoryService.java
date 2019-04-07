package com.zpi.subcategory;

import com.zpi.category.Category;
import com.zpi.category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubcategoryService
{
    @Autowired
    private SubcategoryRepository subcategoryRepository;


    public List<Subcategory> findAll()
    {
        return subcategoryRepository.findAll();
    }


    public Optional<Subcategory> findById(int id)
    {
        return subcategoryRepository.findById(id);

    }


    public Subcategory save(Subcategory subcategory)
    {
        return subcategoryRepository.save(subcategory);
    }


    public void deleteById(int id)
    {
        subcategoryRepository.deleteById(id);
    }

}
