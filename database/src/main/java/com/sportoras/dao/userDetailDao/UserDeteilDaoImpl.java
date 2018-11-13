package com.sportoras.dao.userDetailDao;

import com.sportoras.dao.BaseDaoImpl;
import com.sportoras.entity.UserDateil;

public class UserDeteilDaoImpl extends BaseDaoImpl<Long, UserDateil> implements UserDetailDao {

    private static final UserDetailDao INSTANCE = new UserDeteilDaoImpl();



    public static UserDetailDao getInstance() {
        return INSTANCE;
    }
}




