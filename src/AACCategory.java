import structures.AssociativeArray;
import structures.NullKeyException;

/**
 * A basic implementation of AACCategory that stores a string category and a new
 * associative array.
 * 
 * @author Alyssa Trapp
 */

public class AACCategory {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The size of the associative array (the number of key/value pairs).
   */
  int size;

  /**
   * The category that represents the area in which all of the objects are stored
   */
  String category;

  /**
   * The associative array that represents the array of the arrays of key values
   * and pairs
   */
  AssociativeArray<String, String> arr;

  // +--------+------------------------------------------------------
  // | Constructors|
  // +--------+----

  /**
   * The constructor for AACCategory
   */
  public AACCategory(String category) {
    this.category = category;
    this.arr = new AssociativeArray<String, String>();
  } // AACCategory (String)

  // +------------------+--------------------------------------------
  // | Standard Methods |
  // +------------------+

  /**
   * Adds an item to the AACCategory array by mapping the image location to the
   * text of the category
   */
  public void addItem(String image, String text) throws NullKeyException {
    arr.set(image, text);
  } // addItem (String, String)

  /**
   * Returns the name of the category
   */
  public String getCategory() {
    if (category == null) {
      return null;
    } // if
    return category;
  } // getCategory()

  /**
   * Returns an array of image locations which represents where the images are
   * stored at
   */
  public String[] getImages() {
    return arr.getAllKeys();
  } // getImages()

  /**
   * Returns the text associated with the image location in the category
   */

  public String getText(String image) {
    try {
      return arr.get(image);
    } catch (Exception e) {
      return "CONFUSION!";
    } // catch
  } // getText (String)

  /**
   * Determines if image is in the current category
   */
  public boolean hasImage(String image) {
    return arr.hasKey(image);
  } // hasImage(String)
} // class AACCategory
