package storage;

import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUser {
    public static final String SELECT_ALL_USER = "select * form user;";
    private static final String FIND_FRIEND_BY_ID = "select * from users where id = ?;";
    private static String url = "jdbc:mysql://localhost:3306/case_study";
    private static String user = "root";
    private static String password = "hunghip12";

    public UserDAO(int id, String account, String password, String email, String avatar, int phoneNumber, String address) {
    }


    public static Connection getConnetion() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            System.out.println("không có driver");
        } catch (SQLException throwables) {
            System.out.println("Không kết nối được");
        }
        System.out.println("kết nối thành công");

        return connection;
    }

    @Override
    public List<User> showAllFriend() {
        List<User> list = new ArrayList<>();
        Connection connection = getConnetion();
        try {
            PreparedStatement p = connection.prepareStatement(SELECT_ALL_USER);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String account = rs.getString("account");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String avatar = rs.getString("avatar");
                int phoneNumber = rs.getInt("phoneNumber");
                String address = rs.getString("address");
                list.add(new User(id, account, password, email, avatar, phoneNumber, address));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return list;
    }

    @Override
    public User findFriendById(int id) {
        User user = null;
        Connection connection = getConnetion();
        try {
            PreparedStatement p = connection.prepareStatement(FIND_FRIEND_BY_ID);
            p.setInt(1, id);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                String account = rs.getString("account");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String avatar = rs.getString("avatar");
                int phoneNumber = rs.getInt("phoneNumber");
                String address = rs.getString("address");
                user = new User(id, account, password, email, avatar, phoneNumber, address);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return user;
    }
}
