package com.example.allen.criminalintent;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

/**
 * CrimeLab
 *
 * @author: Allen
 * @time: 2016/2/20 0:27
 *
 * 创建单例，该类只允许创建一个实类，
 * 需要创建私有构造方法以及get（）方法，
 * 单例存在的时间和应用在内存存在时间相同
 */
public class CrimeLab {
    private static final String TAG = "CrimeLab";
    private static final String FILENAME = "crimes.json";

    private ArrayList<Crime> mCrimes;
    private CriminalIntentJSONSerializer mSerializer;

    private static CrimeLab sCrimeLab;
    private Context mAppContext;

    private CrimeLab(Context appContext) {
        mAppContext = appContext;
        mSerializer = new CriminalIntentJSONSerializer(mAppContext, FILENAME);
        try {
            mCrimes = mSerializer.loadCrimes();
        } catch (Exception e) {
            mCrimes = new ArrayList<Crime>();
            Log.d(TAG, "----------Error loading crimes----------- ", e);
            Toast.makeText(mAppContext, TAG + " Error Error loading crimes",
                    Toast.LENGTH_SHORT).show();

        }
    }

    public static CrimeLab get(Context c) {
        if (sCrimeLab == null){
            sCrimeLab = new CrimeLab(c.getApplicationContext());
        }
        return sCrimeLab;
    }

    public ArrayList<Crime> getCrimes() {
        return mCrimes;
    }

    public Crime getCrime(UUID id) {
        for (Crime c : mCrimes)
            if (c.getId().equals(id))
                return c;
        return null;
    }

    public void addCrime(Crime c) {
        mCrimes.add(c);
    }

    public boolean saveCrimes() {
        try {
            mSerializer.saveCrimes(mCrimes);
            Toast.makeText(mAppContext, TAG + " Successed crimes saved",
                    Toast.LENGTH_SHORT).show();
            Log.d(TAG, "---------Successed crimes saved---------");
            return true;
        } catch (IOException e) {
            Toast.makeText(mAppContext, TAG + " Error saving crimes for IOException",
                    Toast.LENGTH_SHORT).show();
            Log.e(TAG, "--------Error saving crimes for JSONException---------", e);
            return false;
        } catch (JSONException e) {
            Toast.makeText(mAppContext, TAG + " Error saving crimes for IOException",
                    Toast.LENGTH_SHORT).show();
            Log.e(TAG, "---------Error saving crimes for JSONException---------", e);
            return false;
        }
    }
}
