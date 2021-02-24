package service.postService;

import model.Post;
import service.commentService.CommentService;
import service.likesService.LikesService;
import storage.GetConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostService implements IPostService{
    @Override
    public List<Post> findAll() {
        List<Post> list =new ArrayList<>();
        Connection connection= GetConnection.getConnetion();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement("select * from post");
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                int id=resultSet.getInt("id");
                String image=resultSet.getString("image");
                String content=resultSet.getString("content");
                int user_id=resultSet.getInt("user_id");
                Post post=new Post(id,image,content,user_id);
                list.add(post);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public Post findById(int id) {
        Post post=null;
        Connection connection=GetConnection.getConnetion();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement("select * from post where id =?");
            preparedStatement.setInt(1,id);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                String image=resultSet.getString("image");
                String content=resultSet.getString("content");
                int user_id=resultSet.getInt("user_id");
                post=new Post(id,image,content,user_id);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return post;
    }
    @Override
    public void create(Post post) {
        Connection connection=GetConnection.getConnetion();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO post (user_id, image, content) VALUES (?, ?, ?);");
            preparedStatement.setInt(1, post.getUser_id());
            preparedStatement.setString(2, post.getImage());
            preparedStatement.setString(3, post.getContent());
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void update(Post post) {
        Connection connection=GetConnection.getConnetion();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update post set content = ? where id = ? ;");
            preparedStatement.setInt(2, post.getId());
            preparedStatement.setString(1, post.getContent());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void delete(int id) {
        Connection connection=GetConnection.getConnetion();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from post where id = ?;");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public List<Post> fillAll(int user_id) {
        List<Post> posts = new ArrayList<>();
        Connection connection = GetConnection.getConnetion();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from post where user_id = ? order by id desc ;");
            preparedStatement.setInt(1, user_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String content = resultSet.getString("content");
                String image = resultSet.getString("image");
                posts.add(new Post(id, image, content, user_id));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return posts;
    }
}
