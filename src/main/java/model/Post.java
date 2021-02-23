package model;

import service.commentService.CommentService;
import service.likesService.LikesService;

import java.util.List;

public class Post {
    private int id;
    private String image;
    private String content;
    private int user_id;

    public Post(String image, String content, int user_id) {
        this.image = image;
        this.content = content;
        this.user_id = user_id;
    }

    public Post(int id, String image, String content, int user_id) {
        this.id=id;
        this.image = image;
        this.content = content;
        this.user_id = user_id;
    }
    public List<Comment> getListComment(){
        return CommentService.getCommentByPost_id(id);
    }
    public int getLikeAmount(){
        return LikesService.getLikeAmount(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
