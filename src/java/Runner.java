import com.company.bean.Cinema;
import com.company.dao.BaseFileDao;
import com.company.dao.Converter;
import com.company.dao.Dao;
import com.company.dao.factory.CinemaDaoFactory;

import java.util.List;

/**
 * Created by Kiryl_Parfiankou on 2/24/2017.
 */
public class Runner {

    public static void main(String... args) {

        Dao<Cinema> cinemaDao = CinemaDaoFactory.getInstance().createDao();

        List<Cinema> cinemaList = cinemaDao.findAll();

        for(Cinema cinema: cinemaList) {
            System.out.println(cinema);
        }

    }
}
