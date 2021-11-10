package com.z.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCUtils {

    private static Connection CONNECTION = null;
    static {
        try {
            String url="jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT&rewriteBatchedStatements=true";
            String user="root";
            String password="123456";
            String driverClass="com.mysql.cj.jdbc.Driver";
            Class.forName(driverClass);
            CONNECTION= DriverManager.getConnection(url, user, password);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnect(){
        return CONNECTION;
    }

    public static void close(Connection connection, ResultSet set, PreparedStatement statement){
        try{
            if(connection !=null){
                connection.close();
            }
            if(set !=null){
                set.close();
            }
            if(statement !=null){
                statement.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
