package co.edu.udea.appair.controlador;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.widget.ArrayAdapter;

import com.example.oscargallon.tuviaje.R;

import java.util.List;

import co.edu.udea.appair.logicadelnegocio.usuario.Itinerary;
import co.edu.udea.appair.persistencia.dao.ItineraryDAO;
import co.edu.udea.appair.presentacion.guivuelos.ItineraryResultActivity;
import co.edu.udea.appair.presentacion.guivuelos.SearchFlightsActivity;
import co.edu.udea.appair.presentacion.utilidades.Dialogation;

/**
 * Created by OscarGallon on 19/08/14.
 */
public class SearchController extends Dialogation{

    private SearchFlightsActivity activity;

    public SearchController(SearchFlightsActivity activity) {
        this.activity= activity;
    }

    public SearchFlightsActivity getActivity() {
        return activity;
    }

    public void setActivity(SearchFlightsActivity activity) {
        this.activity = activity;
    }

    public void searchFlights(String departureCity, String arrivalCity, String departureDate, String arrivalDate){
        ItineraryDAO itineraryDAO = new ItineraryDAO();
        itineraryDAO.getItineraries(departureCity, arrivalCity,departureDate, arrivalDate);
    }

    @Override
    public void showAlertMessage(String mensaje, String titulo, Activity actividad) {
        super.showAlertMessage(mensaje, titulo, actividad);
    }

    @Override
    public void showProgressDialog(String title, String message, Context context) {
        super.showProgressDialog(title, message, context);
    }

    @Override
    public void dismissProgressDialog() {
        super.dismissProgressDialog();
    }

    public void showSearchResults(final List<Itinerary> lista) {
        if (lista != null
                && lista.size() > 0) {
            AlertDialog.Builder builderSingle = new AlertDialog.Builder(
                    activity);
            builderSingle.setIcon(R.drawable.ic_launcher);
            builderSingle.setTitle("Itinerarios");
            final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                    activity, android.R.layout.select_dialog_singlechoice);
            for (Itinerary itinerary : lista) {

                arrayAdapter.add(String.format(
                        " Ciudad Salida: %s, Ciudad de Llegada:  %s, Fecha de Salida: %s, Fecha de Llegado %s, Valor: %s",
                        itinerary.getDepartureCity(),
                        itinerary.getArrivalCity(),
                        itinerary.getDepartureDate(),
                        itinerary.getArrivalDate(), itinerary.getPrice()));
            }

            builderSingle.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface arg0, int arg1) {
                    FacadeController facadeController = FacadeController.getInstance();
                    facadeController.setItinerary(lista.get(arg1));
                    showSelectedItinerary();


                }
            });
            builderSingle.show();

        }


    }

    public void showSelectedItinerary(){

        Intent i = new Intent(getActivity(), ItineraryResultActivity.class);
        getActivity().startActivity(i);
    }



}

