package com.sportoras.dao;

import com.sportoras.connection.ConnectionManager;
import com.sportoras.util.TestDataImporter;

public class BaseDaoTest {

    static {
        TestDataImporter.getInstance().importTestData(ConnectionManager.getFactory());
    }
}
