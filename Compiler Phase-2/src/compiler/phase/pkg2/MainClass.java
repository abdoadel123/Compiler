package compiler.phase.pkg2;

import java.util.ArrayList;

public class MainClass implements Node{
    Identifier identifier;
    Statement statement;
    
    /*MainClass()
    {
        identifier=new Identifier();
        statement=new Statement();
    }*/
    @Override
    public int parser(ArrayList<Token>tokens , int[] index)
    {
        identifier=new Identifier();
        statement=new Statement();
        /* MainClass ::= "class" Identifier "{" "public" "static" "void" "main" "(" "String" "["
                    "]" Identifier ")" "{" Statement "}" "}"
      */
       if(tokens.get(index[0]).type.equals("CLASS"))
       {
           pretty_print(tokens.get(index[0]));
           index[0]=index[0]+1;
       }
       else
       {
           return -1;
       }
       if(identifier.parser(tokens, index) == -1)
       {
           return -1;
       }
       if(tokens.get(index[0]).type.equals("LEFT_CURLY_B"))
       {
           pretty_print(tokens.get(index[0]));
           index[0]=index[0]+1;
       }
       else
       {
           return -1;
       }
       if(tokens.get(index[0]).type.equals("PUBLIC"))
       {
           pretty_print(tokens.get(index[0]));
           index[0]=index[0]+1;
       }
       else
       {
           return -1;
       }
       if(tokens.get(index[0]).type.equals("STATIC"))
       {
           pretty_print(tokens.get(index[0]));
           index[0]=index[0]+1;
       }
       else
       {
           return -1;
       }
       if(tokens.get(index[0]).type.equals("VOID"))
       {
           pretty_print(tokens.get(index[0]));
           index[0]=index[0]+1;
       }
       else
       {
           return -1;
       }
       if(tokens.get(index[0]).type.equals("MAIN"))
       {
           pretty_print(tokens.get(index[0]));
           index[0]=index[0]+1;
       }
       else
       {
           return -1;
       }
       if(tokens.get(index[0]).type.equals("LEFT_ROUND_B"))
       {
           pretty_print(tokens.get(index[0]));
           index[0]=index[0]+1;
       }
       else
       {
           return -1;
       }
       if(tokens.get(index[0]).type.equals("STRING"))
       {
           pretty_print(tokens.get(index[0]));
           index[0]=index[0]+1;
       }
       else
       {
           return -1;
       }
       if(tokens.get(index[0]).type.equals("LEFT_SQUARE_B"))
       {
           pretty_print(tokens.get(index[0]));
           index[0]=index[0]+1;
       }
       else
       {
           return -1;
       }
       if(tokens.get(index[0]).type.equals("RIGHT_SQUARE_B"))
       {
           pretty_print(tokens.get(index[0]));
           index[0]=index[0]+1;
       }
       else
       {
           return -1;
       }
       if(identifier.parser(tokens, index) == -1)
       {
           return -1;
       }
       if(tokens.get(index[0]).type.equals("RIGHT_ROUND_B"))
       {
           pretty_print(tokens.get(index[0]));
           index[0]=index[0]+1;
       }
       else
       {
           return -1;
       }
       if(tokens.get(index[0]).type.equals("LEFT_CURLY_B"))
       {
           pretty_print(tokens.get(index[0]));
           index[0]=index[0]+1;
       }
       else
       {
           return -1;
       }
       int result=statement.parser(tokens, index);
       if(result == -1)
       {
           return -1;
       }
       else
       {
           while((result !=0) && (result != -1) )
           {
               result=statement.parser(tokens, index);
           }
           if(result == -1)
           {
               return -1;
           }
       }
       if(tokens.get(index[0]).type.equals("RIGHT_CURLY_B"))
       {
           pretty_print(tokens.get(index[0]));
           index[0]=index[0]+1;
       }
       else
       {

           return -1;
       }
       if(tokens.get(index[0]).type.equals("RIGHT_CURLY_B"))
       {
           pretty_print(tokens.get(index[0]));
           index[0]=index[0]+1;
       }
       else
       {
           return -1;
       }
       return 1;
    }
    @Override
    public void pretty_print(Token t) 
    {
        System.out.print(t.value+" ");
        if(t.value.equals("{"))
            System.out.println("\n");
        
        if(t.value.equals("}")||t.value.equals(";"))
            System.out.println();
    }
}
