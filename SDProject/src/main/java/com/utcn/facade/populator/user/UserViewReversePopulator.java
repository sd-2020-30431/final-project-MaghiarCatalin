package com.utcn.facade.populator.user;

import com.utcn.data.user.UserViewData;
import com.utcn.facade.populator.Populator;
import com.utcn.model.BillingAddress;
import com.utcn.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserViewReversePopulator implements Populator<UserViewData, User> {

    @Override
    public void populate(User user, UserViewData userViewData) {
        user.setFirstName(userViewData.getFirstName());
        user.setLastName(userViewData.getLastName());
        user.setPhoneNumber(userViewData.getPhoneNumber());
        user.setIDNumber(userViewData.getIDNumber());
        BillingAddress billingAddress = new BillingAddress();
        billingAddress.setCountry(userViewData.getCountry());
        billingAddress.setCity(userViewData.getCity());
        billingAddress.setZipCode(userViewData.getZipCode());
        billingAddress.setStreetName(userViewData.getStreetName());
        billingAddress.setStreetNumber(userViewData.getStreetNumber());
        billingAddress.setFlatNumber(userViewData.getFlatNumber());
        billingAddress.setBuildingNumber(userViewData.getBuildingNumber());
        user.setBillingAddress(billingAddress);
    }
}
