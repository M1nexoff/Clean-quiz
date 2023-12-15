package com.example.cleanquiz.presentation.main;

import com.example.cleanquiz.data.model.QuestionData;
import com.example.cleanquiz.domain.AppController;

import java.util.List;

public class MainModel implements MainContract.Model{
    private AppController controller = AppController.getInstance();
    @Override
    public List<QuestionData> getQuestionByCategory() {
        return controller.getQuestionByCategory();
    }
}
