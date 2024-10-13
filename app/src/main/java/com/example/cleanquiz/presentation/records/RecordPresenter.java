package com.example.cleanquiz.presentation.records;

import com.example.cleanquiz.data.model.CategoryEnum;
import com.example.cleanquiz.presentation.category.CategoryContract;
import com.example.cleanquiz.presentation.category.CategoryModel;

public class RecordPresenter implements RecordContract.Presenter{
    private CategoryContract.Model model;
    private CategoryContract.View view;

    public RecordPresenter(CategoryContract.View view) {
        this.view = view;
        this.model = new CategoryModel();
    }

}
