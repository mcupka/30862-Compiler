public class SwpStmt extends Stmt {

    public SwpStmt() {
        parser = new NullParser();
    }


    public byte [] genCode(String[] tokens) {

        ArgObj args = parser.parse(tokens);
        NullArgObj nargs = (NullArgObj) args;

    
        //One byte for opcode
        byte [] codebytes = new byte[1];

        //swp opcode
        codebytes[0] = (byte) 94;

        return codebytes;
    }

}