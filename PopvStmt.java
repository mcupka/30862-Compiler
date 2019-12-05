public class PopvStmt extends Stmt {

  public PopvStmt() {
      parser = new SParser();
  }


  public byte [] genCode(String[] tokens) {

      ArgObj args = parser.parse(tokens);
      SArgObj sargs = (SArgObj) args;

      //printv does: pushi (int from symbol table), pushvi, printi
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


      //popv
      codebytes[5] = (byte) 80;


      return codebytes;
  }

}
