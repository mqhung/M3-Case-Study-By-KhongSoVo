package model;

public class Likes {
    private int id;
    private int post_id;
    private int user_id;

    public Likes(int post_id, int user_id) {
        this.post_id = post_id;
        this.user_id = user_id;
    }

    public Likes(int id, int post_id, int user_id) {
        this.id=id;
        this.post_id = post_id;
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
