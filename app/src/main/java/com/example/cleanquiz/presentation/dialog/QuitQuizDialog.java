package com.example.cleanquiz.presentation.dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.cleanquiz.R;
import com.example.cleanquiz.databinding.DialogQuitAppBinding;

public class QuitQuizDialog extends DialogFragment {
    private final DialogListener listener;

    public QuitQuizDialog(DialogListener listener) {
        this.listener = listener;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_quit_quiz, container, false);
        view.setBackgroundColor(Color.TRANSPARENT);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        DialogQuitAppBinding binding = DialogQuitAppBinding.bind(view);

        binding.noButton.setOnClickListener(v -> {
            if (listener != null) {
                listener.onNoClicked();
            }
            dismiss();
        });

        binding.yesButton.setOnClickListener(v -> {
            if (listener != null) {
                listener.onYesClicked();
            }
            dismiss();
        });
    }
}
