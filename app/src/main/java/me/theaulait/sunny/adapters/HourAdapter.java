package me.theaulait.sunny.adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import me.theaulait.sunny.R;
import me.theaulait.sunny.weather.Hour;

/**
 * Created by c4q-vanice on 6/26/15.
 */
public class HourAdapter extends RecyclerView.Adapter<HourAdapter.HourViewHolder> {

    private Hour[] mHours;
    private Context mContext;

// A constructor is always needed for a recycler view adapter.
    public HourAdapter(Context context, Hour[] hours){
        mContext = context;
        mHours = hours;
    }
    @Override
    public HourViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hourly_list, viewGroup, false);
        HourViewHolder viewHolder = new HourViewHolder(view);
        return viewHolder;
    }

//This is the bridge between the ViewHolder from the onBind method and the adapter.
    @Override
    public void onBindViewHolder(HourViewHolder hourViewHolder, int i) {
            hourViewHolder.bindHour(mHours[i]);
    }

    @Override
    public int getItemCount() {return mHours.length;}

// Recycler has the getView() within the ViewHolder with onClickListener.
    public class HourViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

            public TextView mTimeLabel;
            public TextView mSummaryLabel;
            public TextView mTemperatureLabel;
            public ImageView mIconImageView;

        public HourViewHolder(View itemView) {
            super(itemView);

            mTimeLabel = (TextView) itemView.findViewById(R.id.timeLabel);
            mSummaryLabel = (TextView) itemView.findViewById(R.id.summaryLabel);
            mTemperatureLabel = (TextView) itemView.findViewById(R.id.temperatureLabel);
            mIconImageView = (ImageView) itemView.findViewById(R.id.iconImageView);

            itemView.setOnClickListener(this);
        }

    public void bindHour(Hour hour){
            mTimeLabel.setText(hour.getHour());
            mSummaryLabel.setText(hour.getSummary());
            mTemperatureLabel.setText(hour.getTemperature() + "");
            mIconImageView.setImageResource(hour.getIconId());
    }

        @Override
        public void onClick(View view) {
            String time = mTimeLabel.getText().toString();
            String temperature = mTemperatureLabel.getText().toString();
            String summary = mSummaryLabel.getText().toString();
            String message = String.format("At %s it will be %s with %s",
                             time, temperature, summary);
            Toast.makeText(mContext, message, Toast.LENGTH_LONG).show();
        }
    }
}
