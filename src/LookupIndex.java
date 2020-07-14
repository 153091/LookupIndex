/** %java LookupIndex.java movies.txt "/"
 Done indexing
 Bacon, Kevin
        Animal House (1978)
        Apollo 13 (1995)
        Beauty Shop (2005)
        Diner (1982)
        Few Good Men, A (1992)
        Flatliners (1990)
        Footloose (1984)
        Friday the 13th (1980)
        He Said, She Said (1991)
        Hollow Man (2000)
        In the Cut (2003)
        JFK (1991)
        Murder in the First (1995)
        My Dog Skip (2000)
        Mystic River (2003)
        Novocaine (2001)
        Picture Perfect (1997)
        Planes, Trains & Automobiles (1987)
        River Wild, The (1994)
        She's Having a Baby (1988)
        Sleepers (1996)
        Stir of Echoes (1999)
        Trapped (2002)
        Tremors (1990)
        Where the Truth Lies (2005)
        Wild Things (1998)
        Woodsman, The (2004)
*/

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.*;


public class LookupIndex {

    public static void main(String[] args) {
	String filename = args[0];
	String separator = args[1];
    In in = new In(filename);

    // create empty ST
    TreeMap<String, List<String>> st = new TreeMap<>();
    TreeMap<String, List<String>> ts = new TreeMap<>();

    // read text and create structure with given data
    while (in.hasNextLine()) {
        String line = in.readLine();
        String[] fields = line.split(separator);
        String key = fields[0];
        for (int i = 1; i < fields.length; i++) {
            String value = fields[i];
                if (!st.containsKey(key)) st.put(key, new LinkedList<>());
                if (!ts.containsKey(value)) ts.put(value, new LinkedList<>());
            st.get(key).add(value);
            ts.get(value).add(key);
        }
    }

        StdOut.println("Done indexing");

    // process queries
    // read queries from standard input, one per line
        while (!StdIn.isEmpty()) {
            String query = StdIn.readLine();

            if (st.containsKey(query))
                for (String vals : st.get(query))
                StdOut.println(" " + vals);

            if (ts.containsKey(query))
                for (String keys : ts.get(query))
                StdOut.println(" " + keys);
        }

    }
}
