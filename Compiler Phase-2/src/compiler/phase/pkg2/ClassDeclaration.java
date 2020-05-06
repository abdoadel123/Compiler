package compiler.phase.pkg2;

import java.util.ArrayList;

public class ClassDeclaration implements Node{
    
    
    Identifier identifier;
    VarDeclaration vardeclaration;
    ConstructorDeclaration constructordeclaration ;
    MethodDeclaration methoddeclaration ;
    
    /*ClassDeclaration()
    {
        identifier=new Identifier();
        vardeclaration=new VarDeclaration();
        constructordeclaration=new ConstructorDeclaration();
        methoddeclaration=new MethodDeclaration();
    }*/
    
    @Override
    public int parser(ArrayList<Token>tokens , int[] index)
    {
        /* ClassDeclaration ::= "class" Identifier ( "extends" Identifier )? "{" ( VarDeclaration )* (
                 ConstructorDeclaration )* ( MethodDeclaration )* "}"
        */
        identifier=new Identifier();
        vardeclaration=new VarDeclaration();
        constructordeclaration=new ConstructorDeclaration();
        methoddeclaration=new MethodDeclaration();
       if(tokens.get(index[0]).type.equals("CLASS"))
       {
           pretty_print(tokens.get(index[0]));
           index[0]=index[0]+1;
       }
       else
       {
           return 0;
       }
       if(identifier.parser(tokens, index) == -1)
       {
           return -1;
       }
       if(tokens.get(index[0]).type.equals("EXTENDS"))
       {
           pretty_print(tokens.get(index[0]));
           index[0]=index[0]+1;
           if(identifier.parser(tokens, index) == -1)
           {
              return -1;
           }
       }
       if(tokens.get(index[0]).type.equals("LEFT_CURLY_B"))
       {
           pretty_print(tokens.get(index[0]));
           index[0]=index[0]+1;
       }
       else
       {
           return -1;
       }
       //// 3 whiles 
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
       ///////////////////////////////////////
       result=constructordeclaration.parser(tokens, index);
       if(result == -1)
       {
           return -1;
       }
       else
       {
           while((result !=0) && (result != -1) )
           {
               result=constructordeclaration.parser(tokens, index);
           }
           if(result == -1)
           {
               return -1;
           }
       }
       /////////////////////////////////////////////////////////////
       result=methoddeclaration.parser(tokens, index);
       if(result == -1)
       {
           return -1;
       }
       else
       {
           while((result !=0) && (result != -1) )
           {
               result=methoddeclaration.parser(tokens, index);
           }
           if(result == -1)
           {
               return -1;
           }
       }
       //////////////////////////////////////////////////////////////////////////
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