package chart.main;

import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

/**
 * The ChartController.
 */
public class ChartController {

  DataSetModel dataSetModel;
  
  @FXML
  private VBox chartContainer;

  /**
   * The constructor.
   * 
   * @param lineChartType The line chart type to display
   */
  public ChartController(String lineChartType) {
    dataSetModel = DataSetModel.getInstance();
  }

  /**
   * The initialize method.
   */
  public void initialize() {
    createLineChart();
  }

  /**
   * Creates the line chart.
   */
  private void createLineChart() {
    LineChart<String, Number> lineChart;
    CategoryAxis xAxis = new CategoryAxis();
    NumberAxis yAxis = new NumberAxis();
    XYChart.Series<String, Number> series = new XYChart.Series<>();

    dataSetModel.getChartDataSet()
        .forEach((k, v) -> series.getData().add(new XYChart.Data<String, Number>(k, v)));

    lineChart = new LineChart<>(xAxis, yAxis);
    lineChart.getData().add(series);
    lineChart.setLegendVisible(false);
    chartContainer.getChildren().add(lineChart);
    HBox.setHgrow(lineChart, Priority.ALWAYS);
    VBox.setVgrow(lineChart, Priority.ALWAYS);
  }

}
