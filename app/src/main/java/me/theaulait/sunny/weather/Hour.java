package me.theaulait.sunny.weather;

import android.os.Parcel;
import android.os.Parcelable;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by c4q-vanice on 6/23/15.
 */
public class Hour implements Parcelable {
    private long mTime;
    private String mSummary;
    private double mTemperature;
    private String mIcon;
    private String mTimeZone;

    public Hour(){}

    public long getTime() {return mTime;}

    public void setTime(long time) {
        mTime = time;
    }

    public String getSummary() {
        return mSummary;
    }

    public void setSummary(String summary) {
        mSummary = summary;
    }

    public int getTemperature() {return (int) Math.round(mTemperature);}

    public void setTemperature(double temperature) {
        mTemperature = temperature;
    }

    public String getIcon() {
        return mIcon;
    }

    public int getIconId(){return Forecast.getIconId(mIcon);}

    public void setIcon(String icon) {
        mIcon = icon;
    }

    public String getTimeZone() {
        return mTimeZone;
    }

    public void setTimeZone(String timeZone) {
        mTimeZone = timeZone;
    }

    public String getHour(){
        SimpleDateFormat format = new SimpleDateFormat("h a");
        Date date = new Date(mTime * 1000);
        return format.format(date);
    }

    @Override
    public int describeContents() {return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int i) {
        out.writeLong(mTime);
        out.writeString(mSummary);
        out.writeDouble(mTemperature);
        out.writeString(mIcon);
        out.writeString(mTimeZone);
    }
//Method to un-parcel the package. This will be only access by the creator field.
//TODO The order is very important! It goes in and comes out the exact same way.
    private Hour(Parcel in) {
        mTime = in.readLong();
        mSummary = in.readString();
        mTemperature = in.readDouble();
        mIcon = in.readString();
        mTimeZone = in.readString();
    }

    public static final Creator<Hour> CREATOR = new Creator<Hour>() {
        @Override
        public Hour createFromParcel(Parcel source) {
            return new Hour(source);
        }

        @Override
        public Hour[] newArray(int size) {
            return new Hour[size];
        }
    };
}
