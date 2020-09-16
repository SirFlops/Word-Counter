import java.util.Scanner;

import javax.lang.model.util.ElementScanner6;
class Main {
  public static void main(String[] args) {
    //Scanner declaration
    Scanner scan = new Scanner(System.in);
    //Use Scanner to take input
    System.out.println("Enter your quote(must have less than 1000 unique words)");
    String quote = scan.nextLine();
    boolean run=true;
    int lastIndex=0;
    String curWord="";
    String wordList[] = new String[1000];
    int numList[] = new int[1000];
    int wordQuantity =0;
    char tempChar;
    for(int i=0; i<quote.length(); i++)
    {
      if(quote.charAt(i)==' ')
      {
        for(int j=lastIndex; j<i; j++)
        {
          tempChar=Character.toLowerCase(quote.charAt(j));
          if(tempChar!=',' && tempChar!='.' && tempChar!=':' && tempChar!=';' && tempChar!='(' && tempChar!=')'&& tempChar!='?'&& tempChar!='!')
          {
            curWord+=tempChar;
          }
        }
        for(int k=0; k<wordList.length; k++)
        {

          if(curWord.equals(wordList[k]))
          {
            numList[k]++;
            System.out.println("incremented (" + wordList[k]+") to: " + numList[k]);
            break;
          }
          else if(wordList[k]==null)
          {
            wordList[k]=curWord;
            numList[k]=1;
            break;
          }
        }
        curWord="";
        lastIndex=i+1;
        wordQuantity++;
      }
    }
    //Final Word case fix
    for(int j=lastIndex; j<quote.length(); j++)
    {
      tempChar=Character.toLowerCase(quote.charAt(j));
      if(tempChar!=',' && tempChar!='.' && tempChar!=':' && tempChar!=';' && tempChar!='(' && tempChar!=')'&& tempChar!='?'&& tempChar!='!')
      {
        curWord+=tempChar;
      }
    }
    for(int k=0; k<wordList.length; k++)
    {

      if(curWord.equals(wordList[k]))
      {
        numList[k]++;
        System.out.println("incremented (" + wordList[k]+") to: " + numList[k]);
        break;
      }
      else if(wordList[k]==null)
      {
        wordList[k]=curWord;
        numList[k]=1;
        break;
      }
    }
    wordQuantity++;
    //output
    for(int i=0; i<wordList.length; i++)
    {
      if(wordList[i]==null)
      {
        break;
      }
      else
      {
          System.out.println(wordList[i]+": "+numList[i]+" or "+((numList[i]*100.0)/wordQuantity)+"%");
      }
    }
  }
}