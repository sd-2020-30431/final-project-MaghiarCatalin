package com.utcn.dao.user.impl;

import com.utcn.dao.HibernateAbstractCrudRepository;
import com.utcn.dao.user.BillingAddressDao;
import com.utcn.model.BillingAddress;
import org.springframework.stereotype.Repository;

@Repository
public class BillingAddressDaoImpl extends HibernateAbstractCrudRepository<Long, BillingAddress> implements BillingAddressDao {

    @Override
    protected Class<BillingAddress> getValueClass() {
        return BillingAddress.class;
    }

}
