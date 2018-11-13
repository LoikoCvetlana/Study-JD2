package com.sportoras.dao.userDao;

import com.sportoras.dao.BaseDao;
import com.sportoras.entity.User;
import org.hibernate.Session;

public interface UserDao extends BaseDao<Long, User> {

    User findByMailPassword(Session session, String email, String password);

    User findByCompany(Session session, String company);

}
