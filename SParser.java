public class SParser extends Parser {


    public ArgObj parse(String[] tokens) {
        SArgObj args = new SArgObj();
        String parsedstring = "";

        args.str = tokens[1];

        return args;
    }

}
