package com.example.nguyensyhongnam_51702139_lab10.ex3;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
// import androidx.preference.PreferenceFragmentCompat;


import com.example.nguyensyhongnam_51702139_lab10.R;


public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex3_settings_activity);
        getSupportFragmentManager()
                .beginTransaction()
               // .replace(R.id.settings, new SettingsFragment())
                .commit();
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

//    public static class SettingsFragment extends PreferenceFragmentCompat {
//
//        @Override
//        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
//            setPreferencesFromResource(R.xml.root_preferences, rootKey);
//        }
//    }
}