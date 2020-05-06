package compiler.phase.pkg2;

import java.util.ArrayList;

public interface Node {
    
    public int parser(ArrayList<Token>tokens , int[] index);
    public void pretty_print(Token t );
    
}