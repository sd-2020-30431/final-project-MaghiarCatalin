package com.utcn.dao.user;

import com.utcn.model.BillingAddress;

import java.util.Optional;

public interface BillingAddressDao {
    Optional<BillingAddress> getById(Long id);

    void update(BillingAddress updatedBillingAddress);

    void delete(Long id);

    void save(BillingAddress value);
}
