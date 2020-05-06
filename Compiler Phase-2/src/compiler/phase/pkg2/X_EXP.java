package compiler.phase.pkg2;

import java.util.ArrayList;

public class X_EXP implements Node{
    Expression expression ;
    Y_STAT y_stat;

    /*X_EXP() {
        expression=new Expression();
        y_stat=new Y_STAT();
    }*/
    
    @Override
    public int parser(ArrayList<Token>tokens , int[] index)
    {
        expression=new Expression();
        y_stat=new Y_STAT();
        if(tokens.get(index[0]).type.equals("LEFT_ROUND_B"))
        {
            pretty_print(tokens.get(index[0]));
            index[0]=index[0]+1;
        }
        else
        {
            return -1;
        }
        if(expression.parser(tokens, index) == -1)
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
        if(y_stat.parser(tokens, index) == -1)
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
