package org.apache.dolphinscheduler.api.converter;

import com.google.common.base.Converter;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.apache.dolphinscheduler.api.dto.UserDetail;
import org.apache.dolphinscheduler.api.service.UsersService;
import org.apache.dolphinscheduler.common.enums.UserType;
import org.apache.dolphinscheduler.dao.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class UserDetail2UserConverter extends Converter<UserDetail, User> {

    @Autowired
    private UsersService usersService;

    @Override
    @Transactional
    protected User doForward(UserDetail userDetail) {

        Long id = userDetail.getId();
        Integer superAdmin = userDetail.getSuperAdmin();
        //check if user exist
        User user = usersService.getUserByUserName(String.valueOf(id));
        if (user == null) {
            user = usersService.createUser(superAdmin != null && superAdmin == 1 ?
                    UserType.ADMIN_USER : UserType.GENERAL_USER, String.valueOf(id), userDetail.getEmail());
        }
        return user;
    }

    @Override
    protected UserDetail doBackward(User user) {
        return null;
    }
}
