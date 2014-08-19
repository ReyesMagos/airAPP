package co.edu.udea.appair.persistencia.dao;

import android.util.Log;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

import co.edu.udea.appair.logicadelnegocio.usuario.Itinerary;

/**
 * Created by OscarGallon on 19/08/14.
 */
public class ItineraryDAO implements IItineraryDAO {
    @Override
    public List<Itinerary> getItineraries(String departureCity, String arrivalCity, String departureDate, String arrivalDate){
        ParseQuery query = new ParseQuery("Itinerary");

        query.whereEqualTo("Brand", "Burnettes");

        query.findInBackground(new FindCallback() {
            @Override
            public void done(List list, ParseException e) {
                if(e==null){

                }

            }
        });

        return null;
    }
}
