package storage;

import model.Notice;
import model.RelationShip;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUser {
    private static final String url = "jdbc:mysql://localhost:3306/case_study";
    private static final String user = "root";
    private static final String password = "hunghip12";
    public static final String SELECT_ALL_USER = "select * from user;";
    private static final String FIND_FRIEND_BY_ID = "select * from user where id = ?;";
    public static final String INSERT_RELATIONSHIP = "insert into relationship values (?,?,?,?);";

    public UserDAO() {
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
    public int createRelative(RelationShip relationShip){
        int rowEffect=0;
        Connection connection =getConnetion();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(INSERT_RELATIONSHIP);
            preparedStatement.setInt(1,relationShip.getId());
            preparedStatement.setInt(2,relationShip.getUser_id());
            preparedStatement.setInt(3,relationShip.getFriend_id());
            preparedStatement.setInt(4,relationShip.getRelative_status_id());
            rowEffect=preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowEffect;
    }

    public void creatNotice(Notice notice){
        Connection connection=getConnetion();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement("insert into notice values (?,?,?)");
            preparedStatement.setInt(1, notice.getId());
            preparedStatement.setInt(2, notice.getUser_id());
            preparedStatement.setString(3, notice.getContent());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
