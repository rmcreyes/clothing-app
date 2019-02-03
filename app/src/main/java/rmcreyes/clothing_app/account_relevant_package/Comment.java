package rmcreyes.clothing_app.account_relevant_package;

/**
 * Created by robin on 2018-05-22.
 */

public class Comment {

    private int comment_id, post_id, user_id, like_count;
    private String comment;

    public Comment(int comment_id, int post_id, int user_id, int like_count, String comment) {
        this.comment_id = comment_id;
        this.post_id = post_id;
        this.user_id = user_id;
        this.like_count = like_count;
        this.comment = comment;
    }

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
