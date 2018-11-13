package com.sportoras.dao.materialDao;

import com.querydsl.jpa.impl.JPAQuery;
import com.sportoras.dao.BaseDaoImpl;
import com.sportoras.entity.Material;
import com.sportoras.entity.QMaterial;
import org.hibernate.Session;

import java.util.List;

public class MaterialDaoImpl extends BaseDaoImpl<Long, Material> implements MaterialDao {

    public static final QMaterial MATERIAL = QMaterial.material;
    private static final MaterialDao INSTANCE = new MaterialDaoImpl();

    public static MaterialDao getInstance() {
        return INSTANCE;
    }

    @Override
    public List<Material> findMaterialInStock(Session session) {
        return new JPAQuery<Material>(session)
                .select(MATERIAL)
                .from(MATERIAL)
                .where(MATERIAL.availability.eq(true))
                .fetch();
    }
}

