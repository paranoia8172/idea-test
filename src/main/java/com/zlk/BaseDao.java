package com.zlk;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
    private Jdbc jdbc = new Jdbc();

    public void closeConnection(){
        jdbc.closeConnection();
    }

    public Connection getConnection(){
        return jdbc.getConnection();
    }

    public ResultSet query(String sql){
        try {
            PreparedStatement prepareStatement = jdbc.getConnection().prepareStatement(sql);
            return prepareStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }

    public boolean update(PreparedStatement prstm){
        try {
            return prstm.executeUpdate() > 0; // 这里执行了语句
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
