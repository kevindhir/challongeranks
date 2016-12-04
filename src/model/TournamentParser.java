package model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import java.util.Collection;
import java.util.HashSet;


/**
 * Created by kevindhir on 2016-12-03.
 */
public class TournamentParser {
    public String username = "challongerankings";
    public String apikey = "KOQ2Dzakf5oIOwgBVN0N5dhivU3TB6UvI3Vvp24U";
    public Collection<Tournament> tournaments = new HashSet<>();
    private static TournamentParser instance;


    public static TournamentParser getInstance() throws IOException, org.json.JSONException {
        if (instance == null) {
            instance = new TournamentParser();
        }
        return instance;
    }

    protected URL getURL() throws MalformedURLException {
        String URLstring = "https://" + username + ":" + apikey + "@api.challonge.com/v1/tournaments.json";
        URL returnUrl = new URL(URLstring);
        return returnUrl;
    }

    //May need to be STATIC
    public void parseTournaments(String jsonResponse) throws org.json.JSONException {
        JSONArray response = new JSONArray(jsonResponse);
        for (int index = 0; index < response.length(); index++) {
            JSONObject tournament = response.getJSONObject(index).getJSONObject("tournament");
            Tournament parsedTournament = parseTournament(tournament);
            tournaments.add(parsedTournament);
        }
    }

    public Tournament parseTournament(JSONObject tournament) throws org.json.JSONException {
        //int swiss_rounds = tournament.getInt("swiss_rounds");
        int id = tournament.getInt("id");
        String name = tournament.getString("name");
        int participantCount = tournament.getInt("participants_count");
        Tournament parsedTournament = new Tournament(name, id, participantCount);
        return parsedTournament;
    }

    public int getNumberOfTournaments() {
        return tournaments.size();
    }

    public Collection<Tournament> getTournaments() {
        return tournaments;
    }


    // hello there
}
