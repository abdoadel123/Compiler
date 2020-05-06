package compiler.phase.pkg2;

import java.util.ArrayList;

public class VarDeclaration implements Node{
    Type type ;
    Identifier identifier ;
    
    /*VarDeclaration()
    {
        type=new Type();
        identifier=new Identifier();
    }*/
    
    @Override
    public int parser(ArrayList<Token>tokens , int[] index)
    {
        type=new Type();
        identifier=new Identifier();
       if(type.parser(tokens, index) == -1)
       {
           return 0;
       }
       if(identifier.parser(tokens, index) == -1)
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
    public void pretty_print(Token t) 
    {
        System.out.print(t.value+" ");
        if(t.value.equals("{"))
            System.out.println("\n");
        
        if(t.value.equals("}")||t.value.equals(";"))
            System.out.println();
    }
}