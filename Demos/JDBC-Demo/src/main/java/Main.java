import com.Persistance.*;
import com.Utils.ConnectionManager;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

//        User andrew = new User("Andrew","Jackson","ajackson@aol.com");
//
//        UserDAO userDao = new UserDAO();
//
//        System.out.println(userDao.create(andrew));

        UserDAO userDao = new UserDAO();
        AccountTypeDAO accountTypeDAO = new AccountTypeDAO();
        AccountDAO accountDAO = new AccountDAO();

        User benji = new User("Benji","ReadyToGo","benji@isoutofthebuilding.com");
        Integer benjiUserId = userDao.create(benji);


        AccountType accType = new AccountType("checking");
        Integer accTypeId = accountTypeDAO.create(accType);

        Account bankAccount = new Account(100.00,accTypeId,benjiUserId, Date.valueOf(LocalDate.now()));
        System.out.println(accountDAO.create(bankAccount));

    }
}
