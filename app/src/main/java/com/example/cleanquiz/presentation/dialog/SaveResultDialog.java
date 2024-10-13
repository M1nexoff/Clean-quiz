package com.example.cleanquiz.presentation.dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.cleanquiz.R;
import com.example.cleanquiz.data.model.GameResult;
import com.example.cleanquiz.databinding.DialogQuitAppBinding;
import com.example.cleanquiz.databinding.DialogSaveResultBinding;

public class SaveResultDialog extends DialogFragment {
    private final SaveDialog listener;

    public SaveResultDialog(SaveDialog listener) {
        this.listener = listener;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_save_result, container, false);
        view.setBackgroundColor(Color.TRANSPARENT);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        DialogSaveResultBinding binding = DialogSaveResultBinding.bind(view);

        binding.saveButton.setOnClickListener(v -> {
            if (listener != null) {
                String name = binding.editText.getText().toString();
                if (isValidUsername(name)){
                    listener.onSaveClicked(name);
                    dismiss();
                }
                else if (name.isEmpty()) {
                    listener.onSaveClicked("Anonymous");
                    dismiss();
                }
                else
                    Toast.makeText(requireContext(), "Change UserName!", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public static boolean isValidUsername(String username) {
        String regex = "^[a-zA-Z0-9_]+$";

        if (username == null) {
            return false;
        }

        return username.matches(regex);
    }
}
