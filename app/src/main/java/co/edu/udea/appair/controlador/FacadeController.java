package co.edu.udea.appair.controlador;

import android.app.Activity;
import android.util.Log;

import com.example.oscargallon.tuviaje.R;


import co.edu.udea.appair.logicadelnegocio.usuario.User;
import co.edu.udea.appair.presentacion.guiusuario.LoginActivity;
import co.edu.udea.appair.presentacion.guivuelos.SearchFlightsActivity;

/**
 * Created by OscarGallon on 18/08/14.
 */
public class FacadeController {


    public static FacadeController instance;
    private LoginController loginController;
    private SearchController searchController;
    private User user;

    private FacadeController() {
    }

    public void registerActities(Activity activity) {

        if (activity instanceof LoginActivity) {
            this.loginController = new LoginController((LoginActivity) activity);
            //this.loginController.showProgressDialog(activity.getResources().getString(R.string.alert_title),
            //      activity.getResources().getString(R.string.wait_message), activity);
        } else if (activity instanceof SearchFlightsActivity) {
            this.searchController = new SearchController((SearchFlightsActivity) activity);
        }

    }

    public void singUp(String name, String lastName, String username, String password, String email, String birthDate,
                       String adress, String cell, String phoneNumber) {
        loginController.showProgressDialog(loginController.getActivity().getResources().getString(R.string.alert_title),
                loginController.getActivity().getResources().getString(R.string.wait_message),
                loginController.getActivity());

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
        loginController.dismissProgressDialog();

    }


    public void login(String username, String password) {
        loginController.showProgressDialog(loginController.getActivity().getResources().getString(R.string.alert_title),
                loginController.getActivity().getResources().getString(R.string.wait_message),
                loginController.getActivity());
        user = loginController.login(username, password);
        loginController.dismissProgressDialog();
        if (user != null) {

            loginController.changeTOSearch();
        } else {
            Log.i("Error", "Error en el Login");
        }

    }

    public static FacadeController getInstance() {
        if (instance == null)
            instance = new FacadeController();
        return instance;
    }

    public static void setInstance(FacadeController instance) {
        FacadeController.instance = instance;
    }
}
