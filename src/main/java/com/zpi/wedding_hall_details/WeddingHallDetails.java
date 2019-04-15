package com.zpi.wedding_hall_details;

import com.zpi.service.Service;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;


@Data
@Entity
public class WeddingHallDetails
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_service")
    @MapsId
    private Service service;

    @Column(nullable = true)
    private boolean canSleep;

    @Column(nullable = true)
    private int maxNumberOfGuests;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

}
