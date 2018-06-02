package rmcreyes.clothing_app.account_relevant_package;

import android.util.Pair;

import java.net.URI;
import java.util.List;

/**
 * Created by robin on 2018-05-22.
 */

public class Post {

    private int post_id, user_id, like_count, comment_count;
    private String username, bio, recency;
    private List<Comment> comments;
    private List<Integer> liker_ids;
    private URI image, profile_pic;
    private int[] date, time;

    public Post(String username, String recency, String bio) {
        this.username = username;
        this.recency = recency;
        this.bio = bio;
    }

    public String getUsername() {
        return username;
    }

    public String getRecency() {
        return recency;
    }

    public String getBio() {
        return bio;
    }





}
