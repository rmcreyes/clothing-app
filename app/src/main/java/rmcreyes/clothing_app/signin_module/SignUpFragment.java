package rmcreyes.clothing_app.signin_module;


import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import rmcreyes.clothing_app.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpFragment extends Fragment {

    private Button next_btn;
    private EditText email_edit, username_edit, password_edit, reenter_password_edit;
    private TextView email_error, username_error, password_error;
    private ProgressBar progressBar;

    public SignUpFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_up, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        next_btn = view.findViewById(R.id.next_btn);
        email_edit = view.findViewById(R.id.email_edit);
        username_edit = view.findViewById(R.id.username_edit);
        password_edit = view.findViewById(R.id.password_edit);
        reenter_password_edit = view.findViewById(R.id.reenter_password_edit);
        email_error = view.findViewById(R.id.email_error);
        username_error = view.findViewById(R.id.username_error);
        password_error = view.findViewById(R.id.password_error);
        progressBar = view.findViewById(R.id.progressBar);

        // set all error messages and the progress bar to invisible
        email_error.setVisibility(View.INVISIBLE);
        username_error.setVisibility(View.INVISIBLE);
        password_error.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.INVISIBLE);
        progressBar.getIndeterminateDrawable().setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_IN);

        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email_input = email_edit.getText().toString().trim(),
                        username_input = username_edit.getText().toString().trim(),
                        password_input = password_edit.getText().toString().trim(),
                        reenter_password_input = reenter_password_edit.getText().toString().trim();

                if(email_input.equals("")) {
                    email_error.setText("this field is required");
                    email_error.setVisibility(View.VISIBLE);
                }
                else if(!StringChecker.checkEmail(email_input)) {
                    email_error.setText("not a valid email address");
                    email_error.setVisibility(View.VISIBLE);
                }
                else
                    email_error.setVisibility(View.INVISIBLE);

                if(username_input.equals("")) {
                    username_error.setText("this field is required");
                    username_error.setVisibility(View.VISIBLE);
                }
                else if(!StringChecker.checkUsername(username_input)) {
                    username_error.setText("not a valid username");
                    username_error.setVisibility(View.VISIBLE);
                }
                else
                    username_error.setVisibility(View.INVISIBLE);

                if(password_input.equals("")) {
                    password_error.setText("this field is required");
                    password_error.setVisibility(View.VISIBLE);
                }
                else if(!StringChecker.checkPassword(password_input)) {
                    password_error.setText("not a valid password");
                    password_error.setVisibility(View.VISIBLE);
                }
                else if(!password_input.equals(reenter_password_input)) {
                    password_error.setText("passwords do not match");
                    password_error.setVisibility(View.VISIBLE);
                }
                else
                    password_error.setVisibility(View.INVISIBLE);



                // if no errors exist, attempt to sign up with this information and go to
                // the terms of service fragment
                if(email_error.getVisibility() == View.INVISIBLE &&
                        username_error.getVisibility() == View.INVISIBLE &&
                        password_error.getVisibility() == View.INVISIBLE) {
                    progressBar.setVisibility(View.VISIBLE);

                    FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                    ft.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
                    ft.replace(R.id.fragment_container, new TermsFragment());
                    ft.addToBackStack(null);
                    ft.commit();
                }
            }
        });


    }
}
