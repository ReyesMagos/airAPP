package co.edu.udea.appair.controlador;

import android.app.Activity;
import android.util.Log;

import com.example.oscargallon.tuviaje.R;


import java.util.List;

import co.edu.udea.appair.logicadelnegocio.usuario.Itinerary;
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
    private Itinerary itinerary;

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


    }


    public void login(String username, String password) {
        loginController.showProgressDialog(loginController.getActivity().getResources().getString(R.string.alert_title),
                loginController.getActivity().getResources().getString(R.string.wait_message),
                loginController.getActivity());
        loginController.login(username, password);



    }

    public void grantUserAccess(User user){
        this.user= user;
        getLoginController().changeTOSearch();
        loginController.dismissProgressDialog();

    }

    public void showUserLoginErrorMessage(){
        loginController.dismissProgressDialog();
        loginController.showAlertMessage("Usuario o Contraseña Invalidos", "Alerta", loginController.getActivity());
    }

    public void showUserSingUpMessage(){
        loginController.dismissProgressDialog();
        loginController.showAlertMessage("Registro con Exito", "Alerta",loginController.getActivity());
    }

    public void showSingUpErrorMessage(){
        loginController.dismissProgressDialog();
        loginController.showAlertMessage("Error En el registro","Alerta",loginController.getActivity());
    }

    public void searchFlight(String departureCity, String arrivalCity, String departureDate, String arrivalDate) {

        searchController.showProgressDialog("Alerta", "Buscando Por favor Espere", searchController.getActivity());

        List<Itinerary> lista= searchController.searchFlights(departureCity, arrivalCity, departureDate, arrivalDate);
        if(lista!=null)
                searchController.showSearchResults(lista) ;

        searchController.dismissProgressDialog();

    }

    public LoginController getLoginController() {
        return loginController;
    }

    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }

    public SearchController getSearchController() {
        return searchController;
    }

    public void setSearchController(SearchController searchController) {
        this.searchController = searchController;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Itinerary getItinerary() {
        return itinerary;
    }

    public void setItinerary(Itinerary itinerary) {
        this.itinerary = itinerary;
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
