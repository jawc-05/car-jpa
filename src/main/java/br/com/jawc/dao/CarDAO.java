/**
 * @author jawc
 */
package br.com.jawc.dao;

import br.com.jawc.dao.generic.GenericDAO;
import br.com.jawc.dao.generic.IGenericDAO;
import br.com.jawc.domain.Car;

public class CarDAO extends GenericDAO<Car> implements IGenericDAO<Car> {

    @Override
    public Car save(Car entity) {
        return super.save(entity);
    }
}
