package com.utcn.facade.converter.user;


import com.utcn.data.user.UserData;
import com.utcn.facade.converter.Converter;
import com.utcn.facade.populator.Populator;
import com.utcn.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserConverter implements Converter<User, UserData> {

    @Autowired
    private Populator<User, UserData> userPopulator;

    @Override
    public UserData convert(User user) {
        UserData userData = new UserData();
        userPopulator.populate(userData, user);
        return userData;
    }
}
