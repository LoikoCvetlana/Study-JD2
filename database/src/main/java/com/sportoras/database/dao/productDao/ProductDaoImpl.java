//package com.sportoras.database.dao.productDao;
//
//import com.querydsl.jpa.impl.JPAQuery;
//import com.sportoras.database.dao.BaseDaoImpl;
//import com.sportoras.database.entity.Product;
//import com.sportoras.database.entity.QProduct;
//import org.hibernate.Session;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public class ProductDaoImpl extends BaseDaoImpl<Long, Product> implements ProductDao {
//
//    private static final ProductDao INSTANCE = new ProductDaoImpl();
//    public static final QProduct PRODUCT = QProduct.product;
//
//    @Override
//    public List<Product> findByNameAndCostOrder(Session session, String name, Double value, int limit, int offset) {
//        return new JPAQuery<Product>(session)
//                .select(PRODUCT)
//                .from(PRODUCT)
//                .where(PRODUCT.name.eq(name).and(PRODUCT.value.between(0.00, value)))
//                .orderBy(PRODUCT.value.asc())
//                .limit(limit)
//                .offset(offset)
//                .fetch();
//    }
//
//    public static ProductDao getInstance() {
//        return INSTANCE;
//    }
//}
