package com.example;

import java.util.ArrayList;
import java.util.Objects;

public class CategoryData {

    private ArrayList<Category> categories = new ArrayList<Category>();

    public CategoryData(){
        categories.add(new Category("Food", new Budget("Food", 3000)));
        categories.add(new Category("Transportation", new Budget("Transportation", 1000)));
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public int getBudget(String type){
        System.out.println(categories.size());
        for (int i = 0;i < categories.size(); i++){
            if (Objects.equals(categories.get(i).getType().toUpperCase(), type.toUpperCase())){
                return categories.get(i).getBudget().getCurrentLeft();
            }
        }

        return -1;
    }

}
