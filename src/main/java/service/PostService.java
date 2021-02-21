package service;

import model.Post;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostService implements IPost {
    private String jdbcURL = "jdbc:mysql://localhost:3306/case_study";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";

    Connection getConnection() {
        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);

        } catch (ClassNotFoundException e) {
            System.out.println("k co thu vien");
        } catch (SQLException throwables) {
            System.out.println("k ket noi dc");
        }
        System.out.println("kn thanh cong");
        return connection;
    }

    @Override
    public List<Post> fillAll(int user_id) {
        List<Post> posts = new ArrayList<>();
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from post where user_id = ? ;");
            preparedStatement.setInt(1,user_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String content = resultSet.getString("content");
                String image = resultSet.getString("image");
                //int user_id = resultSet.getInt("user_id");
                posts.add(new Post(id,image,content,user_id));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return posts;
    }

    @Override
    public void createPost(Post post) {

    }

    @Override
    public boolean updatePost(int id) {
        return false;
    }

    @Override
    public void deletePost(int id) {

    }
}
