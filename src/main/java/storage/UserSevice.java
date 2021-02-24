package storage;

import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserSevice implements IUserSevice{
    protected Connection getConnection() {
       return GetConnection.getConnetion();
    }

    @Override
    public List<User> findAll() {
        List<User> userList = new ArrayList<>();
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from User;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String account = resultSet.getString("account");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                String avata = resultSet.getString("avatar");
                int phoneNumber = resultSet.getInt("phoneNumber");
                String address = resultSet.getString("address");

                User user = new User(id,account,password,email,avata,phoneNumber,address);
                userList.add(user);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userList;
    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public boolean remove(int id) {
        return false;
    }

    @Override
    public User save(User user) {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into User(account, password, email, avatar, phoneNumber, address) value (?,?,?,?,?,?)");

            preparedStatement.setString(1, user.getAccount());
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.setString(3,user.getEmail());
            preparedStatement.setString(4,user.getAvatar());
            preparedStatement.setInt(5,user.getPhoneNumber());
            preparedStatement.setString(6,user.getAddress());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }
}
