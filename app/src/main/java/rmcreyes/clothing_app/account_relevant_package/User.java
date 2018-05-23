package rmcreyes.clothing_app.account_relevant_package;

/**
 * Created by robin on 2018-05-22.
 */

public class User {

    private String username, email;
    private int user_id, post_count, like_count, subscriber_count, subscribed_to_count;

    public User(String username, String email, int user_id, int post_count, int like_count, int subscriber_count, int subscribed_to_count) {
        this.username = username;
        this.email = email;
        this.user_id = user_id;
        this.post_count = post_count;
        this.like_count = like_count;
        this.subscriber_count = subscriber_count;
        this.subscribed_to_count = subscribed_to_count;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getPost_count() {
        return post_count;
    }

    public void setPost_count(int post_count) {
        this.post_count = post_count;
    }

    public int getLike_count() {
        return like_count;
    }

    public void setLike_count(int like_count) {
        this.like_count = like_count;
    }

    public int getSubscriber_count() {
        return subscriber_count;
    }

    public void setSubscriber_count(int subscriber_count) {
        this.subscriber_count = subscriber_count;
    }

    public int getSubscribed_to_count() {
        return subscribed_to_count;
    }

    public void setSubscribed_to_count(int subscribed_to_count) {
        this.subscribed_to_count = subscribed_to_count;
    }
}
