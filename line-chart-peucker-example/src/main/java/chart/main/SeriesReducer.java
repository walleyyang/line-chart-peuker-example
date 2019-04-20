package chart.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * Uses the Douglas Peucker algorithm for reducing the series.
 */
public class SeriesReducer {

  private double epsilon;

  /**
   * The constructor.
   */
  public SeriesReducer() {
    // TODO: Remove
    epsilon = 0.0;
  }

  /**
   * Filters the series. This assumes the data set is a map that uses the keys for a line chart
   * category axis and uses the values for a line chart number axis.
   * 
   * @param chartDataSet The map containing the chart data set
   */
  public Map<String, Integer> filter(Map<String, Integer> chartDataSet) {
    List<Entry<String, Integer>> dataSet = new ArrayList<>(chartDataSet.entrySet());
    int startIndex = 0;
    int endIndex = dataSet.size() - 1;

    List<Entry<String, Integer>> reducedSeriesList = reduce(dataSet, startIndex, endIndex);
    Map<String, Integer> reducedSeriesMap = new TreeMap<>();
    reducedSeriesList.forEach(entry -> reducedSeriesMap.put(entry.getKey(), entry.getValue()));
    
    return reducedSeriesMap;
  }

  /**
   * Gets the perpendicular distance.
   * 
   * @param pointsData The PointsData object with the data
   * @return The perpendicular distance
   */
  private double getPerpendicularDistance(PointsData pointsData) {
    double a = pointsData.getEndIndex() - pointsData.getStartIndex();
    double b = pointsData.getEndEntry().getValue() - pointsData.getStartEntry().getValue();
    double c = -(b * pointsData.getStartIndex() - a * pointsData.getStartEntry().getValue());
    double distance = Math.hypot(a, b);

    return Math.abs(b * pointsData.getEntryIndex() - a * pointsData.getEntry().getValue() + c)
        / distance;
  }

  /**
   * Reduces the number of points.
   */
  private List<Entry<String, Integer>> reduce(List<Entry<String, Integer>> chartDataSet,
      int startIndex, int endIndex) {
    double maxDistance = 0;
    int index = 0;

    for (int i = startIndex + 1; i < endIndex; i++) {
      PointsData pointsData = new PointsData.Builder()
          .setEntry(chartDataSet.get(i))
          .setStartEntry(chartDataSet.get(startIndex))
          .setEndEntry(chartDataSet.get(endIndex))
          .setEntryIndex(i)
          .setStartIndex(startIndex)
          .setEndIndex(endIndex)
          .build();

      double distance = getPerpendicularDistance(pointsData);

      if (distance > maxDistance) {
        index = i;
        maxDistance = distance;
      }
    }
    
    if (maxDistance > epsilon) {
      List<Entry<String, Integer>> reducedResult1 = reduce(chartDataSet, startIndex, index);
      List<Entry<String, Integer>> reducedResult2 = reduce(chartDataSet, index, endIndex);
      List<Entry<String, Integer>> result = new ArrayList<>(reducedResult1.size() + reducedResult2.size());
      result.addAll(reducedResult1);
      result.addAll(reducedResult2);
      
      return result;
    } else {
      List<Entry<String, Integer>> result = new ArrayList<>(endIndex - startIndex);
      result.addAll(chartDataSet.subList(startIndex + 1, endIndex));

      return result;
    }
  }

  /**
   * Sets the threshold epsilon.
   * 
   * @param epsilon The margin for the curve
   */
  public void setEpsilon(int epsilon) {
    this.epsilon = epsilon;
  }

}
