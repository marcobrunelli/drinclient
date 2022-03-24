package com.mb.mybellclient.ui.setting;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.textfield.TextInputEditText;
import com.mb.mybellclient.Utils;
import com.mb.mybellclient.databinding.FragmentSettingBinding;

import org.apache.commons.lang3.StringUtils;

public class SettingFragment extends Fragment {

    private FragmentSettingBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SettingViewModel settingsViewModel =
                new ViewModelProvider(this).get(SettingViewModel.class);

        settingsViewModel.setTextServerIP(Utils.getSharedPreferencesValue(getActivity(),"SERVER_IP"));
        settingsViewModel.setTextServerPort(Utils.getSharedPreferencesValue(getActivity(),"SERVER_PORT"));
        settingsViewModel.setTextNickname(Utils.getSharedPreferencesValue(getActivity(),"NICKNAME"));

        binding = FragmentSettingBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        configButtonSettings();
        configTextSettings(settingsViewModel);

        return root;
    }

    private void configTextSettings(SettingViewModel settingsViewModel) {
        final TextInputEditText setting_server_ip = binding.settingTextServerIp;
        settingsViewModel.getTextServerIP().observe(getViewLifecycleOwner(), setting_server_ip::setText);
        final TextInputEditText setting_server_port = binding.settingTextServerPort;
        settingsViewModel.getTextServerPort().observe(getViewLifecycleOwner(), setting_server_port::setText);
        final TextInputEditText setting_nickname = binding.settingTextNickname;
        settingsViewModel.getTextNickname().observe(getViewLifecycleOwner(), setting_nickname::setText);
    }

    private void configButtonSettings() {
        final Button button_sos = binding.settingButtonSave;
        button_sos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final TextInputEditText setting_server_ip = binding.settingTextServerIp;
                final TextInputEditText setting_server_port = binding.settingTextServerPort;
                final TextInputEditText setting_nickname = binding.settingTextNickname;

                String server_ip = setting_server_ip.getText().toString();
                if (!StringUtils.isBlank(server_ip)) {
                    Utils.setSharedPreferencesValue(getActivity(),"SERVER_IP",server_ip);
                }

                String server_port = setting_server_port.getText().toString();
                if (!StringUtils.isBlank(server_port)) {
                    Utils.setSharedPreferencesValue(getActivity(),"SERVER_PORT",server_port);
                }

                String nickname = setting_nickname.getText().toString();
                if (!StringUtils.isBlank(nickname)) {
                    Utils.setSharedPreferencesValue(getActivity(),"NICKNAME",nickname);
                }
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}