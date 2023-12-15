package com.example.cleanquiz.presentation.category;

import com.example.cleanquiz.data.model.CategoryEnum;
import com.example.cleanquiz.domain.AppController;

public class CategoryModel implements CategoryContract.Model{
    private AppController controller =  AppController.getInstance();

    @Override
    public void setSelectCategory(CategoryEnum category) {
        controller.setSelectCategory(category);
    }
}
