package com.recipeapp.datahandler;

import java.util.ArrayList;
import java.util.List;

import com.recipeapp.model.Recipe;

public class JSONDataHandler implements DataHandler{
        // 文字列JSONを返す
    @Override
    public String getMode() {
        return "JSON";
    }

    // 以降の設問で処理を実装するため定義し、nullをreturnしてください。
    @Override
    public ArrayList<Recipe> readData() {
        return null;
    }

    // 以降の設問で処理を実装するため定義のみ行います。
    @Override
    public void writeData(Recipe recipe) {

    }

    // 以降の設問で処理を実装するため定義し、nullをreturnしてください。
    @Override
    public ArrayList<Recipe> searchData() {
        return null;
    }

    @Override
    public List<String> readRecipes() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readRecipes'");
    }
}
