package com.ami_coding_pari_na.ami_coding_pari_na.response;

import org.springframework.stereotype.Repository;

@Repository
public class AuthResponse {
    private Boolean status;
    private String message;
    private long userid;
    private String email;
    public AuthResponse() {
    }

    public AuthResponse(Boolean status, String message) {
        this.status = status;
        this.message = message;
    }
    public AuthResponse(Boolean status, String message, long userid, String email) {
        this.status = status;
        this.message = message;
        this.userid = userid;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "AuthResponse{" +
                "status=" + status +
                ", message='" + message + '\'' +
                '}';
    }
}
