package com.startcoding0to1.shopeasybackend.generator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

/**
 * Custom generator for generating product IDs.
 * This generator is responsible for generating unique product IDs for new products.
 * 
 * @author Mahammad Khairuddin
 */
public class ProductIdGenerator implements IdentifierGenerator {

    /**
     * Generates a unique product ID using a custom format.
     * 
     * @param session The Hibernate session.
     * @param object The object for which the ID is being generated.
     * @return A unique product ID.
     */
    @Override
    public Object generate(SharedSessionContractImplementor session, Object object) {
        String prefix = "Prod_";
        String suffix = "";
        try {
            Connection con = session.getJdbcConnectionAccess().obtainConnection();
            Statement stmt = con.createStatement();
            String sql = "Select PRODUCT_SEQUENCE.NEXTVAL from dual";
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                int seqval = rs.getInt(1);
                suffix = String.valueOf(seqval);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prefix + suffix;
    }
}
