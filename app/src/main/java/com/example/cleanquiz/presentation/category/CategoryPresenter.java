package com.example.cleanquiz.presentation.category;

import com.example.cleanquiz.data.model.CategoryEnum;

public class CategoryPresenter implements CategoryContract.Presenter{
    private CategoryContract.Model model;
    private CategoryContract.View view;

    public CategoryPresenter(CategoryContract.View view) {
        this.view = view;
        this.model = new CategoryModel();
    }

    @Override
    public void setSelectCategory(CategoryEnum category) {
        model.setSelectCategory(category);
        view.openQuestionActivity();
    }
}
