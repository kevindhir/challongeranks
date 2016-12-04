package gui;

import model.Tournament;
import model.TournamentDataProvider;
import org.json.JSONException;
import singleton.challongeranks;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

/**
 * Created by Jonathan on 2016-12-03.
 */
public class ChooseTournaments extends JPanel implements KeyListener {
    challongeranks instance = challongeranks.getInstance();
    private JList list1;
    private JPanel panel1;

    public ChooseTournaments() throws IOException, JSONException {
        for (int i = 0; i < instance.getNumOfTournaments(); i++) {

        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // 1
        if (e.getKeyCode() == 49) {

            for (Tournament t : instance.getTournaments()) {
                int index = 0;
                if (index == 0) {
                    instance.setSelected(t);
                    index++;
                }
            }
        } else if (e.getKeyCode() == 50) {
            int index = 0;
            for (Tournament t : instance.getTournaments()) {
                if (index == 1) {
                    instance.setSelected(t);
                } else {
                    index++;
                }
            }

        } else if (e.getKeyCode() == 51) {
            int index = 0;
            for (Tournament t : instance.getTournaments()) {
                if (index == 2) {
                    instance.setSelected(t);
                } else {
                    index++;
                }
            }

        } else if (e.getKeyCode() == 52) {
            int index = 0;
            for (Tournament t : instance.getTournaments()) {
                if (index == 3) {
                    instance.setSelected(t);
                } else {
                    index++;
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
