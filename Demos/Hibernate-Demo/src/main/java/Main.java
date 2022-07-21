import com.Util.HibernateUtil;
import com.models.Crime;
import com.models.SuperPrison;
import com.models.SuperVillain;
import com.persistence.CrimeDAO;
import com.persistence.SuperPrisonDAO;
import com.persistence.SuperVillainDAO;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("Running our Hibernate Demo");


        Crime c1 = new Crime("Arson","setting the city ablaze");
        Crime c2 = new Crime("Murder","killing too many people");
        Crime c3 = new Crime("Rape","unspeakable actions towards another person");
        Crime c4 = new Crime("Robbery","took a granny's purse");
        Crime c5 = new Crime("Beauty","why'd i wake up so cute this morning");


        CrimeDAO crimeDAO = new CrimeDAO();

        crimeDAO.insert(c1);
        crimeDAO.insert(c2);
        crimeDAO.insert(c3);
        crimeDAO.insert(c4);
        crimeDAO.insert(c5);

        List<Crime> crimes = new ArrayList<Crime>();
        crimes.add(c1);
        crimes.add(c4);

        SuperPrison arkham = new SuperPrison("Arkham Asylum","Gotham City");


        SuperVillain joker = new SuperVillain("The Joker","evilness",1_000_000.00, crimes,arkham);

        SuperPrisonDAO spdao = new SuperPrisonDAO();
        spdao.insert(arkham);

        SuperVillainDAO svdao = new SuperVillainDAO();
        svdao.insert(joker);

        System.out.println(svdao.selectAll());

    }
}
