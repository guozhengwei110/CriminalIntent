package com.example.allen.criminalintent;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Photo    该类用来封装照片文件名字
 *
 * @author: Allen
 * @time: 2016/2/26 10:50
 */
public class Photo {
    private static final String JSON_FILENAME = "filename";
    private String mFilename;

    public Photo(String filename) {
        mFilename = filename;
    }

    public Photo(JSONObject json) throws JSONException {
        mFilename = json.getString(JSON_FILENAME);
    }

    public JSONObject toJSON() throws JSONException {
        JSONObject json = new JSONObject();
        json.put(JSON_FILENAME, mFilename);
        return json;
    }

    public String getFilename() {
        return mFilename;
    }
}
