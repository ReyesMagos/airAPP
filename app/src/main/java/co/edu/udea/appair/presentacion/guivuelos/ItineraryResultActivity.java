package co.edu.udea.appair.presentacion.guivuelos;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.oscargallon.tuviaje.R;

import co.edu.udea.appair.controlador.FacadeController;
import co.edu.udea.appair.persistencia.dao.FlightDAO;

public class ItineraryResultActivity extends Activity {


    private TextView departureCity;
    private TextView departureDate;
    private TextView departureHour;
    private TextView arrivalCity;
    private TextView arrivalDate;
    private TextView arrivalHour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_result);
        init();
        FacadeController facadeController = FacadeController.getInstance();
        facadeController.registerActities(this);
        facadeController.showItineraryInformation();

    }

    public void init(){

        departureCity = (TextView) findViewById(R.id.txtDepartureCity);
        departureDate= (TextView) findViewById(R.id.txtDepartureDate);
        departureHour= (TextView) findViewById(R.id.txtDepartureHour);
        arrivalCity = (TextView) findViewById(R.id.txtArrivalCity);
        arrivalDate = (TextView) findViewById(R.id.txtArrivalDate);
        arrivalHour= (TextView) findViewById(R.id.txtArrivalHour);


    }

    public void showFlights(View v){
        FlightDAO flightDAO = new FlightDAO();
        flightDAO.getFlight(FacadeController.getInstance().getItinerary());
    }

    public TextView getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(TextView departureCity) {
        this.departureCity = departureCity;
    }

    public TextView getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(TextView departureDate) {
        this.departureDate = departureDate;
    }

    public TextView getDepartureHour() {
        return departureHour;
    }

    public void setDepartureHour(TextView departureHour) {
        this.departureHour = departureHour;
    }

    public TextView getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(TextView arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public TextView getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(TextView arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public TextView getArrivalHour() {
        return arrivalHour;
    }

    public void setArrivalHour(TextView arrivalHour) {
        this.arrivalHour = arrivalHour;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.itinerary_result, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
