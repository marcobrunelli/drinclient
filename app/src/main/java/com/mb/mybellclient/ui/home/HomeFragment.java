package com.mb.mybellclient.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.mb.mybellclient.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        // config button home
        configButtonHome();

        //final TextView textView = binding.textHome;
        //homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    private void configButtonHome() {
        // resource button
        final AppCompatImageButton button_sos = binding.homeBtnSos;
        final AppCompatImageButton button_wc = binding.homeBtnWc;
        final AppCompatImageButton button_food = binding.homeBtnFood;
        final AppCompatImageButton button_water = binding.homeBtnWater;
        final AppCompatImageButton button_pill = binding.homeBtnPill;
        final AppCompatImageButton button_more = binding.homeBtnMore;
        // listener
        button_sos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"prova",Toast.LENGTH_LONG).show();
            }
        });

        button_wc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        button_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"prova",Toast.LENGTH_LONG).show();
            }
        });

        button_water.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"prova",Toast.LENGTH_LONG).show();
            }
        });

        button_pill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"prova",Toast.LENGTH_LONG).show();
            }
        });

        button_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"prova",Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}