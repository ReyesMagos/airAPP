package co.edu.udea.appair.presentacion.guiusuario;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.oscargallon.tuviaje.R;
import com.parse.Parse;

import co.edu.udea.appair.controlador.FacadeController;


public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        Parse.initialize(this, "pdiXlN65BweJPjTx46Xtv4SfCkIw3yE0aSHkTw2w", "SsdbdZ2rj0xAWPe2esH4wP6pQYcZj9V0fkpJIuWy");
        FacadeController facadeController = FacadeController.getInstance();
        facadeController.registerActities(this );
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.inicio, menu);
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
