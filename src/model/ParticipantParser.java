package model;

import org.json.JSONArray;
import org.json.JSONObject;
import singleton.challongeranks;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by kevindhir on 2016-12-03.
 */
public class ParticipantParser {

    public String username = "challongerankings";
    public String apikey = "KOQ2Dzakf5oIOwgBVN0N5dhivU3TB6UvI3Vvp24U";
    public Collection<Participant> participants = new HashSet<>();
    public static ParticipantParser instance = new ParticipantParser();



    public static ParticipantParser getInstance() throws IOException, org.json.JSONException {
        if (instance == null) {
            instance = new ParticipantParser();
        }
        return instance;
    }

    protected URL getURL() throws MalformedURLException {
        String URLstring = "https://" + username + ":" + apikey + "@api.challonge.com/v1/tournaments.json";
        URL returnUrl = new URL(URLstring);
        return returnUrl;
    }

    //May need to be STATIC
    public void parseParticipants(String jsonResponse) throws org.json.JSONException, IOException {
        JSONArray response = new JSONArray(jsonResponse);
        for (int index = 0; index < response.length(); index++) {
            JSONObject participant = response.getJSONObject(index).getJSONObject("participant");
            Participant parsedParticipant = parseParticipant(participant);
            participants.add(parsedParticipant);
        }
    }

    public Participant parseParticipant(JSONObject participant) throws org.json.JSONException, IOException {
        int id = participant.getInt("id");
        String name = participant.getString("name");
        Participant parsedParticipant = new Participant(name, id);

        HashSet<Participant> masterSet = challongeranks.getInstance().returnParticipants();

        if (!(masterSet.contains(parsedParticipant))){
            challongeranks.getInstance().addParticipant(parsedParticipant);
            parsedParticipant.addPlacement(participant.getInt("final_rank"));
        } else {
            for (Participant p: masterSet) {
                if (p.equals(parsedParticipant)){
                    p.addPlacement(participant.getInt("final_rank"));
                }
            }

        }

        return parsedParticipant;
    }

    public Collection<Participant> returnParticipants(){
        return participants;
    }

}
