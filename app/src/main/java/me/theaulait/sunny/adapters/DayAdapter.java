package me.theaulait.sunny.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import me.theaulait.sunny.R;
import me.theaulait.sunny.weather.Daily;

/**
 * Created by c4q-vanice on 6/24/15.
 */
public class DayAdapter extends BaseAdapter {

    private Context mContext;
    private Daily[] mDays;

    // constructor to set the values.
    public DayAdapter(Context context, Daily[] days){
        mContext = context;
        mDays = days;
    }

    // Get the count of items in the Daily [] i.e. Monday, Tuesday, Wednesday etc.
    @Override
    public int getCount() {
        return mDays.length;
    }

    // Get the actual item i.e. item Monday
    @Override
    public Object getItem(int position) {
        return mDays[position];
    }

    // This is going to tag the item to use for reference. i.e 1 = Monday
    @Override
    public long getItemId(int i) {
        return 0;
    }

    // "View view" is the place holder that will recycle the view. The first time view is call will be null.
    //TODO You do not have to use a view holder for listView but it is best practice.
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null){
            view = LayoutInflater.from(mContext).inflate(R.layout.daily_list, null);
            holder = new ViewHolder();
            holder.iconImageView = (ImageView) view.findViewById(R.id.iconImageView);
            holder.temperatureLabel = (TextView) view.findViewById(R.id.temperatureLabel);
            holder.dayName = (TextView) view.findViewById(R.id.dayName);
            // Set a tag for the holder current holding "this" view. This tag will be reused.
            view.setTag(holder);}

        else{
            holder = (ViewHolder) view.getTag();}
            Daily day = mDays[position];

            holder.iconImageView.setImageResource(day.getIconId());
            holder.temperatureLabel.setText(day.getTemperatureMax() + "");
        if(position == 0 ){
            holder.dayName.setText("Today");}
        else{
            holder.dayName.setText(day.getDayOfTheWeek());}
        // This will be reuse will fresh data after call.
        return view;
    }

    private static class ViewHolder {
            ImageView iconImageView;
            TextView temperatureLabel;
            TextView dayName;

    }
}
