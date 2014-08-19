package co.edu.udea.appair.controlador;

import android.app.Activity;

import com.example.oscargallon.tuviaje.R;

import co.edu.udea.appair.logicadelnegocio.usuario.User;
import co.edu.udea.appair.presentacion.guiusuario.LoginActivity;

/**
 * Created by OscarGallon on 18/08/14.
 */
public class FacadeController {


    public static  FacadeController instance;
    private LoginController loginController;

    private FacadeController() {
    }

    public void registerActities(Activity activity) {

        if (activity instanceof LoginActivity) {
            this.loginController = new LoginController((LoginActivity) activity);
            //this.loginController.showProgressDialog(activity.getResources().getString(R.string.alert_title),
              //      activity.getResources().getString(R.string.wait_message), activity);
        }

    }

    public void singUp(String name, String lastName, String username, String password, String email, String birthDate,
                       String adress, String cell, String phoneNumber){

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setName(name);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setBirthDate(birthDate);
        user.setAdress(adress);
        user.setCell(Integer.parseInt("32442"));
        user.setPhoneNumber(Integer.parseInt("33443"));
        loginController.singUp(user);

    }

    public void login(String username, String password){


    }

    public static FacadeController getInstance() {
        if(instance==null)
            instance= new FacadeController();
        return instance;
    }

    public static void setInstance(FacadeController instance) {
        FacadeController.instance = instance;
    }
}
