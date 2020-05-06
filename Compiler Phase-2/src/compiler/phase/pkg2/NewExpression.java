package compiler.phase.pkg2;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amira
 */
public class NewExpression implements Node
{
    ExpArr exparr ;
    FunctionCall functioncall;
    @Override
    public int parser(ArrayList<Token>tokens , int[] index)
    {
       exparr=new ExpArr();
       functioncall=new FunctionCall();
       if((tokens.get(index[0]).type.equals("INT")) || (tokens.get(index[0]).type.equals("FLOAT")) || (tokens.get(index[0]).type.equals("STRING")) || (tokens.get(index[0]).type.equals("CHARACTER")) || (tokens.get(index[0]).type.equals("BOOLEAN")) )
       {
           pretty_print(tokens.get(index[0]));
           index[0]=index[0]+1;
           if(exparr.parser(tokens, index)==-1)
           {
               return -1;
           }
           return 1;
       }
       else if(functioncall.parser(tokens, index) == 1)
       {
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
