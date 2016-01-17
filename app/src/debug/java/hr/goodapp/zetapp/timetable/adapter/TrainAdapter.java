package hr.goodapp.zetapp.timetable.adapter;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import hr.goodapp.zetapp.R;
import hr.goodapp.zetapp.timetable.model.Train;

/**
 * Created by User on 6.1.2016..
 */
public class TrainAdapter extends
        RecyclerView.Adapter<TrainAdapter.ViewHolder> {

    // Store a member variable for the contacts
    private List<Train> mTrains;

    public void setTrains(List<Train> trains) {
        this.mTrains = trains;
    }

    // Usually involves inflating a layout from XML and returning the holder

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView numberTrain;
        public TextView nameTrain;
        public TextView timeTrain;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            numberTrain = (TextView) itemView.findViewById(R.id.number_train);
            nameTrain = (TextView) itemView.findViewById(R.id.name_train);
            timeTrain = (TextView) itemView.findViewById(R.id.time_train);
        }
    }

    @Override
    public TrainAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_train, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        // Get the data model based on position
        Train train = mTrains.get(position);

        int color[] = {
                R.color.colorPrimary,
                R.color.colorAccent,
                R.color.color3,
                R.color.colorPrimaryDark,
                R.color.color1,
                R.color.color2,
                R.color.color4,
        };

        // Set item views based on the data model
        TextView textView = viewHolder.numberTrain;
        GradientDrawable shapeDrawable = (GradientDrawable) textView.getBackground();

        shapeDrawable.setColor(viewHolder.itemView.getContext().getResources().getColor(color[position % 7]));

        textView.setText(train.getNumber());
        //
        TextView nameTrain = viewHolder.nameTrain;
        nameTrain.setText(train.getName());

        TextView timeTrain = viewHolder.timeTrain;
        timeTrain.setText(
                Integer.toString((int) train.getTime()) + " min");
    }

    // Return the total count of items
    @Override
    public int getItemCount() {

        if (mTrains == null) {
            return 0;
        }else {
            return mTrains.size();
        }
    }
}
