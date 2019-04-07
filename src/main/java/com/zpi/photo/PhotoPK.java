package com.zpi.photo;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

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


    @Override
    public boolean equals(Object o)
    {
        if(this == o)
            return true;
        if(o == null || getClass() != o.getClass())
            return false;
        PhotoPK photoPK = (PhotoPK) o;
        return id == photoPK.id && Objects.equals(value, photoPK.value);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, value);
    }
}