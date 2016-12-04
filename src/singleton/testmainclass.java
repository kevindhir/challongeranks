package singleton;

import gui.ChooseTournaments;
import gui.JListDisplay;
import model.Tournament;
import org.json.JSONException;

import javax.swing.*;
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

        JFrame jFrame = new JFrame("Display");
        ChooseTournaments chooseTournaments = new ChooseTournaments();
        jFrame.setContentPane(new JListDisplay());
        jFrame.add(chooseTournaments);
        jFrame.setSize(300, 500);
        jFrame.setVisible(true);


    }

}
