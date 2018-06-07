package rmcreyes.clothing_app.feed_module;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.CardView;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
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
 * Created by robin on 2018-05-22.
 */

public class TrendingPostAdapter extends BaseAdapter {

    Context context;
    LayoutInflater layoutInflater;
    List<Post> posts;

    public TrendingPostAdapter(Context context, List<Post> posts) {
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
        View v = layoutInflater.inflate(R.layout.detail_trending_feed, null);

        TextView username = (TextView) v.findViewById(R.id.username);
        TextView recency = (TextView) v.findViewById(R.id.recency);
        ImageView outfit_pic = (ImageView) v.findViewById(R.id.outfit_pic);

        Post post = posts.get(position);

        username.setText(post.getUsername());
        recency.setText(post.getRecency());
        formatImage(outfit_pic, post.getOutfit_pic());

        return v;
    }

    private void formatImage(ImageView img, Uri pic) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        int screen_width = metrics.widthPixels;
        int screen_height = metrics.heightPixels;

        InputStream inputStream = null;

        try {
            inputStream = context.getContentResolver().openInputStream(pic);
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }

        Bitmap bitmap = BitmapFactory.decodeStream(inputStream);

        int image_width = bitmap.getWidth();
        int image_height = bitmap.getHeight();

        float scale = ((float) screen_width) / image_width;

        Matrix matrix = new Matrix();
        matrix.postScale(scale, scale);

        Bitmap scaled_bitmap = Bitmap.createBitmap(bitmap, 0, 0, image_width, image_height, matrix, true);

        RoundedBitmapDrawable rounded_image = RoundedBitmapDrawableFactory.create(context.getResources(), scaled_bitmap);
        rounded_image.setCornerRadius(100.0f);
        img.setImageDrawable(rounded_image);
    }
}
