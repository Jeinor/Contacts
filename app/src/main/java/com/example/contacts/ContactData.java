package com.example.contacts;

import java.io.Serializable;

public class ContactData implements Serializable
{
    private String firstName;
    private String secondName;
    private String surname;
    private String phone;
    private String email;

    public ContactData(String firstName, String secondName, String surname, String phone, String email)
    {
        this.firstName = firstName;
        this.secondName = secondName;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
    }

    public String getFirstName()
    {
        return this.firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getSecondName()
    {
        return this.secondName;
    }

    public void setSecondName(String secondName)
    {
        this.secondName = secondName;
    }

    public String getSurname()
    {
        return this.surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public String getPhone()
    {
        return this.phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getEmail()
    {
        return this.email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }
}


