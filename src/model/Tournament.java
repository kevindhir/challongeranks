package model;

import java.util.HashMap;
import java.util.List;

/**
 * Created by kevindhir on 2016-12-03.
 */
public class Tournament {
    private String tournamentName;
    private int tournamentID;
    private int participantCount;
    private List<Participant> participants;
    private HashMap<Participant, Integer> placements;

    public Tournament(String tournamentName, int tournamentID, int participantCount){
        this.tournamentID = tournamentID;
        this.tournamentName = tournamentName;
        this.participantCount = participantCount;
    }


    public String getName(){
        return tournamentName;
    }
    public int getPlacement(int participantID){
        return placements.get(participantID);
    }





}
