import structures.AssociativeArray;
import structures.NullKeyException;
import structures.KeyNotFoundException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Mappings of AACCategory that map over AACCategory
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
    try{
    ogCategory = new AACCategory("");
    curCategory = ogCategory;
    this.categories = new AssociativeArray<String, AACCategory>();
    categories.set ("", curCategory);
      Scanner scanner = new Scanner(new File (filename));
    while (scanner.hasNext()){
      String temp = scanner.nextLine();
      String[] arr = temp.split(" ", 2);
      if (temp.charAt(0) != '>'){
        this.curCategory = new AACCategory(arr[1]);
        categories.set(arr[0],curCategory);
        ogCategory.addItem(arr[0], arr[1]);
      }
      else {
        arr[0] =arr[0].substring(1);
        curCategory.addItem(arr[0], arr[1]);
      }
    }
  scanner.close();
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
    if (this.curCategory == null) {
      this.categories.set(image, new AACCategory(text));
    }
    else {
      curCategory.addItem(image, text);
    }
  } catch (NullKeyException e){
    e.printStackTrace();
    }
  }

  /**
   * Returns the current category
   */
  String getCurrentCategory (){
    if (curCategory == null){
      return null;
    }
    return curCategory.getCategory();
  } // getCurrentCategory()

  /**
   * Returns the array of image locations in the current category
   */
  String[] getImageLocs() {
    if (curCategory != null) {
      return curCategory.getImages();
    }
    return null;
} // getImageLocs()

  /**
   * Determines the text associated with the image location given
   */

  String getText(String image) {
      if (isCategory(image)){
        try{
    this.curCategory = categories.get(image);
    return this.curCategory.getCategory();
      }catch (KeyNotFoundException e){
      }
    }
        return curCategory.getText(image);
      } // getText (String)
  


  /**
   * Determines if the image is in a category
   */
  boolean isCategory (String image) {
    return categories.hasKey(image);
  }


  /**
   * Resets the screen to the home screen
   */
  void reset(){
    curCategory = ogCategory;
  }


  /**
   * Writes the ACC mappings stored to a file 
   */
  
   void writeToFile (String filename){
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))){
    for (int i = 0; i < categories.size(); i++) {
      String category = categories.pairs[i].key;
    for (String location : this.categories.get(category).getImages()) {
      writer.write(location + this.categories.get(category).getText(location) + '\n');
    }
   }
   } catch (KeyNotFoundException e){
    e.printStackTrace();
    }
    catch (FileNotFoundException e){
      e.printStackTrace();
    }
    catch (IOException e){
      e.printStackTrace();
    }
  }
} // writeToFile(String)

