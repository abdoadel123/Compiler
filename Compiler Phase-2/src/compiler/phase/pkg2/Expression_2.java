package compiler.phase.pkg2;

import java.util.ArrayList;

public class Expression_2 implements Node{
    
    Operator operator;
    
    @Override
    public int parser(ArrayList<Token>tokens , int[] index)
    {
        operator=new Operator();
        if(operator.parser(tokens, index) == 1)
        {
            if(this.parser(tokens, index) == -1)
            {
                return -1;
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
