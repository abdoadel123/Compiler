package compiler.phase.pkg2;

import java.io.*;
import java.util.ArrayList;

public class CompilerPhase2 {
    
    public static ArrayList<Token> tokens = new ArrayList();
    public static int[] tokens_index =new int[1];
    public static Node root =new Goal();

    public static void readFile() throws FileNotFoundException, IOException 
    {
        FileReader fr = new FileReader("output8.txt");
        String line;
        String inp = "";
        BufferedReader bufRead = new BufferedReader(fr);
        line = bufRead.readLine();
        inp="";
        while (line != null) 
        {
            if(! line.equals(""))
            {
                inp+=line;
            }
            line = bufRead.readLine();
        }
        String []arr=inp.split("~");
        ArrayList<String[]> arr2=new ArrayList();
        for(int i=0;i<arr.length;i++){
            arr2.add(arr[i].split("@"));
        }
        for(int i=0;i<arr2.size();i++)
        {
            /*for(int j=0;j<2;j++)
            {
                System.out.println(arr2.get(i)[j]);
                //System.out.println("-------------------------------------------------------");
                
            }*/
            Token t=new Token();
            t.value=arr2.get(i)[0];
            t.type=arr2.get(i)[1];
            tokens.add(t);
        }
        /*for(int i =0 ;i<tokens.size();i++)
        {
            System.out.println(tokens.get(i).type);
            System.out.println(tokens.get(i).value);
        }*/

    }

    public static void main(String[] args) throws IOException 
    {
      readFile();
      tokens_index[0]=0;     // tokens.size();
      int result=root.parser(tokens,tokens_index );
      if(result==-1)
            System.out.println("Syntax Erorr");
    }
}
