package hr.goodapp.zetapp.timetable_new.adapter;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import java.util.List;

import hr.goodapp.zetapp.R;
import hr.goodapp.zetapp.timetable_new.model.TimeTableModel;

/**
 * Created by User on 14.5.2016..
 */
public class ListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int CARD_VIEW = 0;
    private static final int OTHER_ELEMENTS = 1;
    List<TimeTableModel> mArrayList;
    SearchManager searchManager;
    Context mContext;

    public ListAdapter(List<TimeTableModel> arrayList) {
        this.mArrayList = arrayList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        searchManager = (SearchManager) parent.getContext().getSystemService(Context.SEARCH_SERVICE);
        mContext = parent.getContext();

        switch (viewType) {
            case CARD_VIEW:
                View cardView = inflater.inflate(R.layout.edit_card_view, parent, false);
                viewHolder = new ViewHolderCard(cardView);
                break;
            case OTHER_ELEMENTS:
                View v2 = inflater.inflate(R.layout.timetable_list_item, parent, false);
                viewHolder = new ViewHolder(v2);
                break;
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        switch (holder.getItemViewType()) {

            case CARD_VIEW:

                break;
            case OTHER_ELEMENTS:
                ViewHolder viewHolder = ((ViewHolder) holder);

                viewHolder.getTextViewTime().setText(mArrayList.get(position).getTime());
                viewHolder.getTextViewStart().setText(mArrayList.get(position).getStart());
                viewHolder.getTextViewEnd().setText(mArrayList.get(position).getEnd());
                break;


        }


    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == CARD_VIEW) {
            return CARD_VIEW;
        } else {
            return OTHER_ELEMENTS;
        }

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

    public class ViewHolderCard extends RecyclerView.ViewHolder {

        SearchView mSearchView;

        public ViewHolderCard(View itemView) {
            super(itemView);

            mSearchView = (SearchView) itemView.findViewById(R.id.time_table_search_view);

            // Assumes current activity is the searchable activity
            mSearchView.setSearchableInfo(searchManager.getSearchableInfo(((Activity)mContext).getComponentName()));
            //searchView.setIconifiedByDefault(false); // Do not iconify the widget; expand it by default
            mSearchView.setInputType(InputType.TYPE_CLASS_NUMBER);
            mSearchView.setImeOptions(EditorInfo.IME_ACTION_SEARCH);
            mSearchView.setSubmitButtonEnabled(true);

        }


    }


}
