package hr.goodapp.zetapp.zetlines.model;

import com.bignerdranch.expandablerecyclerview.Model.ParentListItem;

import java.util.List;



/**
 * Created by User on 19.3.2016..
 */
public class ZetTrainsParent implements ParentListItem {

    private String mName;
    private List<ZetTrainsChild> mZetTrainsChild;

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }


    public void setZetTrainsChildren(List<ZetTrainsChild> zetTrainsChild) {
        this.mZetTrainsChild = zetTrainsChild;
    }

    @Override
    public List<?> getChildItemList() {
        return mZetTrainsChild;
    }

    @Override
    public boolean isInitiallyExpanded() {
        return false;
    }
}
