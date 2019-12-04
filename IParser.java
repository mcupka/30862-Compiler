public class IParser extends Parser {

    public ArgObj parse(String[] tokens) {
        IArgObj args = new IArgObj();
        int parsedint = 0;

        try {
            int i = Integer.parseInt(tokens[1]);
            parsedint = i;
        }
        catch (Exception e) {
            System.out.println("Error parsing int in IParser");
        }
    
        args.i = parsedint;

        return args;
    }

}