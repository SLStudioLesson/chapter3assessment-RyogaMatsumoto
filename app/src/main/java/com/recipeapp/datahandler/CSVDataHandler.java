package com.recipeapp.datahandler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.recipeapp.model.Recipe;

public class CSVDataHandler implements com.recipeapp.DataHandler{
    private String filePath; // レシピデータを格納するCSVファイルのパス。

    // フィールドfilePathにapp/src/main/resources/recipes.csvを代入する
    String csvFile = "app/src/main/resources/recipes.csv";
    public CSVDataHandler() {
        csvFile = filePath;
    }

    // フィールドfilePathに引数を代入する
    public CSVDataHandler(String filePath) {
        this.filePath = filePath;
    }

    // 文字列CSVを返す
    public String getMode() {
        return "CSV";
    }

    // recipes.csvからレシピデータを読み込み、それをリスト形式で返す
    public ArrayList<Recipe> readData() {
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return readData();
    }

    // 以降の設問で処理を実装するため定義のみ行います。
    public void writeData(Recipe recipe) {

    }

    // 以降の設問で処理を実装するため定義し、nullをreturnしてください。
    public ArrayList<Recipe> searchData(String keyword) {
        return null;
    }
}
