package com.tecnm.aquacontrol.ui.calidad;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.tecnm.aquacontrol.databinding.FragmentCalidadBinding;

public class CalidadFragment extends Fragment {

    private FragmentCalidadBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CalidadViewModel calidadViewModel =
                new ViewModelProvider(this).get(CalidadViewModel.class);

        binding = FragmentCalidadBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textCalidad;
        calidadViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}