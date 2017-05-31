package com.example.work.task_7_note_book;

import java.io.Serializable;

/**
 * Created by Viktor on 27.01.2017.
 */

public class Person implements Serializable {

    int mId;
    String mName;
    String mSName;
    String mPhone;
    String mMail;
    String mSkype;
    public static Person selectPerson;

    public Person() {
        super();
    }

    public Person(int mId, String mName, String mSName, String mPhone, String mMail, String mSkype) {
        this.mId = mId;
        this.mName = mName;
        this.mSName = mSName;
        this.mPhone = mPhone;
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

    public String getmSName() {
        return mSName;
    }

    public void setmSName(String mSName) {
        this.mSName = mSName;
    }

    public String getmMail() {
        return mMail;
    }

    public void setmMail(String mMail) {
        this.mMail = mMail;
    }

    public String getmPhone() {
        return mPhone;
    }

    public void setmPhone(String mPhone) {
        this.mPhone = mPhone;
    }

    public String getmSkype() {
        return mSkype;
    }

    public void setmSkype(String mSkype) {
        this.mSkype = mSkype;
    }

    @Override
    public String toString() {
        return "Person{" +
                "mId=" + mId +
                ", mName='" + mName + '\'' +
                ", mSName='" + mSName + '\'' +
                ", mPhone='" + mPhone + '\'' +
                ", mMail='" + mMail + '\'' +
                ", mSkype='" + mSkype + '\'' +
                '}';
    }
}
