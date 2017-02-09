package com.example.groupbasemanager;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class GroupLab {
    private static GroupLab ourInstance;
    private List<Group> groupList;

    public static GroupLab getInstance(Context context) {
        if(ourInstance == null) {
            ourInstance = new GroupLab(context);
        }
        return ourInstance;
    }

    private GroupLab(Context context) {
        groupList = new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            Group group = new Group();
            group.setGroupName("Group " + i);
            groupList.add(group);
        }
    }

    public List<Group> getGroupList() {
        return groupList;
    }

    public Group getGroup(UUID id) {
        for (Group group: groupList
                ) {
            if(group.getGroupID().equals(id)) {
                return group;
            }
        }
        return null;
    }
}
