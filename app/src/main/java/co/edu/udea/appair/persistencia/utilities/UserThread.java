package co.edu.udea.appair.persistencia.utilities;

import android.os.AsyncTask;

import com.parse.ParseException;
import com.parse.ParseUser;

import co.edu.udea.appair.logicadelnegocio.usuario.User;
import co.edu.udea.appair.persistencia.dao.UserDAO;

/**
 * Created by OscarGallon on 19/08/14.
 */
public class UserThread extends AsyncTask<Object,String, Boolean>{

    private String order;
    private UserDAO userDAO;
    private ParseUser user;

    public UserThread(String order, UserDAO userDAO) {
        this.order = order;
        this.userDAO = userDAO;
    }

    @Override
    protected Boolean doInBackground(Object... params) {

           if(this.order.equals("loggin")){

               try{
                   ParseUser parseUser =  ParseUser.logIn((String)params[0],(String)params[1]);
                   this.user = parseUser;
                   return true;
               }catch(ParseException e){

                   return false;

               }



           }else if(this.order.equals("sing_up")){
               User user = (User)params[0];
               ParseUser parseUser = new ParseUser();
               parseUser.setUsername(user.getUsername());
               parseUser.setPassword(user.getPassword());
               parseUser.setEmail(user.getEmail());
               parseUser.put("name", user.getName());
               parseUser.put("last_name", user.getLastName());
               parseUser.put("adress", user.getAdress());
               parseUser.put("birthDate", user.getBirthDate());
               parseUser.put("cell", user.getCell());
               parseUser.put("phoneNumber", user.getPhoneNumber());

               try{
                   parseUser.signUp();
                   return true;
               }catch(ParseException e){

                   return false;

               }

           }

        return false;


    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
        if(aBoolean){

            if(this.order.equals("loggin")){
                userDAO.returnUser(this.user);

            }else if(this.order.equals("sing_up")){
                userDAO.setUserSing();

            }

        }else{

            if(this.order.equals("loggin")){
                userDAO.showLogginError();


            }else if(this.order.equals("sing_up")){
                userDAO.showSingUpError();


            }

        }
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }
}
