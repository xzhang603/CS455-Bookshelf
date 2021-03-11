// Name: Xin Zhang
// USC NetID: xzhang55    ID:4998-6225-16
// CSCI455 PA2
// Spring 2021

import java.lang.Integer;
import java.util.ArrayList;
import java.util.Scanner;

public class BookshelfKeeperProg
{
   public static void main(String[] args)   {
      // Read first line of books and load into bookshelf and bookshelf keeper
      System.out.println("Please enter initial arrangement of books followed by newline:");
      Scanner in = new Scanner(System.in);
      Bookshelf Books = new Bookshelf();
      String Books_str = in.nextLine();//Load first Line
      Scanner First_Line = new Scanner(Books_str);
      //Load value into Bookshelf
      while (First_Line.hasNextInt()){
         int value = First_Line.nextInt();
         if (value<=0){
            System.out.println("ERROR: Height of a book must be positive.");
            System.out.println("Exiting Program.");
            return;
         }
         Books.addLast(value);
      }
      //Error Check      
      if (Books.isSorted()==false){
         System.out.println("ERROR: Heights must be specified in non-decreasing order.");
         System.out.println("Exiting Program.");
         return;
      }
      BookshelfKeeper Books_Keeper = new BookshelfKeeper(Books);//Load bookshelf into BookshelfKeeper
      System.out.println(Books_Keeper.toString());
      System.out.println("Type pick <index> or put <height> followed by newline. Type end to exit.");
      //Read next Line of pick, put or end      
      Action(in, Books_Keeper);
   }
   
   
   

//If a line begin with pick String, then the program will run this function
   public static int pick_act(String next, BookshelfKeeper Books_Keeper){
      int len = Books_Keeper.getNumBooks();
      int c = next.lastIndexOf("pick")+4; //collect Integer after pick String, c is the begining of the first index after pick
      String next_int_str = next.substring(c,next.length());
      
      Scanner next_int_sca = new Scanner(next_int_str);
      int next_int = next_int_sca.nextInt(); 
      //Error Check
      if ((next_int<0)||(next_int>len-1)){
         System.out.println("ERROR: Entered pick operation is invalid on this shelf.");
         System.out.println("Exiting Program.");
         return 0;
      }
      Books_Keeper.pickPos(next_int);
      System.out.println(Books_Keeper.toString());
      return 1;
   }
   
   
//If a line begin with put String, then the program will run this function  
   public static int put_act(String next, BookshelfKeeper Books_Keeper){
      int c = next.lastIndexOf("put")+3;//collect Integer after put String, c is the begining of the first index after pick
      String next_int_str = next.substring(c,next.length());
      Scanner next_int_sca = new Scanner(next_int_str);
      int next_int = next_int_sca.nextInt();
      //Error Check
      if (next_int<=0){
         System.out.println("ERROR: Height of a book must be positive.");
         System.out.println("Exiting Program.");
         return 0;
      }
      Books_Keeper.putHeight(next_int);
      System.out.println(Books_Keeper.toString());
      return 1;
   }
   
   
//This function is to Read line after first line, and verify the first letter shows in line.
   public static void Action(Scanner in, BookshelfKeeper Books_Keeper){
      while(in.hasNextLine()){
         String next = in.nextLine();
         Scanner next_scanner = new Scanner(next);
         //Run put function here
         if (next_scanner.hasNext("put")==true){
            int ref = put_act(next, Books_Keeper);
            if (ref==0){//Error Check find out there is error, return
               return;
            }
         }
         //Run pick function here
         else if (next_scanner.hasNext("pick")==true){
            int ref = pick_act(next, Books_Keeper);
            if (ref==0){//Error Check find out there is error, return
               return;
            }
         }
         //Find end, return and exit program
         else if (next_scanner.hasNext("end")==true){
            System.out.println("Exiting Program.");
            return;
         }
         //Error Check, found wrong command         
         else{
            System.out.println("ERROR: Operation should be either pick or put.");
            System.out.println("Exiting Program.");
            return;
         }
      } 
   }

   
}
