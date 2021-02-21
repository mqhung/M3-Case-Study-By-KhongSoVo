package service;

import model.Post;

import java.util.List;

public interface IPost {
    List<Post> fillAll(int user_id);
void createPost(Post post);
boolean updatePost(int id);
void deletePost(int id);
}
