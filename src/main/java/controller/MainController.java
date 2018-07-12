package controller;

import model.entity.User;
import model.hibPackage.UserHiberSession;
import service.UserService;
import service.exception.IncorrectDataException;
import util.constant.Messages;
import util.locale.LocalizeMessage;
import view.View;

import java.util.Locale;
import java.util.Scanner;

/**
 * Created by Vladyslava_Hubenko on 7/12/2018.
 */
public class MainController {

    View view = new View();
    Scanner scanner =  new Scanner(System.in);

    public void singIn(){
        view.printMessages(Messages.LOGIN);
        String login = scanner.next();
        view.printMessages(Messages.PASSWORD);
        String password = scanner.next();

        UserService service = new UserService(new UserHiberSession());
        try {
            User user = service.getByLoginAndPassword(login,password);
            view.printMessages(user.toString());
        } catch (IncorrectDataException e) {
            e.printStackTrace();
        }
    }
}
