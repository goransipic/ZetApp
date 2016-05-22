package hr.goodapp.zetapp.timetable_new.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import hr.goodapp.zetapp.R;
import hr.goodapp.zetapp.timetable_new.model.TimeTableModel;

/**
 * Created by User on 14.5.2016..
 */
public class ListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<TimeTableModel> mArrayList;

    public ListAdapter(List<TimeTableModel> arrayList) {
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

        viewHolder.getTextViewTime().setText(mArrayList.get(position).getTime());
        viewHolder.getTextViewStart().setText(mArrayList.get(position).getStart());
        viewHolder.getTextViewEnd().setText(mArrayList.get(position).getEnd());

    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }


    static public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textView_time;
        private TextView textView_start;
        private TextView textView_end;

        public ViewHolder(View v) {
            super(v);
            this.textView_time = (TextView) v.findViewById(R.id.timetable_type_two_textview_time);
            this.textView_start = (TextView) v.findViewById(R.id.timetable_type_two_textview_start);
            this.textView_end = (TextView) v.findViewById(R.id.timetable_type_two_textview_end);
        }


        public TextView getTextViewTime() {
            return textView_time;
        }

        public TextView getTextViewStart() {
            return textView_start;
        }

        public TextView getTextViewEnd() {
            return textView_end;
        }


    }


}
