package com.hfad.androidqbackgroundlocation;

import android.content.Context;
import android.location.Location;
import android.preference.PreferenceManager;

import java.util.Date;
import java.text.DateFormat;

public class Common {
    public static final String KEY_REQUIRED_LOCATION_UPDATES = "LocationUpdateEnable";

    public static String getLocationText(Location mLocation){
        return mLocation==null? "Unknown Location": new StringBuilder()
                .append(mLocation.getLatitude())
                .append("/")
                .append(mLocation.getLongitude())
                .toString();

    }

    public static CharSequence getLocationTitle (MyBackgroundService myBackgroundService){
        return String.format("Location Updated: %1$a", DateFormat.getDateInstance().format(new Date()));
    }

    public static void setRequestingLocationUpdates(Context context, boolean value){
        PreferenceManager.
                getDefaultSharedPreferences(context)
                .edit()
                .putBoolean(KEY_REQUIRED_LOCATION_UPDATES,value)
                .apply();
    }

    public static boolean requestingLocationUpdates(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getBoolean(KEY_REQUIRED_LOCATION_UPDATES, false);
    }

}

