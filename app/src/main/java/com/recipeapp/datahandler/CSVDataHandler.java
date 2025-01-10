package com.recipeapp.datahandler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.recipeapp.model.Ingredient;
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
        ArrayList<Recipe> recipes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // カンマで分割
                String[] recipe = line.split(",");

                // 食材用のリスト作成
                ArrayList<Ingredient> ingredients = new ArrayList<>();
                // recipe[1]以降を繰り返し分で、Ingredientクラスのnameに入れる
                for (int i = 1; i < recipe.length; i++) {
                    Ingredient ingredient = new Ingredient(recipe[i]);
                    ingredients.add(ingredient);
                }

                // recipe[0]をRecipeクラスのnameに入れる
                Recipe Recipe = new Recipe(recipe[0], ingredients);

                recipes.add(Recipe);
            }
        } catch (IOException e) {
        }
        return recipes;
    }

    // 新しいレシピをrecipes.csvに追加します。 レシピ名と材料はカンマ区切りで1行としてファイルに書き込まれます。
    @Override
    public void writeData(Recipe recipe) {
        // 3,DataHandlerから「2」で「Recipeクラス」に追加した新しいレシピを受け取り、recipes.csvに書き込む (レシピ名と材料はカンマ区切りで1行としてファイルに書き込まれます。)
        // ※ Recipeオブジェクトからどのように「Tomato Soup,Tomatoes, Onion...」のような1行の文字列にしていくか整理しましょう。

        // ユーザから受け取った材料を変数にまとめる
        String writeIngredient = "";
        ArrayList<Ingredient> ingredients =  recipe.getIngredient();
        for (Ingredient ingredient : ingredients) {
            // 材料がある時、次の材料を書く前に「,」を入れる
            if (!(writeIngredient.equals(""))) {
                writeIngredient += (", ");
            }
            writeIngredient += (ingredient.getName());
        }

        // 新しいレシピ名と材料を「recipes.csv」に書き込む
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(recipe.getName() + "," + writeIngredient);
            writer.newLine(); // 書き込み後に改行する
        } catch (IOException e) {
            System.out.println("Failed to add new recipe: " + e.getMessage());
        }
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
