package hr.goodapp.zetapp.timetable_new.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import hr.goodapp.zetapp.R;

/**
 * Created by User on 14.5.2016..
 */
public class ListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int ITEM_TYPE_ONE = 0;
    private static final int ITEM_TYPE_TWO = 1;
    String[] mArrayList;

    public ListAdapter(String[] arrayList) {
        this.mArrayList = arrayList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        switch (viewType) {

            case ITEM_TYPE_ONE:
                View v1 = inflater.inflate(R.layout.timetable_type_one_layout, parent, false);
                viewHolder = new ViewHolderTypeOne(v1);
                break;

            case ITEM_TYPE_TWO:
                View v2 = inflater.inflate(R.layout.timetable_type_two_layout, parent, false);
                viewHolder = new ViewHolderTypeTwo(v2);
                break;

        }


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        switch (holder.getItemViewType()) {
            case ITEM_TYPE_ONE:
                ViewHolderTypeOne viewHolder = ((ViewHolderTypeOne) holder);
                //viewHolder.getTextView().setText(mArrayList[position]);
                break;
            case ITEM_TYPE_TWO:
                ViewHolderTypeTwo viewHolderTypeTwo = ((ViewHolderTypeTwo) holder);
                viewHolderTypeTwo.getTextView().setText(mArrayList[position]);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mArrayList.length;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return ITEM_TYPE_ONE;
        } else {
            return ITEM_TYPE_TWO;
        }


    }

    static public class ViewHolderTypeOne extends RecyclerView.ViewHolder {

        private TextView textView;

        public ViewHolderTypeOne(View v) {
            super(v);
            //textView = (TextView) v.findViewById(R.id.bus_station);
        }

        public TextView getTextView() {
            return textView;
        }

        public void setTextView(TextView textView) {
            this.textView = textView;
        }
    }


    static public class ViewHolderTypeTwo extends RecyclerView.ViewHolder {

        private TextView textView;

        public ViewHolderTypeTwo(View v) {
            super(v);
            this.textView = (TextView) v.findViewById(R.id.timetable_type_two);
        }


        public TextView getTextView() {
            return textView;
        }

        public void setTextView(TextView textView) {
            this.textView = textView;
        }
    }


}
