package model;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by kevindhir on 2016-12-03.
 */
public class ParticipantDataProvider extends AbstractHttpDataProvider {
    private int tournamentID;

    public ParticipantDataProvider(int tournamentID){
        this.tournamentID = tournamentID;
    }
    /**
     * Read data source as bytes
     *
     * @return bytes containing data read from source
     * @throws IOException when error occurs reading from source
     */
    @Override
    public byte[] dataSourceToBytes() throws IOException {
        return new byte[0];
    }

    /**
     * Get URL of Http data provider
     *
     * @return URL of http data provider
     * @throws MalformedURLException when URL is malformed
     */
    @Override
    protected URL getURL() throws MalformedURLException {
        String URLstring = "https://api.challonge.com/v1/tournaments/"+tournamentID+"/participants.json";
        URL returnUrl = new URL(URLstring);
        return returnUrl;
    }
}
