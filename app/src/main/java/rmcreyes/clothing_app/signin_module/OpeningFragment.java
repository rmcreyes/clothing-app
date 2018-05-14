package rmcreyes.clothing_app.signin_module;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import rmcreyes.clothing_app.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class OpeningFragment extends Fragment {


    public OpeningFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_opening, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        // button used to login
        Button login_btn = (Button) getView().findViewById(R.id.login_btn);
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getActivity().getApplicationContext(), "login", Toast.LENGTH_SHORT).show();
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
                ft.replace(R.id.fragment_container, new LoginFragment());
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        // button used to sign up
        Button signup_btn = (Button) getView().findViewById(R.id.signup_btn);
        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getActivity().getApplicationContext(), "sign up", Toast.LENGTH_SHORT).show();
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
                ft.replace(R.id.fragment_container, new SignUpFragment());
                ft.addToBackStack(null);
                ft.commit();
            }
        });
    }

}
