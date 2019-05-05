package com.zpi.account;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.zpi.service.Service;
import com.zpi.user.User;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Account
{
    @EmbeddedId
    private AccountPK pk;

    @MapsId("id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_service")
    @JsonManagedReference
    private Service service;

    @MapsId("login")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_login")
    @JsonManagedReference
    private User user;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

}
