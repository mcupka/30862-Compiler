import java.nio.ByteBuffer;

class DeclStmt extends Stmt {

    public DeclStmt() {
        parser = new NullParser();
    }


    public byte [] genCode(String[] tokens) {

        ArgObj args = parser.parse(tokens);
        NullArgsObj nargs = (NullArgsObj) nargs;

        //pushv does: pushi val, pushv
        byte [] codebytes = new byte [5];

        //pushi
        codebytes[0] = (byte) 70;

        //convert 0 into bytes
        ByteBuffer b = ByteBuffer.allocate(4);
        b.putInt(StatementFactory.variables.get(sargs.str));
        byte[] intbytes = b.array();

        codebytes[1] = intbytes[3];
        codebytes[2] = intbytes[2];
        codebytes[3] = intbytes[1];
        codebytes[4] = intbytes[0];

        return codebytes;
    }

}