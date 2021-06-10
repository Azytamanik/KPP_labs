import models.*;
import services.*;

import java.sql.SQLException;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws SQLException {

        Date date = new Date();

        UserService userService = new UserService();
     /*   //User user1 = new User("Pavel", 22, 964445);
        userService.saveUser(user1);
        Order order1 = new Order("Checked", date);
        order1.setUser(user1);
        user1.addOrder(order1);
        Auto auto1 = new Auto("BMW", "Black", 25000);
        userService.updateUser(user1);*/
    }
}
