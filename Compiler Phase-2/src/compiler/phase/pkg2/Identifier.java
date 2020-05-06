package compiler.phase.pkg2;

import java.util.ArrayList;

public class Identifier implements Node{
    @Override
    public int parser(ArrayList<Token>tokens , int[] index)
    {
        if(tokens.get(index[0]).type.equals("ID"))
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
    public void pretty_print(Token t) 
    {
        System.out.print(t.value+" ");
        if(t.value.equals("{"))
            System.out.println("\n");
        
        if(t.value.equals("}")||t.value.equals(";"))
            System.out.println();
    }
}
