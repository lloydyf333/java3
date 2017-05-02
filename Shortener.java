/*
 * Name: ???
 * Student number: ???
 */

import java.io.File;
import java.util.*;
import java.io.*;
import java.nio.*;

import java.util.*;
import java.io.*;

public class Shortener {
    // This class is only a starting point. You should complete all members
    // below, but you may also need to add other fields and methods to
    // finish the implementation as per the question on the assignment sheet.
    private ArrayList<String> abb = new ArrayList<String>();
    private File fileName;
    /*
     * Default constructor that will load a default abbreviations text file.
     */
    public Shortener() {
        this.fileName = new File("abbreviations.txt");
    }
    
    /*
     * Constructor that will load the abbreviations file represented by the
     * File parameter.
     */
    public Shortener( File inAbbreviationsFile ) {
        this.fileName = inAbbreviationsFile;
    }
    
    /*
     * Constructor that will load the abbreviations file that the String 
     * parameter is a file path for.
     */
    public Shortener( String inAbbreviationsFilePath ) {
        this.fileName = new File(inAbbreviationsFilePath);
    }
    
    /*
     * This method attempts to shorten a word by finding its abbreviation. If 
     * no abbreviation exists for this word, then this method will return the 
     * original (i.e., unshortened) word.
     * 
     * You may assume that words are always lower case.
     *
     * `inWord` should be a single word (no spaces). It may optionally be
     * followed by one of the five following punctuation characters:
     *   ,
     *   ?
     *   .
     *   !
     *   ;
     * If one of these characters is at the end of the word this method will
     * shorten the word (ignoring the punctuation) and return the shortened
     * word with the punctuation character at the end.
     * For example,
     *     shortenerObject.shortenWord( "hello?" )
     * should return
     *     "lo?"
     *
     * You may assume that words are always lower case.
     */

    // Find abbreveation for singular words
    public String shortenWord( String inWord ) {
        
        inWord = inWord.trim();

        String lastLetter = inWord.substring(inWord.length() - 1); // Find last character of word
        boolean hasPunc = false;

        if(Arrays.asList(",", "?", ".", "!", ";").contains(lastLetter)){ // Check if last letter is punctuation

            inWord = inWord.substring(0, inWord.length() - 1); //remove punctuation if present
            hasPunc = true;

        }
        // Iterate through abbreviations.txt and return abbreviation of any words inputted
        for(String word: abb){

            String[] wordSplit = word.split(","); 

            if(wordSplit[0].toLowerCase().equals(inWord.toLowerCase())){ 
                String abbWord = wordSplit[1]; 
                if(hasPunc){
                    return abbWord + lastLetter; 
                }
                else{
                    return abbWord; 
                }
            }
        }
        // return input word and any punctuation if there is no abbreviation
        if(hasPunc){
            return inWord + lastLetter;
        }
        else{
            return inWord;
        }
    }

    // find abbreviation for a phrase
    public String shortenPhrase(String inMessage){ 

        for(String phrase: abb){

            String[] phraseSplit = phrase.split(","); 

            if(phraseSplit[0].split(" ").length > 1){ 

                if(inMessage.toLowerCase().indexOf(phraseSplit[0].toLowerCase()) > 0){ 

                    inMessage = inMessage.replace(phraseSplit[0].toLowerCase(), phraseSplit[1]); 

                }
            }
        }
        return inMessage; //return new msg 
    }
    /*
     * Attempts to shorten a message by replacing words with their 
     * abbreviations. 
     *
     * You may assume that messages are always lower case.
     *
     * Punctuation characters (,?.!;) should be retained after shortening. See
     * `shortenWord( String inWord )` for more information.
     */
    
    //find abbreviation for inputted msg
    public String shortenMessage( String inMessage ) {
        
        String msg = ""; //string to store output msg

        //read abbreviation txt file
        try{

            BufferedReader reader = new BufferedReader(new FileReader(fileName)); 

            String line;

            while((line = reader.readLine()) != null){ 
                abb.add(line);

            }
        }
        //exceptions...    
        
        catch(FileNotFoundException e){ 
            
            return "ERROR: " + e;

        }

        catch(IOException e){

            return "ERROR: " + e;
        }

        inMessage = shortenPhrase(inMessage);
        inMessage = inMessage.toLowerCase(); 
        String[] message = inMessage.split("\\s+");


        for(int i = 0; i < message.length; i++){
            String finalWord = shortenWord(message[i]); 
            msg += finalWord + " "; 
        }    

        return msg.substring(0, msg.length() -1); 
    }
}

