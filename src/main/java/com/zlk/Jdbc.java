package com.zlk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Jdbc {
    private String url = "jdbc:mysql://localhost:3306/db_student_manager_web";
    private String user = "root";
    private String password = "";
    private Connection connection = null;

    public Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url,user,password);
            System.out.println("数据库连接成功");
        } catch (Exception e){
            System.out.println("数据库连接失败");
            e.printStackTrace();
        }
        return connection;
    }
    public void closeConnection(){
        if (connection != null)
            try {
                connection.close();
                System.out.println("数据库连接关闭");
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
    public static void cleanup(Connection conn, PreparedStatement prstm) {
        // TODO Auto-generated method stub
        try {
            if(conn != null)
            {
                conn.close();
            }
            if(prstm != null)
            {
                prstm.close();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Jdbc jdbc = new Jdbc();
        jdbc.getConnection();
    }
}
