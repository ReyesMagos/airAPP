package co.edu.udea.appair.controlador;

import co.edu.udea.appair.logicadelnegocio.usuario.Itinerary;
import co.edu.udea.appair.presentacion.guivuelos.ItineraryResultActivity;

/**
 * Created by OscarGallon on 19/08/14.
 */
public class ItinerarioResultController {

    private ItineraryResultActivity activity;
    private Itinerary itinerary;

    public ItinerarioResultController(ItineraryResultActivity activity) {
        this.activity = activity;
        FacadeController facadeController = FacadeController.getInstance();
        this.itinerary = facadeController.getItinerary();
    }

    public Itinerary getItinerary() {
        return itinerary;
    }

    public void setItinerary(Itinerary itinerary) {
        this.itinerary = itinerary;
    }

    public ItineraryResultActivity getActivity() {
        return activity;
    }

    public void setActivity(ItineraryResultActivity activity) {
        this.activity = activity;
    }
}
