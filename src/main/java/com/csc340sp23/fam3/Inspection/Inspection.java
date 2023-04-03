package com.csc340sp23.fam3.Inspection;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "inspection")

public class Inspection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private double form;
    private double quality;
    private int currentLine = 1;
    private String timestamp = "";
    private int result = -1;

    public Inspection() {
        // Generate form and quality values from a normal distribution with a mean of 8
        Random random = new Random();
        this.form = Math.min(10, Math.abs(random.nextGaussian() + 8));
        this.quality = Math.min(10, Math.abs(random.nextGaussian() + 8));
        
        try {
            URL url = new URL("http://worldtimeapi.org/api/timezone/Etc/UTC");
            URLConnection conn = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            String json = response.toString();
            int start = json.indexOf("datetime") + 12;
            int end = start + 19;
            this.timestamp = json.substring(start, end);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
