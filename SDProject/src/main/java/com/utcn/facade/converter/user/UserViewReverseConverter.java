package com.utcn.facade.converter.user;

import com.utcn.data.user.UserViewData;
import com.utcn.facade.converter.Converter;
import com.utcn.facade.populator.Populator;
import com.utcn.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserViewReverseConverter implements Converter<UserViewData, User> {

    @Autowired
    private Populator<UserViewData, User> userViewReversePopulator;

    @Override
    public User convert(UserViewData UserViewData) {
        User user = new User();
        userViewReversePopulator.populate(user, UserViewData);
        return user;
    }
}
