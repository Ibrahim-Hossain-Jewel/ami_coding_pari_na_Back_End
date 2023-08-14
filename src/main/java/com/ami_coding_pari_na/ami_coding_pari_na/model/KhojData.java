package com.ami_coding_pari_na.ami_coding_pari_na.model;
import com.ami_coding_pari_na.ami_coding_pari_na.repo.KhojRepo;
import org.springframework.stereotype.Repository;
import javax.persistence.*;
import java.util.List;

@Repository
@Entity
@Table(name = "khoj")
public class KhojData {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "userid")
    private long userid;
    @Column(name = "inputarray")
    private String inputarray;

    @Column(name = "timestamp")
    private String timestamp;

    public KhojData() {
    }

    public KhojData(long id, String inputArray, long userid, String timeStamp) {
        this.id = id;
        this.inputarray = inputArray;
        this.userid = userid;
        this.timestamp = timeStamp;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public String getInputarray() {
        return inputarray;
    }

    public void setInputarray(String inputarray) {
        this.inputarray = inputarray;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "KhojData{" +
                "id=" + id +
                ", userid=" + userid +
                ", inputarray='" + inputarray + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }


}
