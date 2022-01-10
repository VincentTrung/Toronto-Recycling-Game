package myPackage.superpackage;

public class Post extends Threads{
  private String name;
  private String thePost;
  private Date date = new Date(); //create association 

  /**
  *This is the first constructor to create the starting values
  *using the deafult values constants
  *
  *no parameters or return
  */////////////////////////////////
  public Post(){
    super();
    name = "Anonymous";
  }

  /**
  *This is the second constructor to create the starting values
  *using the deafult values constants
  *
  *@param name String value for the name
  *no return
  */////////////////////////////////
  public Post(String threadName){
    super(threadName);
    name = "Anonymous";
  }


  /**
  *This sets the name of the person
  *
  *@param newName String of new name to change to 
  *no return
  */////////////////////////////////
  public void addPost(String addPost){
    thePost = "\n"+name + "             Posted on: " + date + "\n------------------------------------------------\n" + addPost;
  }

  /**
  *This sets the name of the person
  *
  *@param newName String of new name to change to 
  *no return
  */////////////////////////////////
  public String getPost(){
    return thePost;
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
    return thePost; //add something about verbal abuse
  }

}