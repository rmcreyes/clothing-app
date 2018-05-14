package rmcreyes.clothing_app.signin_module;

import android.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import rmcreyes.clothing_app.R;

public class SignInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        // initialize the start up page of the app
        FragmentTransaction init = getSupportFragmentManager().beginTransaction();
        init.add(R.id.fragment_container, new OpeningFragment());
        init.commit();
    }

    /**
     * Allow navigating through fragments using the Android back button
     */
    @Override
    public void onBackPressed() {
        FragmentManager fm = getFragmentManager();

        if(fm.getBackStackEntryCount() > 0)
            fm.popBackStack();
        else
            super.onBackPressed();
    }
}
