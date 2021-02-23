package service;

import model.Comment;
import model.Likes;
import model.Notice;
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
    public List<Notice> findNoticeByUser_id(int user_id){
        List<Notice> list=new ArrayList<>();
        Connection connection=GetConnection.getConnetion();
        PreparedStatement preparedStatement= null;
        try {
            preparedStatement = connection.prepareStatement("select * from notice where user_id=?");
            preparedStatement.setInt(1,user_id);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                int id=resultSet.getInt("id");
                String content=resultSet.getString("content");
                Notice notice=new Notice(id,user_id,content);
                list.add(notice);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;

    }
    public void creatNotice(Notice notice){
        Connection connection=GetConnection.getConnetion();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement("insert into notice(user_id,content) values (?,?)");
            preparedStatement.setInt(1, notice.getUser_id());
            preparedStatement.setString(2, notice.getContent());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
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
