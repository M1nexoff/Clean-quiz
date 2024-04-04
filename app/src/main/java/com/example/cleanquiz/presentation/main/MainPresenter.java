package com.example.cleanquiz.presentation.main;

import java.util.List;

import com.example.cleanquiz.data.model.QuestionData;
import com.example.cleanquiz.presentation.main.MainContract;
import com.example.cleanquiz.presentation.main.MainModel;

public class MainPresenter implements MainContract.Presenter {
    private MainContract.Model model;
    private MainContract.View view;
    private List<QuestionData> questionList;
    private int currentPos = 0;
    private int correctCount = 0;
    private int selectIndex = -1;

    MainPresenter(MainContract.View view) {
        this.view = view;
        this.model = new MainModel();

        loadQuestionData();
        loadQuestionByPos();
    }

    private void loadQuestionData() {
        this.questionList = model.getQuestionByCategory();
    }

    private void loadQuestionByPos() {
        view.showCount(currentPos);
        view.describeQuestion(questionList.get(currentPos));
    }

    @Override
    public int getPos() {
        return currentPos;
    }

    @Override
    public void selectAnswer(int pos) {
        if (pos == this.selectIndex) return;
        if (selectIndex > -1) view.clearOldStates(selectIndex);
        selectIndex = pos;
        view.nextButtonState(true);
        view.showSelectedIndex(pos);
    }

    @Override
    public void clickNextButton() {
        QuestionData currentQuestion = questionList.get(currentPos);
        if (currentQuestion.getAnswer().equals(currentQuestion.getVariants()[selectIndex])) {
            this.correctCount ++;
        }
        view.clearOldStates(selectIndex);
        view.nextButtonState(false);
        currentPos++;
        view.showCount(currentPos);
        if (currentPos == questionList.size()) view.fastFinish(correctCount);
        else view.describeQuestion(questionList.get(currentPos));
        selectIndex=-1;
    }

    @Override
    public void finish() {
        view.finish(correctCount);
    }
}
