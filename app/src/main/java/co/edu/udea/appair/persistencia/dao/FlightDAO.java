package co.edu.udea.appair.persistencia.dao;

import co.edu.udea.appair.logicadelnegocio.usuario.Itinerary;
import co.edu.udea.appair.persistencia.utilities.FlightDAOThread;

/**
 * Created by Stephys on 8/19/2014.
 */
public class FlightDAO implements IFlightDAO {

    @Override
    public void getFlight(Itinerary itinerary) {

        FlightDAOThread flightDAOThread = new FlightDAOThread();
        flightDAOThread.execute(itinerary);

    }
}
