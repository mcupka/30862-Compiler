import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.Path;
import java.nio.charset.StandardCharsets;


public class Main {



    public static void main(String[] args) {

      try {
        FileReader freaderSymbol = new FileReader(args[0]);
        BufferedReader buffreader = new BufferedReader(freaderSymbol);

        String line = buffreader.readLine();
        String[] tokens = null;
        Integer byte_count = 0;

        while(line != null)
        {
          line = line.trim( );
          line = line.replaceAll(",", " , ");
          line = line.replaceAll("\\s+", " ");
          tokens = line.split("\\s");


          if (tokens[0].matches("lab")) {
            //if the statement is a label statement, place the current byte_count in the symbol table entry for that label
            StatementFactory.labels.put(tokens[1], byte_count);
          }

          else if (tokens[0].matches("decl|ret|printi|subr|pushv|popv|printv|pushi|add|sub|mul|div|swp|popm|cmpe|cmplt|cmpgt|jmp|jmpc|poke|peek")) {
            //if statement is any valid statement but lab, increment the byte_count
            byte_count += StatementFactory.bytes_per_stmt.get(tokens[0]);
          }

          line = buffreader.readLine();

        }

        buffreader.close();

      }

      catch (Exception e) {System.out.println("Exception Occured in label symbol scan"); System.out.println(e);}

      try {
        FileReader freaderSymbol = new FileReader(args[0]);
        BufferedReader buffreader = new BufferedReader(freaderSymbol);

        String line = buffreader.readLine();
        String[] tokens = null;
        Integer count = 0;

        while(line != null)
        {
          line = line.trim( );
          line = line.replaceAll(",", " , ");
          line = line.replaceAll("\\s+", " ");
          tokens = line.split("\\s");

          if (tokens[0].matches("decl"))
          {
            StatementFactory.variables.put(tokens[1], count);
            count++;
          }

          line = buffreader.readLine();

        }

        buffreader.close();

      }

      catch (Exception e) {System.out.println("Exception Occured in variable symbol scan"); System.out.println(e);}

      try {
        FileReader freader = new FileReader(args[0]);
        BufferedReader buffreader = new BufferedReader(freader);

        //Path to outputh file
        Path outpath = Paths.get(args[1]);

        //First delete contents of the output file if it exists
        BufferedWriter writer = Files.newBufferedWriter(outpath);
        writer.write("");
        writer.flush();

        //Get first line
        String line = buffreader.readLine();

        String[] tokens = null;

        while (line != null) {

            line = line.trim( );
            line = line.replaceAll(",", " , ");
            line = line.replaceAll("\\s+", " ");
            tokens = line.split("\\s");


            Stmt stmt;
            byte [] data;
            if (tokens[0].matches("decl|ret|printi|subr|pushv|popv|printv|pushi|add|sub|mul|div|swp|popm|cmpe|cmplt|cmpgt|jmp|jmpc|poke|peek")) {

                stmt = StatementFactory.getStmt(tokens[0]);
                data = stmt.genCode(tokens);

                //append the bytes to the output file
                if (data != null) {Files.write(outpath, data, StandardOpenOption.APPEND);}

            }


            //Get the next line
            line = buffreader.readLine();
        }

        //Close the reader
        buffreader.close();

        }


        catch (IOException e) {System.out.println("Error Opening Input File!");}
        catch (ArrayIndexOutOfBoundsException e) {System.out.println("Not enough arguments!");}
        catch (Exception e) {System.out.println("Exception Occured"); System.out.println(e);}
    }
}
