package com.zpi.user;

import com.zpi.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, String>
{}
