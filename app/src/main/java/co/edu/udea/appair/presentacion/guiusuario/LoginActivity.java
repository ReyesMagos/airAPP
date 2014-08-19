package co.edu.udea.appair.presentacion.guiusuario;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.oscargallon.tuviaje.R;
import com.parse.Parse;
import android.app.Dialog;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import co.edu.udea.appair.controlador.FacadeController;



public class LoginActivity extends Activity {

    private  FacadeController facadeController;
    private EditText txtUsername;
    private EditText txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        Parse.initialize(this, "pdiXlN65BweJPjTx46Xtv4SfCkIw3yE0aSHkTw2w", "SsdbdZ2rj0xAWPe2esH4wP6pQYcZj9V0fkpJIuWy");
        init();
        facadeController = FacadeController.getInstance();
        facadeController.registerActities(this );
    }

    public void init(){
        txtUsername = (EditText) findViewById(R.id.txtUsername);
        txtPassword= (EditText) findViewById(R.id.txtPassword);
    }

    public void singUp(View v) {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.sing_up_dialog);
        dialog.setTitle("Registro");

        // set the custom dialog components - text, image and button
        final EditText txtUserName = (EditText) dialog
                .findViewById(R.id.txtUsername);

        final EditText txtPassWord = (EditText) dialog
                .findViewById(R.id.txtPassword);

        final EditText txtName = (EditText) dialog
                .findViewById(R.id.txtName);

        final EditText txtLastName = (EditText) dialog
                .findViewById(R.id.txtLastName);

        final EditText txtEmail = (EditText) dialog
                .findViewById(R.id.txtEmail);

        final EditText txtBirthDate = (EditText) dialog
                .findViewById(R.id.txtBirthDate);

        final EditText txtAdress = (EditText) dialog
                .findViewById(R.id.txtAdress);

        final EditText txtPhoneNumber = (EditText) dialog
                .findViewById(R.id.txtPhoneNumber);

        final EditText txtCell = (EditText) dialog
                .findViewById(R.id.txtCell);


        ImageView btnOk = (ImageView) dialog.findViewById(R.id.btnOk);
        ImageView btnCancel = (ImageView) dialog.findViewById(R.id.btnCancel);

        // if button is clicked, close the custom dialog
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = txtUserName.getText().toString();
                String password = txtPassWord.getText().toString();
                String name = txtName.getText().toString();
                String lastNAme= txtLastName.getText().toString();
                String email = txtEmail.getText().toString();
                String birthDate = txtBirthDate.getText().toString();
                String adress = txtAdress.getText().toString();
                String phoneNumber = txtPhoneNumber.getText().toString();
                String cell = txtCell.getText().toString();


                if (username != null && username.length() > 5
                        && password != null && password.length() > 5
                        && email != null && email.length() > 7
                        && cell != null && cell.length() > 5
                        && name != null && name.length()>4
                        && lastNAme!=null && lastNAme.length()>5
                        && birthDate!=null && birthDate.length()>9
                        && adress!=null && adress.length()> 5
                        && phoneNumber!=null && phoneNumber.length() >6) {
                   facadeController.singUp(name,lastNAme,username,password,email,birthDate,adress,cell,phoneNumber);
                } else {
                   // controlador.showMessage(
                     //       getResources().getString(R.string.error),
                       //     getResources().getString(R.string.error_datos));
                    Log.i("Error", "Faltan Datos");
                }
                dialog.dismiss();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();

    }


    public void login(View v){
        String username= txtUsername.getText().toString();
        String password = txtPassword.getText().toString();
        if(username!=null && username.length()>5 && password!=null && password.length()>5)
        facadeController.login(username,password);

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
