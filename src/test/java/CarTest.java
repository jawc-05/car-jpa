import br.com.jawc.dao.AccessoriesDAO;
import br.com.jawc.dao.BrandDAO;
import br.com.jawc.dao.CarDAO;
import br.com.jawc.domain.Accessories;
import br.com.jawc.domain.Brand;
import br.com.jawc.domain.Car;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * @author jawc
 */

public class CarTest {

    @Test
    public void CarTest(){
        CarDAO carDao = new CarDAO();
        BrandDAO brandDao = new BrandDAO();
        AccessoriesDAO accessoriesDAO = new AccessoriesDAO();

        Brand brand = new Brand();
        brand.setName("BYD");
        brandDao.save(brand);

        Car car = new Car();
        car.setBrand(brand);
        car.setName("SEAL");
        car.setModel("COMFORT");
        Accessories accessories = new Accessories();
        accessories.setName("SOM JBL");
        accessoriesDAO.save(accessories);
        accessories.setName("TETO SOLAR");
        accessoriesDAO.save(accessories);

        Car car2 = new Car();
        car2.setBrand(brand);
        car2.setName("Dolphin");
        car2.setModel("MINI");

        carDao.save(car);
        carDao.save(car2);
        Assert.assertNotNull(car.getId());

        Car carConsulted = carDao.findById(car.getId());
        Assert.assertNotNull(carConsulted);

        car.setModel("EXCELLENCE");
        carDao.update(car);

        List list = carDao.findAll();
        Assert.assertNotNull(list);
        Assert.assertEquals(list.size(), 2);

        Car carConsultedUpd = carDao.findById(car.getId());
        Assert.assertEquals(car.getModel(), carConsultedUpd.getModel());

        carDao.delete(carConsultedUpd);
        Car carConsultedDel = carDao.findById(carConsultedUpd.getId());
        Assert.assertNull(carConsultedDel);
        carDao.delete(car2);

    }

}
