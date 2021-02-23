package service.postService;

import model.Post;
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

    }

    @Override
    public void update(Post post) {

    }

    @Override
    public void delete(int id) {

    }
}
