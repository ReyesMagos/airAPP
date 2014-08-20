package co.edu.udea.appair.persistencia.utilities;

import android.os.AsyncTask;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseRelation;

import java.util.ArrayList;
import java.util.List;

import co.edu.udea.appair.logicadelnegocio.usuario.Itinerary;

/**
 * Created by Stephys on 8/19/2014.
 */
public class FlightDAOThread extends AsyncTask<Itinerary, String, Boolean>{


    @Override
    protected Boolean doInBackground(Itinerary... param) {

        try {
            Itinerary itinerary = param[0];
            ParseQuery<ParseObject> query = ParseQuery.getQuery("ItineraryFlights");
            query.whereEqualTo("itinerario", itinerary.getItinerary());
            List parseObjects = query.find();
            List<ParseObject> flitghts = new ArrayList<ParseObject>();
            for(Object object: parseObjects){
                ParseObject obj = (ParseObject) object;
                ParseObject obj2= obj.getParseObject("flight").fetch();

                   flitghts.add(obj2);
            }
            return true;
        }catch(ParseException e){
            return false;
        }


    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
    }
}
