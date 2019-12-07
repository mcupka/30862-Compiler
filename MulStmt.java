public class MulStmt extends Stmt {

    public MulStmt() {
        parser = new NullParser();
    }


    public byte [] genCode(String[] tokens) {

        ArgObj args = parser.parse(tokens);
        NullArgObj nargs = (NullArgObj) args;

    
        //One byte for mul opcode
        byte [] codebytes = new byte[1];

        //mul opcode
        codebytes[0] = (byte) 108;

        return codebytes;
    }

}