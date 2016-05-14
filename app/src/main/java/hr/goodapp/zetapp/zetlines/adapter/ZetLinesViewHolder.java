package hr.goodapp.zetapp.zetlines.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ParentViewHolder;

import hr.goodapp.zetapp.R;
import hr.goodapp.zetapp.zetlines.model.ZetTrainsParent;

/**
 * Created by User on 19.3.2016..
 */
public class ZetLinesViewHolder extends ParentViewHolder {

    private final TextView mRecipeTextView;
    private final ImageView mArrowExpandImageView;

    public ZetLinesViewHolder(View itemView) {
        super(itemView);

        mRecipeTextView = (TextView) itemView.findViewById(R.id.recipe_textview);
        mArrowExpandImageView = (ImageView) itemView.findViewById(R.id.arrow_expand_imageview);
    }

    public void bind(ZetTrainsParent zetTrainsParent) {
        mRecipeTextView.setText(zetTrainsParent.getName());
    }



}
