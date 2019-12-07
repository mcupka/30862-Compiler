
public class CmpeStmt extends Stmt {

  public CmpeStmt() {
      parser = new NullParser();
  }


  public byte [] genCode(String[] tokens) {

      ArgObj args = parser.parse(tokens);
      NullArgObj nargs = (NullArgObj) args;

      //one byte for cmpe opcode
      byte [] codebytes = new byte [1];

      //cmpe
      codebytes[0] = (byte) 132;

      return codebytes;
  }
}
