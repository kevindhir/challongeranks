package singleton;

import model.*;
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
    private Collection<Participant> participants;
    private static challongeranks instance;

    public static challongeranks getInstance() throws IOException, JSONException {
        if (instance == null) {
            instance = new challongeranks();
        }
        return instance;
    }

    public challongeranks() throws IOException, JSONException {
        TournamentParser parser = new TournamentParser();
        TournamentDataProvider provider = new TournamentDataProvider();
        parser.parseTournaments(provider.dataSourceToString());
        this.numOfTournaments = parser.getNumberOfTournaments();
        System.out.print(numOfTournaments);
        this.tournaments = parser.getTournaments();
        selectedTournaments = new HashSet<>();
        participants = new HashSet<>();

    }

    public void addParticipantsSet(Collection<Participant> participants){
        for (Participant p: participants) {
            if (!(participants.contains(p))){
                participants.add(p);
            }
            
        }
    }
    public void setSelected(Tournament selected){
        selectedTournaments.add(selected);
    }

    public void getParticipantsSelected() throws IOException, JSONException {
        for (Tournament t: selectedTournaments) {
            ParticipantDataProvider dataProvider = new ParticipantDataProvider(t.getTournamentID());
            ParticipantParser parser = new ParticipantParser();
            parser.parseParticipants(dataProvider.dataSourceToString());
            t.setParticipants(parser.returnParticipants());
            t.addTournamentEntered();
        }
    }

    public Collection<Tournament> getTournaments() {
        return tournaments;
    }

    public Collection<Participant> returnParticipants(){
        return participants;
    }
}
