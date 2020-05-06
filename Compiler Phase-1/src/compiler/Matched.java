package compiler;

public class Matched implements Comparable<Matched>{
    public String token;
    public String name;
    int start;
    int end;

    @Override
    public int compareTo(Matched o) {
        int comp=((Matched)o).start;
        return this.start-comp;
    }
}
