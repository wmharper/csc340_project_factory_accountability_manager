package com.csc340sp23.fam3.Message;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Darian
 */
@Service
public class MessageService {

    @Autowired
    MessageRepository repo;

    List<Message> getYourMessages() {
        return repo.findAll();
        //return repo.messagesForYou(String.format("%d", (int)(id)));
    }

    Message getMessage(long id) {
        return repo.messageById(id);
    }
    
    public void send(Message message) {
        repo.sendMessage(message);
    }
    
    public void read(Message message) {
        repo.readMessage(message);
    }
}
