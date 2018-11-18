package com.sportoras.database.repository;

import com.sportoras.database.entity.Rewiew;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface RewiewRepository extends CrudRepository<Rewiew, Long> {

    List<Rewiew> findAllByDate(LocalDate date);

    List<Rewiew> findAllByUserEmail(String email);

    @Query("select r "
            + "from Rewiew r "
            + "join r.user u "
            + "join u.userDateil ud "
            + "where r.date > :date and u.email = :email and ud.company = :company")
    List<Rewiew> filtersRewiew(@Param("date") LocalDate date, @Param("email") String email, @Param("company") String company);

}