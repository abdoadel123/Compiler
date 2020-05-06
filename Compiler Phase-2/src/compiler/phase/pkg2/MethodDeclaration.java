package compiler.phase.pkg2;

import java.util.ArrayList;

public class MethodDeclaration implements Node{
    
    Type type ;
    Identifier identifier;
    VarDeclaration vardeclaration;
    Statement statement;
    Expression expression ;
    
    @Override
    public int parser(ArrayList<Token>tokens , int[] index)
    {
        type=new Type();
        identifier=new Identifier();
        vardeclaration=new VarDeclaration();
        statement=new Statement();
        expression=new Expression();
        
        if(tokens.get(index[0]).type.equals("PUBLIC"))
        {
            pretty_print(tokens.get(index[0]));
            index[0]=index[0]+1;
        }
        else if(tokens.get(index[0]).type.equals("PRIVATE"))
        {
            pretty_print(tokens.get(index[0]));
            index[0]=index[0]+1;
        }
        else if(tokens.get(index[0]).type.equals("PROTECTED"))
        {
            pretty_print(tokens.get(index[0]));
            index[0]=index[0]+1;
        }
        else
        {
            return 0;
        }
        if(type.parser(tokens, index) == -1)
        {
            return -1 ;
        }
        if(identifier.parser(tokens, index) == -1)
        {
            return -1 ;
        }
        if(tokens.get(index[0]).type.equals("LEFT_ROUND_B"))
        {
            pretty_print(tokens.get(index[0]));
            index[0]=index[0]+1;
        }
        else
            return -1;
        if(type.parser(tokens, index)==1 )
        {
            if(identifier.parser(tokens, index)==-1)
            {
                return -1;
            }
            while(tokens.get(index[0]).type.equals("COMMA"))
            {
                pretty_print(tokens.get(index[0]));
                index[0]=index[0]+1;
                if(type.parser(tokens, index)== -1)
                {
                    return -1;
                }
                if(identifier.parser(tokens, index)== -1)
                {
                    return -1;
                }
            }
        }
        if(tokens.get(index[0]).type.equals("RIGHT_ROUND_B"))
        {
            pretty_print(tokens.get(index[0]));
            index[0]=index[0]+1;
        }
        else
            return -1;
        ///////////////////////////////////////////////////////////
        if(tokens.get(index[0]).type.equals("LEFT_CURLY_B"))
       {
           pretty_print(tokens.get(index[0]));
           index[0]=index[0]+1;
       }
       else
       {
           return -1;
       }
       //////////////// 2 whiles 
       
       int result=vardeclaration.parser(tokens, index);
       if(result == -1)
       {
           return -1;
       }
       else
       {
           while((result !=0) && (result != -1) )
           {
               result=vardeclaration.parser(tokens, index);
           }
           if(result == -1)
           {
               return -1;
           }
       }
       result=statement.parser(tokens, index);
       if(result == -1)
       {
           return -1;
       }
       else
       {
           while((result !=0) && (result != -1) )
           {
               result=statement.parser(tokens, index);
           }
           if(result == -1)
           {
               return -1;
           }
       }
       
       ///////////////////////
       if(tokens.get(index[0]).type.equals("RETURN"))
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
       if(tokens.get(index[0]).type.equals("RIGHT_CURLY_B"))
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
