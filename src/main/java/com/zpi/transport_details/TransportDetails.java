package com.zpi.transport_details;


import com.zpi.service.Service;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;


@Data
@Entity
public class TransportDetails
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(mappedBy = "weddingHallDetails", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Service service;

    @Column(nullable = true)
    @Min(2)
    @Max(15)
    private int maxSittingPlaces;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

}
