package compiler.phase.pkg2;

import java.util.ArrayList;

public class Type implements Node{
    SQB sqb;

    /*Type() 
    {
        sqb=new SQB();
    }*/
    
    @Override
    public int parser(ArrayList<Token>tokens , int[] index)
    {
        sqb=new SQB();
        // Type ::= ("int" "|"float"|"String"|"char"|"boolean")SQB
        if(tokens.get(index[0]).type.equals("INT"))
        {
           pretty_print(tokens.get(index[0]));
           index[0]=index[0]+1;
        }
        else if(tokens.get(index[0]).type.equals("FLOAT"))
        {
           pretty_print(tokens.get(index[0]));
           index[0]=index[0]+1; 
        }
        else if(tokens.get(index[0]).type.equals("STRING"))
        {
           pretty_print(tokens.get(index[0]));
           index[0]=index[0]+1;
        }
        else if(tokens.get(index[0]).type.equals("CHARACTER"))
        {
            pretty_print(tokens.get(index[0]));
           index[0]=index[0]+1;
        }
        else if(tokens.get(index[0]).type.equals("BOOLEAN"))
        {
           pretty_print(tokens.get(index[0]));
           index[0]=index[0]+1;
        }
        else
        {
            return -1;
        }
        if(sqb.parser(tokens, index) == -1)
        {
           return -1;
        }
        return 1;
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
