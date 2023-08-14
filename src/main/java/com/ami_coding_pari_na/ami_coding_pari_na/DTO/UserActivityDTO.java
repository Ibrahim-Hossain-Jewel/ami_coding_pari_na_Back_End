package com.ami_coding_pari_na.ami_coding_pari_na.DTO;

public class UserActivityDTO {
    private long userid;

    public UserActivityDTO(long userid) {
        this.userid = userid;
    }

    public UserActivityDTO() {

    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "UserActivityDTO{" +
                "userid=" + userid +
                '}';
    }
}
