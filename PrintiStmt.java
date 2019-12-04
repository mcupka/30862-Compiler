import java.nio.ByteBuffer;

public class PrintiStmt extends Stmt {

    public PrintiStmt() {
        parser = new IParser();
    }


    public byte [] genCode(String[] tokens) {

        ArgObj args = parser.parse(tokens);
        IArgObj iargs = (IArgObj) args;

        

        //One byte for pushi opcode, 4 for int, 1 for printi opcode
        byte [] codebytes = new byte[6];

        //pushi opcode
        codebytes[0] = (byte) 70;

        //printi opcode
        codebytes[5] = (byte) 146;


        //convert int into bytes
        ByteBuffer b = ByteBuffer.allocate(4);
        b.putInt(iargs.i);
        byte[] intbytes = b.array();

        codebytes[1] = intbytes[3];
        codebytes[2] = intbytes[2];
        codebytes[3] = intbytes[1];
        codebytes[4] = intbytes[0];

        return codebytes;
    }
}