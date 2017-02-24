import com.company.bean.Cinema;
import com.company.dao.BaseFileDao;
import com.company.dao.Converter;
import com.company.dao.Dao;

import java.util.List;

/**
 * Created by Kiryl_Parfiankou on 2/24/2017.
 */
public class Runner {

    public static void main(String... args) {

        Dao<Cinema> cinemaDao = new BaseFileDao<Cinema>("D:\\No-Work\\data\\cinema.csv", new Converter<Cinema>() {

            private int ORDER_ID = 0;
            private int ORDER_NAME = 1;
            private int ORDER_ADDRESS = 2;

            @Override
            public Cinema convert(String line) {

                if (line != null) {
                    Cinema cinema = new Cinema();
                    String[] snippets = line.split(";");
                    cinema.setId(snippets[ORDER_ID]);
                    cinema.setName(snippets[ORDER_NAME]);cinema.setAddress(snippets[ORDER_ADDRESS]);
                    return cinema;
                }

                return null;
            }
        });

        List<Cinema> cinemaList = cinemaDao.findAll();

        for(Cinema cinema: cinemaList) {
            System.out.println(cinema);
        }

    }
}
