public class AddStmt extends Stmt {

    public AddStmt() {
        parser = new NullParser();
    }


    public byte [] genCode(String[] tokens) {

        ArgObj args = parser.parse(tokens);
        NullArgObj nargs = (NullArgObj) args;

    
        //One byte for add opcode
        byte [] codebytes = new byte[1];

        //add opcode
        codebytes[0] = (byte) 100;

        return codebytes;
    }

}