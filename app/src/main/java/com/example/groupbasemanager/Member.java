package com.example.groupbasemanager;


import java.util.Date;
import java.util.UUID;

public class Member {

    private String memberName, memberLastName, memberMiddleName;
    private Date memberBirthDate;
    private UUID memberID;

    Member() {
        memberID = UUID.randomUUID();
    }

    public UUID getMemberID() {
        return memberID;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberLastName() {
        return memberLastName;
    }

    public void setMemberLastName(String memberLastName) {
        this.memberLastName = memberLastName;
    }

    public String getMemberMiddleName() {
        return memberMiddleName;
    }

    public void setMemberMiddleName(String memberMiddleName) {
        this.memberMiddleName = memberMiddleName;
    }

    public Date getMemberBirthDate() {
        return memberBirthDate;
    }

    public void setMemberBirthDate(Date memberBirthDate) {
        this.memberBirthDate = memberBirthDate;
    }
}
