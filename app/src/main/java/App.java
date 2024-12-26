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
                    CSVDataHandler csvDataHandler = new CSVDataHandler();
                    RecipeUI recipeUI2 = new RecipeUI((DataHandler)csvDataHandler);
                    recipeUI2.displayMenu();
                    break;

                default:
                    JSONDataHandler jsonDataHandler = new JSONDataHandler();
                    RecipeUI recipeUI1 = new RecipeUI((DataHandler)jsonDataHandler);
                    recipeUI1.displayMenu();
                    break;
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}