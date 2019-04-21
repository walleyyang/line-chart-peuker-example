package chart.main;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AppViewModel {

  private static AppViewModel instance = null;
  private StringProperty reducedByMessage;

  /**
   * The constructor.
   */
  private AppViewModel() {
    reducedByMessage = new SimpleStringProperty();
  }

  /**
   * Gets the AppViewModel instance.
   * 
   * @return The AppViewModel instance
   */
  public static AppViewModel getInstance() {
    if (instance == null) {
      instance = new AppViewModel();
    }

    return instance;
  }

  /**
   * Gets the reducedByMessage.
   * 
   * @return The reducedByMessage
   */
  public StringProperty getReducedByMessage() {
    return reducedByMessage;
  }

  /**
   * Sets the reducedByMessage.
   * 
   * @param reducedByMessage The reducedByMessage
   */
  public void setReducedByMessage(String reducedByMessage) {
    this.reducedByMessage.setValue(reducedByMessage);
  }

}
