package compiler.phase.pkg2;

import java.util.ArrayList;

public class Statement implements Node{
    
    Identifier identifier ;
    W_EQU w_equ;
    X_EXP x_exp;

    /*Statement() 
    {
        identifier=new Identifier();
        w_equ=new W_EQU();
        x_exp=new X_EXP();
    }*/
    
    @Override
    public int parser(ArrayList<Token>tokens , int[] index)
    {
        identifier=new Identifier();
        w_equ=new W_EQU();
        x_exp=new X_EXP();
        
        if(tokens.get(index[0]).type.equals("LEFT_CURLY_B"))
        {
            pretty_print(tokens.get(index[0]));
            index[0]=index[0]+1;
            int result=this.parser(tokens, index);
            if(result == -1)
            {
               return -1;
            }
            else
            {
               while((result !=0) && (result != -1) )
               {
                   result=this.parser(tokens, index);
               }
               if(result == -1)
               {
                   return -1;
               }
           }
           if(tokens.get(index[0]).type.equals("RIGHT_CURLY_B"))
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
        else if((tokens.get(index[0]).type.equals("IF") )||(tokens.get(index[0]).type.equals("WHILE") )|| (tokens.get(index[0]).type.equals("SYSTEM.OUT.PRINTLN")))
        {
            pretty_print(tokens.get(index[0]));
            index[0]=index[0]+1;
            if( x_exp.parser(tokens,index )== -1)
            {
               return -1;
            }
            else
            {
                return 1;
            }
        }
        else if(identifier.parser(tokens,index ) == 1)
        {
            if(w_equ.parser(tokens, index)==1)
            {
                return 1;
            }
            else
            {
                return -1;
            }
        }
        else
        {
            return 0;
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
