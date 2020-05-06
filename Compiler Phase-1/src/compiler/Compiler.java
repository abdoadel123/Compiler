package compiler;

import java.util.ArrayList;
import java.util.regex.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Compiler {

    public static ArrayList<Token> re = new ArrayList();
    public static ArrayList<Matched> tok = new ArrayList();

    public static String ReadInp() throws FileNotFoundException, IOException {
        FileReader fr = new FileReader("input.txt");
        String line;
        String inp = "";
        BufferedReader bufRead = new BufferedReader(fr);
        line = bufRead.readLine();
        while (line != null) {
            if (line.equals("")) {
            } else {
                inp += line + "\n";
            }
            line = bufRead.readLine();
        }
        return inp;
    }

    public static boolean isID(String id) {
        String served[] = {"if", "int", "else", "main", "this", "true", "false", "void", "class", "while", "length", "public", "private", "protected", "return", "static", "new", "String", "float", "character", "extends", "null", "abstract", "assert", "break", "continue", "byte", "case", "catch", "const", "default", "do", "double", "enum", "final", "finally", "for", "goto", "implements", "import", "package", "instanceof", "interface", "short", "super", "switch", "throw", "try", "System", "out", "println"};
        for (int i = 0; i < served.length; i++) {
            if (id.equals(served[i])) {
                //System.out.println("ID = "+id+" SERV = "+served[i]);
                return false;
            }
        }
        return true;
    }

    public static void addRe(ArrayList<Token> re) {
        Token reg = new Token();
        reg.name = "M_COMMENTS";
        reg.Regex = "/\\*+(.|\\n|.)*?(\\*+/)(?!(\\w*\"))";
        re.add(reg);
        
        reg = new Token();
        reg.name = "S_COMMENTS";
        reg.Regex = "//.*((?!(( |.)*\")|(\\w*.*\\\\s*\\*+/+))|(?=(\\w*.*/+\\*)))";
        re.add(reg);
        
        reg = new Token();
        reg.name = "STRING_LITERAL";
        reg.Regex = "(\".*?\")";
        re.add(reg);
        
        reg = new Token();
        reg.name = "EOL";
        reg.Regex = "\\n|$";
        re.add(reg);

        reg = new Token();
        reg.name = "PLUS";
        reg.Regex = "\\+";
        re.add(reg);

        reg = new Token();
        reg.name = "LEFT_CURLY_B";
        reg.Regex = "\\{()";
        re.add(reg);

        reg = new Token();
        reg.name = "RIGHT_CURLY_B";
        reg.Regex = "(\\})";
        re.add(reg);

        reg = new Token();
        reg.name = "LEFT_SQUARE_B";
        reg.Regex = "(\\[)";
        re.add(reg);

        reg = new Token();
        reg.name = "RIGHT_SQUARE_B";
        reg.Regex = "(\\])";
        re.add(reg);

        reg = new Token();
        reg.name = "LEFT_ROUND_B";
        reg.Regex = "(\\()";
        re.add(reg);

        reg = new Token();
        reg.name = "RIGHT_ROUND_B";
        reg.Regex = "(\\))";
        re.add(reg);

        reg = new Token();
        reg.name = "COMMA";
        reg.Regex = "(,)";
        re.add(reg);

        reg = new Token();
        reg.name = "SEMICOLON";
        reg.Regex = "(;)";
        re.add(reg);

        reg = new Token();
        reg.name = "DOT";
        reg.Regex = "(\\.)";
        re.add(reg);

        reg = new Token();
        reg.name = "NOT";
        reg.Regex = "(!)";
        re.add(reg);

        reg = new Token();
        reg.name = "ASSIGNMENT";
        reg.Regex = "(\\={1})";
        re.add(reg);

        reg = new Token();
        reg.name = "EQUAL";
        reg.Regex = "(\\={2})";
        re.add(reg);

        reg = new Token();
        reg.name = "NOT_EQUAL";
        reg.Regex = "(\\!\\={2})";
        re.add(reg);

        reg = new Token();
        reg.name = "AND";
        reg.Regex = "(\\&{2})";
        re.add(reg);

        reg = new Token();
        reg.name = "OR";
        reg.Regex = "(\\|{2})";
        re.add(reg);

        reg = new Token();
        reg.name = "MINUS";
        reg.Regex = "(-)";
        re.add(reg);

        reg = new Token();
        reg.name = "MULTIPLY";
        reg.Regex = "((?>!/)\\*)";
        re.add(reg);

        reg = new Token();
        reg.name = "DIV";
        reg.Regex = "(/((?!(\\w*\")|((.|\\n|.)*\\*+/)|(/*)|(\\**))|(?=(\\w*.*/+\\*))))";
        re.add(reg);

        reg = new Token();
        reg.name = "MOD";
        reg.Regex = "(%)";
        re.add(reg);

        reg = new Token();
        reg.name = "LESSTHAN";
        reg.Regex = "(\\<)";
        re.add(reg);

        reg = new Token();
        reg.name = "GREATERTHAN";
        reg.Regex = "(\\>)";
        re.add(reg);

        reg = new Token();
        reg.name = "LESS_EQ";
        reg.Regex = "(\\<\\=)";
        re.add(reg);

        reg = new Token();
        reg.name = "GREATER_EQ";
        reg.Regex = "(\\>\\=)";
        re.add(reg);

        reg = new Token();
        reg.name = "IF";
        reg.Regex = "(\\bif\\b)";
        re.add(reg);

        reg = new Token();
        reg.name = "INT";
        reg.Regex = "(\\bint\\b)";
        re.add(reg);

        reg = new Token();
        reg.name = "ELSE";
        reg.Regex = "(\\belse\\b)";
        re.add(reg);

        reg = new Token();
        reg.name = "MAIN";
        reg.Regex = "(\\bmain\\b)";
        re.add(reg);

        reg = new Token();
        reg.name = "THIS";
        reg.Regex = "(\\bthis\\b)";
        re.add(reg);

        reg = new Token();
        reg.name = "TRUE";
        reg.Regex = "(\\btrue\\b)";
        re.add(reg);

        reg = new Token();
        reg.name = "VOID";
        reg.Regex = "(\\bvoid\\b)";
        re.add(reg);

        reg = new Token();
        reg.name = "CLASS";
        reg.Regex = "(\\bclass\\b)";
        re.add(reg);

        reg = new Token();
        reg.name = "FALSE";
        reg.Regex = "(\\bfalse\\b)";
        re.add(reg);

        reg = new Token();
        reg.name = "WHILE";
        reg.Regex = "(\\bwhile\\b)";
        re.add(reg);

        reg = new Token();
        reg.name = "LENGTH";
        reg.Regex = "(\\blength\\b)";
        re.add(reg);

        reg = new Token();
        reg.name = "PUBLIC";
        reg.Regex = "(\\bpublic\\b)";
        re.add(reg);

        reg = new Token();
        reg.name = "PRIVATE";
        reg.Regex = "(\\bprivate\\b)";
        re.add(reg);

        reg = new Token();
        reg.name = "PROTECTED";
        reg.Regex = "(\\bprotected\\b)";
        re.add(reg);

        reg = new Token();
        reg.name = "RETURN";
        reg.Regex = "(\\breturn\\b)";
        re.add(reg);

        reg = new Token();
        reg.name = "STATIC";
        reg.Regex = "(\\bstatic\\b)";
        re.add(reg);

        reg = new Token();
        reg.name = "NEW";
        reg.Regex = "(\\bnew\\b)";
        re.add(reg);

        reg = new Token();
        reg.name = "STRING";
        reg.Regex = "(\\bString\\b)";
        re.add(reg);

        reg = new Token();
        reg.name = "FLOAT";
        reg.Regex = "(\\bfloat\\b)";
        re.add(reg);

        reg = new Token();
        reg.name = "CHARACTER";
        reg.Regex = "(\\bchar\\b)";
        re.add(reg);

        reg = new Token();
        reg.name = "BOOLEAN";
        reg.Regex = "(\\bboolean\\b)";
        re.add(reg);

        reg = new Token();
        reg.name = "EXTENDS";
        reg.Regex = "(\\bextends\\b)";
        re.add(reg);

        reg = new Token();
        reg.name = "NULL";
        reg.Regex = "(\\bnull\\b)";
        re.add(reg);

        reg = new Token();
        reg.name = "ABSTRACT";
        reg.Regex = "(\\babstract\\b)";
        re.add(reg);

        reg = new Token();
        reg.name = "ASSERT";
        reg.Regex = "(\\bassert\\b)";
        re.add(reg);

        reg = new Token();
        reg.name = "BREAK";
        reg.Regex = "(\\bbreak\\b)";
        re.add(reg);

        reg = new Token();
        reg.name = "CONTINUE";
        reg.Regex = "(\\bcontinue\\b)";
        re.add(reg);

        reg = new Token();
        reg.name = "BYTE";
        reg.Regex = "(\\bbyte\\b)";
        re.add(reg);

        reg = new Token();
        reg.name = "CASE";
        reg.Regex = "(\\bcase\\b)";
        re.add(reg);

        reg = new Token();
        reg.name = "CATCH";
        reg.Regex = "(\\bcatch\\b)";
        re.add(reg);

        reg = new Token();
        reg.name = "CONST";
        reg.Regex = "(\\bconst\\b)";
        re.add(reg);

        reg = new Token();
        reg.name = "DEFAULT";
        reg.Regex = "(\\bdefault\\b)";
        re.add(reg);

        reg = new Token();
        reg.name = "DO";
        reg.Regex = "(\\bdo\\b)";
        re.add(reg);

        reg = new Token();
        reg.name = "DOUBLE";
        reg.Regex = "(\\bdouble\\b)";
        re.add(reg);

        reg = new Token();
        reg.name = "ENUM";
        reg.Regex = "(\\benum\\b)";
        re.add(reg);

        reg = new Token();
        reg.name = "FINAL";
        reg.Regex = "(\\bfinal\\b)";
        re.add(reg);

        reg = new Token();
        reg.name = "FINALLY";
        reg.Regex = "(\\bfinally\\b)";
        re.add(reg);

        reg = new Token();
        reg.name = "FOR";
        reg.Regex = "(\\bfor\\b)";
        re.add(reg);

        reg = new Token();
        reg.name = "GOTO";
        reg.Regex = "(\\bgoto\\b)";
        re.add(reg);

        reg = new Token();
        reg.name = "IMPLEMENTS";
        reg.Regex = "(\\bimplements\\b)";
        re.add(reg);

        reg = new Token();
        reg.name = "IMPORT";
        reg.Regex = "(\\bimport\\b)";
        re.add(reg);

        reg = new Token();
        reg.name = "PACKAGE";
        reg.Regex = "(\\bpackage\\b)";
        re.add(reg);

        reg = new Token();
        reg.name = "INSTANCEOF";
        reg.Regex = "(\\binstanceof\\b)";
        re.add(reg);

        reg = new Token();
        reg.name = "INTERFACE";
        reg.Regex = "(\\binterface\\b)";
        re.add(reg);

        reg = new Token();
        reg.name = "SHORT";
        reg.Regex = "(\\bshort\\b)";
        re.add(reg);

        reg = new Token();
        reg.name = "SUPER";
        reg.Regex = "(\\bsuper\\b)";
        re.add(reg);

        reg = new Token();
        reg.name = "SWITCH";
        reg.Regex = "(\\bswitch\\b)";
        re.add(reg);

        reg = new Token();
        reg.name = "THROW";
        reg.Regex = "(\\bthrow\\b)";
        re.add(reg);

        reg = new Token();
        reg.name = "TRY";
        reg.Regex = "(\\btry\\b)";
        re.add(reg);

        reg = new Token();
        reg.name = "SYSTEM_OUT_PRINTLN";
        reg.Regex = "(\\bSystem.out.println\\b)";
        re.add(reg);

        reg = new Token();
        reg.name = "INTEGRAL_LITERAL";
        reg.Regex = "(?<!\\.)\\b\\d+(?!\\d*\\.)";
        re.add(reg);

        reg = new Token();
        reg.name = "FLOAT_LITERAL";
        reg.Regex = "\\b(\\d*\\.\\d+)(?!\\d*\\.)";
        re.add(reg);

        reg = new Token();
        reg.name = "ID";
        reg.Regex = "\\b([a-zA-Z_][a-zA-Z0-9_]*\\b)";
        re.add(reg);

        reg = new Token();
        reg.name = "A_CHAR";
        reg.Regex = "\'\\w\'";
        re.add(reg);

        

        
    }

    public static void main(String[] args) throws IOException {
        String inp = ReadInp();
        addRe(re);
        String str="";
        for (int i = 0; i < re.size(); i++) {
            Pattern pattern = Pattern.compile(re.get(i).Regex);
            Matcher matcher = pattern.matcher(inp);
            while (matcher.find()) {
                int le=inp.length();
                Matched to = new Matched();
                to.token = matcher.group();
                to.name = re.get(i).name;
                to.start = matcher.start();
                to.end = matcher.end();
                if (to.name.equals("ID")) {
                    if (isID(to.token) == true) {
                        System.out.println(to.token);
                        tok.add(to);
                    }
                } else {
                    tok.add(to);
                }
                System.out.println(le);
                if(to.name.equals("M_COMMENTS")||to.name.equals("S_COMMENTS")||to.name.equals("STRING_LITERAL")){
                    System.out.println(to.token);
                    System.out.println(matcher.start());
                    System.out.println(matcher.end());
                    str=inp.substring(0,matcher.start()-1);
                   str+=inp.substring(matcher.end()+1,le);
                }
            }
            inp=str;
        }
        System.out.println(inp);
        Collections.sort(tok);
        FileWriter fr = new FileWriter("output.txt");
        BufferedWriter buf = new BufferedWriter(fr);
        for (int i = 0; i < tok.size(); i++) {
            try {
                buf.write("<" + tok.get(i).name + "> : " + tok.get(i).token + "\n");
            } catch (IOException e) {
                System.out.println("ERORR");
            }
        }
        buf.close();
    }
}
