package rmcreyes.clothing_app.feed_module;


import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import rmcreyes.clothing_app.R;
import rmcreyes.clothing_app.account_relevant_package.Post;

/**
 * A simple {@link Fragment} subclass.
 */
public class FollowingFragment extends Fragment {

    List<Post> Posts;

    public FollowingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_following, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Posts = new ArrayList<Post>();

        long test_post_time = (long) 1528267800000.0;

        Uri filler_image = Uri.parse("android.resource://rmcreyes.clothing_app/" + R.drawable.filler);
        Uri square_image = Uri.parse("android.resource://rmcreyes.clothing_app/" + R.drawable.square_filler);
        Uri long_image = Uri.parse("android.resource://rmcreyes.clothing_app/" + R.drawable.long_filler);
        Uri wide_image = Uri.parse("android.resource://rmcreyes.clothing_app/" + R.drawable.wide_filler);


        Posts.add(new Post("rmcreyes", test_post_time, filler_image));
        Posts.add(new Post("andreoiid", test_post_time, square_image));
        Posts.add(new Post("vince.gao", test_post_time, long_image));
        Posts.add(new Post("airchong", test_post_time, wide_image));
        Posts.add(new Post("ilikerice", test_post_time, filler_image));
        Posts.add(new Post("cpbluewhale", test_post_time, filler_image));
        Posts.add(new Post("mickeyneuf", test_post_time, filler_image));
        Posts.add(new Post("cjang", test_post_time, filler_image));
        Posts.add(new Post("nancyrolls", test_post_time, filler_image));
        Posts.add(new Post("nancyyjiang", test_post_time, filler_image));

        TrendingPostAdapter trendingPostAdapter = new TrendingPostAdapter(getActivity().getApplicationContext(), Posts);
        ListView list_view = (ListView) view.findViewById(R.id.list_view);
        list_view.setAdapter(trendingPostAdapter);
        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity().getApplicationContext(), Posts.get(position).getUsername(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
