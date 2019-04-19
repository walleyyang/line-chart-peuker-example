package chart.main;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

/**
 * The ChartController.
 */
public class ChartController {

  @FXML private VBox chartContainer;
  
  public ChartController(String lineChartType)
  {
    System.out.println(lineChartType);
  }
  
}
