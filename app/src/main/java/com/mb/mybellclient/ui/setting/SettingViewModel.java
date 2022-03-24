package com.mb.mybellclient.ui.setting;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mb.mybellclient.Utils;

public class SettingViewModel extends ViewModel {

    private final MutableLiveData<String> textServerIP,textServerPort,textNickname;

    public SettingViewModel(String serverIP,String serverPort,String nickname) {
        textServerIP = new MutableLiveData<>();
        textServerPort = new MutableLiveData<>();
        textNickname = new MutableLiveData<>();
        //textServerIP.setValue(serverIP);
        //textServerPort.setValue(serverPort);
        //textNickname.setValue(nickname);
    }

    // ip
    public void setTextServerIP(String serverIP) {
        textServerIP.setValue(serverIP);
    }
    public LiveData<String> getTextServerIP() {
        return textServerIP;
    }

    // port
    public void setTextServerPort(String serverPort) {
        textServerPort.setValue(serverPort);
    }
    public LiveData<String> getTextServerPort() {
        return textServerPort;
    }

    //nickname
    public void setTextNickname(String nickname) {
        textNickname.setValue(nickname);
    }
    public LiveData<String> getTextNickname() {
        return textNickname;
    }


}