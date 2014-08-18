package co.edu.udea.appair.controlador;

import android.content.Context;

import co.edu.udea.appair.logicadelnegocio.usuario.User;
import co.edu.udea.appair.persistencia.dao.UserDAO;
import co.edu.udea.appair.presentacion.guiusuario.LoginActivity;
import co.edu.udea.appair.presentacion.utilidades.Dialog;

/**
 * Created by OscarGallon on 18/08/14.
 */
public class LoginController extends Dialog {

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