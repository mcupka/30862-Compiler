public class SubStmt extends Stmt {

    public SubStmt() {
        parser = new NullParser();
    }


    public byte [] genCode(String[] tokens) {

        ArgObj args = parser.parse(tokens);
        NullArgObj nargs = (NullArgObj) args;

    
        //One byte for sub opcode
        byte [] codebytes = new byte[1];

        //sub opcode
        codebytes[0] = (byte) 104;

        return codebytes;
    }

}