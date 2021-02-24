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
    public static final String SELECT_ALL_NOTICE_BY_ID = "select * from notice where user_id=?;";
    public static final String CREATE_NOTICE = "insert into notice values (?,?,?)";
    public static final String UPDATE_NOTICE = "update notice set content = ? where user_id = ?;";
    public static final String UPDATE_RELATIVE = "update relationship set relative_status_id = ? where id = ?;";

    public UserDAO() {
    }


    public static Connection getConnetion() {
      return GetConnection.getConnetion();

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

    public int createRelative(RelationShip relationShip) {
        int rowEffect = 0;
        Connection connection = getConnetion();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_RELATIONSHIP);
            preparedStatement.setInt(1, relationShip.getId());
            preparedStatement.setInt(2, relationShip.getUser_id());
            preparedStatement.setInt(3, relationShip.getFriend_id());
            preparedStatement.setInt(4, relationShip.getRelative_status_id());
            rowEffect = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowEffect;
    }

    public void createNotice(Notice notice) {
        Connection connection = getConnetion();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_NOTICE);
            preparedStatement.setInt(1, notice.getId());
            preparedStatement.setInt(2, notice.getUser_id());
            preparedStatement.setString(3, notice.getContent());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Notice> findNoticeByUser_id(int user_id) {
        List<Notice> list = new ArrayList<>();
        Connection connection = getConnetion();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SELECT_ALL_NOTICE_BY_ID);
            preparedStatement.setInt(1, user_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String content = resultSet.getString("content");
                Notice notice = new Notice(id, user_id, content);
                list.add(notice);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public void editNotice(Notice notice) {
        Connection connection = getConnetion();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(UPDATE_NOTICE);
            preparedStatement.setString(1, notice.getContent());
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public int editRelationship(int relativeId, int id) {
        int rowEffect = 0;
        Connection connection = getConnetion();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(UPDATE_RELATIVE);
            preparedStatement.setInt(1,relativeId);
            preparedStatement.setInt(2,id);
            rowEffect = preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return rowEffect;
    }
}
