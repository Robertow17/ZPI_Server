package com.zpi.repository;

import com.zpi.composite_key.FavouritePK;
import com.zpi.entity.Favourite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavouriteRepository  extends JpaRepository<Favourite, FavouritePK>
{}
