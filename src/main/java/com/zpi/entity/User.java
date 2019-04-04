package com.zpi.entity;

import com.zpi.enums.Gender;
import com.zpi.enums.UserType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    private List<Favourite> favourites = new ArrayList<>();


    public String getLogin()
    {
        return login;
    }

    public void setLogin(String login)
    {
        this.login = login;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public Gender getGender()
    {
        return gender;
    }

    public void setGender(Gender gender)
    {
        this.gender = gender;
    }

    public UserType getType()
    {
        return type;
    }

    public void setType(UserType type)
    {
        this.type = type;
    }

    public List<Favourite> getFavourites()
    {
        return favourites;
    }

    public void setFavourites(List<Favourite> favourites)
    {
        this.favourites = favourites;
    }
}
