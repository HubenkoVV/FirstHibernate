package service;

import model.entity.User;
import model.hibPackage.UserHiberSession;
import org.hibernate.Session;
import service.exception.IncorrectDataException;
import util.constant.Exceptions;
import util.secure.SecurePasswordMD5;

/**
 * Created by Vladyslava_Hubenko on 7/12/2018.
 */
public class UserService {

    private UserHiberSession session;

    public UserService(UserHiberSession session) {
        this.session = session;
    }

    public User getByLoginAndPassword(String login, String password) throws IncorrectDataException {
        User user = session.findByLogin(login);
        if (user == null) {
            throw new IncorrectDataException(Exceptions.WRONG_LOGIN);
        }
        checkPassword(password, user.getPassword());
        return user;
    }

    private void checkPassword(String password, String userPassword) throws IncorrectDataException {
        if(!SecurePasswordMD5.verifyPassword(password, userPassword)){
            throw new IncorrectDataException(Exceptions.WRONG_PASSWORD);
        }
    }

}
