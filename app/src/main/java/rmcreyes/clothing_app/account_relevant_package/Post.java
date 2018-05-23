package rmcreyes.clothing_app.account_relevant_package;

import java.util.List;

/**
 * Created by robin on 2018-05-22.
 */

public class Post {

    private int post_id, user_id, like_count, comment_count;
    private String username, bio;
    private List<Comment> comments;

    public Post(int post_id, int user_id, int like_count, int comment_count, String username, String bio, List<Comment> comments) {
        this.post_id = post_id;
        this.user_id = user_id;
        this.like_count = like_count;
        this.comment_count = comment_count;
        this.username = username;
        this.bio = bio;
        this.comments = comments;
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

    public int getLike_count() {
        return like_count;
    }

    public void setLike_count(int like_count) {
        this.like_count = like_count;
    }

    public int getComment_count() {
        return comment_count;
    }

    public void setComment_count(int comment_count) {
        this.comment_count = comment_count;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
