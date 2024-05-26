package com.startcoding0to1.shopeasybackend.generator;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserIdGenerator implements IdentifierGenerator {
    @Override
    public Object generate(SharedSessionContractImplementor session, Object object) {
        String prefix="User_";
        String suffix="";
        try {
            Connection connection=session.getJdbcConnectionAccess().obtainConnection();
            Statement statement=connection.createStatement();
            String sql="Select user_sequence.NEXTVAL from dual";
            ResultSet rs=statement.executeQuery(sql);
            if(rs.next()){
                int seqval=rs.getInt(1);
                suffix=String.valueOf(seqval);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return prefix+suffix;
    }
}
