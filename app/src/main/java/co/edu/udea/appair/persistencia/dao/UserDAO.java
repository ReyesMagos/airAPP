package co.edu.udea.appair.persistencia.dao;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import co.edu.udea.appair.logicadelnegocio.usuario.User;

/**
 * Created by OscarGallon on 18/08/14.
 */
public class UserDAO implements IUsuarioDao {

    @Override
    public User getUser(String username, String password) {
        try{
            ParseUser parseUser =  ParseUser.logIn(username, password);
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
            return  user;

        }catch(ParseException e){
            return null;
        }



    }

    @Override
    public boolean singUpUser(User user) {
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


// other fields can be set just like with ParseObject
        parseUser.put("phone", "650-253-0000");

        try{
            parseUser.signUp();
            return true;
        }catch(ParseException e ){
            return  false;
        }


    }
}
