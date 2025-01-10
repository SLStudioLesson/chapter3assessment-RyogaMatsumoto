package com.recipeapp.ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.recipeapp.datahandler.CSVDataHandler;
import com.recipeapp.datahandler.DataHandler;
import com.recipeapp.model.Ingredient;
import com.recipeapp.model.Recipe;

public class RecipeUI implements DataHandler {
    private BufferedReader reader;
    private DataHandler dataHandler;

    public RecipeUI(DataHandler dataHandler) {
        reader = new BufferedReader(new InputStreamReader(System.in));
        this.dataHandler = dataHandler;
    }

    public void displayMenu() {

        System.out.println("\nCurrent mode: " + dataHandler.getMode());

        while (true) {
            try {
                System.out.println();
                System.out.println("Main Menu:");
                System.out.println("1: Display Recipes");
                System.out.println("2: Add New Recipe");
                System.out.println("3: Search Recipe");
                System.out.println("4: Exit Application");
                System.out.print("Please choose an option: ");

                String choice = reader.readLine();

                switch (choice) {
                    case "1":
                    // DataHandlerから読み込んだレシピデータを整形してコンソールに表示
                    displayRecipes();
                        break;
                    case "2":
                    addNewRecipe();
                        break;
                    case "3":
                        break;
                    case "4":
                        System.out.println("Exiting the application.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please select again.");
                        break;
                }
            } catch (IOException e) {
                System.out.println("Error reading input from user: " + e.getMessage());
            }
        }
    }

    private void displayRecipes() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("app/src/main/resources/recipes.csv"))) {
            String line;
            ArrayList<Recipe> recipes = dataHandler.readData();

            // ファイル内に何も入っていなければ「No recipes available」と表示  入っていれば「Recipes:」と表示
            if ((line = reader.readLine()) != null) {
                System.out.println("\nRecipes:");
                for (Recipe recipe : recipes) {
                    System.out.println("-----------------------------------");
                    System.out.println("Recipe Name: " + recipe.getName());

                    System.out.print("Main Ingredients: ");
                    ArrayList<Ingredient> ingredients =  recipe.getIngredient();
                    String displayIngredient = "";
                    for (Ingredient ingredient : ingredients) {
                        // 材料がある時、次の材料を書く前に「,」を入れる
                        if (!(displayIngredient.equals(""))) {
                            displayIngredient += (",");
                        }
                        displayIngredient += (ingredient.getName());
                    }
                    System.out.println(displayIngredient);
                }
                System.out.println("-----------------------------------");
            } else {
                System.out.println("\nNo recipes available.");
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // ユーザーからレシピ名と主な材料を入力させ、DataHandlerを使用してrecipes.csvに新しいレシピを追加
    private void addNewRecipe() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("app/src/main/resources/recipes.csv", true))) {
            // 1,ユーザからレシピ名 材料を入力させる (材料の入力はdoneと入力するまで入力を受け付け)
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            
            System.out.println("\nAdding a new recipe."); // Adding a new recipe.と出力
            // ユーザからレシピ名を入力してもらう
            System.out.print("Enter recipe name: ");
            String addRecipe = reader.readLine();

            // 材料のリストを作成
            ArrayList<Ingredient> addIngredients = new ArrayList<>();
            // ユーザから材料を入力してもらう(材料の入力はdoneと入力するまで入力を受け付け)
            System.out.println("Enter ingredients (type 'done' when finished): ");
            String addIngredient = "";
            
            // 2,DataHandlerを使用して「1」で受け取った新しいレシピを「Recipeクラス」に追加する
            // ※ Recipeクラスのインスタンスを生成するためにIngredientクラスのインスタンスのリスト（ArrayList<Ingredient>）も用意しなければいけない
            while (!(addIngredient.equals("done"))) {
                System.out.print("Ingredient: ");
                addIngredient = reader.readLine();
                // 受け取った素材がdoneでない場合ingredientsリストに入る
                if (!(addIngredient.equals("done"))) {
                    // Ingredient型のインスタンスを生成して、ArrayList<Ingredient> addIngredientsに追加する
                    addIngredients.add(new Ingredient(addIngredient));
                }
            }
            // ユーザから受け取ったレシピと材料の情報が入った「newRecipe」インスタンスを生成して、writeDataメソッドに渡す
            Recipe newRecipe = new Recipe(addRecipe, addIngredients);
            dataHandler.writeData(newRecipe);
            // ここまでの処理ができたら（ユーザから受け取ったレシピと材料の情報追加出来たら）、「Recipe added successfully.」と出力
            System.out.println("\nRecipe added successfully.");
        } catch (IOException e) {
            // 4,IOExceptionを受け取った場合はFailed to add new recipe: 例外のメッセージとコンソールに表示
            System.out.println("Failed to add new recipe: " + e.getMessage());
        }
    }

    @Override
    public String getMode() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMode'");
    }

    @Override
    public ArrayList<Recipe> readData() throws IOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readData'");
    }

    @Override
    public void writeData(Recipe recipe) throws IOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'writeData'");
    }

    @Override
    public ArrayList<Recipe> searchData() throws IOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchData'");
    }

    @Override
    public List<String> readRecipes() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readRecipes'");
    }
}
