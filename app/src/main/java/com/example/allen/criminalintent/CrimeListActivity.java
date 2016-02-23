package com.example.allen.criminalintent;

import android.app.Fragment;
import android.app.Notification;
import android.os.Bundle;
import android.support.v7.app.ActionBar;

/**
 * CrimeListActivity
 *
 * @author: Allen
 * @time: 2016/2/20 19:05
 */
public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
