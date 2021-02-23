package service.noticeService;

import model.Notice;
import storage.GetConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NoticeService {
    public void creatNotice(Notice notice){
        Connection connection= GetConnection.getConnetion();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement("insert into notice(user_id,content) values (?,?)");
            preparedStatement.setInt(1, notice.getUser_id());
            preparedStatement.setString(2, notice.getContent());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
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
}
