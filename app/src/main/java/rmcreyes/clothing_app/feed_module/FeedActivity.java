package rmcreyes.clothing_app.feed_module;

import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import rmcreyes.clothing_app.R;

public class FeedActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private Toolbar search_bar;
    private FeedCollectionPagerAdapter pagerAdapter;
    private ViewPager viewPager;
    private TabLayout tab_bar;
    private EditText search_edit;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        setTitle("");

        drawerLayout= findViewById(R.id.drawer_layout);
        search_bar = findViewById(R.id.search_bar);
        tab_bar = findViewById(R.id.tab_bar);
        search_edit = findViewById(R.id.search_edit);
        fab = findViewById(R.id.fab);

        // set up drawer button
        setSupportActionBar(search_bar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_nav_drawer_btn);


        // set up pager adapter
        pagerAdapter = new FeedCollectionPagerAdapter(getSupportFragmentManager());
        viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(pagerAdapter);
        tab_bar.setupWithViewPager(viewPager);

        tab_bar.getTabAt(0).setIcon(R.drawable.ic_fire_prime);
        tab_bar.getTabAt(1).setIcon(R.drawable.ic_follow_prime);

        search_edit.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_SEARCH) {
                    performSearch(v.getText().toString().trim());
                    return true;
                }
                return false;
            }
        });

        // set up fab to perform a concord search
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FeedActivity.this, "concord search", Toast.LENGTH_SHORT).show();
            }
        });

        // set up navigation drawer item selection
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // set item as selected to persist highlight
                item.setChecked(true);
                // close drawer when item is tapped
                drawerLayout.closeDrawers();

                switch(item.getItemId()) {
                    case R.id.nav_my_profile:
                        Toast.makeText(FeedActivity.this, "My Profile", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_bookmarks:
                        Toast.makeText(FeedActivity.this, "Bookmarks", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_hottest:
                        Toast.makeText(FeedActivity.this, "This Week's Hottest", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_report:
                        Toast.makeText(FeedActivity.this, "Report a Problem", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_settings:
                        Toast.makeText(FeedActivity.this, "Settings", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_logout:
                        Toast.makeText(FeedActivity.this, "Logout", Toast.LENGTH_SHORT).show();
                        break;
                }

                item.setChecked(false);

                return true;
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

    private void performSearch(String username) {
        Toast.makeText(this, username, Toast.LENGTH_SHORT).show();
    }
}
