package co.edu.udea.appair.persistencia.dao;

import java.util.List;

import co.edu.udea.appair.logicadelnegocio.usuario.Itinerary;

/**
 * Created by OscarGallon on 19/08/14.
 */
public interface IItineraryDAO {


    public void getItineraries(String departureCity,
                                          String arrivalCity, String departureDate,
                                          String arrivalDate);

}
