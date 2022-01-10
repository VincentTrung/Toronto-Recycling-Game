//ICS4U 
//Mr.Loo
//
//Final Summative Project
//Racial Bias In Society
//Created by Vincent Trung
///////////////////////////////////////
import java.util.Scanner;// input
import java.io.*; //for files
import java.io.IOException; // Import the IOException class to handle errors
import java.util.InputMismatchException;
import myPackage.superpackage.*;//import the classes


/**
*Main is a class which hosts the necessary methods to run the game
*created for ICS4U Final Project
*@author Vincent Trung 
*/////////////////////////////////
class Main {
  //create Global variables
  private static final String options [] = {"White", "Asian", "Black","Hispanic","Miscellaneous","Resources"};
  private static String choices[] ={"login", "post","exit"};
  private static String displayChoices="";
  private static String displayOptions="";
  
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
  public static String readArray(String file) throws IOException{
    writeFile(file);// incase it doens't exist
    //intialize
    BufferedReader br = new BufferedReader(new FileReader(file));
    String everything =""; //start th string

    try {
        StringBuilder sb = new StringBuilder(); //to make into string
        String line = br.readLine(); //read the line
        //loop through the file
        while (line != null) {
            sb.append(line); //append
            sb.append(System.lineSeparator());
            line = br.readLine();  //next line
        }
        everything += sb.toString();//add new text onto string
    } finally {
        br.close();//close the file
    }
    return everything;
  }

  /**
  *This is a method that will record the name and score(money left) into a csv file
  *
  *@param file is the file we want to write to
  *@param name is the name associated with the score, to be saved in file
  *@param score is the value associated with the name, to be saved in file
  *no return 
  */////////////////////////////////
  public static void writeFile(String file, String text){
      //Try to write to file, true to not overwrite data
      try {
        FileWriter writer = new FileWriter(file,true);
        //write the information into the file and append to next line
        writer.write("\n"+text);
        writer.close();//close the file
        //To catch any errors
        }catch (IOException e) {
          System.out.println(e);
      }
  }

  /**
  *This is a method that will record the name and score(money left) into a csv file
  *
  *@param file is the file we want to write to
  *@param name is the name associated with the score, to be saved in file
  *@param score is the value associated with the name, to be saved in file
  *no return 
  */////////////////////////////////
  public static void writeFile(String file){
      //Try to write to file, true to not overwrite data
      try {
        FileWriter writer = new FileWriter(file,true);
        //write create a file
        writer.close();//close the file
        //To catch any errors
        }catch (IOException e) {
          System.out.println(e);
      }
  }

  /**
  *This is a method that be the first major block of code mainly just
  *for the title screen introduction before the real game starts
  *
  *@param races[] is a String array used to output to the user the races 
  *@return a boolean of whether or not they would like to continue the game
  */////////////////////////////////
  public static boolean start() {
    Scanner input = new Scanner(System.in);
    //set default value as true
    boolean play = true;

    while (true) {
      cls();

      //output the starting information and objective
      System.out.printf("%50s \n\n", "Facing Racial Bias in Society");
      System.out.print("This is a learning tool to connect you to real world experiences of racism. These are the following groups that will be available \n( ");
      //output the different options
      for (int i =0;i<options.length-1;i++){
        System.out.print(options[i]+", ");
      }
      System.out.println(")\n");
      System.out.println("The data being used are stastics from the real world, from offical sources.\n");
      System.out.print("To start, type \"continue\" or \"skip\" to skip: ");
      String start = input.nextLine();
      //use input to determine whether it's correct, and whether they want to skip or play
      if (start.equalsIgnoreCase("continue")) {
            return play;// return true if they got out of loop

      } else if (start.equalsIgnoreCase("skip")) {
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
  // */////////////////////////////////
  // public static int game(String items[][], boolean running){
  
  //   }catch (InputMismatchException e){
  //     System.out.print("Invalid input, please try again.");
  //     i -= 1; //adjust the index to retry the question
  //     delay(1);
  //     input.next(); //continue to collect input
  //   }
  //   delay(1);//delay 1 second
  //   }
   
  //   return score;
  // }


  /**
  *This is a method will be the end game information, and will ask the player 
  * whether to save their initals/data, reads/outputs the leaderboard scores
  *
  *@param score will take the players int score to save if the user wanted
  *@return true or false depending on if play wants to retry this game
  */////////////////////////////////
  // public static boolean endDisplay(int score)throws IOException{
  //   Scanner input = new Scanner(System.in); //for inputs

  //   //read the saved scores and output them 
  //   String savedScores[][]=readArray("scores.csv");
  //   //let them know if they qualify to have their name on the leaderboard


  //   //ask whether to quit
  //   System.out.print("\nIf you want to replay, press any button. Or type \"quit\" to exit the program: ");
  //   String replay = input.nextLine();
  //   //return whether they want to quit
  //   if (replay.equalsIgnoreCase("quit")){
  //     return false;
  //   }else{
  //     return true;
  //   }
  // }

  /**
  *This is a method is where we run all the other methods and 
  *is the main part of the program
  *
  *@param args string array of command line arguments
  */////////////////////////////////
  public static void main(String[] args) throws IOException{
    boolean play=true;//set the loop


    //used for choosing threads 
    for (int i = 0; i < options.length; i++) {
      displayOptions += (i+1) + ". " + options[i] +"\n";
     }

    //  display the different choices
    for (int i = 0; i < choices.length; i++) {
      displayChoices += (i+1) + ". " + choices[i] +"\n";
     }

    while (play){
      Scanner input = new Scanner(System.in);
      //instantiate the social media platform
      Platform platform = new Platform();

      // //transition
      // cls();
      // delay("Loading",3);

      // //starting screen
      // boolean running = start();

      //loading page
      System.out.println(platform);
      delay(2);
      cls();
      boolean noTopic = true;
      String topic = "";
      while (noTopic){
        try{
          //ask for what thread to read
          System.out.println(displayOptions);//display choices
          System.out.print("Please type the thread you would want to read:");
          int topicNum = input.nextInt()-1;
          input.nextLine();//for phantom inputs


          cls();
          //reset and redo the loop if input is out of bounds
          if (topicNum>=options.length||topicNum<0){
            continue;
          }

          topic = options[topicNum];
          noTopic = false;

        //catch the error that may occur from invalid input
        }catch (InputMismatchException e){
          System.out.print("Invalid input, please try again.");
          delay(1);
          input.next(); //continue to collect input
        }
      }


      //create the objects 
      Threads thread = new Threads(topic);

      Post forum = new Post(topic);
      //ask for the todays date

      //update the posts from csv
      forum.addPost("story stuff experience");

      cls();

      boolean inThread = true;
      while (inThread){

      //enter game loop

        for (int i =0; i < choices.length;i++){//change while loop?
          try{
            cls();
            System.out.println(" ");
            System.out.println(thread);
            String oldForum = readArray(topic+"Thread.csv");//create the data for game

            //System.out.println(oldForum); //change soon as it only shows the recent forum
            //ask for the action   
            System.out.println("\n\n\nEnter the number of the action you want to do");
            System.out.println(displayChoices);//display choices

          

            //collect input index and adjust for program
            int in = input.nextInt()-1;
            input.nextLine();
            
            //reset and redo the loop if input is out of bounds
            if (in>=choices.length||in<0){
              i-=1; //set back the loop
              continue;
            }else{
              //compare the input value with the value of the item to gain points 
              if (choices[in].equalsIgnoreCase("login")){
                System.out.print("Please enter your username: ");
                String newName = input.nextLine();
                //ask for username
                forum.setName(newName);

              } else if (choices[in].equalsIgnoreCase("post")){
                cls();
                String words="";
                String enter;
                
                while(true){
                  System.out.println("Please type up your post and type \"post\" on a new line to finish, or type \"exit\" to exit:");
                  System.out.println(words);
                  enter = input.nextLine();  
                  if (enter.equalsIgnoreCase("post")){
                    break;
                  }else if(enter.equalsIgnoreCase("exit")){
                    break; 
                  }else{
                    words+=enter + "\n";
                    System.out.println(words);
                    cls();
                  }
                                  
                }
                if (!(enter.equalsIgnoreCase("exit"))){
                  forum.addPost(words);
                  writeFile(topic+"Thread.csv",forum.getPost());
                }

              } else if (choices[in].equalsIgnoreCase("exit")){
                inThread = false;// end the loop
                break;
              }
              
            }
        //catch the error that may occur from invalid input
        }catch (InputMismatchException e){
          System.out.print("Invalid input, please try again.");
          i -= 1; //adjust the index to retry the question
          delay(1);
          input.next(); //continue to collect input
        }
      }
    }
      //transition
      cls();
      delay("Fetching data",5);


      delay("Insert fact!",5);      
      cls(); 
      
      //play = endDisplay(score);//display end of game information
      //ask if they want to quit
  
      cls();
      delay("Thanks for playing!",3);      
    }

    //direct to sources 
    cls();
    
  }
}