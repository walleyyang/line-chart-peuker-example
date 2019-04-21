package chart.main;

import java.util.Map.Entry;

/**
 * Contains the data for the line.
 */
public class Line {

  private Entry<String, Integer> point;
  private Entry<String, Integer> lineStart;
  private Entry<String, Integer> lineEnd;
  private int pointX;
  private int lineStartX;
  private int lineEndX;

  /**
   * The constructor.
   * 
   * @param builder The builder object
   */
  public Line(Builder builder) {
    this.point = builder.point;
    this.lineStart = builder.lineStart;
    this.lineEnd = builder.lineEnd;
    this.pointX = builder.pointX;
    this.lineStartX = builder.lineStartX;
    this.lineEndX = builder.lineEndX;
  }

  /**
   * Gets the point.
   * 
   * @return The point
   */
  public Entry<String, Integer> getPoint() {
    return point;
  }

  /**
   * Gets the lineStart.
   * 
   * @return The lineStart
   */
  public Entry<String, Integer> getLineStart() {
    return lineStart;
  }

  /**
   * Gets the lineEnd.
   * 
   * @return The lineEnd
   */
  public Entry<String, Integer> getLineEnd() {
    return lineEnd;
  }

  /**
   * Gets the pointX.
   * 
   * @return The pointX
   */
  public int getPointX() {
    return pointX;
  }

  /**
   * Gets the lineStartX.
   * 
   * @return The lineStartX
   */
  public int getLineStartX() {
    return lineStartX;
  }

  /**
   * Gets the lineEndX.
   * 
   * @return The lineEndX
   */
  public int getLineEndX() {
    return lineEndX;
  }

  /**
   * The builder.
   */
  public static class Builder {
    private Entry<String, Integer> point;
    private Entry<String, Integer> lineStart;
    private Entry<String, Integer> lineEnd;
    private int pointX;
    private int lineStartX;
    private int lineEndX;

    /**
     * Sets the point.
     * 
     * @param point The point to set
     * @return The builder object
     */
    public Builder setPoint(Entry<String, Integer> point) {
      this.point = point;
      return this;
    }

    /**
     * Sets the lineStart.
     * 
     * @param lineStart The lineStart to set
     * @return The builder object
     */
    public Builder setLineStart(Entry<String, Integer> lineStart) {
      this.lineStart = lineStart;
      return this;
    }

    /**
     * Sets the lineEnd.
     * 
     * @param lineEnd The lineEnd to set
     * @return The builder object
     */
    public Builder setLineEnd(Entry<String, Integer> lineEnd) {
      this.lineEnd = lineEnd;
      return this;
    }

    /**
     * Sets the pointX.
     * 
     * @param pointX The pointX
     * @return The builder object
     */
    public Builder setPointX(int pointX) {
      this.pointX = pointX;
      return this;
    }

    /**
     * Sets the lineStartX.
     * 
     * @param lineStartX The index to set
     * @return The builder object
     */
    public Builder setLineStartX(int lineStartX) {
      this.lineStartX = lineStartX;
      return this;
    }

    /**
     * Sets the lineEndX.
     * 
     * @param lineEndX The index to set
     * @return The builder object
     */
    public Builder setLineEndX(int lineEndX) {
      this.lineEndX = lineEndX;
      return this;
    }

    /**
     * Builds the new line.
     * 
     * @return The new line
     */
    public Line build() {
      return new Line(this);
    }
  }

}
