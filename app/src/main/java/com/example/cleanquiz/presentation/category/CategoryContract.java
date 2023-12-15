package com.example.cleanquiz.presentation.category;

import com.example.cleanquiz.data.model.CategoryEnum;

public interface CategoryContract {
    interface Model {
        void setSelectCategory(CategoryEnum category);
    }
    interface View{
        void openQuestionActivity();
    }
    interface Presenter{
        void setSelectCategory(CategoryEnum category);
    }
}
