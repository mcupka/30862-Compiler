import java.nio.ByteBuffer;

class PushiStmt extends Stmt {

    public PushiStmt() {
        parser = new IParser();
    }


    public byte [] genCode(String[] tokens) {

        ArgObj args = parser.parse(tokens);
        IArgObj sargs = (IArgObj) args;

        //pushi does: pushi val, pushv
        byte [] codebytes = new byte [5];

        //pushi
        codebytes[0] = (byte) 70;

        //convert (valuefromsymboltable) into bytes
        ByteBuffer b = ByteBuffer.allocate(4);
        b.putInt(sargs.i);
        byte[] intbytes = b.array();

        codebytes[1] = intbytes[3];
        codebytes[2] = intbytes[2];
        codebytes[3] = intbytes[1];
        codebytes[4] = intbytes[0];


        return codebytes;
    }

}
