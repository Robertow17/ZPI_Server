package com.zpi.subcategory;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.zpi.service.Service;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
public class Subcategory
{

    @Id
    @Column(length = 30)
    private String name;


    @OneToMany(mappedBy = "subcategory", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Service> services = new ArrayList<>();


}
