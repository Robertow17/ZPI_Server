package com.zpi.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.zpi.user.enums.Gender;
import com.zpi.user.enums.UserType;
import com.zpi.favourite.Favourite;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
public class User
{

    @Id
    @Column(length = 30)
    private String login;

    @Column(length = 30, nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(length = 10, columnDefinition = "ENUM('FEMALE', 'MALE', 'UNDEFINED') default 'UNDEFINED'")
    private Gender gender = Gender.UNDEFINED;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, columnDefinition = "ENUM('USER', 'SERVICE_PROVIDER') default 'USER'")
    private UserType type = UserType.USER;

    @OneToMany(mappedBy= "user",  cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Favourite> favourites = new ArrayList<>();

}
