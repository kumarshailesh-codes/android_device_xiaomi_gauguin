package org.lineageos.settings;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import org.lineageos.settings.bypasscharging.BypassChargingUtils;

public class BootCompletedReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
            int mode = BypassChargingUtils.getBypassMode(context);
            BypassChargingUtils.writeNode(mode);
        }
    }
}
