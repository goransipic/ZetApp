package hr.goodapp.zetapp.zetlines.adapter;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import hr.goodapp.zetapp.R;
import hr.goodapp.zetapp.zetlines.model.ZetLines;

/**
 * Created by User on 24.1.2016..
 */
public class ZetlinesAdapter extends RecyclerView.Adapter<ZetlinesAdapter.ViewHolder> {

    // Store a member variable for the contacts
    private List<ZetLines> mZetLines;

    public void setZetLines(List<ZetLines> zetLines) {
        this.mZetLines = zetLines;
    }

    // Usually involves inflating a layout from XML and returning the holder

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        private TextView zetNumberofVehicle;
        public TextView zetTypeOfVehicle;
        public TextView nameStation;

        private LinearLayout linearLayout;
        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            zetNumberofVehicle = (TextView) itemView.findViewById(R.id.zet_number_of_vehicle);
            zetTypeOfVehicle = (TextView) itemView.findViewById(R.id.zet_lines_zet_type_of_vehicle);
            nameStation = (TextView) itemView.findViewById(R.id.name_station);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.zet_venhicle_type_ic);


        }
    }

    @Override
    public ZetlinesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_zetlines, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        // Get the data model based on position
        ZetLines zetLines = mZetLines.get(position);

        int color[] = {
                R.color.colorPrimary,
                R.color.colorAccent,
                R.color.color3,
                R.color.colorPrimaryDark,
                R.color.color1,
                R.color.color2,
                R.color.color4,
        };

        viewHolder.zetNumberofVehicle.setText(zetLines.getZetNumber());

        // Set item views based on the data model
        TextView zetTypeOfVehicle = viewHolder.zetTypeOfVehicle;
        GradientDrawable shapeDrawable = (GradientDrawable) viewHolder.linearLayout.getBackground();

        shapeDrawable.setColor(viewHolder.itemView.getContext().getResources().getColor(color[position % 7]));

        zetTypeOfVehicle.setText(zetLines.getZetVenhicleType());
        //
        TextView nameStation = viewHolder.nameStation;
        nameStation.setText(zetLines.getZetRouteStations());

    }

    // Return the total count of items
    @Override
    public int getItemCount() {

        if (mZetLines == null) {
            return 0;
        }else {
            return mZetLines.size();
        }
    }



}
