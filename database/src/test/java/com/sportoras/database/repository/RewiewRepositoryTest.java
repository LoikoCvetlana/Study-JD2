package com.sportoras.database.repository;

import com.sportoras.database.config.TestConfiguration;
import com.sportoras.database.entity.Rewiew;
import com.sportoras.database.util.DatabaseHelper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
@Transactional
public class RewiewRepositoryTest {

    @Autowired
    private DatabaseHelper databaseHelper;

    @Autowired
    private RewiewRepository rewiewRepository;

    @Before
    public void init() {
        databaseHelper.cleanDatabase();
        databaseHelper.prepareData();
    }

    @Test
    public void checkFilters() {
        List<Rewiew> rewiews = rewiewRepository.filtersRewiew
                (LocalDate.of(2017, 01, 01), "mail0", "RCOP");
        assertThat(rewiews, hasSize(2));
    }
}