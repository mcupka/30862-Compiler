class RetStmt extends Stmt {

    public RetStmt() {
        parser = new NullParser();
    }


    public byte [] genCode(String[] tokens) {

        ArgObj args = parser.parse(tokens);
        NullArgObj nargs = (NullArgObj) args;


        byte [] codebytes = new byte [1];
        codebytes[0] = (byte) 0;

        return codebytes;
    }
}