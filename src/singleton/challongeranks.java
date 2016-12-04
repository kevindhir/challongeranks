package singleton;

import model.JSONParser;
import model.Tournament;
import model.TournamentDataProvider;
import org.json.JSONException;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by kevindhir on 2016-12-03.
 */
public class challongeranks {
    private Collection<Tournament> tournaments;
    private Collection<Tournament> selectedTournaments;
    private int numOfTournaments;
    private static challongeranks instance;

    public static challongeranks getInstance() throws IOException, JSONException {
        if (instance == null) {
            instance = new challongeranks();
        }
        return instance;
    }

    public challongeranks() throws IOException, JSONException {
        JSONParser parser = new JSONParser();
        TournamentDataProvider provider = new TournamentDataProvider();
        parser.parseTournaments(provider.dataSourceToString());
        this.numOfTournaments = parser.getNumberOfTournaments();
        this.tournaments = parser.getTournaments();
        selectedTournaments = new HashSet<>();
    }

    public void setSelected(Tournament selected){
        selectedTournaments.add(selected);
    }

    public Collection<Tournament> getTournaments() {
        return tournaments;
    }
}
