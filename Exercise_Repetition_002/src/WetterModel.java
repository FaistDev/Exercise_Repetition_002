
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.security.Timestamp;
import java.time.ZoneOffset;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import javax.swing.AbstractListModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ben
 */
public class WetterModel extends AbstractListModel{
    private ArrayList<WetterWert> wetterdaten = new ArrayList<>();
    
    @Override
    public int getSize() {
        return wetterdaten.size();
    }

    @Override
    public Object getElementAt(int index) {
        return wetterdaten.get(index);
    }
    
    public void add(WetterWert w){
        wetterdaten.add(w);
        fireIntervalAdded(this, wetterdaten.size()-1, wetterdaten.size()-1);
    }
    
    public void save(File f) throws Exception{
        BufferedWriter bw = new BufferedWriter(new FileWriter(f));
        for (WetterWert w : wetterdaten) {
            java.sql.Timestamp t = java.sql.Timestamp.valueOf(w.getTime());
            bw.append(w.getTemp()+","+w.getLuft()+","+t.getTime()+"\n");
        }
        bw.flush();
        bw.close();
    }
    
    public void load(File f) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader(f));
        String line=null;
        while((line=br.readLine())!=null){
            String[] parts = line.split(",");
            wetterdaten.add(new WetterWert(parts[0],parts[1],Long.parseLong(parts[2])));
        }
        br.close();
        fireIntervalAdded(this, 0, wetterdaten.size()-1);
    }
    
}
