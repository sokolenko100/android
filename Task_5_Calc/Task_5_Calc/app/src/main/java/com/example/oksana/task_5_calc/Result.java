package com.example.oksana.task_5_calc;

import java.io.Serializable;

/**
 * Created by Oksana on 18.01.2017.
 */

public class Result implements Serializable{
    int mId;
    String mFirstValue;
    String mOperand;
    String mSecondValue;
    String mResult;

    public Result(){
        super();
    }

    public Result(int mId, String mFirstValue, String mOperand, String mSecondValue, String mResult) {
        this.mId = mId;
        this.mFirstValue = mFirstValue;
        this.mOperand = mOperand;
        this.mSecondValue = mSecondValue;
        this.mResult = mResult;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmFirstValue() {
        return mFirstValue;
    }

    public void setmFirstValue(String mFirstValue) {
        this.mFirstValue = mFirstValue;
    }

    public String getmOperand() {
        return mOperand;
    }

    public void setmOperand(String mOperand) {
        this.mOperand = mOperand;
    }

    public String getmSecondValue() {
        return mSecondValue;
    }

    public void setmSecondValue(String mSecondValue) {
        this.mSecondValue = mSecondValue;
    }

    public String getmResult() {
        return mResult;
    }

    public void setmResult(String mResult) {
        this.mResult = mResult;
    }
    public String toString()
    {
        return null;
    }
}
