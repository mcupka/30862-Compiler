class NullParser extends Parser {

    public ArgObj parse(String[] tokens) {
        NullArgObj args = new NullArgObj();

        return args;
    }

}