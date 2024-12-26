package com.recipeapp.datahandler;

import java.util.ArrayList;

import com.recipeapp.model.Recipe;

public class JSONDataHandler implements com.recipeapp.DataHandler{
        // 文字列JSONを返す
    public String getMode() {
        return "JSON";
    }

    // 以降の設問で処理を実装するため定義し、nullをreturnしてください。
    public ArrayList<Recipe> readData() {
        return null;
    }

    // 以降の設問で処理を実装するため定義のみ行います。
    public void writeData(Recipe recipe) {

    }

    // 以降の設問で処理を実装するため定義し、nullをreturnしてください。
    public ArrayList<Recipe> searchData(String keyword) {
        return null;
    }
}
