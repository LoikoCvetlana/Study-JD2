//package com.sportoras.database.dao.rewiewDao;
//
//import com.querydsl.jpa.impl.JPAQuery;
//import com.sportoras.database.dao.BaseDaoImpl;
//import com.sportoras.database.entity.QRewiew;
//import com.sportoras.database.entity.QUser;
//import com.sportoras.database.entity.QUserDateil;
//import com.sportoras.database.entity.Rewiew;
//import org.hibernate.Session;
//
//import java.time.LocalDate;
//import java.util.List;
//
//public class RewiewDaoImpl extends BaseDaoImpl<Long, Rewiew> implements RewiewDao {
//
//    private static final RewiewDao INSTANCE = new RewiewDaoImpl();
//    public static final QUser USER = QUser.user;
//    public static final QRewiew REWIEW = QRewiew.rewiew;
//    public static final QUserDateil USERDETAIL = QUserDateil.userDateil;
//
//    @Override
//    public List<Rewiew> findByUser(Session session, String email) {
//        return new JPAQuery<Rewiew>(session)
//                .select(REWIEW)
//                .from(REWIEW)
//                .join(REWIEW.user, USER)
//                .where(USER.email.eq(email))
//                .groupBy(USER.email)
//                .fetch();
//    }
//
//    @Override
//    public List<Rewiew> findRewiewafterDateFromUsersFromCompany(Session session, LocalDate date, String email, String compony) {
//        return new JPAQuery<Rewiew>(session)
//                .select(REWIEW)
//                .from(REWIEW)
//                .join(REWIEW.user, USER)
//                .join(USER.userDateil, USERDETAIL)
//                .where(REWIEW.date.after(date).and(USER.email.eq(email)).and(USERDETAIL.company.eq(compony)))
//                .fetch();
//    }
//
//    public static RewiewDao getInstance() {
//        return INSTANCE;
//    }
//}
//
//
//
//
