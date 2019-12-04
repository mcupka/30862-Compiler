public class SIParser extends Parser {


    public ArgObj parse(String[] tokens) {
        SIArgObj args = new SIArgObj();
        int parsedint = 0;
        String parsedstring = "";

        for (int a = 1; a < tokens.length; a++) {
            try {
                int i = Integer.parseInt(tokens[a]);
                parsedint = i;
            }
            catch (Exception e) {
                parsedstring = tokens[a];
            }
        }

        args.i = parsedint;
        args.str = parsedstring;

        return args;
    }

}