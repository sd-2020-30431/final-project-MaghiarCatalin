package com.utcn.facade.populator.user;

import com.utcn.data.user.UserData;
import com.utcn.facade.populator.Populator;
import com.utcn.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserPopulator implements Populator<User, UserData> {

    @Override
    public void populate(UserData userData, User user) {
        userData.setEmail(user.getEmail());
        userData.setPassword(user.getPassword());
        userData.setRole(user.getRole());
        userData.setFirstName(user.getFirstName());
        userData.setLastName(user.getLastName());
        userData.setPhoneNumber(user.getPhoneNumber());
        userData.setAddressId(Long.toString(user.getBillingAddress().getId()));
        userData.setCountry(user.getBillingAddress().getCountry());
        userData.setCity(user.getBillingAddress().getCity());
        userData.setZipCode(user.getBillingAddress().getZipCode());
        userData.setStreetName(user.getBillingAddress().getStreetName());
        userData.setStreetNumber(user.getBillingAddress().getStreetNumber());
        userData.setFlatNumber(user.getBillingAddress().getFlatNumber());
        userData.setBuildingNumber(user.getBillingAddress().getBuildingNumber());
        userData.setIDNumber(user.getIDNumber());
    }
}
