package com.zpi.transport_details;


import com.zpi.service.Service;
import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class TransportDetails
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_service")
    @MapsId
    private Service service;

    @Column(nullable = true)
    private int maxSittingPlaces;

}
