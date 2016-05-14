package hr.goodapp.zetapp.zetlines.adapter;

import android.view.View;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;

import hr.goodapp.zetapp.R;
import hr.goodapp.zetapp.zetlines.model.ZetTrainsChild;

/**
 * Created by User on 19.3.2016..
 */
public class ZetLinesChildViewHolder extends ChildViewHolder {

    TextView textView;

    public ZetLinesChildViewHolder(View itemView) {
        super(itemView);

        textView = (TextView) itemView.findViewById(R.id.ingredient_textview);
    }

    void bind (ZetTrainsChild zetTrainsChild){
        textView.setText(zetTrainsChild.getName());
    }

}
