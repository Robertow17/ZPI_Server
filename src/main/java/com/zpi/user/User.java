package com.zpi.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.zpi.user.enums.Gender;
import com.zpi.user.enums.UserType;
import com.zpi.favourite.Favourite;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Data
@Entity
public class User
{

    @Id
    @Column(length = 30)
    private String login;

    @Column(length = 30, nullable = false)
    @Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})")
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

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

}


    /* PASSWORD:
     must contains one digit from 0-9
     must contains one lowercase characters
     must contains one uppercase characters
     must contains one special symbols in the list "@#$%"
     match anything with previous condition checking
     length at least 6 characters and maximum of 20*/