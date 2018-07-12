package view;

import java.util.Collection;
import java.util.ResourceBundle;

/**
 * Created by Vladyslava_Hubenko on 7/3/2018.
 */
public class View {

    public void printMessages(String... messages) {
        for (String mes : messages) {
            System.out.println(mes);
        }
    }

    public void printList(Collection<?> objects) {
        objects.forEach(o -> System.out.println(o.toString()));
    }
}
