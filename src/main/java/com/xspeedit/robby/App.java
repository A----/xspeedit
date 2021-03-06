package com.xspeedit.robby;

import com.xspeedit.robby.io.Formatter;
import com.xspeedit.robby.io.Parser;
import com.xspeedit.robby.packagingstrategies.RecursivePackagingStrategy;

public class App 
{
    public static void main( String[] args )
    {
        String input;
        String output;

        Parser parser = new Parser();
        Formatter formatter = new Formatter();
        Packager packager = new Packager(new RecursivePackagingStrategy());

        if (args.length > 0) {
            input = args[0];
        }
        else {
            input = "";
        }

        try {
            output = formatter.format(packager.packageBoxes(parser.parse(input)));
            System.out.println(output);
        }
        catch (IllegalArgumentException e) {
            System.err.println("Invalid input: " + input);
            System.exit(1);
        }
    }
}
