package co.edu.udea.appair.presentacion.guivuelos;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.oscargallon.tuviaje.R;

import co.edu.udea.appair.controlador.FacadeController;
import co.edu.udea.appair.persistencia.dao.ItineraryDAO;

public class SearchFlightsActivity extends Activity {

    private DatePicker dpDepartureDate;
    private DatePicker dpArrivalDate;
    private Spinner spDepartureCity;
    private Spinner spArrivalCity;
    private String departureCity;
    private String arrivalCity;
    private FacadeController facadeController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busqueda_vuelos);
        init();
        facadeController= FacadeController.getInstance();
        facadeController.registerActities(this);
    }

    public void init() {
        dpDepartureDate = (DatePicker) findViewById(R.id.dpFechaIda);
        dpArrivalDate = (DatePicker) findViewById(R.id.dpFechaSalida);
        spDepartureCity = (Spinner) findViewById(R.id.spCiudadOrigen);
        spArrivalCity = (Spinner) findViewById(R.id.spCiudadDestino);

        String[] arrivalCities = new String[]{"seleccione","barranquilla",
                "bogota", " bucaramanga", "cartagena","cucuta", "medellin","new york", "pereira"
        };

        String[] departureCities = new String[]{"seleccione",
                "bogota", "medellin","panama", "rionegro", "san juan"
        };

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, departureCities);

        ArrayAdapter<String> adaptador2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, arrivalCities);

        spDepartureCity.setAdapter(adaptador);
        spArrivalCity.setAdapter(adaptador2);

        spDepartureCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> arg0, View v, int position, long id) {
                if(position!=0)
                    departureCity = arg0.getAdapter().getItem(position).toString();
                  else
                    departureCity=null;

            }

            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });

        spArrivalCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> arg0, View v, int position, long id) {
                if(position!=0)
                    arrivalCity = arg0.getAdapter().getItem(position).toString();
                else
                    arrivalCity= null;

            }

            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.busqueda_vuelos, menu);
        return true;
    }

    public void search(View v) {
        String departureDate = getDateFromPiker(dpDepartureDate);
        String arrivalDate= getDateFromPiker(dpArrivalDate);

       facadeController.searchFlight(departureCity,arrivalCity,departureDate,arrivalDate);

    }


    public String getDateFromPiker(DatePicker picker){
        if(picker==null)
            return null;
        String date = "";
        String dai="";
        String month = "";
        int day = picker.getDayOfMonth();
        int m = picker.getMonth();
        m += 1;
        dai+=day;
        month += m;
        if (month.length() == 1)
            month = "0" + month;
        if(dai.length()==1)
            dai="0"+dai;

        date +=dai+"/";
        date += month + "/";
        date += picker.getYear();
        return date;

    }

    public DatePicker getDpDepartureDate() {
        return dpDepartureDate;
    }

    public void setDpDepartureDate(DatePicker dpDepartureDate) {
        this.dpDepartureDate = dpDepartureDate;
    }

    public DatePicker getDpArrivalDate() {
        return dpArrivalDate;
    }

    public void setDpArrivalDate(DatePicker dpArrivalDate) {
        this.dpArrivalDate = dpArrivalDate;
    }

    public Spinner getSpDepartureCity() {
        return spDepartureCity;
    }

    public void setSpDepartureCity(Spinner spDepartureCity) {
        this.spDepartureCity = spDepartureCity;
    }

    public Spinner getSpArrivalCity() {
        return spArrivalCity;
    }

    public void setSpArrivalCity(Spinner spArrivalCity) {
        this.spArrivalCity = spArrivalCity;
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
