package co.edu.udea.appair.controlador;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import co.edu.udea.appair.logicadelnegocio.usuario.User;
import co.edu.udea.appair.persistencia.dao.UserDAO;
import co.edu.udea.appair.presentacion.guiusuario.LoginActivity;
import co.edu.udea.appair.presentacion.guivuelos.SearchFlightsActivity;
import co.edu.udea.appair.presentacion.utilidades.Dialogation;

/**
 * Created by OscarGallon on 18/08/14.
 */
public class LoginController extends Dialogation {

    private LoginActivity activity;

    public LoginController(LoginActivity activity) {
        this.activity = activity;
    }


    public void singUp(User user){

        UserDAO userDAO= new UserDAO();
        userDAO.singUpUser(user);

    }


    @Override
    public void showProgressDialog(String title, String message, Context context) {
        super.showProgressDialog(title, message, context);
    }

    public void login(String username, String password){
        UserDAO userDAO= new UserDAO();
        userDAO.getUser(username, password);
    }


    public void changeTOSearch(){
        Intent i = new Intent(activity, SearchFlightsActivity.class);
        getActivity().startActivity(i);
    }

    @Override
    public void showAlertMessage(String mensaje, String titulo, Activity actividad) {
        super.showAlertMessage(mensaje, titulo, actividad);
    }

    @Override
    public void dismissProgressDialog() {
        super.dismissProgressDialog();
    }

    public LoginActivity getActivity() {
        return activity;
    }

    public void setActivity(LoginActivity activity) {
        this.activity = activity;
    }
}
