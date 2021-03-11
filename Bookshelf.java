// Name: Xin Zhang   
// USC NetID: xzhang55    ID:4998-6225-16 
// CSCI455 PA2
// Spring 2021


/**
 * Class Bookshelf
 * Implements idea of arranging books into a bookshelf.
 * Books on a bookshelf can only be accessed in a specific way so books don’t fall down;
 * You can add or remove a book only when it’s on one of the ends of the shelf.   
 * However, you can look at any book on a shelf by giving its location (starting at 0).
 * Books are identified only by their height; two books of the same height can be
 * thought of as two copies of the same book.
*/

import java.lang.Integer;
import java.util.ArrayList;


public class Bookshelf {

    /**
      Representation invariant:
      All the books must have height larger than 0, and smaller than Integer.MAX_Value.
      The arraylist should not be null
      
      <put rep. invar. comment here>

   */
   
   // <add instance variables here>


   /**
    * Creates an empty Bookshelf object i.e. with no books
    */
   
   private ArrayList<Integer> book; 
   private int Len_check;
   
   public Bookshelf() {
      book = new ArrayList<Integer>();
      assert isValidBookshelf();  // sample assert statement (you will be adding more of these calls)
   }

   /**
    * Creates a Bookshelf with the arrangement specified in pileOfBooks. Example
    * values: [20, 1, 9].
    * 
    * PRE: pileOfBooks contains an array list of 0 or more positive numbers
    * representing the height of each book.
    */
   public Bookshelf(ArrayList<Integer> pileOfBooks) {
      book = new ArrayList<Integer>(pileOfBooks);
      assert isValidBookshelf();
   }

   /**
    * Inserts book with specified height at the start of the Bookshelf, i.e., it
    * will end up at position 0.
    * 
    * PRE: height > 0 (height of book is always positive)
    */
   public void addFront(int height) {
      book.add(0,height);
      assert isValidBookshelf();
   }

   /**
    * Inserts book with specified height at the end of the Bookshelf.
    * 
    * PRE: height > 0 (height of book is always positive)
    */
   public void addLast(int height) {
      book.add(height);
      assert isValidBookshelf();
   }

   /**
    * Removes book at the start of the Bookshelf and returns the height of the
    * removed book.
    * 
    * PRE: this.size() > 0 i.e. can be called only on non-empty BookShelf
    */
   public int removeFront() {
      int remove_F = book.get(0);
      book.remove(0);
      assert isValidBookshelf();
      return remove_F;   // dummy code to get stub to compile
      
   }

   /**
    * Removes book at the end of the Bookshelf and returns the height of the
    * removed book.
    * 
    * PRE: this.size() > 0 i.e. can be called only on non-empty BookShelf
    */
   public int removeLast() {
      int len = book.size();
      int remove_L = book.get(len-1);
      book.remove(len-1);
      assert isValidBookshelf();
      return remove_L;   // dummy code to get stub to compile      
   }

   /*
    * Gets the height of the book at the given position.
    * 
    * PRE: 0 <= position < this.size()
    */
   public int getHeight(int position) {
      int height = book.get(position);
      assert isValidBookshelf();
      return height;   // dummy code to get stub to compile
      
   }

   /**
    * Returns number of books on the this Bookshelf.
    */
   public int size() {
      int s = book.size();
      assert isValidBookshelf();
      return s;   // dummy code to get stub to compile

   }

   /**
    * Returns string representation of this Bookshelf. Returns a string with the height of all
    * books on the bookshelf, in the order they are in on the bookshelf, using the format shown
    * by example here:  “[7, 33, 5, 4, 3]”
    */
   public String toString() {
      int len = book.size();
      String str = "[";
      for (int i=0; i<len; i++){
         int cur = book.get(i);
         str += cur;
         if (i<len-1){
            str += ", ";
         }
      }
      str += "]";
      return str;   // dummy code to get stub to compile

   }

   /**
    * Returns true iff the books on this Bookshelf are in non-decreasing order.
    * (Note: this is an accessor; it does not change the bookshelf.)
    */
   public boolean isSorted() {
      int len = book.size();
      for (int i=1;i<len;i++){
         if (book.get(i)<book.get(i-1)){
            return false;
         }
      }
      assert isValidBookshelf();
      return true;  // dummy code to get stub to compile
   }

   /**
    * Returns true iff the Bookshelf data is in a valid state.
    * (See representation invariant comment for more details.)
    */
   private boolean isValidBookshelf() {    
      int len = book.size();
      
      if (book==null){
         return false;
      }
      
      for (int i=0;i<len;i++){
         if ((book.get(i)<=0) || (book.get(i)>Integer.MAX_VALUE)){
            return false;
         }
      }
      
      
      return true;  // dummy code to get stub to compile

   }
   
   

}
