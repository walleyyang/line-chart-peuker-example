package chart.main;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * The App.
 */
public class App extends Application {

  /**
   * The main method.
   * 
   * @param args The command line arguments
   */
  public static void main(String[] args) {
    launch(args);
  }

  /**
   * The start method.
   */
  @Override
  public void start(Stage primaryStage) {
    try {
      primaryStage.setTitle("Line Chart Example");

      Pane pane = FXMLLoader.load(getClass().getResource("/views/app.fxml"));

      int width = 400;
      int height = 130;
      
      primaryStage.setScene(new Scene(pane, width, height));
      primaryStage.show();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
