package org.lineageos.settings.bypasscharging;

import android.app.Activity;
import android.os.Bundle;

public class BypassChargingActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction().replace(
                android.R.id.content,
                new BypassChargingFragment(), "bypass_charging").commit();
    }
}
