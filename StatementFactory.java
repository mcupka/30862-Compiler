
import java.util.Map;
import java.lang.reflect.Constructor;
import java.util.HashMap;

public class StatementFactory {

    private static String[] stmtClasses = {"SubrStmt", "PrintiStmt", "RetStmt"};
    private static String[] stmts = {"subr", "printi", "ret"};

    private static Map<String, Stmt> statements = new HashMap<String, Stmt>();

    static{
        for (int i = 0; i < stmtClasses.length; i++) {
            Class<?> cls = null;
            Constructor<?> constructor = null;

            try {
            cls = Class.forName(stmtClasses[i]);
            constructor = cls.getConstructor();
            Stmt stmt = (Stmt) constructor.newInstance();
            statements.put(stmts[i], stmt);
            }
            catch (Exception e) {
                System.out.println("Error creating string<->statement map");
                System.out.println(e);
            }
            
        }
    }


    public static Stmt getStmt(String stmt) {

        Stmt obj = statements.get(stmt);
        if (obj == null) {
            System.out.println("Error getting statement for token: " + stmt);
        }
        return obj;

    }
}