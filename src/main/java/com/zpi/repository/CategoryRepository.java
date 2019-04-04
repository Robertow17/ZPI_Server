package com.zpi.repository;

import com.zpi.entity.Category;
import com.zpi.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer>
{}
