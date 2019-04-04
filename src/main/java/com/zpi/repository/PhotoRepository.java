package com.zpi.repository;

import com.zpi.composite_key.PhotoPK;
import com.zpi.entity.Category;
import com.zpi.entity.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepository extends JpaRepository<Photo, PhotoPK>
{}
