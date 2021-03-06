package com.example.allen.criminalintent;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;
import java.util.UUID;
import java.util.jar.JarException;

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

    private static final String JSON_ID = "id";
    private static final String JSON_TITLE = "title";
    private static final String JSON_SOLVED = "solved";
    private static final String JSON_DATE = "date";
    private static final String JSON_PHOTO = "photo";
    private static final String JSON_SUSPECT = "suspect";


    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;
    private Photo mPhoto;
    private String mSuspect;

    public Crime(){
        mId = UUID.randomUUID();    //生成唯一的标识
        mDate = new Date();
    }
    public Crime(JSONObject json) throws JSONException {
        mId = UUID.fromString(json.getString(JSON_ID));
        if (json.has(JSON_TITLE)) {
            mTitle = json.getString(JSON_TITLE);
        }
        mSolved = json.getBoolean(JSON_SOLVED);
        mDate = new Date(json.getString(JSON_DATE));        //书上是json.getLong(JSON_DATE)，结果抛出异常
        if (json.has(JSON_PHOTO)) {
            mPhoto = new Photo(json.getJSONObject(JSON_PHOTO));
            //先把Photo toJSON()再put()，get()时用Photo(JSONObject json)构造出Photo
        }
        if (json.has(mSuspect)) {
            mSuspect = json.getString(mSuspect);
        }
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

    public Photo getPhoto() {
        return mPhoto;
    }

    public void setPhoto(Photo photo) {
        mPhoto = photo;
    }

    public JSONObject toJSON() throws JSONException {
        JSONObject json = new JSONObject();
        json.put(JSON_ID, mId.toString());
        json.put(JSON_TITLE, mTitle);
        json.put(JSON_SOLVED, mSolved);
        json.put(JSON_DATE, mDate.toString());
        if (mPhoto != null) {
            json.put(JSON_PHOTO, mPhoto.toJSON());
            //先把Photo toJSON()再put()，get()时用Photo(JSONObject json)构造出Photo
        }
        json.put(JSON_SUSPECT, mSuspect);

        return json;
    }

    public String getSuspect() {
        return mSuspect;
    }

    public void setSuspect(String suspect) {
        mSuspect = suspect;
    }

    @Override
    public String toString() {
        return mTitle;
    }

}
