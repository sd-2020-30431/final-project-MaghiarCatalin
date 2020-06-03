package com.utcn.facade.converter.user;

import com.utcn.data.user.UserViewData;
import com.utcn.facade.converter.Converter;
import com.utcn.facade.populator.Populator;
import com.utcn.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserViewConverter implements Converter<User, UserViewData> {

    @Autowired
    private Populator<User, UserViewData> userViewPopulator;

    @Override
    public UserViewData convert(User user) {
        UserViewData UserViewData = new UserViewData();
        userViewPopulator.populate(UserViewData, user);
        return UserViewData;
    }
}
