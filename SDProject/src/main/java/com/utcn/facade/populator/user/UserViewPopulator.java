package com.utcn.facade.populator.user;

import com.utcn.data.user.UserViewData;
import com.utcn.facade.populator.Populator;
import com.utcn.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserViewPopulator implements Populator<User, UserViewData> {

    @Override
    public void populate(UserViewData userViewData, User user) {
        userViewData.setFirstName(user.getFirstName());
        userViewData.setLastName(user.getLastName());
        userViewData.setPhoneNumber(user.getPhoneNumber());
        userViewData.setIDNumber(user.getIDNumber());
        userViewData.setCountry(user.getBillingAddress().getCountry());
        userViewData.setCity(user.getBillingAddress().getCity());
        userViewData.setZipCode(user.getBillingAddress().getZipCode());
        userViewData.setStreetName(user.getBillingAddress().getStreetName());
        userViewData.setStreetNumber(user.getBillingAddress().getStreetNumber());
        userViewData.setFlatNumber(user.getBillingAddress().getFlatNumber());
        userViewData.setBuildingNumber(user.getBillingAddress().getBuildingNumber());
    }
}
