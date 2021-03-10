package ThinkingInJava.Annotations.P793;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.lang.*;
import java.sql.*;

public class TestSqL {
    public static void main(String[] args) {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("111111");
        dataSource.setServerName("localhost");
        dataSource.setDatabaseName("pet_records");
        try(Connection con = dataSource.getConnection();
        Statement stmt = con.createStatement()){
            ResultSet rs = stmt.executeQuery("SELECT * from PETS");
            while(rs.next()){
                String name = rs.getString(1);
                String breed = rs.getString(2);
                String sex = rs.getString(3);
                String date = rs.getString(4);
                System.out.println("Name: " + name +
                        "\nBreed: " + breed +
                        "\nSex: " + sex +
                        "\nDate " + date);
                System.out.println("***************************");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
