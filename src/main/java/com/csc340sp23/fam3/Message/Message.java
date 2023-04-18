package com.csc340sp23.fam3.Message;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



/**
 *
 * @author Darian
 */
@Entity
@Table(name = "message")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String recipient;
    private String timestamp;
    private String messageSender;
    private boolean readOrUnread;
    private String messageBody;

    public Message(String recipient, String messageSender, String messageBody) {
        this.recipient = recipient;
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedTime = currentTime.format(formatter);
        this.timestamp = formattedTime;
        this.messageSender = messageSender;
        this.readOrUnread = false;
        this.messageBody = messageBody;
    }
}
