package com.example.groupbasemanager;


import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.UUID;

public class MemberListActivity extends SingleFragmentActivity {


    private static final String EXTRA_GROUP_ID = "com.bignerdranch.android.GroupBaseManager.group_id";

    @Override
    protected Fragment createFragment() {
        return MemberListFragment.newInstance((UUID) getIntent().getSerializableExtra(EXTRA_GROUP_ID));
    }

    public static Intent newIntent(Context packageContent, UUID groupID) {
        Intent intent = new Intent(packageContent, MemberListFragment.class);
        intent.putExtra(EXTRA_GROUP_ID, groupID);
        return intent;
    }
}