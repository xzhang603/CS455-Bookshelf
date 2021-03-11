// Name: Xin Zhang
// USC NetID: xzhang55    ID:4998-6225-16
// CSCI455 PA2
// Spring 2021


/**
 * Class BookshelfKeeper 
 *
 * Enables users to perform efficient putPos or pickHeight operation on a bookshelf of books kept in 
 * non-decreasing order by height, with the restriction that single books can only be added 
 * or removed from one of the two *ends* of the bookshelf to complete a higher level pick or put 
 * operation.  Pick or put operations are performed with minimum number of such adds or removes.
 */
import java.lang.Integer;
import java.util.ArrayList;

public class BookshelfKeeper {

    /**
      Representation invariant:
      All the books must have height larger than 0, and smaller than Integer.MAX_Value.
      The arraylist should not be null.
      The BookshelfKeeper arraylist should be sorted with increasing order.
      <put rep. invar. comment here>

   */
   
   // <add instance variables here>
   private Bookshelf Books; 
   private int numsOp_total = 0;
   private int numsOp_cur = 0;
   
   /**
    * Creates a BookShelfKeeper object with an empty bookshelf
    */
   public BookshelfKeeper() {
      Books = new Bookshelf();
      assert isValidBookshelfKeeper();
   }

   /**
    * Creates a BookshelfKeeper object initialized with the given sorted bookshelf.
    * Note: method does not make a defensive copy of the bookshelf.
    *
    * PRE: sortedBookshelf.isSorted() is true.
    */
   public BookshelfKeeper(Bookshelf sortedBookshelf) {
      Books = sortedBookshelf;
      assert isValidBookshelfKeeper();
   }

   /**
    * Removes a book from the specified position in the bookshelf and keeps bookshelf sorted 
    * after picking up the book.
    * 
    * Returns the number of calls to mutators on the contained bookshelf used to complete this
    * operation. This must be the minimum number to complete the operation.
    * 
    * PRE: position must be in the range [0, getNumBooks()).
    */
   public int pickPos(int position) {
      int len = Books.size();
      Bookshelf Load_Books = new Bookshelf();             //For Loading the book that we will put back after pick
      int numsOp_pre = numsOp_total;                      //Load previous total operation, and get last operations by new total operations - previous total operations
      int pick;//the height of we pick's
      if (position>=(len-1)/2.0){                         //Find out left or right has less operations (this if statement is remove book from right will has less operations)
         for(int i=len-1; i>position; i--){               //Load book that before the position we are going to put
            int cur_book = Books.removeLast();
            Load_Books.addFront(cur_book);
            numsOp_total += 1;}  
         pick = Books.removeLast();                        //Pick book by position
         numsOp_total += 1;
         while(Load_Books.size()>0){                       //Put back books we loaded
            int cur_book = Load_Books.removeFront();
            Books.addLast(cur_book);
            numsOp_total += 1;}}
      else{                                                //(this if statement is remove book from left will has less operations)
         for(int i=0;i<position;i++){                      //Load book that before the position we are going to put
            int cur_book = Books.removeFront();
            Load_Books.addFront(cur_book);
            numsOp_total += 1;}     
         pick = Books.removeFront();                       //Pick book by position
         numsOp_total += 1;
         while(Load_Books.size()>0){                       //Put back books we loaded
            int cur_book = Load_Books.removeFront();
            Books.addFront(cur_book);
            numsOp_total += 1;}}
      numsOp_cur = numsOp_total - numsOp_pre;
      assert isValidBookshelfKeeper();
      return pick;  
   }

   /**
    * Inserts book with specified height into the shelf.  Keeps the contained bookshelf sorted 
    * after the insertion.
    * 
    * Returns the number of calls to mutators on the contained bookshelf used to complete this
    * operation. This must be the minimum number to complete the operation.
    * 
    * PRE: height > 0
    */
   public int putHeight(int height) {
      int len = Books.size();
      int numsOp_pre = numsOp_total;                      //Load previous total operation, and get last operations by new total operations - previous total operations
      if (len>0){
         int mid = Books.getHeight(len/2);                //Find the book height in the middle. If the nums of book is even, it will get the left middle height
         Bookshelf Load_Books = new Bookshelf();
         if (mid!=height){
            put_action(Load_Books, len, height, mid, height);}
   //extra credit
         else{
            extra_part(Load_Books,len,height);}           
      }
      else{
         Books.addFront(height);
         numsOp_total += 1;
      }  
      numsOp_cur = numsOp_total - numsOp_pre;
      assert isValidBookshelfKeeper();
      return 0;   
   }

   /**
    * Returns the total number of calls made to mutators on the contained bookshelf
    * so far, i.e., all the ones done to perform all of the pick and put operations
    * that have been requested up to now.
    */
   public int getTotalOperations() {
      assert isValidBookshelfKeeper();
      return numsOp_total;   
   }

   /**
    * Returns the number of books on the contained bookshelf.
    */
   public int getNumBooks() {
      int nums = Books.size();
      assert isValidBookshelfKeeper();
      return nums;   // dummy code to get stub to compile
   }

   /**
    * Returns string representation of this BookshelfKeeper. Returns a String containing height
    * of all books present in the bookshelf in the order they are on the bookshelf, followed 
    * by the number of bookshelf mutator calls made to perform the last pick or put operation, 
    * followed by the total number of such calls made since we created this BookshelfKeeper.
    * 
    * Example return string showing required format: “[1, 3, 5, 7, 33] 4 10”
    * 
    */
   public String toString() {
      int len = Books.size();
      String str = "[";
      for (int i=0; i<len; i++){
         int cur = Books.getHeight(i);
         str += cur;
         if (i<len-1){
            str += ", ";}
      }
      str += "] " + numsOp_cur + " " + numsOp_total;
      assert isValidBookshelfKeeper();
      return str;   
   }

   /**
    * Returns true iff the BookshelfKeeper data is in a valid state.
    * (See representation invariant comment for details.)
    */
   private boolean isValidBookshelfKeeper() {
      int len = Books.size();
      if (Books==null){
         return false;
      }
      if (Books.isSorted()==false){
         return false;
      }
      for (int i=0;i<len;i++){
         if ((Books.getHeight(i)<=0) || (Books.getHeight(i)>Integer.MAX_VALUE)){
            return false;
         }
      }
      return true;  
   }

   // add any other private methods here
   
   
   /**
    * Extra credit part(only care about put action), if the height is equal to the middle book in bookshelf,
    * We need to find out from left would operate less or right
    * And I did this by from left, if the book height not equal to the one I put, i++(Right++).
    * from right, if the book height not equal to the one I put, j--(ref_Left++).
    * This will easily find the smallest operation from left or right.
    */
   private void extra_part(Bookshelf Load_Books, int len, int height){
      int Right = 0;
      int Left = len-1;
      int ref_Left = 0;
      while (Books.getHeight(Right)!=height){
         Right++;}
      while (Books.getHeight(Left)!=height){
         Left--;
         ref_Left++;}
      put_action(Load_Books, len, height, ref_Left, Right);
   }
   
   /**
    * Put Aaction function is based on the int L and R to verify we gonna put the book from left or from right.
    * If L<=R, we put from left (i=0, i++). Else, we put from right(i=book.length-1,i--).
    */
   private void put_action(Bookshelf Load_Books, int len, int height, int L, int R){
      if (L<=R){
         int j = len-1;
         while(Books.getHeight(j)>height){                  //Load book that before the position we are going to put
            int cur_book = Books.removeLast();
            Load_Books.addFront(cur_book);
            numsOp_total += 1;
            j--;}
         Books.addLast(height);                             //Put height of book
         numsOp_total += 1;
         while(Load_Books.size()>0){                        //Put back books we loaded
            int cur_book = Load_Books.removeFront();
            Books.addLast(cur_book);
            numsOp_total += 1;}
      }
      else{
         while(Books.getHeight(0)<height){                  //Load book that before the position we are going to put
            int cur_book = Books.removeFront();
            Load_Books.addFront(cur_book);
            numsOp_total += 1;}
         Books.addFront(height);                            //Put height of book
         numsOp_total += 1;
         while(Load_Books.size()>0){                        //Put back books we loaded
            int cur_book = Load_Books.removeFront();
            Books.addFront(cur_book);
            numsOp_total += 1;}
      }
   }
   
   
   
}
