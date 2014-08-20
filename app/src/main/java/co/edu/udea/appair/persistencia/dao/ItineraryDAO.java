package co.edu.udea.appair.persistencia.dao;

import android.util.Log;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

import co.edu.udea.appair.logicadelnegocio.usuario.Itinerary;
import co.edu.udea.appair.persistencia.utilities.ItineraryDAOThread;

/**
 * Created by OscarGallon on 19/08/14.
 */
public class ItineraryDAO implements IItineraryDAO {
    @Override
    public void getItineraries(String departureCity, String arrivalCity, String departureDate, String arrivalDate) {
        ParseQuery query = new ParseQuery("Itinerary");

        query.whereEqualTo("departureCity", departureCity);
        query.whereEqualTo("arrivalCity", arrivalCity);
        query.whereEqualTo("departureDate", departureDate);
        if (arrivalDate != null)
            query.whereEqualTo("arrivalDate", arrivalDate);

        ItineraryDAOThread itineraryDAOThread = new ItineraryDAOThread(this);
        itineraryDAOThread.execute(query);


    }

    public void returnItinerariesList(List<Itinerary> lista){

    }


}
