package co.edu.udea.appair.persistencia.dao;

import co.edu.udea.appair.logicadelnegocio.usuario.User;

/**
 * Created by Stephys on 8/19/2014.
 */
public interface IUsuarioDAO {

    public void getUser(String username, String password);
    public void singUpUser(User user);
}

