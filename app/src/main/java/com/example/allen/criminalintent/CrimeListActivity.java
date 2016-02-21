package com.example.allen.criminalintent;

import android.app.Fragment;

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
