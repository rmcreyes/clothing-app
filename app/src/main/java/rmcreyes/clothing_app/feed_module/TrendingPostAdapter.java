package rmcreyes.clothing_app.feed_module;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import rmcreyes.clothing_app.R;
import rmcreyes.clothing_app.account_relevant_package.Post;

/**
 * Created by robin on 2018-05-22.
 */

public class TrendingPostAdapter extends BaseAdapter {

    LayoutInflater layoutInflater;
    List<Post> posts;

    public TrendingPostAdapter(Context context, List<Post> posts) {
        this.posts = posts;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return posts.size();
    }

    @Override
    public Object getItem(int position) {
        return posts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = layoutInflater.inflate(R.layout.detail_trending_feed, null);

        TextView username = (TextView) v.findViewById(R.id.username);
        TextView recency = (TextView) v.findViewById(R.id.recency);
        TextView bio = (TextView) v.findViewById(R.id.bio);

        Post post = posts.get(position);

        username.setText(post.getUsername());
        recency.setText(post.getRecency());
        bio.setText(post.getBio());

        return v;
    }
}
