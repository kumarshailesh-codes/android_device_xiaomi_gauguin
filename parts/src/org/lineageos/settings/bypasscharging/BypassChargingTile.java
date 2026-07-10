package org.lineageos.settings.bypasscharging;
import android.service.quicksettings.Tile;
import android.service.quicksettings.TileService;
import org.lineageos.settings.R;
public class BypassChargingTile extends TileService {
    @Override
    public void onStartListening() {
        super.onStartListening();
        updateTile();
    }
    @Override
    public void onClick() {
        super.onClick();
        int mode = BypassChargingUtils.getBypassMode(this);
        int newMode = (mode == 2) ? 0 : 2;
        BypassChargingUtils.setBypassMode(this, newMode);
        updateTile();
    }
    private void updateTile() {
        Tile tile = getQsTile();
        if (tile == null) return;
        int mode = BypassChargingUtils.getBypassMode(this);
        if (mode == 2) {
            tile.setState(Tile.STATE_ACTIVE);
            tile.setSubtitle(getString(R.string.bypass_charging_enabled));
        } else {
            tile.setState(Tile.STATE_INACTIVE);
            tile.setSubtitle(getString(R.string.bypass_charging_disabled));
        }
        tile.updateTile();
    }
}
