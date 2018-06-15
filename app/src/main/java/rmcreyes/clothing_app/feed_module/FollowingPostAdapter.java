package rmcreyes.clothing_app.feed_module;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import rmcreyes.clothing_app.R;
import rmcreyes.clothing_app.account_relevant_package.Post;

/**
 * Created by robin on 2018-06-14.
 */

public class FollowingPostAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private List<Post> posts;

    public FollowingPostAdapter(Context context, List<Post> posts) {
        this.context = context;
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
        View v = layoutInflater.inflate(R.layout.detail_following_feed, null);

        TextView username = (TextView) v.findViewById(R.id.username);
        TextView recency = (TextView) v.findViewById(R.id.recency);
        ImageView outfit_pic = (ImageView) v.findViewById(R.id.outfit_pic);
        ImageView like_btn = (ImageView) v.findViewById(R.id.like_btn);
        ImageView comment_btn = (ImageView) v.findViewById(R.id.comment_btn);

        Post post = posts.get(position);

        // for each post, display its information on each panel in the list view
        username.setText(post.getUsername());
        recency.setText(post.getRecency());
        formatImage(outfit_pic, post.getOutfit_pic());

        like_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "like", Toast.LENGTH_SHORT).show();
            }
        });

        comment_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "comment", Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }

    /**
     * Resizes the Uri of an image to fit the screen, rounds the corners,
     * and applies the resulting Bitmap to the ImageView
     * @param img ImageView to apply the manipulated Bitmap to
     * @param pic Uri whose Bitmap to is to manipulate
     */
    private void formatImage(ImageView img, Uri pic) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        int screen_width = metrics.widthPixels;

        InputStream inputStream = null;

        try {
            inputStream = context.getContentResolver().openInputStream(pic);
        } catch(FileNotFoundException e) {
            // if the file is not found, leave the imageview blank
            return;
        }

        Bitmap bitmap = BitmapFactory.decodeStream(inputStream);

        int image_width = bitmap.getWidth();
        int image_height = bitmap.getHeight();

        // have the scaling factor be so that the image can be as tall as
        // it is, provided its width fits on the screen
        float scale = ((float) screen_width) / image_width;

        Matrix matrix = new Matrix();
        matrix.postScale(scale, scale);

        Bitmap scaled_bitmap = Bitmap.createBitmap(bitmap, 0, 0, image_width, image_height, matrix, true);

        // create a rounded bitmap drawable from the previously manipulated bitmap to easily
        // create corner radii
        RoundedBitmapDrawable rounded_image = RoundedBitmapDrawableFactory.create(context.getResources(), scaled_bitmap);
        rounded_image.setCornerRadius(100.0f);
        img.setImageDrawable(rounded_image);
    }
}
