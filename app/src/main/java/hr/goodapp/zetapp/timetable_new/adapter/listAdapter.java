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

    String[] mArrayList;

    public ListAdapter(String[] arrayList) {
        this.mArrayList = arrayList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());


        View v2 = inflater.inflate(R.layout.timetable_list_item, parent, false);
        viewHolder = new ViewHolder(v2);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {


        ViewHolder viewHolder = ((ViewHolder) holder);
        viewHolder.getTextView().setText(mArrayList[position]);

    }

    @Override
    public int getItemCount() {
        return mArrayList.length;
    }





    static public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        public ViewHolder(View v) {
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
