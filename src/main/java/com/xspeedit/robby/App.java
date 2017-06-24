package com.xspeedit.robby;

import com.xspeedit.robby.io.Formatter;
import com.xspeedit.robby.io.Parser;

public class App 
{
    public static void main( String[] args )
    {
        String input;
        String output;

        Parser parser = new Parser();
        Formatter formatter = new Formatter();
        Packager packager = new Packager();

        if (args.length > 0) {
            input = args[0];
        }
        else {
            input = "";
        }

        output = formatter.format(packager.packageBoxes(parser.parse(input)));

        System.out.println(output);
    }
}
