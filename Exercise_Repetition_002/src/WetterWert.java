
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ben
 */
public class WetterWert {
    private int temperatur,luftfeuchtigkeit;
    private LocalDateTime timestamp;
    
    public WetterWert(String temp, String luft){
        temperatur=Integer.parseInt(temp);
        luftfeuchtigkeit=Integer.parseInt(luft);
        timestamp=LocalDateTime.now();
    }
    
    public WetterWert(int temp, int luft){
        temperatur=temp;
        luftfeuchtigkeit=luft;
        timestamp=LocalDateTime.now();
    }
    
    public WetterWert(String temp, String luft, long time){
        temperatur=Integer.parseInt(temp);
        luftfeuchtigkeit=Integer.parseInt(luft);
        timestamp=LocalDateTime.ofEpochSecond(time, 0, ZoneOffset.UTC);
    }
    
    public int getTemp(){
        return temperatur;
    }
    
    public int getLuft(){
        return luftfeuchtigkeit;
    }
    
    public LocalDateTime getTime(){
        return timestamp;
    }

    @Override
    public String toString() {
        return String.format("%s - %s - %d° - %d%%", timestamp.format(DateTimeFormatter.ofPattern("dd.MM")),timestamp.format(DateTimeFormatter.ofPattern("HH:mm:ss")),temperatur,luftfeuchtigkeit);
    }
    
    
}
