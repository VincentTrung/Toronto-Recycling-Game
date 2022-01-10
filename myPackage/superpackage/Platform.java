package myPackage.superpackage;

public class Platform {
  private String name;
  //private Date date = new date(); //create association //maybe add date last

  /**
  *This is the first constructor to create the starting values
  *using the deafult values constants
  *
  *no parameters or return
  */////////////////////////////////
  public Platform(){
    name = "Racism Stories";
  }
  
  /**
  *This is the second constructor to create the starting values
  *using the deafult values constants
  *
  *@param name String value for the name
  *no return
  */////////////////////////////////
  public Platform(String name){
    this.name = name;
  }

  /**
  *This collects the name of the person
  *
  *no parameters 
  *return name String
  */////////////////////////////////
  public String getName(){
    return name;
  }

  /**
  *This sets the name of the person
  *
  *@param newName String of new name to change to 
  *no return
  */////////////////////////////////
  public void setName(String newName){
    name = newName;
  }

  /**
  *This is to output the name in nice
  *
  *@no param
  *return String to be outputted
  */////////////////////////////////  
  public String toString(){
    return "                    "+name + "\nWe strive to bring awareness of racism situtation in our society.";
  }
}