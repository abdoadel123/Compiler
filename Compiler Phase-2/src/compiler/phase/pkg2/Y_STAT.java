package compiler.phase.pkg2;

import java.util.ArrayList;

public class Y_STAT implements Node{
    Statement statement ;
    Z_ELSE z_else;

    /*Y_STAT() 
    {
        statement=new Statement();
        z_else=new Z_ELSE();
    }*/
    
    @Override
    public int parser(ArrayList<Token>tokens , int[] index)
    {
        statement=new Statement();
        z_else=new Z_ELSE();
        if(statement.parser(tokens, index) ==1)
        {
            if(z_else.parser(tokens, index) == -1)
            {
               return -1;
            }
            return 1;
        }
        else if(tokens.get(index[0]).type.equals("SEMICOLON"))
        {
            pretty_print(tokens.get(index[0]));
            index[0]=index[0]+1;
            return 1;
        }
        else
        {
            return -1;
        }
    }
    @Override
    public void pretty_print(Token t) {
        System.out.print(t.value+" ");
      if(t.value.equals("{"))
            System.out.println("\n");
        
        if(t.value.equals("}")||t.value.equals(";"))
            System.out.println();
    }
}
