package com.zpi.composite_key;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PhotoPK implements Serializable
{

    private int id;

    @Column(length = 255)
    private String value;

}