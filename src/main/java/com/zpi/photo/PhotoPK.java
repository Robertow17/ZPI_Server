package com.zpi.photo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class PhotoPK implements Serializable
{

    private int id;

    @Column(length = 255)
    private String value;

    public PhotoPK()
    {
    }

    public PhotoPK(int id, String value)
    {
        this.id = id;
        this.value = value;
    }

}