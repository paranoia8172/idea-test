package com.zlk;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;


public class UserDao extends BaseDao{

    public int login(String name ,String password){
        UserModel um = new UserModel();
        um = getUser(name);
        if(um.getPassword().equals(password)){
            return 1;
        }
        return 0;
    }

    public UserModel getUser(String name){
        UserModel um = null;
        String sql = "select * from s_homework where username = " + name;
        ResultSet resultSet = query(sql);
        try {
            if(resultSet.next()){
                um = new UserModel();
                um.setUsername(resultSet.getString("username"));
                um.setPassword(resultSet.getString("password"));
                um.setMobile(resultSet.getString("mobile"));
                um.setEmail(resultSet.getString("email"));
                return um;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return um;
    }

    public boolean addUser(UserModel um){
        Jdbc jdbc = new Jdbc();
        PreparedStatement prstm = null;
        boolean result = false;
        Date date = new Date();
        try{
            prstm = jdbc.getConnection().prepareStatement("insert into s_homework values(null,?,?,?,?,?,null)");
            prstm.setString(1,um.getUsername());
            prstm.setString(2,um.getPassword());
            prstm.setString(3,um.getEmail());
            prstm.setString(4,um.getMobile());
            prstm.setString(5,date.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(prstm != null)
        {
            result = update(prstm); //执行update并保存返回结果，这直接调用update(PreparedStatement prstm)重载
            jdbc.cleanup(null,prstm)	;
        }
        return result;
    }
}
