package rmcreyes.clothing_app.signin_module;


import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
public class ForgotPasswordFragment extends Fragment {

    private EditText email_edit;
    private TextView email_error;
    private Button reset_btn;
    private ProgressBar progressBar;



    public ForgotPasswordFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_forgot_password, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        email_edit = view.findViewById(R.id.email_edit);
        email_error = view.findViewById(R.id.email_error);
        reset_btn = view.findViewById(R.id.reset_btn);
        progressBar = view.findViewById(R.id.progressBar);

        // initially set the error message and progress bar invisible
        email_error.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.INVISIBLE);
        progressBar.getIndeterminateDrawable().setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_IN);


        reset_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = email_edit.getText().toString().trim();

                if(input.equals("")) {
                    email_error.setText("this field is required");
                    email_error.setVisibility(View.VISIBLE);
                }
                else if(!StringChecker.checkEmail(input)) {
                    email_error.setText("not a valid email address");
                    email_error.setVisibility(View.VISIBLE);
                }
                else {
                    email_error.setVisibility(View.INVISIBLE);
                    progressBar.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
