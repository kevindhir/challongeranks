package model;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * Created by kevindhir on 2016-12-03.
 */
public class Tournament {
    private String tournamentName;
    private int tournamentID;
    private int participantCount;
    private Collection<Participant> participants;
    private HashMap<Participant, Integer> placements;

    public Tournament(String tournamentName, int tournamentID, int participantCount){
        this.tournamentID = tournamentID;
        this.tournamentName = tournamentName;
        this.participantCount = participantCount;
    }


    public String getName(){
        return tournamentName;
    }
    public void setParticipants(Collection<Participant> participants){
        this.participants = participants;
    }
    public int getTournamentID(){ return tournamentID; }
    public int getPlacement(int participantID){
        return placements.get(participantID);
    }

    public void addTournamentEntered(){
        for (Participant p: participants) {
            p.addTournamentEntered(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tournament that = (Tournament) o;

        return tournamentID == that.tournamentID;
    }

    @Override
    public int hashCode() {
        return tournamentID;
    }
}
