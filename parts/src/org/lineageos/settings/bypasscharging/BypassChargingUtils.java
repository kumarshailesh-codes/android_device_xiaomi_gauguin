package org.lineageos.settings.bypasscharging;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class BypassChargingUtils {
    public static final String KEY_BYPASS_MODE = "bypass_charging_mode";
    public static final String NODE_INPUT_SUSPEND = "/sys/class/power_supply/battery/input_suspend";

    public static int getBypassMode(Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        try {
            return Integer.parseInt(prefs.getString(KEY_BYPASS_MODE, "0"));
        } catch (Exception e) {
            return 0;
        }
    }

    public static void setBypassMode(Context context, int mode) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        prefs.edit().putString(KEY_BYPASS_MODE, String.valueOf(mode)).apply();
        writeNode(mode);
    }

    public static void writeNode(int val) {
        File f = new File(NODE_INPUT_SUSPEND);
        if (f.exists() && f.canWrite()) {
            try (FileOutputStream fos = new FileOutputStream(f)) {
                fos.write(String.valueOf(val).getBytes());
            } catch (IOException e) {
            }
        }
    }
}
