import com.Persistance.*;
import com.Utils.ConnectionManager;
import com.Utils.CurrentUser;

import java.sql.Date;

public class Main {
    public static void main(String[] args) {

        TeacherDAO teacherDAO = new TeacherDAO();
        RequestDAO requestDAO = new RequestDAO();
        PrincipalDAO principalDAO = new PrincipalDAO();

//
//        Teacher msTiffany = new Teacher("Tiffany","Obi",
//                "tiffany.obi@revature.com","password",101);
//
//        Integer msTiffanyID = teacherDAO.create(msTiffany);

        //if you had to retrieve the principal ID from the database becuase u didnt know it
        // the logic would be as follows
        //basically this logic is saying that you would have to send the request to the database ,
        //get the teachers id and read using the teacher id the use this return to get whta was sent to the db
        //however we can always change the create method to return a Teacher object instead of
        // an int and then you can have your teacher with all updated information immediately
//        Teacher msTiffFromDB = teacherDAO.read(msTiffanyID);
//        Request timeOffRequest = new Request(Date.valueOf("2022-07-21"),Date.valueOf("2022-07-28"),
//                "Turn up time",msTiffanyID, msTiffFromDB.getPrincipalID());



//        Request timeOffRequest = new Request(Date.valueOf("2022-07-21"),Date.valueOf("2022-07-28"),
//                "Turn up time",false,msTiffanyID, msTiffany.getPrincipalID());
//        requestDAO.create(timeOffRequest);
//
//
//        //this should return null because the approved 'boolean' has not been set
//        System.out.println("This means that it was a success -" + timeOffRequest.getApproved());

        //this gives a current teacher
//       CurrentUser cu = teacherDAO.loginCurrentTeacher("tiffany.obi@revature.com","password");
//        System.out.println(cu.getFirstName());


        //this is a current principal
        CurrentUser cu = principalDAO.loginCurrentPrincipal("ingridJos99@aol.com","password");
        System.out.println(cu.getFirstName());

    }
}
