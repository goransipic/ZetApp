package hr.goodapp.zetapp.zetlines.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerview.Model.ParentListItem;

import java.util.List;

import hr.goodapp.zetapp.R;
import hr.goodapp.zetapp.zetlines.model.ZetTrainsChild;
import hr.goodapp.zetapp.zetlines.model.ZetTrainsParent;

/**
 * Created by User on 19.3.2016..
 */
public class ZetLinesAdapterExp extends ExpandableRecyclerAdapter<ZetLinesViewHolder,ZetLinesChildViewHolder> {

    private LayoutInflater mInflator;

    public ZetLinesAdapterExp(Context context, List<? extends ParentListItem> parentItemList) {
        super(parentItemList);
        mInflator = LayoutInflater.from(context);
    }

    @Override
    public ZetLinesViewHolder onCreateParentViewHolder(ViewGroup parentViewGroup) {
        View recipeView = mInflator.inflate(R.layout.parent_zet_lines, parentViewGroup, false);
        return new ZetLinesViewHolder(recipeView);
    }

    @Override
    public ZetLinesChildViewHolder onCreateChildViewHolder(ViewGroup childViewGroup) {
        View ingredientView =  mInflator.inflate(R.layout.child_zet_lines,childViewGroup,false);
        return new ZetLinesChildViewHolder(ingredientView);
    }

    @Override
    public void onBindParentViewHolder(ZetLinesViewHolder parentViewHolder, int position, ParentListItem parentListItem) {
        ZetTrainsParent zetTrainsParent = (ZetTrainsParent) parentListItem;
        parentViewHolder.bind(zetTrainsParent);
    }

    @Override
    public void onBindChildViewHolder(ZetLinesChildViewHolder childViewHolder, int position, Object childListItem) {
        ZetTrainsChild zetTrainsChild =  (ZetTrainsChild)childListItem;
        childViewHolder.bind(zetTrainsChild);
    }
}
