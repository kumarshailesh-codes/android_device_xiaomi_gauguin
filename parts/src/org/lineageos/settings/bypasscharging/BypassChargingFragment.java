package org.lineageos.settings.bypasscharging;

import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceFragment;
import org.lineageos.settings.R;

public class BypassChargingFragment extends PreferenceFragment implements OnPreferenceChangeListener {
    private ListPreference mBypassModePref;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.bypass_charging);

        mBypassModePref = (ListPreference) findPreference("bypass_charging_mode");
        mBypassModePref.setOnPreferenceChangeListener(this);
        
        int currentVal = BypassChargingUtils.getBypassMode(getContext() != null ? getContext() : getActivity());
        mBypassModePref.setValue(String.valueOf(currentVal));
        updateSummary(currentVal);
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        if (preference == mBypassModePref) {
            int value = Integer.parseInt((String) newValue);
            BypassChargingUtils.setBypassMode(getContext() != null ? getContext() : getActivity(), value);
            updateSummary(value);
            return true;
        }
        return false;
    }

    private void updateSummary(int val) {
        if (val == 2) {
            mBypassModePref.setSummary(getString(R.string.bypass_charging_enabled));
        } else {
            mBypassModePref.setSummary(getString(R.string.bypass_charging_disabled));
        }
    }
}
