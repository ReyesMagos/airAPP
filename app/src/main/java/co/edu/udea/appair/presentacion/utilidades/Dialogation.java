package co.edu.udea.appair.presentacion.utilidades;


import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by OscarGallon on 18/08/14.
 */
public abstract class Dialogation {


    private ProgressDialog progressDialog;


    public void showProgressDialog(String title, String message, Context context) {

        this.progressDialog = new ProgressDialog(context);
        this.progressDialog.setCancelable(true);
        this.progressDialog.setTitle(title);
        this.progressDialog.setMessage(message);
        this.progressDialog.show();

    }

    public void dismissProgressDialog(){
        if(this.progressDialog!=null){
            this.progressDialog.dismiss();
        }
    }


}
