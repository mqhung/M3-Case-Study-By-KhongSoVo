package service.likesService;

import model.Likes;
import storage.GetConnection;

import java.sql.*;

public class LikesService {
    public static int getLikeAmount(int post_id){
        int likeAmount=0;
        Connection connection= GetConnection.getConnetion();
        try {
            CallableStatement callableStatement=connection.prepareCall("{call count_post_like(?,?)}");
            callableStatement.setInt(1,post_id);
            callableStatement.registerOutParameter(2, Types.INTEGER);
            callableStatement.execute();
            likeAmount=callableStatement.getInt(2);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return likeAmount;
    }
    public int creatLike(Likes like){
        int rowEffect=0;
        Connection connection =GetConnection.getConnetion();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement("insert into likes(post_id,user_id) values (?,?)");
            preparedStatement.setInt(1,like.getPost_id());
            preparedStatement.setInt(2,like.getUser_id());
            rowEffect=preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowEffect;
    }
    public void deleteByPostId(int postId){
        Connection connection=GetConnection.getConnetion();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement("delete from likes where post_id=?");
            preparedStatement.setInt(1,postId);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
