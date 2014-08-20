package co.edu.udea.appair.persistencia.dao;

import com.parse.ParseUser;

import co.edu.udea.appair.controlador.FacadeController;
import co.edu.udea.appair.logicadelnegocio.usuario.User;
import co.edu.udea.appair.persistencia.utilities.UserThread;

/**
 * Created by OscarGallon on 18/08/14.
 */
public class UserDAO  implements IUsuarioDAO  {

    @Override
    public void getUser(String username, String password) {

        UserThread userThread= new UserThread("loggin", this);
        userThread.execute(username,password);

    }

    public void returnUser(ParseUser parseUser){
        User user = new User();
        user.setName(parseUser.getString("name"));
        user.setLastName(parseUser.getString("last_name"));
        user.setUsername(parseUser.getUsername());
        user.setEmail(parseUser.getEmail());
        user.setAdress(parseUser.getString("adress"));
        user.setBirthDate(parseUser.getString("birthDate"));
        user.setCell(parseUser.getInt("cell"));
        user.setPhoneNumber(parseUser.getInt("phoneNumber"));
        user.setObjectId(parseUser.getObjectId());
        user.setUser(parseUser);
        FacadeController facadeController= FacadeController.getInstance();
        facadeController.grantUserAccess(user);

    }


    public void setUserSing(){
        FacadeController facadeController= FacadeController.getInstance();
        facadeController.showUserSingUpMessage();
    }

    public void showSingUpError(){

        FacadeController facadeController= FacadeController.getInstance();
        facadeController.showSingUpErrorMessage();

    }

    public void showLogginError(){
        FacadeController facadeController= FacadeController.getInstance();
        facadeController.showUserLoginErrorMessage();
    }

    @Override
    public void singUpUser(User user) {

        UserThread userThread= new UserThread("sing_up", this);
        userThread.execute(user);

    }
}
