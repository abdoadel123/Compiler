package compiler.phase.pkg2;

import java.util.ArrayList;

public class U_ARR implements Node{
    Expression expression ;

    /*public U_ARR() {
        expression=new Expression();
    }*/
    
    @Override
    public int parser(ArrayList<Token>tokens , int[] index)
    {
        expression=new Expression();
        if(tokens.get(index[0]).type.equals("LEFT_SQUARE_B"))
        {
            pretty_print(tokens.get(index[0]));
            index[0]=index[0]+1;
        }
        else
        {
            return 1;
        }
        if(expression.parser(tokens, index) == -1)
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
