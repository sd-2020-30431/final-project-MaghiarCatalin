package com.utcn.facade.converter.user;

import com.utcn.data.user.UserData;
import com.utcn.facade.converter.Converter;
import com.utcn.facade.populator.Populator;
import com.utcn.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserReverseConverter implements Converter<UserData, User> {

    @Autowired
    private Populator<UserData, User> userReversePopulator;

    @Override
    public User convert(UserData userData) {
        User user = new User();
        userReversePopulator.populate(user, userData);
        return user;
    }
}
