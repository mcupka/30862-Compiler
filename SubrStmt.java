
public class SubrStmt extends Stmt {

    public SubrStmt() {
        parser = new SIParser();
    }


    public byte [] genCode(String[] tokens) {

        ArgObj args = parser.parse(tokens);
        SIArgObj siargs = (SIArgObj) args;


        //Subr will always do: push 16, push 17, push 1, call, halt; Since main will be the only subr
        byte [] codebytes = new byte[17];

        //pushi
        codebytes[0] = (byte) 70;

        //convert 16 into bytes
        ByteBuffer b = ByteBuffer.allocate(4);
        b.putInt(16);
        byte[] intbytes = b.array();

        codebytes[1] = intbytes[3];
        codebytes[2] = intbytes[2];
        codebytes[3] = intbytes[1];
        codebytes[4] = intbytes[0];

        //pushi
        codebytes[5] = (byte) 70;

        //convert 17 into bytes
        ByteBuffer b = ByteBuffer.allocate(4);
        b.putInt(17);
        byte[] intbytes = b.array();

        codebytes[6] = intbytes[3];
        codebytes[7] = intbytes[2];
        codebytes[8] = intbytes[1];
        codebytes[9] = intbytes[0];


        //pushi
        codebytes[10] = (byte) 70;

        //convert 1 into bytes
        ByteBuffer b = ByteBuffer.allocate(4);
        b.putInt(1);
        byte[] intbytes = b.array();

        codebytes[11] = intbytes[3];
        codebytes[12] = intbytes[2];
        codebytes[13] = intbytes[1];
        codebytes[14] = intbytes[0];


        //call
        codebytes[15] = (byte) 44;

        //halt
        codebytes[16] = (byte) 0;

        return codebytes;
    }
}