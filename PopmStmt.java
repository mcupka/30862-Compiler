import java.nio.ByteBuffer;

public class PopmStmt extends Stmt {

  public PopmStmt() {
      parser = new IParser();
  }


  public byte [] genCode(String[] tokens) {

      ArgObj args = parser.parse(tokens);
      IArgObj iargs = (IArgObj) args;

      //printv does: pushi val, popm
      byte [] codebytes = new byte [6];

      //pushi
      codebytes[0] = (byte) 70;

      //convert int into bytes
      ByteBuffer b = ByteBuffer.allocate(4);
      b.putInt(iargs.i);
      byte[] intbytes = b.array();

      codebytes[1] = intbytes[3];
      codebytes[2] = intbytes[2];
      codebytes[3] = intbytes[1];
      codebytes[4] = intbytes[0];


      //popm
      codebytes[5] = (byte) 76;

      return codebytes;
  }

}
