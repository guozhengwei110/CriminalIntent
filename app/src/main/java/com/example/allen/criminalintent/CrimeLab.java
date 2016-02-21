package com.example.allen.criminalintent;

import android.content.Context;

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
    private ArrayList<Crime> mCrimes;

    private static CrimeLab sCrimeLab;
    private Context mAppContext;

    private CrimeLab(Context appContext) {
        mAppContext = appContext;
        mCrimes = new ArrayList<Crime>();
        for (int i = 0; i < 100; i++) {
            Crime c = new Crime();
            c.setTitle("Crime #" + i);
            c.setSolved(i % 2 == 0);
            mCrimes.add(c);
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
}
