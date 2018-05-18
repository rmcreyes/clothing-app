package rmcreyes.clothing_app.feed_module;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import rmcreyes.clothing_app.R;

public class FeedActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private Toolbar search_bar;
    private FeedCollectionPagerAdapter pagerAdapter;
    private ViewPager viewPager;
    private ImageButton trending_btn, following_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        setTitle("");

        drawerLayout= findViewById(R.id.drawer_layout);
        search_bar = findViewById(R.id.search_bar);
        trending_btn = findViewById(R.id.trending_btn);
        following_btn = findViewById(R.id.following_btn);

        // set up drawer button
        setSupportActionBar(search_bar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_nav_drawer_btn);


        // set up pager adapter
        pagerAdapter = new FeedCollectionPagerAdapter(getSupportFragmentManager());
        viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(pagerAdapter);

        trending_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trending_btn.setBackgroundResource(R.drawable.ic_fire_prime);
                following_btn.setBackgroundResource(R.drawable.ic_follow_white);
                viewPager.setCurrentItem(0);
            }
        });

        following_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trending_btn.setBackgroundResource(R.drawable.ic_fire_white);
                following_btn.setBackgroundResource(R.drawable.ic_follow_prime);
                viewPager.setCurrentItem(1);
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position == 0) {
                    trending_btn.setBackgroundResource(R.drawable.ic_fire_prime);
                    following_btn.setBackgroundResource(R.drawable.ic_follow_white);
                }
                else if(position == 1) {
                    trending_btn.setBackgroundResource(R.drawable.ic_fire_white);
                    following_btn.setBackgroundResource(R.drawable.ic_follow_prime);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
