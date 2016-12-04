package gui;

import model.TournamentParser;
import model.Tournament;
import org.json.JSONException;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevindhir on 2016-12-03.
 */
public class TournamentSelector{

    private TournamentParser tournamentParser = TournamentParser.getInstance();
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton goButton;

    public TournamentSelector() throws IOException, JSONException {
        List<JCheckBox> checkBoxes = new ArrayList<>();
        for (Tournament t : tournamentParser.tournaments) {
            JCheckBox checkBox = new JCheckBox(t.getName());
            checkBoxes.add(checkBox);
        }
    }
}
