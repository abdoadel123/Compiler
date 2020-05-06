package compiler.phase.pkg2;

import java.util.ArrayList;

public class Expression implements Node{
    Expression_2 expression_2 ;
    Identifier identifier ;
    NewExpression newExpression;

    /*public Expression() 
    {
        expression_2=new Expression_2();
        identifier=new Identifier();
        b_new=new B_NEW();
        a_ex=new A_EX();
    }*/
    
    @Override
    public int parser(ArrayList<Token>tokens , int[] index)
    {
        expression_2=new Expression_2();
        identifier=new Identifier();
        newExpression=new NewExpression();
        if( (tokens.get(index[0]).type.equals("STRING_LITERAL"))  ||(tokens.get(index[0]).type.equals("INTEGRAL_LITERAL"))  || (tokens.get(index[0]).type.equals("FLOAT_LITERAL")) || (tokens.get(index[0]).type.equals("TRUE")) || (tokens.get(index[0]).type.equals("FALSE")) || (tokens.get(index[0]).type.equals("THIS"))  )
        {
            pretty_print(tokens.get(index[0]));
            index[0]=index[0]+1;
            if(expression_2.parser(tokens,index )== -1)
            {
                return -1 ;
            }
        }
        else if(identifier.parser(tokens, index)==1)
        {
            if(expression_2.parser(tokens, index)==-1)
            {
                return -1;
            }
        }
        else if(tokens.get(index[0]).type.equals("NEW"))
        {
            pretty_print(tokens.get(index[0]));
            index[0]=index[0]+1;
            if(newExpression.parser(tokens, index)==-1)
            {
                return -1;
            }
            if(expression_2.parser(tokens, index)==-1)
            {
                return -1;
            }
        }
        else if(tokens.get(index[0]).type.equals("LEFT_ROUND_B"))
        {
            pretty_print(tokens.get(index[0]));
            index[0]=index[0]+1;
            if(this.parser(tokens, index)==-1)
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
            if(expression_2.parser(tokens, index)==-1)
            {
                return -1;
            }
        }
        else if(tokens.get(index[0]).type.equals("NOT"))
        {
            pretty_print(tokens.get(index[0]));
            index[0]=index[0]+1;
            if(this.parser(tokens, index)==-1)
            {
                return -1;
            }
            if(expression_2.parser(tokens, index)==-1)
            {
                return -1;
            }
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
