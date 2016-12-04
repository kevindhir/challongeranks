package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * Created by kevindhir on 2016-12-03.
 */
public class Participant {
    private Collection<Tournament> tournamentsEntered;
    private String username;
    private int participantID;
    private List<Integer> placements;
    private int numTournamentsEntered;
    private int avgPlacement;

    public Participant(String username, int participantID){
        this.username = username;
        this.participantID = participantID;
        placements = new ArrayList<>();
        numTournamentsEntered = 0;
        tournamentsEntered = new HashSet<>();
    }

    public void setTournamentsEntered(HashSet<Tournament> tournaments){
        tournamentsEntered = tournaments;
        numTournamentsEntered = tournamentsEntered.size();
    }

    public void getPlacements(Collection<Tournament> tournamentsEntered){
        for (Tournament t: tournamentsEntered) {
            int placement = t.getPlacement(participantID);
            placements.add(placement);
        }
    }

    public int getAvgPlacement(){
        int placementSum = 0;
        int totalEntered = 0;
        for (Integer placement: placements) {
            totalEntered ++;
            placementSum += placement;
        }
        return placementSum/totalEntered;
    }


    public void addPlacement(int placement){
        placements.add(placement);
    }

    public void incrementTournamentsEntered(){
        numTournamentsEntered ++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Participant that = (Participant) o;

        return username.equals(that.username);
    }

    @Override
    public int hashCode() {
        return username.hashCode();
    }

    public void addTournamentEntered(Tournament t){
        tournamentsEntered.add(t);
    }


}
