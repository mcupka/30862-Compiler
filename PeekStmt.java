import java.nio.ByteBuffer;

public class PeekStmt extends Stmt {

  public PeekStmt() {
      parser = new SIParser();
  }


  public byte [] genCode(String[] tokens) {

      ArgObj args = parser.parse(tokens);
      SIArgObj sargs = (SIArgObj) args;

      //printv does: pushi (int from symbol table)
      byte [] codebytes = new byte [11];


      //pushi
      codebytes[0] = (byte) 70;

      //convert (valuefromsymboltable) into bytes
      ByteBuffer b = ByteBuffer.allocate(4);
      b.putInt(StatementFactory.variables.get(sargs.str));
      byte[] intbytes = b.array();

      codebytes[1] = intbytes[3];
      codebytes[2] = intbytes[2];
      codebytes[3] = intbytes[1];
      codebytes[4] = intbytes[0];

      codebytes[5] = (byte) 70;

      ByteBuffer b2 = ByteBuffer.allocate(4);
      b2.putInt(sargs.i);
      byte[] intbytes2 = b2.array();

      codebytes[6] = intbytes2[3];
      codebytes[7] = intbytes2[2];
      codebytes[8] = intbytes2[1];
      codebytes[9] = intbytes2[0];


      //peek
      codebytes[10] = (byte) 86;


      return codebytes;
  }

}
