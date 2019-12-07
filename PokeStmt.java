import java.nio.ByteBuffer;

public class PokeStmt extends Stmt {

  public PokeStmt() {
      parser = new SParser();
  }


  public byte [] genCode(String[] tokens) {

      ArgObj args = parser.parse(tokens);
      SArgObj sargs = (SArgObj) args;

      //printv does: pushi (int from symbol table), popv
      byte [] codebytes = new byte [6];


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


      //poke
      codebytes[5] = (byte) 90;


      return codebytes;
  }

}
