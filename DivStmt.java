public class DivStmt extends Stmt {

    public DivStmt() {
        parser = new NullParser();
    }


    public byte [] genCode(String[] tokens) {

        ArgObj args = parser.parse(tokens);
        NullArgObj nargs = (NullArgObj) args;

    
        //One byte for div opcode
        byte [] codebytes = new byte[1];

        //div opcode
        codebytes[0] = (byte) 112;

        return codebytes;
    }

}