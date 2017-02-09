package com.example.groupbasemanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;



public class GroupListFragment extends Fragment {

    private RecyclerView recyclerView;
    private GroupAdapter mAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_group_list, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.group_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();
        return view;
    }

    private void updateUI() {
        GroupLab groupLab = GroupLab.getInstance(getActivity());
        List<Group> groupList = groupLab.getGroupList();

        if (mAdapter == null) {
            mAdapter = new GroupAdapter(groupList);
            recyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.notifyDataSetChanged();
        }
    }


    private class GroupHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private Group mGroup;
        private TextView groupTitle;
        private TextView groupCount;

        public GroupHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            groupTitle = (TextView) itemView.findViewById(R.id.list_item_crime_title_text_view);
            groupCount = (TextView) itemView.findViewById(R.id.list_group_count);
        }

        public void bindCrime(Group group) {
            mGroup = group;
            groupTitle.setText(group.getGroupName());
            groupCount.setText(String.format(getString(R.string.number_of_members), group.getMemberCnt()));
        }

        @Override
        public void onClick(View view) {
            Intent intent = MemberListActivity.newIntent(getActivity(), mGroup.getGroupID());
            startActivity(intent);
        }
    }

    private class GroupAdapter extends RecyclerView.Adapter<GroupHolder> {

        private List<Group> groupList;

        public GroupAdapter(List<Group> groups) {
            groupList = groups;
        }

        @Override
        public GroupHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.list_item_group, parent, false);
            return new GroupHolder(view);
        }

        @Override
        public void onBindViewHolder(GroupHolder holder, int position) {
            Group group = groupList.get(position);
            holder.bindCrime(group);
        }

        @Override
        public int getItemCount() {
            return groupList.size();
        }
    }

}
