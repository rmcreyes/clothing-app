package rmcreyes.clothing_app.account_relevant_package;

import android.net.Uri;
import java.net.URI;
import java.util.Date;
import java.util.List;

/**
 * Created by robin on 2018-05-22.
 */

public class Post {

    private int post_id, user_id, like_count, comment_count;
    private String username, bio;
    private List<Comment> comments;
    private List<Integer> liker_ids;
    private Uri outfit_pic, profile_pic;
    private long post_time;

    // temporary fields
    private String recency;

    public Post(String username, long post_time, Uri outfit_pic) {
        this.username = username;
        this.post_time = post_time;
        this.outfit_pic = outfit_pic;
    }

    public String getUsername() {
        return username;
    }

    /**
     * Returns the time that has elapsed between when the post was made
     * and the current time, in a String detailing the years, months, days,
     * hours, or minutes since the post went up.
     * @return String detailing elapsed time
     */
    public String getRecency() {
        Date date = new Date();
        long current_time = date.getTime();

        // get the difference between current time and post time in milliseconds
        long diff = current_time - post_time;

        int years = (int) (diff / (3.154 * 10000000000.0));
        if(years >= 1)
            return "" + years + "yr ago";

        int months = (int) (diff / (2.628 * 1000000000.0));
        if(months >= 1)
            return "" + months + "mth ago";

        int days = (int) (diff / (8.64 * 10000000.0));
        if(days >= 1)
            return "" + days + "d ago";

        int hr = (int) (diff / (3.6 * 1000000.0));
        if(hr >= 1)
            return "" + hr + "h ago";

        int min = (int) (diff / 60000);
        if(min >= 1)
            return "" + min + "m ago";

        return "now";
    }

    public String getBio() {
        return bio;
    }

    public Uri getOutfit_pic() {
        return outfit_pic;
    }





}
