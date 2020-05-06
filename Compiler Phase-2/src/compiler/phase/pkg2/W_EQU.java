package compiler.phase.pkg2;

import java.util.ArrayList;

public class W_EQU implements Node{
    U_ARR u_arr ;
    Expression expression;

    /*W_EQU() {
        u_arr=new U_ARR();
        expression=new Expression();
    }*/
    
    @Override
    public int parser(ArrayList<Token>tokens , int[] index)
    {
        u_arr=new U_ARR();
        expression=new Expression();
        if(u_arr.parser(tokens, index) == -1)
        {
            return -1;
        }
        if(tokens.get(index[0]).type.equals("ASSIGNMENT"))
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
        if(tokens.get(index[0]).type.equals("SEMICOLON"))
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
