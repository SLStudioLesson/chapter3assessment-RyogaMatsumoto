package com.recipeapp.datahandler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.recipeapp.model.Recipe;

public class CSVDataHandler implements DataHandler {
    private String filePath; // レシピデータを格納するCSVファイルのパス。

    // フィールドfilePathにapp/src/main/resources/recipes.csvを代入する
    public CSVDataHandler() {
        this.filePath = "app/src/main/resources/recipes.csv";
    }

    // フィールドfilePathに引数を代入する
    public CSVDataHandler(String filePath) {
        this.filePath = filePath;
    }

    // 文字列CSVを返す
    @Override
    public String getMode() {
        return "CSV";
    }

    // recipes.csvからレシピデータを読み込み、それをリスト形式で返す
    @Override
    public ArrayList<Recipe> readData() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return readData();
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
}
