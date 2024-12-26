import com.recipeapp.datahandler.CSVDataHandler;
import com.recipeapp.datahandler.DataHandler;
import com.recipeapp.datahandler.JSONDataHandler;
// import com.recipeapp.ui.RecipeUI;
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
                    System.out.println("\nCurrent mode: JSON");
                    System.out.println("\nMain Menu:");
                    System.out.println("Choose the file format:");
                    System.out.println("1: Display Recipes");
                    System.out.println("2: Add New Recipe");
                    System.out.println("3: Search Recipe");
                    System.out.println("4: Exit Application");
                    System.out.print("Please choose an option: ");
                    String choice_JSON = reader.readLine();
                    break;

                default:
                    System.out.println("\nCurrent mode: CSV");
                    System.out.println("\nMain Menu:");
                    System.out.println("Choose the file format:");
                    System.out.println("1: Display Recipes");
                    System.out.println("2: Add New Recipe");
                    System.out.println("3: Search Recipe");
                    System.out.println("4: Exit Application");
                    System.out.print("Please choose an option: ");
                    String choice_CSV = reader.readLine();
                    break;
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}