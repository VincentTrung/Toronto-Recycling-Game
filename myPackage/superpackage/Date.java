package myPackage.superpackage;

public class Date{
  //set variables for Dates
  private int month;
  private int day;
  private int year;
  //default values
  private final int DEFAULT_DAY = 1;
  private final int DEFAULT_MONTH = 1;
  private final int DEFAULT_YEAR = 2020;
  //static variable to count the number of Dates created
  private static int numOfDates = 0;
  
  /**
  *This is the first constructor to create the starting values
  *using the deafult values constants
  *
  *no parameters or return
  */////////////////////////////////
  public Date(){
    month = DEFAULT_MONTH;
    day = DEFAULT_DAY;
    year = DEFAULT_YEAR;
  }

  /**
  *This is the second constructor to create the starting values
  *using given by the program or user
  *
  *@param month is in integer value representing the month
  *@param day is in integer value representing the day
  *@param year is in integer value representing the year
  *no return
  */////////////////////////////////
  public Date(int Month, int Day, int Year){
    month = Month;
    day = Day;
    year = Year;
  }

  /**
  *This is used to retrieve the month of the object
  *
  *return integer month
  */////////////////////////////////
  public int getMonth(){
    return month;
  } 

  /**
  *This is used to retrieve the day of the object
  *
  *return integer day 
  */////////////////////////////////
  public int getDay(){
    return day;
  }   

  /**
  *This is used to retrieve the year of the object
  *
  *return integer year 
  */////////////////////////////////
  public int getYear(){
    return year;
  }   


  /**
  *This is the method that will set the month if the value is within 1-12
  *
  *@param newMonth is the new integer value month will change to
  *no return
  */////////////////////////////////
  public void setMonth(int newMonth){
    numOfDates++;
    if (newMonth <=12 && newMonth >= 1){
      month = newMonth; 
    }else{
      System.out.println("Invalid month, now set to 1");
      month = DEFAULT_MONTH;    
    }
  }

  /**
  *This is the method that will set the day if correct according to the 
  *month and if it's a leap year
  *
  *@param newDay is the new integer value day will change to
  *no return
  */////////////////////////////////
  public void setDay(int newDay){
    numOfDates++;
    if (newDay >1){
      if (month ==2 && newDay ==29){
        if ((year%4==0 && year%100 != 0) || (year%400==0)){
          day = newDay;
        }else{
          System.out.println("Invalid day, now set to 1");
          day = DEFAULT_DAY;
        }
      }else if (month ==2 && newDay <29){
        day = newDay;
      }else if ((month ==4||month==6||month ==9||month==11)&& newDay<31){
        day = newDay;
      }else if (!(month==2||month ==4||month==6||month ==9||month==11)&&newDay <=31){
        day = newDay;
      }else{
        System.out.println("Invalid day, now set to 1");
        day = DEFAULT_DAY;
      }
    }
  }

  /**
  *This is the method that will set the year if it makes sense,
  *which will be when the year is positive
  *
  *@param newYear is the new integer value year will change to
  *no return
  */////////////////////////////////
  public void setYear(int newYear){
    numOfDates++;
    if (newYear >= 0){
      year = newYear;
    }else{
      System.out.println("Invalid year, now set to 2000");
      year = DEFAULT_YEAR;
    }
  }

  /**
  *This is the method that print out the details of this object 
  *in a understandable format for output
  *
  *no parameters
  *return a String which to be printed out
  */////////////////////////////////
  public String toString(){
    return ""+month+"/"+day+"/"+year;
  }

  /**
  *This is the method that will get the number of times the date has 
  *changed in this object and return that int value
  *
  *no parameters
  *return an integer value of how many times the date has changed
  */////////////////////////////////
  public int getNumOfDates(){
    return numOfDates;
  }
}