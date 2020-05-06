package compiler.phase.pkg2;

import java.util.ArrayList;

public class Operator implements Node{
    Expression expression ;
    ExpArr exparr;
    FunctionCall functioncall;
    
    @Override
    public int parser(ArrayList<Token>tokens , int[] index)
    {
        expression=new Expression();
        exparr=new ExpArr();
        functioncall=new FunctionCall();
        
        if((tokens.get(index[0]).value.equals("&&")) || ((tokens.get(index[0]).value.equals("||"))) || ((tokens.get(index[0]).value.equals("==")))
                || ((tokens.get(index[0]).value.equals("!="))) || ((tokens.get(index[0]).value.equals(">"))) || ((tokens.get(index[0]).value.equals("<")))
                || ((tokens.get(index[0]).value.equals("<="))) || ((tokens.get(index[0]).value.equals(">="))) || ((tokens.get(index[0]).value.equals("+")))
                || ((tokens.get(index[0]).value.equals("-"))) || ((tokens.get(index[0]).value.equals("/"))) || ((tokens.get(index[0]).value.equals("*")))
                || ((tokens.get(index[0]).value.equals("!"))))
        {
            pretty_print(tokens.get(index[0]));
            index[0] = index[0] + 1;
            if(expression.parser(tokens, index)==-1)
            {
                return -1;
            }
        }
        else if(exparr.parser(tokens, index) == 1)
        {
            return 1 ;
        }
        else if(tokens.get(index[0]).type.equals("DOT"))
        {
           pretty_print(tokens.get(index[0]));
           index[0]=index[0]+1;
           if(tokens.get(index[0]).type.equals("LENGTH"))
           {
              pretty_print(tokens.get(index[0]));
              index[0]=index[0]+1; 
           }
           else if(functioncall.parser(tokens, index)==-1)
           {
               
               return -1;
           }
           else
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
    public void pretty_print(Token t) {
        System.out.print(t.value+" ");
if(t.value.equals("{"))
            System.out.println("\n");
        
        if(t.value.equals("}")||t.value.equals(";"))
            System.out.println();
    }
}
