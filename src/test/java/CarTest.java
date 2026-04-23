import br.com.jawc.dao.BrandDAO;
import br.com.jawc.dao.CarDAO;
import br.com.jawc.domain.Brand;
import br.com.jawc.domain.Car;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author jawc
 */

public class CarTest {

    @Test
    public void CarTest(){
        CarDAO carDao = new CarDAO();
        BrandDAO brandDao = new BrandDAO();

        Brand brand = new Brand();
        brand.setName("BYD");
        brandDao.save(brand);

        Car car = new Car();
        car.setBrand(brand);
        car.setName("SEAL");
        car.setModel("COMFORT");

        carDao.save(car);
        Assert.assertNotNull(car.getId());

        Car carConsulted = carDao.findById(car.getId());
        Assert.assertNotNull(carConsulted);

        car.setModel("EXCELLENCE");
        carDao.update(car);

        Car carConsultedUpd = carDao.findById(car.getId());
        Assert.assertEquals(car.getModel(), carConsultedUpd.getModel());

        carDao.delete(carConsultedUpd);
        Car carConsultedDel = carDao.findById(carConsultedUpd.getId());
        Assert.assertNull(carConsultedDel);


    }

}
