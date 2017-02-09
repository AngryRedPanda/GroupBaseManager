package com.example.groupbasemanager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class MemberListFragment extends Fragment {

    final static String ARG_GROUP_ID = "group_id";

    public static MemberListFragment newInstance(UUID groupID) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_GROUP_ID, groupID);

        MemberListFragment memberListFragment = new MemberListFragment();
        memberListFragment.setArguments(args);
        return memberListFragment;
    }


    private RecyclerView recyclerView;
    private MemberAdapter mAdapter;
    private Group group;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID groupID = (UUID) getArguments().getSerializable(ARG_GROUP_ID);
        group = GroupLab.getInstance(getActivity()).getGroup(groupID);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_member_list, container, false);

        recyclerView = (RecyclerView) v.findViewById(R.id.member_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();
        return v;
    }

    private void updateUI() {

        List<Member> memberList = group.getMemberList();

        if (mAdapter == null) {
            mAdapter = new MemberAdapter(memberList);
            recyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.notifyDataSetChanged();
        }
    }

    private class MemberHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private Member member;
        private TextView memberName;

        public MemberHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            memberName = (TextView) itemView.findViewById(R.id.member_name_text_view);
        }

        public void bindMember(Member member) {
            this.member = member;
            memberName.setText(member.getMemberLastName());

        }

        @Override
        public void onClick(View view) {

        }
    }

    private class MemberAdapter extends RecyclerView.Adapter<MemberHolder> {

        private List<Member> memberList = new ArrayList<>();

        public MemberAdapter(List<Member> memberList) {
            this.memberList = memberList;
        }

        @Override
        public MemberHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.list_item_member, parent, false);
            return new MemberHolder(view);
        }

        @Override
        public void onBindViewHolder(MemberHolder holder, int position) {
            Member member = memberList.get(position);
            holder.bindMember(member);
        }

        @Override
        public int getItemCount() {
            return memberList.size();
        }
    }
}

