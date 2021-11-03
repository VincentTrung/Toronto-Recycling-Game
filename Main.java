//ICS4U 
//Mr.Loo
//
//Programming Challange #2
//Text-based Responsible Recycling Sim
//Created by Vincent Trung
///////////////////////////////////////
import java.util.Scanner;// input
import java.io.*; //for files
import java.io.PrintWriter; // Import the FileWriter class
import java.io.IOException; // Import the IOException class to handle errors


/**
*Main is a class which hosts the necessary methods to run the game
*created for ICS4U Assignment #2
*@author Vincent Trung 
*/////////////////////////////////
class Main {
  //create Global variables
  private static final String bins [] = {"compost", "recycle", "garbage","other"};
  private static String displayChoice="";
  
  /**
  *This is a method simplfies the process when I want to clear the screen
  *it becomes so much shorter and easy to remember
  *
  *no return or param needed
  */////////////////////////////////
  public static void cls() {
    System.out.print("\033[H\033[2J"); //clears screen
  }

  
  /**
  *This is a method simplfies the process when I want to delay for
  *certain amount of seconds, it's shorter and easy to remember
  *
  *@param second is the amount of int seconds we want to delay for
  *no return needed
  */////////////////////////////////
  public static void delay(int second){
    try {
      Thread.sleep(second*1000); //convert into milliseconds 
    } catch (InterruptedException ie) {
      Thread.currentThread().interrupt();
    }
  }

  /**
  *This is an overloaded method of the one above, this will output 
  *the text you want, and delay for certain a certain amount of seconds,
  * followed with a "." every second
  *
  *@param message is the String message we want to output to the user
  *@param second is the amount of integer seconds we want to delay for
  *no return needed
  */////////////////////////////////
  public static void delay(String message,int second){
    System.out.print(message); //print text
    //loop for the amount of seconds and print "." in the meanwhile
    for (int i =0;i <second; i++){
      System.out.print("."); 
      delay(1);
    }
  }

  /**
  *This is a method which will create an array from what 
  *it reads in the csv file
  *
  *@param file is the file in a String we want to open and parse into an array
  *@return a 2D array of Strings generated from the rows/coloumns from the CSV
  */////////////////////////////////
  public static String[][] readArray(String file) throws IOException{
    try{
			// reading from a file
			BufferedReader infile = new BufferedReader (new FileReader(file));
      
      String line = infile.readLine();//similar to scanners input.nextLine()
      int lineNum =0; //keep track of row

      //check how many elements to size the array until reachs the end
      while (line !=null){
        line =infile.readLine(); // move to next line
        lineNum++; //count
      }

      int size = lineNum;//save size for creating array later


      //second read through//
			// reading from a file second time
			BufferedReader infile2 = new BufferedReader (new FileReader(file));
      lineNum=0; //reset for reading
      line = infile2.readLine();//similar to scanners input.nextLine()

      String items[] = line.split(","); //split at comma for index
      String data[][] = new String [size][items.length]; //declare array and size

      //check aslong as its not the end of file
      while (line !=null){
          items = line.split(",");  //split at comma in csv
          
          //store the values into the array 
          for (int i =0; i <items.length;i++){
            data[lineNum][i]=items[i];
          }

          line =infile2.readLine(); // move to next line
          lineNum++; //next row #
      }
      infile.close();
      return data;//return the complete array

    }catch (FileNotFoundException e){
			System.out.println("Incorrect filename or location. Please verify path and filename. ");
			System.out.println("In Eclipse, data files must be placed directly in the root of the project folder.");
    }
    return null; //handle errors of not returning
  }

  /**
  *This is a method that will record the name and score into a csv file
  *
  *@param file is the file we want to write to
  *@param name is the name associated with the score, to be saved in file
  *@param score is the value associated with the name, to be saved in file
  *no return 
  */////////////////////////////////
  public static void addScore(String file, String name,int score){
      //Try to write to file, true to not overwrite data
      try {
        FileWriter writer = new FileWriter(file,true);
        //write the information into the file and append to next line
        writer.write("\n"+name +","+score);
        writer.close();//close the file
        //To catch any errors
        }catch (IOException e) {
        }
    }

  /**
  *This is a method that will sort the scores into the top 3 for a leaderboard
  *returning the third highest value
  *
  *@param scores is a 2d array of Strings which have names/scores 
  *@param print is a boolean that will determine whether to print a leaderboard
  *@return int of the third highest value on the leaderboard 
  */////////////////////////////////
  public static int scoreboard(String scores[][], boolean print){
    //assuming integer elements in the array and set the values to zero
    int max1,max2,max3;
    max1=max2=max3 = 0;  
    int index1,index2,index3;
    index1=index2=index3 = 0;

    //loop through all the score value
    for (int i = 0; i < scores.length; i++){
      //change indexes and value if theres a new max
      if (Integer.parseInt(scores[i][1]) >max1){
        max3 = max2; 
        max2 = max1; 
        max1 = Integer.parseInt(scores[i][1]);
        index3=index2;
        index2=index1;
        index1=i;
      //change indexs and values below second max
      }else if (Integer.parseInt(scores[i][1])>max2){
        max3 = max2; 
        max2 = Integer.parseInt(scores[i][1]);
        index3=index2;
        index2=i;
      //change third index and value 
      }else if (Integer.parseInt(scores[i][1])>max3){
        max3 = Integer.parseInt(scores[i][1]);
        index3=i;
      }
    }

    //display the output if true
    if (print){
      System.out.println("");
      System.out.println("-----------");
      System.out.println("HIGHSCORES");
      System.out.println("-----------");
      System.out.printf("%5s",scores[index1][0]+": ");
      System.out.printf("%2s\n",scores[index1][1]);
      System.out.printf("%5s",scores[index2][0]+": ");
      System.out.printf("%2s\n",scores[index2][1]);
      System.out.printf("%5s",scores[index3][0]+": ");
      System.out.printf("%2s\n",scores[index3][1]);
      System.out.println("");
    }
    return max3;//highest score value to be on leaderboard
  }


  /**
  *This is a method that be the first major block of code mainly just
  *for the title screen introduction before the real game starts
  *
  *@param bins[] is a String array used to output to the user the options 
  *@return a boolean of whether or not they would like to continue the game
  */////////////////////////////////
  public static boolean start() {
    Scanner input = new Scanner(System.in);
    //set default value as true
    boolean play = true;

    while (true) {
      cls();

      //output the starting information and objective
      System.out.printf("%50s \n\n", "Sustainability Post-Consumption");
      System.out.print("Objective: Organize the items that will be provided, into the correct bin. \n( ");
      //output the different bin options
      for (int i =0;i<bins.length;i++){
        System.out.print(bins[i]+" ");
      }
      System.out.println(")\n");
      System.out.println("This is based off of the collection restrictions in the city of Toronto according to the offical website.\n");
      System.out.print("To start, type \"play\" or \"skip\" to skip: ");
      String start = input.nextLine();
      //use input to determine whether it's correct, and whether they want to skip or play
      if (start.equals("play")) {
            return play;// return true if they got out of loop

      } else if (start.equals("skip")) {
        return false; //return false and exit method
      }
    }
  }


  /**
  *This is a method is the main part of the program where it loops 
  *through all the items in the csv file and turns it into a game 
  *as long as one of the parameter is true
  *
  *@param items[][] is the 2d array of Strings with the items that will be the questions asked in the game to be matched to the correct bin.
  *@param running boolean will determine whether to skip this method(quit game)
  *@return the int score accumulated during the game
  */////////////////////////////////
  public static int game(String items[][], boolean running){
    //exit with value 0 if false(skip)
    if (!running){
      return 0;
    }
    
    Scanner input = new Scanner(System.in);//for inputs
    int score = 0; //intialize score

    //game loops through all the items in csv file
    for (int i =1; i<items.length;i++){
      cls();
      System.out.println(" ");
      System.out.println("Score: " + score); //output score
      System.out.println(" "); //ask question
      System.out.println("What number bin does "+items[i][0]+" belong to?");
      System.out.print(displayChoice); //display choices

      //collect input index and adjust for program
      int in = input.nextInt()-1;
      //reset and redo the loop if input is out of bounds
      if (in>=bins.length||in<0){
        i-=1;
        continue;
      }else{
        //compare the input value with the value of the item to gain points 
        if (bins[in].equals(items[i][1])){
          score +=1; //gain point
          System.out.println("Correct");
        } else{
          System.out.println("Wrong");
        }
      }
      delay(1);//delay 1 second
    }
    return score;
  }


  /**
  *This is a method will be the end game information, and will ask the player 
  * whether to save their initals/data, reads/outputs the leaderboard scores
  *
  *@param score will take the players int score to save if the user wanted
  *@return true or false depending on if play wants to retry this game
  */////////////////////////////////
  public static boolean endDisplay(int score)throws IOException{
    Scanner input = new Scanner(System.in); //for inputs

    //read the saved scores and output them 
    String savedScores[][]=readArray("scores.csv");
    //let them know if they qualify to have their name on the leaderboard
    int highscore = scoreboard(savedScores,false);
    if (score>highscore){
      System.out.println("\nCongratulations! You made it on to the leaderboard  with a total score of "+score);
    }
    delay(1);

    //ask to whether to add score to file and their intials
    String name = "    ";
    while (name.length() > 3){
      if (score == 0){
         break; //if they didnt want to play
      }
      System.out.println("If you want to be included in the saved scores, type your intials up to 3 characters or \"NO\" to skip:");
      name=input.nextLine();
    }
    //check whether they don't want to save, otherwise add score to csv file
    if ((!name.equals("NO")||!name.equals("no"))&&score!=0){
     addScore("scores.csv",name,score);
    }

    delay("saving",3);//output saving
    cls();
    //finally display the updated leaderboard
    scoreboard(savedScores,true);

    //ask whether to quit
    System.out.print("\nIf you want to replay, press any button. Or type \"quit\" to exit the program: ");
    String replay = input.nextLine();
    //return whether they want to quit
    if (replay.equals("quit")){
      return false;
    }else{
      return true;
    }
  }

  /**
  *This is a method is where we run all the other methods and 
  *is the main part of the program
  *
  *@param args string array of command line arguments
  */////////////////////////////////
  public static void main(String[] args) throws IOException{
    boolean play=true;//set the loop

    while (play){
      //used for outputing the options and matching to the items 
      //display the different choices
      for (int i = 0; i < bins.length; i++) {
        displayChoice += (i+1) + ". " + bins[i] +"\n";
      }

      //transition
      cls();
      delay("Loading",3);

      //starting screen
      boolean running = start();
      String items[][] = readArray("items.csv");//create the items for game

      //transition
      cls();
      delay("Compiling data",5);

      //run the Game
      int score = game(items,running);
      cls();
      delay("Remember to check with your local municipal on what goes in what bin!",5);      
      
      play = endDisplay(score);//display end of game information

      cls();
      delay("Thanks for playing!",3);      
    }
    //direct to sources for Toronto
    cls();
    System.out.println("Still not sure where a certain item goes? Check out the following sources:\n");
    System.out.println("Recycling:");
    System.out.println("https://www.toronto.ca/services-payments/recycling-organics-garbage/houses/what-goes-in-my-blue-bin/\n");

    System.out.println("Compost:");
    System.out.println("https://www.toronto.ca/services-payments/recycling-organics-garbage/houses/what-goes-in-my-green-bin/\n");

    System.out.println("Garbage:");
    System.out.println("https://www.toronto.ca/services-payments/recycling-organics-garbage/houses/what-goes-in-my-garbage-bin/\n");

    System.out.println("Others:");
    System.out.println("https://www.toronto.ca/services-payments/recycling-organics-garbage/houses/\n");
  }
}