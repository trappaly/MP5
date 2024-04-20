import structures.AssociativeArray;
import structures.NullKeyException;
import structures.KeyNotFoundException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.Scanner;
//import java.util.Comparator;

/**
 * Mappings of AACCategory
 * @author Alyssa Trapp
 */

public class AACMappings {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The original category.
  */

 AACCategory ogCategory;

  /**
   * The current category
  */
  AACCategory curCategory;

 /**
   * The associative array storing the categories
  */
  AssociativeArray <String, AACCategory> categories;

  /**
   * The constructors for AACMappings
   */

  public AACMappings(String filename) {
    try {
    // sets the original category to an empty string
    ogCategory = new AACCategory("");
    // sets current category to the original categories
    curCategory = ogCategory;
    // stores a new associative array consisting of a string and a category
    this.categories = new AssociativeArray<String, AACCategory>();
    // sets curCategory
    categories.set ("", curCategory);
    // scans in the file 
      Scanner scanner = new Scanner(new File (filename));
      // loops over the file when there is writting on the line
    while (scanner.hasNext()){
      // sets one line to temp 
      String temp = scanner.nextLine();
      // splits the array into two parts
      String[] arr = temp.split(" ", 2);
      // if there is no caret, this means it's a category
      if (temp.charAt(0) != '>'){
        // creates a new category 
        this.curCategory = new AACCategory(arr[1]);
        // adds to the original category
        categories.set(arr[0],curCategory);
        ogCategory.addItem(arr[0], arr[1]);
      } // if
      // otherwise it means it's a value inside of a category
      else {
                // adds item to the current category 
        arr[0] =arr[0].substring(1);
        curCategory.addItem(arr[0], arr[1]);
      } // else
    } // while 
  // closes the scanner
  scanner.close();
  // sets it back to the home category 
  reset();
  // catches exceptions
 } catch (NullKeyException e){
 }
 catch (FileNotFoundException e){
}
 } // AACMappings (String)


  // +--------+------------------------------------------------------
  // | Methods |
  // +--------+

  /**
   * Adds the location of the image and the text to the current category
   */

  void add (String image, String text) {
    try {
      // if curCategory is null, create a new category
    if (this.curCategory == null) {
      this.categories.set(image, new AACCategory(text));
    } // if
    // otherwise add item to the category
    else {
      curCategory.addItem(image, text);
    } // else
  } catch (NullKeyException e){
    e.printStackTrace();
    } // catch
  } // add (String, String)

  /**
   * Returns the current category
   */
  String getCurrentCategory (){
    // if curCategory is null, return null
    if (curCategory == null){
      return null;
    } // if
    // otherwise get the current category
    return curCategory.getCategory();
  } // getCurrentCategory()

  /**
   * Returns the array of image locations in the current category
   */
  String[] getImageLocs() {
    // if current category is not equal to null, return the array of images at the current category
    if (curCategory != null) {
      return curCategory.getImages();
    } // if
    return null;
} // getImageLocs()

  /**
   * Determines the text associated with the image location given
   */

  String getText(String image) {
    // checks if the image is a category
      if (isCategory(image)){
        try{
    this.curCategory = categories.get(image);
    return this.curCategory.getCategory();
      }catch (KeyNotFoundException e){
      } // catch
    } // if
        return curCategory.getText(image);
      } // getText (String)
  


  /**
   * Determines if the image is in a category
   */
  boolean isCategory (String image) {
    return categories.hasKey(image);
  } // isCategory (String)


  /**
   * Resets the screen to the home screen
   */
  void reset(){
    curCategory = ogCategory;
  } // reset()


  /**
   * Writes the ACC mappings stored to a file 
   */

   public void writeToFile (String filename){
    try {
    // creates a pen to print out the file
    PrintWriter pen = new PrintWriter (new FileWriter(filename));
    // loops over the indivdiual categories 
    for (String imageLoc: categories.getAllKeys()){
      // gets the array of image locations at the current category 
      AACCategory category = categories.get(imageLoc);
      // prints the current category 
      pen.println (imageLoc + " " + category.getCategory());
    // loops over the array within a specific category
    for (String image : category.getImages()){
      // if the category is not equal to the original category, then print the image
          if (category != ogCategory){
        pen.println(">" + image + " " + category.getText(image));
       } // if 
      } // for
    } // for
    // closes the pen
    pen.close();
  } catch (IOException e){
  } // catch
  catch (KeyNotFoundException e){
  } // catch 
   } // writeToFile (String)
} // AACMappings class 

