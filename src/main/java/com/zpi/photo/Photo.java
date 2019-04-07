package com.zpi.photo;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.zpi.service.Service;
import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class Photo
{

    @EmbeddedId
    private PhotoPK id;

    @MapsId("id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_service")
    @JsonManagedReference
    private Service service;


}
