package service.messeageService;

import model.Messeage;
import storage.GetConnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MesseageService {
    public List<Messeage> findByTwoId(int user_id, int friend_id){
        List<Messeage> list=new ArrayList<>();
        Connection connection= GetConnection.getConnetion();
        try {
            CallableStatement callableStatement=connection.prepareCall("{call get_messeage_by_id(?,?)}");
            callableStatement.setInt(1,user_id);
            callableStatement.setInt(2,friend_id);
            ResultSet resultSet=callableStatement.executeQuery();
            while (resultSet.next()){
                int id=resultSet.getInt("id");
                int userId=resultSet.getInt("user_id");
                int friendId=resultSet.getInt("friend_id");
                String content=resultSet.getString("content");
                Messeage messeage=new Messeage(id,userId,friendId,content);
                list.add(messeage);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}
