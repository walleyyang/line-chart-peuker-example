package chart.main;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * The AppController.
 */
public class AppController {
  DataSetModel dataSetModel;
  
  @FXML private Label reducedMarkersLabel;
  @FXML private TextField epsilonTextField;
  @FXML private TextField markersTextField;

  public AppController() {
    dataSetModel = DataSetModel.getInstance();
  }
  
  /**
   * The initialize method.
   */
  public void initialize() {
    updateEpsilonMarker();
  }

  @FXML
  public void updateEpsilonMarker() {
    dataSetModel.createDataSet(Integer.parseInt(markersTextField.textProperty().getValue()));
  }

  @FXML
  public void displayDefaultLineChart() {
    displayLineChart("Default Line Chart", "DEFAULT");
  }

  @FXML
  public void displayLineChartWithPeuckerAlgorithm() {
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
      Double epsilon = Double.parseDouble(epsilonTextField.textProperty().getValue());
      ChartController controller = new ChartController(lineChartType, epsilon);

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
