package com.sportoras.dao.materialDao;

import com.sportoras.dao.BaseDao;
import com.sportoras.entity.Material;
import org.hibernate.Session;

import java.util.List;

public interface MaterialDao extends BaseDao<Long, Material> {

    List<Material> findMaterialInStock(Session session);
}
