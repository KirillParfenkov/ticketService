import com.company.bean.Cinema;
import com.company.bean.Session;
import com.company.bean.Ticket;
import com.company.dao.Dao;
import com.company.dao.factory.cinama.CinemaDaoFactory;
import com.company.dao.factory.session.SessionDaoFactory;
import com.company.dao.factory.ticket.TicketDatabaseDao;

import java.util.List;

/**
 * Created by Kiryl_Parfiankou on 2/24/2017.
 */
public class Runner {

    public static void main(String... args) {

        Dao<Cinema> cinemaDao = CinemaDaoFactory
                .getInstance().createDao();
        Dao<Session> sessionDao = SessionDaoFactory
                .getInstance().createDao();

        Dao<Ticket> ticketDao = new TicketDatabaseDao();


        List<Cinema> cinemaList = cinemaDao.findAll();

        for(Cinema cinema: cinemaList) {
            System.out.println(cinema);
        }

        for(Session session: sessionDao.findAll()) {
            System.out.println(session);
        }

        for (Ticket ticket: ticketDao.findAll()) {
            System.out.println(ticket);
        }

    }
}
