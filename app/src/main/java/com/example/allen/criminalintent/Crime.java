package com.example.allen.criminalintent;

import java.util.Date;
import java.util.UUID;

/**
 * Crime
 *
 *
 * @author: Allen

 * @time: 2016/1/26 7:40
 *
 * CriminalIntent的模型层
 */
public class Crime {
    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;

    public Crime(){
        mId = UUID.randomUUID();    //生成唯一的标识
        mDate = new Date();
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }

    public Date getDate() {

        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    @Override
    public String toString() {
        return mTitle;
    }
}
