package sda.pl.com.message;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by RENT on 2016-12-17.
 */
@Entity
public class Message {

    @Id
    @GeneratedValue
    private int id;

    private String receiverId;

    private String senderId;

    private String body;

    @Temporal(TemporalType.DATE)
    private Date created;


    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String reciverId) {
        this.receiverId = reciverId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }


    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", reciverId='" + receiverId + '\'' +
                ", senderId='" + senderId + '\'' +
                ", body='" + body + '\'' +
                ", created=" + created +
                '}';
    }

}