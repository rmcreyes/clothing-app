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
import android.widget.Toast;

import rmcreyes.clothing_app.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    private ProgressBar progressBar;
    private EditText email_edit, password_edit;
    private TextView error_messages, forgot_password_text;
    private Button login_btn;


    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        email_edit = (EditText) view.findViewById(R.id.email_edit);
        password_edit = (EditText) view.findViewById(R.id.password_edit);
        error_messages = (TextView) view.findViewById(R.id.error_messages);
        forgot_password_text = (TextView) view.findViewById(R.id.forgot_password_text);
        login_btn = (Button) view.findViewById(R.id.login_btn);

        // set progressbar black and initially invisible
        progressBar.getIndeterminateDrawable().setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_IN);
        progressBar.setVisibility(View.INVISIBLE);

        // initially set error messages invisible
        error_messages.setVisibility(View.INVISIBLE);

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email_input = email_edit.getText().toString().trim(),
                        password_input = password_edit.getText().toString().trim();

                if(email_input.equals("")) {
                    error_messages.setText("email required");
                    error_messages.setVisibility(View.VISIBLE);
                }
                else if(password_input.equals("")) {
                    error_messages.setText("password required");
                    error_messages.setVisibility(View.VISIBLE);
                }
                else if(email_input.equals("test") && password_input.equals("test")){
                    error_messages.setVisibility(View.INVISIBLE);
                    progressBar.setVisibility(View.VISIBLE);
                }
                else {
                    error_messages.setText("invalid email-password combination");
                    error_messages.setVisibility(View.VISIBLE);

                }
            }
        });

        // send user to the ForgotPasswordFragment upon tap of the text view
        forgot_password_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
                ft.replace(R.id.fragment_container, new ForgotPasswordFragment());
                ft.addToBackStack(null);
                ft.commit();
            }
        });
    }


}
