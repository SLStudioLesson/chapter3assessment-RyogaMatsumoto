import com.recipeapp.datahandler.CSVDataHandler;
import com.recipeapp.datahandler.DataHandler;
import com.recipeapp.datahandler.JSONDataHandler;
import com.recipeapp.ui.RecipeUI;
import com.recipeapp.datahandler.DataHandler;
import java.io.*;

public class App {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Choose the file format:");
            System.out.println("1. CSV");
            System.out.println("2. JSON");
            System.out.print("Select (1/2): ");
            String choice = reader.readLine();
            
            switch (choice) {
                case "2":
                JSONDataHandler jsonDataHandler = new JSONDataHandler();
                RecipeUI recipeUI2 = new RecipeUI((DataHandler)jsonDataHandler);
                recipeUI2.displayMenu();
                    break;

                default:
                    CSVDataHandler csvDataHandler = new CSVDataHandler();
                    RecipeUI recipeUI1 = new RecipeUI((DataHandler)csvDataHandler);
                    recipeUI1.displayMenu();
                    break;
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}