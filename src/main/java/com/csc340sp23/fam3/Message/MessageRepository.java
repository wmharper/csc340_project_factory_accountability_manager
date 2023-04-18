package com.csc340sp23.fam3.Message;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Darian
 */
@Repository
public class MessageRepository {

    @Autowired
    NamedParameterJdbcTemplate structure;

    List<Message> findAll() {

        String query = "select recipient, message_sender, message_body from messages";
        return structure.query(query,
                (result, rowNum)
                -> new Message(
                        result.getString("recipient"),
                        result.getString("message_sender"),
                        result.getString("message_body")
                ));
    }

    public List<Message> messagesForYou(String id) {
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue(
                "recipient", id);
        String query = "select * from messages where recipient=:id AND read_or_unread<1";
        List<Message> newMessages = structure.query(query, namedParameters,
                BeanPropertyRowMapper.newInstance(Message.class));
        // Sort by unread, cross-referenced by time
        return newMessages;
    }
    
    public Message messageById(long id) {
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue(
                "id", id);
        String query = "select * from user where id=:id ";
        return structure.queryForObject(query, namedParameters,
                BeanPropertyRowMapper.newInstance(Message.class));
    }

    public int sendMessage(Message note) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("recipient", note.getRecipient());
        paramMap.put("timestamp", note.getTimestamp());
        System.out.println(note.getTimestamp());
        paramMap.put("message_sender", note.getMessageSender());
        paramMap.put("read_or_unread", note.isReadOrUnread());
        paramMap.put("message_body", note.getMessageBody());
        String query = "INSERT INTO message(recipient,timestamp,message_sender,read_or_unread,message_body) VALUES(:recipient, :timestamp, :message_sender, :read_or_unread, :message_body)";
        return structure.update(query, paramMap);
    }
    
    public void readMessage(Message note) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", note.getId());
        paramMap.put("recipient", note.getRecipient());
        paramMap.put("timestamp", note.getTimestamp());
        paramMap.put("message_sender", note.getMessageSender());
        paramMap.put("read_or_unread", 1);
        paramMap.put("message_body", note.getMessageBody());
        String query = "update message set read_or_unread=1 where id=:id";
        structure.update(query, paramMap);
    }
}
