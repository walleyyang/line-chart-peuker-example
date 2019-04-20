package chart.main;

import java.util.Map.Entry;

/**
 * Contains the data for the points.
 */
public class PointsData {

  private Entry<String, Integer> entry;
  private Entry<String, Integer> startEntry;
  private Entry<String, Integer> endEntry;
  private int entryIndex;
  private int startIndex;
  private int endIndex;

  /**
   * The constructor.
   * 
   * @param builder The builder object
   */
  public PointsData(Builder builder) {
    this.entry = builder.entry;
    this.startEntry = builder.startEntry;
    this.endEntry = builder.endEntry;
    this.entryIndex = builder.entryIndex;
    this.startIndex = builder.startIndex;
    this.endIndex = builder.endIndex;
  }

  /**
   * Gets the entry.
   * 
   * @return The entry
   */
  public Entry<String, Integer> getEntry() {
    return entry;
  }

  /**
   * Gets the startEntry.
   * 
   * @return The startEntry
   */
  public Entry<String, Integer> getStartEntry() {
    return startEntry;
  }

  /**
   * Gets the endEntry.
   * 
   * @return The endEntry
   */
  public Entry<String, Integer> getEndEntry() {
    return endEntry;
  }

  /**
   * Gets the entryIndex.
   * 
   * @return The entryIndex
   */
  public int getEntryIndex() {
    return entryIndex;
  }
  
  /**
   * Gets the startIndex.
   * 
   * @return The startIndex
   */
  public int getStartIndex() {
    return startIndex;
  }

  /**
   * Gets the endIndex.
   * 
   * @return The endIndex
   */
  public int getEndIndex() {
    return endIndex;
  }

  /**
   * The builder.
   */
  public static class Builder {
    private Entry<String, Integer> entry;
    private Entry<String, Integer> startEntry;
    private Entry<String, Integer> endEntry;
    private int entryIndex;
    private int startIndex;
    private int endIndex;

    /**
     * Sets the entry.
     * 
     * @param entry The entry to set
     * @return The builder object
     */
    public Builder setEntry(Entry<String, Integer> entry) {
      this.entry = entry;
      return this;
    }

    /**
     * Sets the startEntry.
     * 
     * @param startEntry The startEntry to set
     * @return The builder object
     */
    public Builder setStartEntry(Entry<String, Integer> startEntry) {
      this.startEntry = startEntry;
      return this;
    }

    /**
     * Sets the endEntry.
     * 
     * @param endEntry The endEntry to set
     * @return The builder object
     */
    public Builder setEndEntry(Entry<String, Integer> endEntry) {
      this.endEntry = endEntry;
      return this;
    }

    /**
     * Sets the entryIndex.
     * 
     * @param entryIndex The index to set
     * @return The builder object
     */
    public Builder setEntryIndex(int entryIndex) {
      this.entryIndex = entryIndex;
      return this;
    }
    
    /**
     * Sets the startIndex.
     * 
     * @param startIndex The index to set
     * @return The builder object
     */
    public Builder setStartIndex(int startIndex) {
      this.startIndex = startIndex;
      return this;
    }

    /**
     * Sets the endIndex.
     * 
     * @param endIndex The index to set
     * @return The builder object
     */
    public Builder setEndIndex(int endIndex) {
      this.endIndex = endIndex;
      return this;
    }

    /**
     * Builds the new PointsData.
     * 
     * @return The new PointsData
     */
    public PointsData build() {
      return new PointsData(this);
    }
  }

}
