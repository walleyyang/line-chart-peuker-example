package chart.main;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/**
 * The DataSetModel.
 */
public class DataSetModel {

  private static DataSetModel instance = null;
  private Map<String, Integer> chartDataSet;
  private Random random;

  /**
   * The constructor.
   */
  private DataSetModel() {
    random = new Random();
  }

  /**
   * Gets the DataSetModel instance.
   * 
   * @return The DataSetModel instance
   */
  public static DataSetModel getInstance() {
    if (instance == null) {
      instance = new DataSetModel();
    }

    return instance;
  }

  /**
   * Creates the data set for the chart series.
   * 
   * @param numberOfMarkers The number of markers to create
   */
  public void createDataSet(int numberOfMarkers) {
    Instant instant = Instant.now();
    int range = 10;
    int offset = 1;

    chartDataSet = new TreeMap<>();
    
    for (int i = 0; i < numberOfMarkers; i++) {
      // A little bit realistic
      int value = i % 5 == 0 ? random.nextInt(range) + offset : 5;
      chartDataSet.put(instant.minus(i, ChronoUnit.HOURS).toString(), value);
    }
  }

  /**
   * Gets the chartDataSet.
   * 
   * @return The chartDataSet
   */
  public Map<String, Integer> getChartDataSet() {
    return chartDataSet;
  }

}
