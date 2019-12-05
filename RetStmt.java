class RetStmt extends Stmt {

    public RetStmt() {
        parser = new NullParser();
    }


    public byte [] genCode(String[] tokens) {

        ArgObj args = parser.parse(tokens);
        NullArgObj nargs = (NullArgObj) args;

        //ret will only occur once at the end of the program. Always does push 0, popa, ret
        byte [] codebytes = new byte [7];


        //pushi
        codebytes[0] = (byte) 70;

        //convert 0 into bytes
        ByteBuffer b = ByteBuffer.allocate(4);
        b.putInt(0);
        byte[] intbytes = b.array();

        codebytes[1] = intbytes[3];
        codebytes[2] = intbytes[2];
        codebytes[3] = intbytes[1];
        codebytes[4] = intbytes[0];


        //popa
        codebytes[5] = (byte) 77;

        //ret
        codebytes[6] = (byte) 48;

        return codebytes;
    }
}