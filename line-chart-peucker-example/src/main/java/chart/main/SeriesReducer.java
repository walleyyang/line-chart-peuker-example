package chart.main;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * Uses the Douglas Peucker algorithm for reducing the series.
 * Reference: https://rosettacode.org/wiki/Ramer-Douglas-Peucker_line_simplification#Java
 */
public class SeriesReducer {

  private double epsilon;
  
  /**
   * Filters the series. This assumes the data set is a map that uses the keys for a line chart
   * category axis and uses the values for a line chart number axis.
   * 
   * @param chartDataSet The map containing the chart data set
   */
  public Map<String, Integer> filter(Map<String, Integer> chartDataSet) {
    List<Entry<String, Integer>> dataSet = new ArrayList<>(chartDataSet.entrySet());
    List<Entry<String, Integer>> pointListOut = new ArrayList<>();
    reduce(dataSet, pointListOut);
    
    Map<String, Integer> reducedSeriesMap = new TreeMap<>();
    pointListOut.forEach(entry -> reducedSeriesMap.put(entry.getKey(), entry.getValue()));
    
    DecimalFormat numberFormat = new DecimalFormat("#.00");
    int pointListOutSize = pointListOut.size();
    String percentage =
        numberFormat.format((1 - ((double) pointListOutSize / (double) dataSet.size())) * 100);
    String reducedByMessage = pointListOutSize + " (" + percentage + "%)";
    AppViewModel.getInstance().setReducedByMessage((reducedByMessage));
    
    return reducedSeriesMap;
  }

  /**
   * Gets the perpendicular distance.
   * 
   * @param line The line object with the data
   * @return The perpendicular distance
   */
  private double getPerpendicularDistance(Line line) {
    double dx = line.getLineEndX() - line.getLineStartX();
    double dy = line.getLineEnd().getValue() - line.getLineStart().getValue();

    double mag = Math.hypot(dx, dy);
    if (mag > 0.0) {
        dx /= mag;
        dy /= mag;
    }
    double pvx = line.getPointX() - line.getLineStartX();
    double pvy = line.getPoint().getValue() - line.getLineStart().getValue();

    double pvdot = dx * pvx + dy * pvy;
    double ax = pvx - pvdot * dx;
    double ay = pvy - pvdot * dy;

    return Math.hypot(ax, ay);
  }

  /**
   * Reduces the number of points.
   */
  private void reduce(List<Entry<String, Integer>> pointList, List<Entry<String, Integer>> listOut) {
    int startIndex = 0;
    int endIndex = pointList.size() - 1;
    int index = 0;
    double maxDistance = 0;
    
    for (int i = startIndex + 1; i < endIndex; i++) {
      Line line = new Line.Builder()
          .setPoint(pointList.get(i))
          .setLineStart(pointList.get(startIndex))
          .setLineEnd(pointList.get(endIndex))
          .setPointX(i)
          .setLineStartX(startIndex)
          .setLineEndX(endIndex)
          .build();

      double distance = getPerpendicularDistance(line);

      if (distance > maxDistance) {
        index = i;
        maxDistance = distance;
      }
    }
    
    if (maxDistance > epsilon) {
      List<Entry<String, Integer>> result1 = new ArrayList<>();
      List<Entry<String, Integer>> result2 = new ArrayList<>();
      List<Entry<String, Integer>> firstLine = pointList.subList(startIndex, index + 1);
      List<Entry<String, Integer>> lastLine = pointList.subList(index, pointList.size());
      reduce(firstLine, result1);
      reduce(lastLine, result2);
      
      List<Entry<String, Integer>> result = new ArrayList<>(result1.size() + result2.size());
      result.addAll(result1);
      result.addAll(result2);
      
      listOut.addAll(result1.subList(startIndex, result1.size() - 1));
      listOut.addAll(result2);
    } else {
      listOut.clear();
      listOut.add(pointList.get(startIndex));
      listOut.add(pointList.get(pointList.size() - 1));
    }
  }

  /**
   * Sets the threshold epsilon.
   * 
   * @param epsilon The margin for the curve
   */
  public void setEpsilon(double epsilon) {
    this.epsilon = epsilon;
  }

}
