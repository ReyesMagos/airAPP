package co.edu.udea.appair.persistencia.utilities;

import android.os.AsyncTask;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

import co.edu.udea.appair.logicadelnegocio.usuario.Itinerary;
import co.edu.udea.appair.persistencia.dao.ItineraryDAO;

/**
 * Created by OscarGallon on 19/08/14.
 */
public class ItineraryDAOThread extends AsyncTask<ParseQuery, String, Boolean> {

    private List<Itinerary> lista;
    private ItineraryDAO itineraryDAO;

    public ItineraryDAOThread(ItineraryDAO itineraryDAO) {
        this.itineraryDAO = itineraryDAO;
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
        if(aBoolean){
            if(this.lista.size()==0)
              itineraryDAO.showEmptyResults();
            itineraryDAO.returnItinerariesList(lista);

        }else{
            itineraryDAO.showSearchError();
        }



    }

    @Override
    protected Boolean doInBackground(ParseQuery... queries) {
        ParseQuery query = queries[0];

        try {
            List list = query.find();
            List<Itinerary> listaItinerario = new ArrayList<Itinerary>();
            for(Object object: list){
                ParseObject parseObject = (ParseObject)object;
                Itinerary itinerary = new Itinerary();
                itinerary.setObjectId(parseObject.getObjectId());
                itinerary.setArrivalCity(parseObject.getString("arrivalCity"));
                itinerary.setDepartureCity(parseObject.getString("departureCity"));
                itinerary.setArrivalDate(parseObject.getString("arrivalDate"));
                itinerary.setDepartureDate(parseObject.getString("departureDate"));
                itinerary.setDepartureHour(parseObject.getString("departureHour"));
                itinerary.setArrivalHour(parseObject.getString("arrivalHour"));
                itinerary.setPrice(parseObject.getString("tarifa"));
                itinerary.setItinerary(parseObject);
                listaItinerario.add(itinerary);



            }
            this.lista= listaItinerario;
            return true;

        } catch (ParseException e) {
            return false;
        }

    }
}
