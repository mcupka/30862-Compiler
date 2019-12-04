
public class SubrStmt extends Stmt {

    public SubrStmt() {
        parser = new SIParser();
    }


    public byte [] genCode(String[] tokens) {

        ArgObj args = parser.parse(tokens);
        SIArgObj siargs = (SIArgObj) args;

        byte [] codebytes = null;

        return codebytes;
    }
}