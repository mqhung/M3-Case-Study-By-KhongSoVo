package model;

public class RelationShip {
    private int user_id;
    private int friend_id;
    private int relative_status_id;

    public RelationShip(int user_id, int friend_id, int relative_status_id) {
        this.user_id = user_id;
        this.friend_id = friend_id;
        this.relative_status_id = relative_status_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getFriend_id() {
        return friend_id;
    }

    public void setFriend_id(int friend_id) {
        this.friend_id = friend_id;
    }

    public int getRelative_status_id() {
        return relative_status_id;
    }

    public void setRelative_status_id(int relative_status_id) {
        this.relative_status_id = relative_status_id;
    }
}
