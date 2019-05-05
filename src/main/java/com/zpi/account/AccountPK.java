package com.zpi.account;


import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class AccountPK implements Serializable
{
    private int id;
    private String login;

    public AccountPK()
    {
    }

    public AccountPK(int id, String login)
    {
        this.id = id;
        this.login = login;
    }


}
