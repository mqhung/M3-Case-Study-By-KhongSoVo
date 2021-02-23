package service.userService;

import model.User;
import storage.GetConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    public List<User> findAll(){
        List<User> list=new ArrayList<>();
        Connection connection = GetConnection.getConnetion();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement("select * from user");
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                int id=resultSet.getInt("id");
                String account=resultSet.getString("account");
                String password =resultSet.getString("password");
                String email=resultSet.getString("email");
                String avatar=resultSet.getString("avatar");
                int phoneNumber=resultSet.getInt("phoneNumber");
                String address=resultSet.getString("address");
                User user=new User(id,account,password,email,avatar,phoneNumber,address);
                list.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
    public User getById(int id){
        User user=null;
        Connection connection=GetConnection.getConnetion();
        try {
            PreparedStatement preparedStatement= connection.prepareStatement("select * from where id=?");
            preparedStatement.setInt(1,id);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                String account=resultSet.getString("account");
                String password =resultSet.getString("password");
                String email=resultSet.getString("email");
                String avatar=resultSet.getString("avatar");
                int phoneNumber=resultSet.getInt("phoneNumber");
                String address=resultSet.getString("address");
                user=new User(id,account,password,email,avatar,phoneNumber,address);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }
}
