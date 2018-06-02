package rmcreyes.clothing_app.feed_module;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

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

        Posts = new ArrayList<Post>();

        Posts.add(new Post("rmcreyes", "1s ago", "This is a test of the the trending fragment. Please work! :D"));
        Posts.add(new Post("andreoiid", "20m ago", "This is a test of the the trending fragment. Please work! :D"));
        Posts.add(new Post("vince.gao", "300h ago", "This is a test of the the trending fragment. Please work! :D"));
        Posts.add(new Post("airchong", "4y ago", "This is a test of the the trending fragment. Please work! :D"));
        Posts.add(new Post("ilikerice", "5y ago", "This is a test of the the trending fragment. Please work! :D"));
        Posts.add(new Post("cpbluewhale", "11y ago", "This is a test of the the trending fragment. Please work! :D"));
        Posts.add(new Post("mickeyneuf", "111y ago", "This is a test of the the trending fragment. Please work! :D"));
        Posts.add(new Post("cjang", "1123y ago", "This is a test of the the trending fragment. Please work! :D"));
        Posts.add(new Post("nancyrolls", "1223y ago", "This is a test of the the trending fragment. Please work! :D"));
        Posts.add(new Post("nancyyjiang", "9999y ago", "This is a test of the the trending fragment. Please work! :D"));

        TrendingPostAdapter trendingPostAdapter = new TrendingPostAdapter(getActivity().getApplicationContext(), Posts);
        ListView list_view = (ListView) view.findViewById(R.id.list_view);
        list_view.setAdapter(trendingPostAdapter);
    }
}
