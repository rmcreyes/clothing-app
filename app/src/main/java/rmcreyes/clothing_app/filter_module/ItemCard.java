package rmcreyes.clothing_app.filter_module;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by robin on 2018-08-06.
 * An object that is the collection of display components that
 * represent an item used to filter the app's database of outfits
 */

public class ItemCard {

    private CardView cardView;
    private ConstraintLayout constraintLayout;
    private TextView item_name, color_label, color, tags_label, tags;
    private View divider;
    private ImageView remove_btn;

    public ItemCard(CardView cardView, ConstraintLayout constraintLayout, TextView item_name, TextView color_label, TextView color, TextView tags_label, TextView tags, View divider, ImageView remove_btn) {
        this.cardView = cardView;
        this.constraintLayout = constraintLayout;
        this.item_name = item_name;
        this.color_label = color_label;
        this.color = color;
        this.tags_label = tags_label;
        this.tags = tags;
        this.divider = divider;
        this.remove_btn = remove_btn;
    }

    /**
     * Sets the visibility of the card's components to the
     * visibility specified in the parameter
     * @param visibility - int representing the visibility of
     *                   the card
     */
    public void setVisibility(int visibility) {
        cardView.setVisibility(visibility);
        constraintLayout.setVisibility(visibility);
        item_name.setVisibility(visibility);
        color_label.setVisibility(visibility);
        color.setVisibility(visibility);
        tags_label.setVisibility(visibility);
        tags.setVisibility(visibility);
        divider.setVisibility(visibility);
        remove_btn.setVisibility(visibility);
    }

    public ImageView getRemove_btn() {
        return remove_btn;
    }
}
