package com.xspeedit.robby.io;

import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.Collection;

/**
 * Convertit une chaîne de chiffre en collection d'entiers.
 */
public class Parser
{
    private static final Pattern VALID_ENTRIES = Pattern.compile("^[0-9]*$");

    public Collection<Integer> parse(String str) {
        Matcher matcher = VALID_ENTRIES.matcher(str);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid input: " + str);
        }
        else {
            ArrayList<Integer> collection = new ArrayList<Integer>();
            for(int i = 0; i < str.length(); i++) {
                collection.add(Character.getNumericValue(str.charAt(i)));
            }
            return collection;
        }
    }
}
