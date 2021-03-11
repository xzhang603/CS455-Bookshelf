import java.lang.Integer;
import java.util.ArrayList;


public class BookshelfTester
{
   public static void main(String[] args)   {
//Exercise 2 
      System.out.println("Exercise 2");
      Bookshelf Books_Empty = new Bookshelf();
      System.out.println("-----Created a empty bookshelf. Expect:[]-----");
      System.out.println("Expect result: []");
      System.out.println("Return result: "  +  Books_Empty.toString());
      System.out.println();
      
      
      
      ArrayList<Integer> nums = new ArrayList<Integer>();
      for (int i=0; i<3; i++){
         nums.add(i*2+1);  //Add height 1, 3, 5
      }
      Bookshelf Books = new Bookshelf(nums);
      System.out.println("-----Created a bookshelf with book height (1,3,5).-----");
      System.out.println("Expect result: [1, 3, 5]");
      System.out.println("Return result: "  +  Books.toString());
      System.out.println();
      System.out.println();
      
//Exercise 3
      System.out.println("Exercise 3");
      System.out.println("-----Add a book with height 6 in front of the bookshelf with (1,3,5).-----");
      System.out.println("Expect result: [6, 1, 3, 5]");
      Books.addFront(6);
      System.out.println("Return result: "  +  Books.toString());
      System.out.println();
      
      System.out.println("-----Add a book with height 8 in the end of the bookshelf with (6,1,3,5).-----");
      System.out.println("Expect result: [6, 1, 3, 5, 8]");
      Books.addLast(8);
      System.out.println("Return result: "  +  Books.toString());
      System.out.println();
      
      System.out.println("-----Remove a book with height 6(first book) in the Front of the bookshelf with (6,1,3,5,8).-----");
      System.out.println("Expect result: [1, 3, 5, 8]");
      int Remove_1 = Books.removeFront();
      System.out.println("Return result: "  +  Books.toString());
      System.out.println();
      
      System.out.println("-----Remove a book with height 8(last book) in the end of the bookshelf with (1,3,5,8).-----");
      System.out.println("Expect result: [1, 3, 5]");
      int Remove_2 = Books.removeLast();
      System.out.println("Return result: "  +  Books.toString());
      System.out.println();
      System.out.println();
      
//Exercise 4
      System.out.println("Exercise 4");
      System.out.println("-----Get position 2 of bookshelf with (1,3,5).-----");
      System.out.println("Expect result: 5");
      System.out.println("Return result: "  +  Books.getHeight(2));
      System.out.println();
      
      System.out.println("-----Get size of bookshelf with (1,3,5).-----");
      System.out.println("Expect result: 3");
      int s = Books.size();
      System.out.println("Return result: "  +  s);
      System.out.println();
      
      System.out.println("-----Does the bookshelf with (1,3,5) is sorted.-----");
      System.out.println("Expect result: true");
      System.out.println("Return result: "  +  Books.isSorted());
      System.out.println();
      
      Books.addLast(1);
      System.out.println("-----Does the bookshelf with (1,3,5,1) is sorted.-----");
      System.out.println("Expect result: false");
      System.out.println("Return result: "  +  Books.isSorted());
      System.out.println();
      
      System.out.println("Return result: "  +  Books_Empty.isSorted());
      
      
      
      int[] a = new int[10];
      System.out.println(a.length);

   }
}
