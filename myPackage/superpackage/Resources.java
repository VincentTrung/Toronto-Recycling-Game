package myPackage.superpackage;

public class Resources extends Threads{
  private String links;
  private String contacts;

  /**
  *This is the first constructor to create the starting values
  *using the deafult values constants
  *
  *no parameters or return
  */////////////////////////////////
  public Resources(){
    super();
  }
  
  /**
  *This is the second constructor to create the starting values
  *using the deafult values constants
  *
  *@param name String value for the name
  *no return
  */////////////////////////////////
  public Resources(String threadName){
    super(threadName);
  }

  /**
  *This collects the name of the person
  *
  *no parameters 
  *return name String
  */////////////////////////////////
  public String getLinks(){
    return links;
  }

  /**
  *This sets the name of the person
  *
  *@param newName String of new name to change to 
  *no return
  */////////////////////////////////
  public void setLinks(String newLinks){
    links = newLinks+"\n";
  }

  /**
  *This collects the name of the person
  *
  *no parameters 
  *return name String
  */////////////////////////////////
  public String getContacts(){
    return contacts;
  }

  /**
  *This sets the name of the person
  *
  *@param newName String of new name to change to 
  *no return
  */////////////////////////////////
  public void setContacts(String newContacts){
    contacts = newContacts+"\n";
  }

  /**
  *This is to output the name in nice
  *
  *@no param
  *return String to be outputted
  */////////////////////////////////  
  public String toString(){
    return "Here are some links:\n"+links+"\nHere are some contacts:\n"+contacts;
  }

}