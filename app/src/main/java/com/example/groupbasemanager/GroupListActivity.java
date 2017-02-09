package com.example.groupbasemanager;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.UUID;

/**
 * Created by Дмитрий on 02.02.2017.
 */

public class GroupListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new GroupListFragment();
    }
}
