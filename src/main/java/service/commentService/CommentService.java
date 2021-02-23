package service.commentService;

import model.Comment;
import storage.GetConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentService {
    public static List<Comment> getCommentByPost_id(int post_id){
        List<Comment> list=new ArrayList<>();
        Connection connection= GetConnection.getConnetion();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement("select * from comment where post_id=?");
            preparedStatement.setInt(1,post_id);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                int id=resultSet.getInt("id");
                int user_id=resultSet.getInt("user_id");
                String content=resultSet.getString("content");
                Comment comment=new Comment(id,user_id,post_id,content);
                list.add(comment);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
    public int createComment(Comment comment){
        int rowEffect=0;
        Connection connection =GetConnection.getConnetion();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement("insert into comment(user_id,post_id,content ) values (?,?,?)");
            preparedStatement.setInt(1,comment.getUser_id());
            preparedStatement.setInt(2,comment.getPost_id());
            preparedStatement.setString(3,comment.getContent());
            rowEffect=preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowEffect;
    }
}
