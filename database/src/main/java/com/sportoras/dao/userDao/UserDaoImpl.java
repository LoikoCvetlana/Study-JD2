package com.sportoras.dao.userDao;

import com.querydsl.jpa.impl.JPAQuery;
import com.sportoras.dao.BaseDaoImpl;
import com.sportoras.entity.QUser;
import com.sportoras.entity.QUserDateil;
import com.sportoras.entity.User;
import org.hibernate.Session;

public class UserDaoImpl extends BaseDaoImpl<Long, User> implements UserDao {

    private static final UserDao INSTANCE = new UserDaoImpl();
    public static final QUser USER = QUser.user;
    public static final QUserDateil USER_DATEIL = QUserDateil.userDateil;

    @Override
    public User findByMailPassword(Session session, String email, String password) {
        return new JPAQuery<User>(session)
                .select(USER)
                .from(USER)
                .where(USER.email.eq(email).and(USER.password.eq(password)))
                .fetchOne();
    }

    @Override
    public User findByCompany(Session session, String company) {
        return new JPAQuery<User>(session)
                .select(USER)
                .from(USER)
                .join(USER.userDateil, USER_DATEIL)
                .where(USER_DATEIL.company.eq(company))
                .groupBy(USER_DATEIL.company)
                .fetchOne();
    }

    public static UserDao getInstance() {
        return INSTANCE;
    }
}




