package com.mb.mybellclient;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.text.format.Formatter;
import android.widget.TextView;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.mb.mybellclient.databinding.ActivityMainBinding;
import org.apache.commons.lang3.StringUtils;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Context context = getBaseContext();
        WifiManager wm = (WifiManager) context.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        String ip = Formatter.formatIpAddress(wm.getConnectionInfo().getIpAddress());

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_setting, R.id.nav_sound)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        // config SharePreferences - server port name
        configSharePreferences(navigationView,navController);
        // button


        //TextView clientName = navigationView.getHeaderView(0).findViewById(R.id.client_name);
        //clientName.setText("AAA");


    }

    private void configSharePreferences(NavigationView navigationView,NavController navController) {
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        String server_ip = sharedPref.getString("SERVER_IP","");
        String server_port = sharedPref.getString("SERVER_PORT","");
        String client_name = sharedPref.getString("CLIENT_NAME","");
        if (
                StringUtils.isEmpty(server_ip) ||
                        StringUtils.isEmpty(server_port) ||
                        StringUtils.isEmpty(client_name)
        ) {
            new MaterialAlertDialogBuilder(MainActivity.this,R.style.RoundShapeTheme)
                    .setTitle(R.string.dialog_title_alert)
                    .setMessage(R.string.dialog_msg_server_ipport)
                    .setPositiveButton(R.string.dialog_button_ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            navigationView.setCheckedItem(R.id.nav_setting);
                            navController.navigate(R.id.nav_setting);
                        }
                    })
                    .show();
        }
    }

/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
*/
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}