package com.csc340sp23.fam3.QuickMessage;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Billy
 */

@AllArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "quickMessage")

public class QuickMessage {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int sender;
    private int reciever;
    private String timestamp;
    private String body;
    
    public QuickMessage() {
        this.sender = -1;
        this.reciever = -1;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.timestamp = formatter.format(new Date(System.currentTimeMillis()));
        this.body = "";
    }
    
}
