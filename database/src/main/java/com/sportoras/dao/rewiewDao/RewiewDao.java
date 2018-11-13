package com.sportoras.dao.rewiewDao;

import com.sportoras.dao.BaseDao;
import com.sportoras.entity.Rewiew;
import org.hibernate.Session;

import java.time.LocalDate;
import java.util.List;

public interface RewiewDao extends BaseDao<Long, Rewiew> {

    List<Rewiew> findByUser(Session session, String email);

    List<Rewiew> findRewiewafterDateFromUsersFromCompany(Session session, LocalDate date, String email, String compony);

}
