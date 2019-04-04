package com.zpi.repository;

import com.zpi.entity.Service;
import com.zpi.entity.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubcategoryRepository extends JpaRepository<Subcategory, Integer>
{}
