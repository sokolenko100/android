package com.example.artyom.task_4_notebook;

import java.io.Serializable;

/**
 * Created by Artyom on 08.01.2017.
 */

public class Person implements Serializable
{
    Integer id;
    String fName;
    String lName;
    String phone;
    String mail;
    String skype;

    public Person( )
    {
    }
    public Person(String name )
    {
        this.fName= name;
    }
    public Person(int id, String fname,String lname,String phone,String mail,String skype )
    {
        this.id= id;
        this.fName= fname;
        this.lName= lname;
        this.phone= phone;
        this.mail= mail;
        this.skype= skype;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

}
