package singleton;

import model.Tournament;
import org.json.JSONException;

import java.io.IOException;

/**
 * Created by kevindhir on 2016-12-03.
 */
public class testmainclass {
    
    public static void main(String[] args) throws IOException, JSONException {
        challongeranks test = new challongeranks();
        for (Tournament t: test.getTournaments()) {
            test.setSelected(t);
        }
        test.getParticipantsSelected();
        test.generateAverages();
        test.returnParticipants();
    }

}
