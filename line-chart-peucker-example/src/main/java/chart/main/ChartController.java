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

  private DataSetModel dataSetModel;
  private String lineChartType;

  @FXML
  private VBox chartContainer;

  /**
   * The constructor.
   * 
   * @param lineChartType The line chart type to display
   */
  public ChartController(String lineChartType) {
    this.lineChartType = lineChartType;
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
    XYChart.Series<String, Number> series =
        lineChartType.equals("DEFAULT") ? getSeriesForDefaultLineChart()
            : getReducedSeriesLineChart();

    lineChart = new LineChart<>(xAxis, yAxis);
    lineChart.getData().add(series);
    lineChart.setLegendVisible(false);
    chartContainer.getChildren().add(lineChart);
    HBox.setHgrow(lineChart, Priority.ALWAYS);
    VBox.setVgrow(lineChart, Priority.ALWAYS);
  }

  /**
   * Gets the series for the default line chart.
   * 
   * @return The series
   */
  private XYChart.Series<String, Number> getSeriesForDefaultLineChart() {
    XYChart.Series<String, Number> series = new XYChart.Series<>();

    dataSetModel.getChartDataSet()
        .forEach((k, v) -> series.getData().add(new XYChart.Data<String, Number>(k, v)));

    return series;
  }

  /**
   * Gets the reduced series for the line chart.
   * 
   * @return The series
   */
  private XYChart.Series<String, Number> getReducedSeriesLineChart() {
    XYChart.Series<String, Number> series = new XYChart.Series<>();

    SeriesReducer reduced = new SeriesReducer();
    reduced.filter(dataSetModel.getChartDataSet())
        .forEach((k, v) -> series.getData().add(new XYChart.Data<String, Number>(k, v)));

    return series;
  }

}
