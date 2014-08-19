package co.edu.udea.appair.presentacion.guivuelos;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;

import com.example.oscargallon.tuviaje.R;

public class SearchFlightsActivity extends Activity {

    private DatePicker dpFechaIda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busqueda_vuelos);
        init();
    }

    public void init(){
        dpFechaIda= (DatePicker) findViewById(R.id.dpFechaIda);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.busqueda_vuelos, menu);
        return true;
    }

    public void search(View v){
        String date="";
        String month="";
        int m =dpFechaIda.getMonth();
        m+=1;
        date += dpFechaIda.getDayOfMonth()+"/";
        month+=m;
        if(month.length()==1)
            month="0"+month;
        date += month+"/";
        date += dpFechaIda.getYear();
        Log.i("Fecha: ", String.format("la fecha es: %s ", date));
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