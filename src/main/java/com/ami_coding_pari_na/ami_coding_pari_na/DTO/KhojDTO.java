package com.ami_coding_pari_na.ami_coding_pari_na.DTO;

public class KhojDTO {
    private String inputArray;
    private long userid;
    private long id;
    private String timeStamp;

    public KhojDTO(long id, String inputArray, long userid, String timeStamp) {
        this.inputArray = inputArray;
        this.userid = userid;
        this.timeStamp = timeStamp;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getInputArray() {
        return inputArray;
    }

    public void setInputArray(String inputArray) {
        this.inputArray = inputArray;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "KhojDTO{" +
                "inputArray='" + inputArray + '\'' +
                ", userid=" + userid +
                ", id=" + id +
                ", timeStamp='" + timeStamp + '\'' +
                '}';
    }
}

