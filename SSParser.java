public class SSParser extends Parser {


    public ArgObj parse(String[] tokens) {
        SSArgObj args = new SSArgObj();
        String parsedstring1 = "";
        String parsedstring2 = "";

        args.str1 = tokens[1];
        args.str2 = tokens[2];

        return args;
    }

}
