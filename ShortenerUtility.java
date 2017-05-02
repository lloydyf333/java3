/*
 * Name: ???
 * Student number: ???
 */

/*
 * A command-line application that shortens a message.
 */
public class ShortenerUtility {
    public static void main(String[] args) {
        if(args.length < 1) {
            System.out.println("ERROR: Please enter an message");
        }
        else {
            Shortener msgshort = new Shortener();
            System.out.println(msgshort.shortenMessage(args[0]));
        }
    }
}