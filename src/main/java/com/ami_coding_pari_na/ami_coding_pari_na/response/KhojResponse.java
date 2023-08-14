package com.ami_coding_pari_na.ami_coding_pari_na.response;

public class KhojResponse {
    private Boolean status;
    private String message;

    public KhojResponse(Boolean status, String message) {
        this.status = status;
        this.message = message;
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
        return "KhojResponse{" +
                "status=" + status +
                ", message='" + message + '\'' +
                '}';
    }
}
