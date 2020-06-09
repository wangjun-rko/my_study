package com.wj88;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            connection = DriverManager.getConnection("jdbc:ArteryBase://192.168.12.41:5432/db_jcdsj", "jcdsj", "tusc99");
            statement = connection.createStatement();
            rs = statement.executeQuery("select * from t_version");
            while(rs.next()){
                String name = rs.getString("c_version");
                System.out.println(name);
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            // ...省略释放资源的代码
            statement.close();
            connection.close();

        }
    }
}
