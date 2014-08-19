package co.edu.udea.appair.persistencia.dao;

import com.parse.ParseUser;

import co.edu.udea.appair.logicadelnegocio.usuario.User;

/**
 * Created by OscarGallon on 18/08/14.
 */
public interface IUsuarioDAO {


    public User getUser(String username, String password);

    public boolean singUpUser(User user);




}
