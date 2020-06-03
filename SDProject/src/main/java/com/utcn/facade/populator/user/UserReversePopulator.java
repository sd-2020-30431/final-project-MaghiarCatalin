package com.utcn.facade.populator.user;

import com.utcn.data.user.UserData;
import com.utcn.facade.populator.Populator;
import com.utcn.model.BillingAddress;
import com.utcn.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserReversePopulator implements Populator<UserData, User> {

    @Override
    public void populate(User user, UserData userData) {
        user.setEmail(userData.getEmail());
        user.setPassword(userData.getPassword());
        user.setRole(userData.getRole());
        user.setFirstName(userData.getFirstName());
        user.setLastName(userData.getLastName());
        user.setPhoneNumber(userData.getPhoneNumber());
        user.setIDNumber(userData.getIDNumber());
        Long id;
        if (userData.getAddressId() != null && !userData.getAddressId().isEmpty()) {
            id = Long.parseLong(userData.getAddressId());
        } else {
            id = null;
        }
        BillingAddress billingAddress = new BillingAddress();
        billingAddress.setId(id);
        billingAddress.setCountry(userData.getCountry());
        billingAddress.setCity(userData.getCity());
        billingAddress.setZipCode(userData.getZipCode());
        billingAddress.setStreetName(userData.getStreetName());
        billingAddress.setStreetNumber(userData.getStreetNumber());
        billingAddress.setFlatNumber(userData.getFlatNumber());
        billingAddress.setBuildingNumber(userData.getBuildingNumber());
        user.setBillingAddress(billingAddress);
    }
}
