
public class Stmt {

    public Parser parser;

    public Stmt() {
        parser = null;
    }

    //Overloaded for actual statement classes
    public byte [] genCode(String[] tokens) {
        return null;
    }

}