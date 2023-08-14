package com.ami_coding_pari_na.ami_coding_pari_na.response;

import com.ami_coding_pari_na.ami_coding_pari_na.model.KhojData;

import java.util.ArrayList;
import java.util.List;

public class UserActivityDetailsResponse {
    private String status;
    private long userid;
    private ArrayList<List<KhojData>> playload;

    public UserActivityDetailsResponse(String status, long userid, ArrayList<List<KhojData>> playload) {
        this.status = status;
        this.userid = userid;
        this.playload = playload;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public ArrayList<List<KhojData>> getPlayload() {
        return playload;
    }

    public void setPlayload(ArrayList<List<KhojData>> playload) {
        this.playload = playload;
    }
}
