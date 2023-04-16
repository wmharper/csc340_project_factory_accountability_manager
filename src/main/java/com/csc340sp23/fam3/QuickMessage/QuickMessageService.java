/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.csc340sp23.fam3.QuickMessage;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Billy
 */
@Service
public class QuickMessageService {

    @Autowired
    private QuickMessageRepository repo;

    public List<QuickMessage> getAllQuickMessages() {
        return repo.findAll();
    }

    void saveQM(QuickMessage qm) {
        repo.save(qm);
    }

    public void createSupervisorAlert(QuickMessage qm) {
        qm.setSender(1);
        qm.setReciever(2);
        qm.setBody("Inspector for line 1 has sent an alert that their assigned "
                + "line does not seem to be  functioning properly. "
                + "It is recommended to inspect the line and reset it if "
                + "necessary.");
        repo.save(qm);
    }

public void createCatFactQuickMessage(QuickMessage qm) {
    try {
        URL url = new URL("https://catfact.ninja/fact?max_length=140");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        con.disconnect();

        // Parse the JSON response using Jackson
        ObjectMapper mapper = new ObjectMapper();
        JsonNode json = mapper.readTree(content.toString());
        String catFact = json.get("fact").asText();

        qm.setSender(1);
        qm.setReciever(2);
        qm.setBody("Cat Fact of the Day: " + catFact);
        repo.save(qm);
    } catch (Exception e) {
        e.printStackTrace();
    }
}

}
