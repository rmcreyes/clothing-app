package rmcreyes.clothing_app.filter_module;

import android.app.ActionBar;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Filter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import rmcreyes.clothing_app.R;
import rmcreyes.clothing_app.account_relevant_package.Post;
import rmcreyes.clothing_app.feed_module.TrendingPostAdapter;

public class FilterQueryActivity extends AppCompatActivity {

    private List<ItemCard> ItemCards;
    private HashMap<ImageView, ItemCard> RemovePairs;
    private int count;

    private ImageButton add_filter_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_query);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorPrimary)));

        // create item cards and add them to the ItemCards list
        getItemCards();
        RemovePairs = new HashMap<ImageView, ItemCard>();

        // initially set each ItemCard to be gone and add each cancel button with its
        // own card to the hashmap
        for(ItemCard card : ItemCards) {
            card.setVisibility(View.GONE);
            RemovePairs.put(card.getRemove_btn(), card);
        }

        count = 0;

        add_filter_btn = (ImageButton) findViewById(R.id.add_filter_btn);
        // upon click, have the button add cards to the view
        add_filter_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ItemCards.get(count).setVisibility(View.VISIBLE);
                count++;

                if(count == ItemCards.size())
                    add_filter_btn.setVisibility(View.GONE);
                }
        });

        // for each card, assign the card's remove button to remove the
        // card from the activity's view
        for(ItemCard card : ItemCards) {
            card.getRemove_btn().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    RemovePairs.get(v).setVisibility(View.GONE);
                    count--;

                    if(count == ItemCards.size() - 1)
                        add_filter_btn.setVisibility(View.VISIBLE);
                }
            });
        }
    }

    /**
     * Creates ItemCard objects out of the on-screen elements, adds them as
     * ItemCards in a list, and equates the ItemCards list to this list
     */
    private void getItemCards() {
        List<ItemCard> itemCards = new ArrayList<ItemCard>();

        CardView card_0 = (CardView) findViewById(R.id.card_0);
        ConstraintLayout layout_0 = (ConstraintLayout) findViewById(R.id.layout_0);
        TextView item_name_0 = (TextView) findViewById(R.id.item_name_0);
        TextView color_label_0 = (TextView) findViewById(R.id.color_label_0);
        TextView color_0 = (TextView) findViewById(R.id.color_0);
        TextView tags_label_0 = (TextView) findViewById(R.id.tags_label_0);
        TextView tags_0 = (TextView) findViewById(R.id.tags_0);
        View divider_0 = (View) findViewById(R.id.divider_0);
        ImageView remove_btn_0 = (ImageView) findViewById(R.id.remove_btn_0);
        itemCards.add(new ItemCard(card_0, layout_0, item_name_0, color_label_0, color_0, tags_label_0, tags_0, divider_0, remove_btn_0));

        CardView card_1 = (CardView) findViewById(R.id.card_1);
        ConstraintLayout layout_1 = (ConstraintLayout) findViewById(R.id.layout_1);
        TextView item_name_1 = (TextView) findViewById(R.id.item_name_1);
        TextView color_label_1 = (TextView) findViewById(R.id.color_label_1);
        TextView color_1 = (TextView) findViewById(R.id.color_1);
        TextView tags_label_1 = (TextView) findViewById(R.id.tags_label_1);
        TextView tags_1 = (TextView) findViewById(R.id.tags_1);
        View divider_1 = (View) findViewById(R.id.divider_1);
        ImageView remove_btn_1 = (ImageView) findViewById(R.id.remove_btn_1);
        itemCards.add(new ItemCard(card_1, layout_1, item_name_1, color_label_1, color_1, tags_label_1, tags_1, divider_1, remove_btn_1));

        CardView card_2 = (CardView) findViewById(R.id.card_2);
        ConstraintLayout layout_2 = (ConstraintLayout) findViewById(R.id.layout_2);
        TextView item_name_2 = (TextView) findViewById(R.id.item_name_2);
        TextView color_label_2 = (TextView) findViewById(R.id.color_label_2);
        TextView color_2 = (TextView) findViewById(R.id.color_2);
        TextView tags_label_2 = (TextView) findViewById(R.id.tags_label_2);
        TextView tags_2 = (TextView) findViewById(R.id.tags_2);
        View divider_2 = (View) findViewById(R.id.divider_2);
        ImageView remove_btn_2 = (ImageView) findViewById(R.id.remove_btn_2);
        itemCards.add(new ItemCard(card_2, layout_2, item_name_2, color_label_2, color_2, tags_label_2, tags_2, divider_2, remove_btn_2));

        CardView card_3 = (CardView) findViewById(R.id.card_3);
        ConstraintLayout layout_3 = (ConstraintLayout) findViewById(R.id.layout_3);
        TextView item_name_3 = (TextView) findViewById(R.id.item_name_3);
        TextView color_label_3 = (TextView) findViewById(R.id.color_label_3);
        TextView color_3 = (TextView) findViewById(R.id.color_3);
        TextView tags_label_3 = (TextView) findViewById(R.id.tags_label_3);
        TextView tags_3 = (TextView) findViewById(R.id.tags_3);
        View divider_3 = (View) findViewById(R.id.divider_3);
        ImageView remove_btn_3 = (ImageView) findViewById(R.id.remove_btn_3);
        itemCards.add(new ItemCard(card_3, layout_3, item_name_3, color_label_3, color_3, tags_label_3, tags_3, divider_3, remove_btn_3));

        CardView card_4 = (CardView) findViewById(R.id.card_4);
        ConstraintLayout layout_4 = (ConstraintLayout) findViewById(R.id.layout_4);
        TextView item_name_4 = (TextView) findViewById(R.id.item_name_4);
        TextView color_label_4 = (TextView) findViewById(R.id.color_label_4);
        TextView color_4 = (TextView) findViewById(R.id.color_4);
        TextView tags_label_4 = (TextView) findViewById(R.id.tags_label_4);
        TextView tags_4 = (TextView) findViewById(R.id.tags_4);
        View divider_4 = (View) findViewById(R.id.divider_4);
        ImageView remove_btn_4 = (ImageView) findViewById(R.id.remove_btn_4);
        itemCards.add(new ItemCard(card_4, layout_4, item_name_4, color_label_4, color_4, tags_label_4, tags_4, divider_4, remove_btn_4));

        CardView card_5 = (CardView) findViewById(R.id.card_5);
        ConstraintLayout layout_5 = (ConstraintLayout) findViewById(R.id.layout_5);
        TextView item_name_5 = (TextView) findViewById(R.id.item_name_5);
        TextView color_label_5 = (TextView) findViewById(R.id.color_label_5);
        TextView color_5 = (TextView) findViewById(R.id.color_5);
        TextView tags_label_5 = (TextView) findViewById(R.id.tags_label_5);
        TextView tags_5 = (TextView) findViewById(R.id.tags_5);
        View divider_5 = (View) findViewById(R.id.divider_5);
        ImageView remove_btn_5 = (ImageView) findViewById(R.id.remove_btn_5);
        itemCards.add(new ItemCard(card_5, layout_5, item_name_5, color_label_5, color_5, tags_label_5, tags_5, divider_5, remove_btn_5));

        CardView card_6 = (CardView) findViewById(R.id.card_6);
        ConstraintLayout layout_6 = (ConstraintLayout) findViewById(R.id.layout_6);
        TextView item_name_6 = (TextView) findViewById(R.id.item_name_6);
        TextView color_label_6 = (TextView) findViewById(R.id.color_label_6);
        TextView color_6 = (TextView) findViewById(R.id.color_6);
        TextView tags_label_6 = (TextView) findViewById(R.id.tags_label_6);
        TextView tags_6 = (TextView) findViewById(R.id.tags_6);
        View divider_6 = (View) findViewById(R.id.divider_6);
        ImageView remove_btn_6 = (ImageView) findViewById(R.id.remove_btn_6);
        itemCards.add(new ItemCard(card_6, layout_6, item_name_6, color_label_6, color_6, tags_label_6, tags_6, divider_6, remove_btn_6));

        CardView card_7 = (CardView) findViewById(R.id.card_7);
        ConstraintLayout layout_7 = (ConstraintLayout) findViewById(R.id.layout_7);
        TextView item_name_7 = (TextView) findViewById(R.id.item_name_7);
        TextView color_label_7 = (TextView) findViewById(R.id.color_label_7);
        TextView color_7 = (TextView) findViewById(R.id.color_7);
        TextView tags_label_7 = (TextView) findViewById(R.id.tags_label_7);
        TextView tags_7 = (TextView) findViewById(R.id.tags_7);
        View divider_7 = (View) findViewById(R.id.divider_7);
        ImageView remove_btn_7 = (ImageView) findViewById(R.id.remove_btn_7);
        itemCards.add(new ItemCard(card_7, layout_7, item_name_7, color_label_7, color_7, tags_label_7, tags_7, divider_7, remove_btn_7));

        CardView card_8 = (CardView) findViewById(R.id.card_8);
        ConstraintLayout layout_8 = (ConstraintLayout) findViewById(R.id.layout_8);
        TextView item_name_8 = (TextView) findViewById(R.id.item_name_8);
        TextView color_label_8 = (TextView) findViewById(R.id.color_label_8);
        TextView color_8 = (TextView) findViewById(R.id.color_8);
        TextView tags_label_8 = (TextView) findViewById(R.id.tags_label_8);
        TextView tags_8 = (TextView) findViewById(R.id.tags_8);
        View divider_8 = (View) findViewById(R.id.divider_8);
        ImageView remove_btn_8 = (ImageView) findViewById(R.id.remove_btn_8);
        itemCards.add(new ItemCard(card_8, layout_8, item_name_8, color_label_8, color_8, tags_label_8, tags_8, divider_8, remove_btn_8));

        CardView card_9 = (CardView) findViewById(R.id.card_9);
        ConstraintLayout layout_9 = (ConstraintLayout) findViewById(R.id.layout_9);
        TextView item_name_9 = (TextView) findViewById(R.id.item_name_9);
        TextView color_label_9 = (TextView) findViewById(R.id.color_label_9);
        TextView color_9 = (TextView) findViewById(R.id.color_9);
        TextView tags_label_9 = (TextView) findViewById(R.id.tags_label_9);
        TextView tags_9 = (TextView) findViewById(R.id.tags_9);
        View divider_9 = (View) findViewById(R.id.divider_9);
        ImageView remove_btn_9 = (ImageView) findViewById(R.id.remove_btn_9);
        itemCards.add(new ItemCard(card_9, layout_9, item_name_9, color_label_9, color_9, tags_label_9, tags_9, divider_9, remove_btn_9));

        ItemCards = itemCards;
    }

}
