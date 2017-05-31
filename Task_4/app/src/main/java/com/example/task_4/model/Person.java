package com.example.task_4.model;

import java.io.Serializable;

/**
 * Created by Дима on 08.01.2017.
 */

public class Person implements Serializable
{
    private int mId;
    private String mName;
    private String mSurName;
    private String mPhoneNumer;
    private String mMail;
    private String mSkype;

    public static Person selectedPerson;

    public Person() {super();}


    public Person(int mId, String mName, String mSurName, String mPhoneNumer, String mMail, String mSkype)
    {
        this.mId = mId;
        this.mName = mName;
        this.mSurName = mSurName;
        this.mPhoneNumer = mPhoneNumer;
        this.mMail = mMail;
        this.mSkype = mSkype;
    }


    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmSurName() {
        return mSurName;
    }

    public void setmSurName(String mSurName) {
        this.mSurName = mSurName;
    }

    public String getmPhoneNumer() {
        return mPhoneNumer;
    }

    public void setmPhoneNumer(String mPhoneNumer) {
        this.mPhoneNumer = mPhoneNumer;
    }

    public String getmMail() {
        return mMail;
    }

    public void setmMail(String mMail) {
        this.mMail = mMail;
    }

    public String getmSkype() {
        return mSkype;
    }

    public void setmSkype(String mSkype) {
        this.mSkype = mSkype;
    }

}
