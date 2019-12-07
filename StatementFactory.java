
import java.util.Map;
import java.lang.reflect.Constructor;
import java.util.HashMap;

public class StatementFactory {

    private static String[] stmtClasses = {"SubrStmt", "PrintiStmt", "RetStmt", "DeclStmt", "PrintvStmt", "PushvStmt", "PopvStmt", "PushiStmt", "AddStmt",
    "SubStmt", "MulStmt", "DivStmt", "SwpStmt"};
    private static String[] stmts = {"subr", "printi", "ret", "decl", "printv", "pushv", "popv", "pushi", "add",
     "sub", "mul", "div", "swp"};

    private static Map<String, Stmt> statements = new HashMap<String, Stmt>();
    public static Map<String, Integer> variables = new HashMap<String, Integer>();


    //Used to make hashmap of command<->(# of bytes it generates) used for the label symbol table
    private static Integer[] bytes_generated = {17 /*subr*/, 6 /*printi*/ , 7 /*ret*/, 5 /*decl*/, 7 /*printv*/, 6 /*pushv*/, 6 /*popv*/, 5 /*pushi*/, 1 /*add*/,
    1 /*sub*/, 1 /*mul*/, 1 /*div*/, 1 /*swp*/};

    public static Map<String, Integer> bytes_per_stmt = new HashMap<String, Integer>();
    public static Map<String, Integer> labels = new HashMap<String, Integer>();

    static{
        for (int i = 0; i < stmtClasses.length; i++) {
            Class<?> cls = null;
            Constructor<?> constructor = null;

            try {
            cls = Class.forName(stmtClasses[i]);
            constructor = cls.getConstructor();
            Stmt stmt = (Stmt) constructor.newInstance();
            statements.put(stmts[i], stmt);

            bytes_per_stmt.put(stmts[i], bytes_generated[i]);

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
