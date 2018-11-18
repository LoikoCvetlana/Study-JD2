//package com.sportoras.database.dao.userDao;
//
//import com.querydsl.jpa.impl.JPAQuery;
//import com.sportoras.database.dao.BaseDaoImpl;
//import com.sportoras.database.entity.QUser;
//import com.sportoras.database.entity.QUserDateil;
//import com.sportoras.database.entity.User;
//import org.hibernate.Session;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public class UserDaoImpl extends BaseDaoImpl<Long, User> implements UserDao {
//
//    private static final UserDao INSTANCE = new UserDaoImpl();
//    public static final QUser USER = QUser.user;
//    public static final QUserDateil USER_DATEIL = QUserDateil.userDateil;
//
//    @Override
//    public User findByMailPassword(Session session, String email, String password) {
//        return new JPAQuery<User>(session)
//                .select(USER)
//                .from(USER)
//                .where(USER.email.eq(email).and(USER.password.eq(password)))
//                .fetchOne();
//    }
//
//    @Override
//    public User findByCompany(Session session, String company) {
//        return new JPAQuery<User>(session)
//                .select(USER)
//                .from(USER)
//                .join(USER.userDateil, USER_DATEIL)
//                .where(USER_DATEIL.company.eq(company))
//                .groupBy(USER_DATEIL.company)
//                .fetchOne();
//    }
//
//    public static UserDao getInstance() {
//        return INSTANCE;
//    }
//}
//
//
//
//
