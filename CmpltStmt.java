
public class CmpltStmt extends Stmt {

    public CmpltStmt() {
        parser = new NullParser();
    }
  
  
    public byte [] genCode(String[] tokens) {
  
        ArgObj args = parser.parse(tokens);
        NullArgObj nargs = (NullArgObj) args;
  
        //one byte for cmplt opcode
        byte [] codebytes = new byte [1];
  
        //cmplt
        codebytes[0] = (byte) 136;
  
        return codebytes;
    }
  }
  