package me.theaulait.sunny.weather;

import me.theaulait.sunny.R;

/**
 * Created by c4q-vanice on 6/23/15.
 */
public class Forecast {
    private Current mCurrent;
    private Hour[] mHour;

    public Current getCurrent() {
        return mCurrent;
    }

    public void setCurrent(Current current) {
        mCurrent = current;
    }

    public Hour[] getHour() {
        return mHour;
    }

    public void setHour(Hour[] hour) {
        mHour = hour;
    }

    public Daily[] getDaily() {
        return mDaily;
    }

    public void setDaily(Daily[] daily) {
        mDaily = daily;
    }

    private Daily[] mDaily;

    public static int getIconId(String mIconString){
        //default icon
        int iconId = R.drawable.clear_day;

        if (mIconString.equals("clear-day")){
            iconId = R.drawable.clear_day;
        }
        else if (mIconString.equals("clear-night")){
            iconId = R.drawable.clear_night;
        }
        else if (mIconString.equals("rain")){
            iconId = R.drawable.rain;
        }
        else if (mIconString.equals("snow")){
            iconId = R.drawable.snow;
        }
        else if (mIconString.equals("sleet")) {
            iconId = R.drawable.sleet;
        }
        else if (mIconString.equals("wind")) {
            iconId = R.drawable.wind;
        }
        else if (mIconString.equals("fog")) {
            iconId = R.drawable.fog;
        }
        else if (mIconString.equals("cloudy")) {
            iconId = R.drawable.cloudy;
        }
        else if (mIconString.equals("partly-cloudy-day")) {
            iconId = R.drawable.partly_cloudy;
        }
        else if (mIconString.equals("partly-cloudy-night")) {
            iconId = R.drawable.cloudy_night;
        }
        return iconId;
    }
}
