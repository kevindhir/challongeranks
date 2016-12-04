package gui;

import model.JSONParser;
import model.Tournament;
import org.json.JSONException;
import singleton.challongeranks;


import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevindhir on 2016-12-03.
 */
public class TournamentSelector {

    private JSONParser jsonParser = JSONParser.getInstance();

    public TournamentSelector() throws IOException, JSONException {
        List<JCheckBox> checkBoxes = new ArrayList<>();
        for (Tournament t: jsonParser.tournaments) {
            JCheckBox checkBox = new JCheckBox(t.getName());
            checkBoxes.add(checkBox);
        }
    }
}
