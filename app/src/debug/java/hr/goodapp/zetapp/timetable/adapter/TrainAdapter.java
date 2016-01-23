package hr.goodapp.zetapp.timetable.adapter;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
        public TextView zetTypeOfVehicle;
        public TextView nameStation;
        public TextView numbersOfTrains;
        private LinearLayout linearLayout;
        private ImageView imageView;
        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            zetTypeOfVehicle = (TextView) itemView.findViewById(R.id.zet_type_of_vehicle);
            nameStation = (TextView) itemView.findViewById(R.id.name_station);
            numbersOfTrains = (TextView) itemView.findViewById(R.id.number_of_trains);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.zet_venhicle_type_ic);
            imageView = (ImageView) itemView.findViewById(R.id.zet_type_of_vehicle_image);

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

        // set image baseg on type of zet
        if (train.getmZetTypeOfVehicle().equals("BUS")) {
            viewHolder.imageView.setBackgroundResource(R.drawable.ic_directions_bus_white_24dp);
        } else {
            viewHolder.imageView.setBackgroundResource(R.drawable.ic_directions_railway_white_24dp);
        }

        // Set item views based on the data model
        TextView zetTypeOfVehicle = viewHolder.zetTypeOfVehicle;
        GradientDrawable shapeDrawable = (GradientDrawable) viewHolder.linearLayout.getBackground();

        shapeDrawable.setColor(viewHolder.itemView.getContext().getResources().getColor(color[position % 7]));

        zetTypeOfVehicle.setText(train.getmZetTypeOfVehicle());
        //
        TextView nameStation = viewHolder.nameStation;
        nameStation.setText(train.getmNameStation());

        TextView numbersOfTrains = viewHolder.numbersOfTrains;
        numbersOfTrains.setText(train.getmNumbersOfTrains());
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
