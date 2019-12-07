
public class CmpgtStmt extends Stmt {

    public CmpgtStmt() {
        parser = new NullParser();
    }
  
  
    public byte [] genCode(String[] tokens) {
  
        ArgObj args = parser.parse(tokens);
        NullArgObj nargs = (NullArgObj) args;
  
        //one byte for cmpgt opcode
        byte [] codebytes = new byte [1];
  
        //cmpgt
        codebytes[0] = (byte) 140;
  
        return codebytes;
    }
  }
  