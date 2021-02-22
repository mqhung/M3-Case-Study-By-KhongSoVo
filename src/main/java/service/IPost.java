package service;

import model.Post;

import java.util.List;

public interface IPost {
    List<Post> fillAll(int user_id);
void createPost(Post post);
Post updatePost(int id, Post post);
void deletePost(int id);
    Post findById(int id);
}
