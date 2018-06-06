package rmcreyes.clothing_app.feed_module;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import rmcreyes.clothing_app.R;
import rmcreyes.clothing_app.account_relevant_package.Post;

/**
 * A simple {@link Fragment} subclass.
 */
public class TrendingFragment extends Fragment {

    List<Post> Posts;

    public TrendingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_trending, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        Posts = new ArrayList<Post>();

        long test_post_time = (long) 1528267800000.0;

        Posts.add(new Post("rmcreyes", test_post_time, "This is a test of the the trending fragment. Please work! :D"));
        Posts.add(new Post("andreoiid", test_post_time, "This is a test of the the trending fragment. Please work! :D"));
        Posts.add(new Post("vince.gao", test_post_time, "This is a test of the the trending fragment. Please work! :D"));
        Posts.add(new Post("airchong", test_post_time, "This is a test of the the trending fragment. Please work! :D"));
        Posts.add(new Post("ilikerice", test_post_time, "This is a test of the the trending fragment. Please work! :D"));
        Posts.add(new Post("cpbluewhale", test_post_time, "This is a test of the the trending fragment. Please work! :D"));
        Posts.add(new Post("mickeyneuf", test_post_time, "This is a test of the the trending fragment. Please work! :D"));
        Posts.add(new Post("cjang", test_post_time, "This is a test of the the trending fragment. Please work! :D"));
        Posts.add(new Post("nancyrolls", test_post_time, "This is a test of the the trending fragment. Please work! :D"));
        Posts.add(new Post("nancyyjiang", test_post_time, "This is a test of the the trending fragment. Please work! :D"));

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
