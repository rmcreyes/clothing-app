package rmcreyes.clothing_app.filter_module;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import rmcreyes.clothing_app.R;

/**
 * Created by robin on 2018-08-28.
 * Dialog used to let user select and describe an item for filtering.
 */

public class ItemFilterDialog extends AppCompatDialogFragment {

    private TextView item_type, tags_text;
    private EditText tag_edit;
    private ImageButton btn_1, btn_2, btn_3, btn_4, btn_5, btn_6;
    private Button add_tag_btn;

    private ItemFilterDialogListener itemFilterDialogListener;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater  inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_item_filter, null);

        builder.setView(view)
                .setTitle("Add filter")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String item = item_type.getText().toString().trim();
                        String tags = tags_text.getText().toString().trim();
                        // call apply texts on the strings to be used on the item cards
                        itemFilterDialogListener.applyTexts(item, tags);
                    }
                });

        Dialog dialog = builder.create();

        item_type = (TextView) view.findViewById(R.id.item_type);
        tags_text = (TextView) view.findViewById(R.id.tags_text);

        // each image button changes the string in the textview item_type
        btn_1 = (ImageButton) view.findViewById(R.id.button1);
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item_type.setText("headwear");
            }
        });

        btn_2 = (ImageButton) view.findViewById(R.id.button2);
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item_type.setText("tops");
            }
        });

        btn_3 = (ImageButton) view.findViewById(R.id.button3);
        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item_type.setText("bottoms");
            }
        });

        btn_4 = (ImageButton) view.findViewById(R.id.button4);
        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item_type.setText("shoes");
            }
        });

        btn_5 = (ImageButton) view.findViewById(R.id.button5);
        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item_type.setText("accessories");
            }
        });

        btn_6 = (ImageButton) view.findViewById(R.id.button6);
        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item_type.setText("one pieces");
            }
        });

        // upon click of the add button, adds the string in the edit text
        // to the list of tags
        // TODO: 2018-08-28 take care of invalid tag strings
        tag_edit = (EditText) view.findViewById(R.id.tag_edit);
        tags_text = (TextView) view.findViewById(R.id.tags_text);
        add_tag_btn = (Button) view.findViewById(R.id.add_tag_btn);
        add_tag_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String new_tag = tag_edit.getText().toString().trim();
                String tags = tags_text.getText().toString().trim();
                if(tags.equals(""))
                    tags_text.setText("#" + new_tag);
                else
                    tags_text.setText(tags + ", #" + new_tag);

                tag_edit.setText("");
            }
        });


        return dialog;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            itemFilterDialogListener = (ItemFilterDialogListener) context;
        } catch(ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement listener");
        }

    }

    public interface ItemFilterDialogListener {
        void applyTexts(String item_type, String tags);
    }
}
