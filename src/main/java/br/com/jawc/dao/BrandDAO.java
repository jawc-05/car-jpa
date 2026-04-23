/**
 * @author jawc
 */
package br.com.jawc.dao;

import br.com.jawc.dao.generic.GenericDAO;
import br.com.jawc.domain.Brand;

public class BrandDAO extends GenericDAO<Brand> {

    @Override
    public Brand save(Brand entity) {
        return super.save(entity);
    }
}
