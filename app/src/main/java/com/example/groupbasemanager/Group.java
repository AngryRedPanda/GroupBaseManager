package com.example.groupbasemanager;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Group {

    private List<Member> memberList;
    private String groupName, subjectName;
    private UUID groupID;

    public Group() {
        groupID = UUID.randomUUID();
        memberList = new ArrayList<>();
        for (int i = 0; i < 10 ; i++) {
            Member member = new Member();
            member.setMemberName("Member " + i);
            memberList.add(member);
        }
    }

    public List<Member> getMemberList() {
        return memberList;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getMemberCnt() {
        Integer s = memberList.size();
        return s.toString();
    }

    public UUID getGroupID() {
        return groupID;
    }

    public void addMember(Member a) {
        memberList.add(a);
    }

    public Member getMember(UUID id) {
        for (Member member: memberList
             ) {
            if(member.getMemberID().equals(id)) {
                return member;
            }
        }
        return null;
    }

}
