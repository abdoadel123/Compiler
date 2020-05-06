package compiler.phase.pkg2;

import java.util.ArrayList;

public class Z_ELSE implements Node{
    Statement statement ;
    @Override
    public int parser(ArrayList<Token>tokens , int[] index)
    {
        statement=new Statement();
        if(tokens.get(index[0]).type.equals("ELSE"))
        {
            pretty_print(tokens.get(index[0]));
            index[0]=index[0]+1;
            if( (statement.parser(tokens, index) == -1)   )
            {
               return -1;
            }
            else if((statement.parser(tokens, index)==0))
            {
                return 0 ;
            }
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
