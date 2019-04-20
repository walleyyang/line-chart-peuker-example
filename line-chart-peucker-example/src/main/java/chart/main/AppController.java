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

  private int numberOfMarkers = 2000;

  public AppController() {
    DataSetModel dataSetModel = DataSetModel.getInstance();
    dataSetModel.createDataSet(numberOfMarkers);
  }

  @FXML
  void displayDefaultLineChart() {
    System.out.println("Displaying Default Line Chart");
    displayLineChart("Default Line Chart", "DEFAULT");
  }

  @FXML
  void displayLineChartWithPeuckerAlgorithm() {
    System.out.println("Displaying Peucker Algorithm");
    displayLineChart("Line Chart With Peucker Algorithm", "REDUCED");
  }

  /**
   * Displays the line chart.
   * 
   * @param title The title for the new stage
   * @param lineChartType The line chart type to display
   */
  private void displayLineChart(String title, String lineChartType) {
    try {
      ChartController controller = new ChartController(lineChartType);

      FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/chart.fxml"));
      loader.setController(controller);

      Pane pane = loader.load();

      int width = 1500;
      int height = 800;

      Stage stage = new Stage();
      stage.setScene(new Scene(pane, width, height));
      stage.setTitle(title);
      stage.show();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
