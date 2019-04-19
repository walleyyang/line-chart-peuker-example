package chart.main;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * The AppController.
 */
public class AppController {

  @FXML
  void displayDefaultLineChart() {
    System.out.println("Displaying Default Line Chart");
    displayLineChart("Default Line Chart", "DEFAULT");
  }

  @FXML
  void displayLineChartWithPeuckerAlgorithm() {
    System.out.println("Displaying Peucker Algorithm");
    displayLineChart("Line Chart With Peucker Algorithm", "PEUCKER");
  }

  /**
   * Displays the line chart.
   */
  private void displayLineChart(String title, String lineChartType) {
    try {
      ChartController controller = new ChartController(lineChartType);

      FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/chart.fxml"));
      loader.setController(controller);

      Pane pane = loader.load();

      Stage stage = new Stage();
      stage.setScene(new Scene(pane, 1000, 700));
      stage.setTitle(title);
      stage.show();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
