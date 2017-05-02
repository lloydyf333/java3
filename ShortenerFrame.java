/*
 * Name: ???
 * Student number: ???
 */

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.tools.Tool;
import java.awt.GridLayout;
import java.awt.event.*;
import java.awt.datatransfer.*;
import java.awt.Toolkit;

public class ShortenerFrame extends JFrame implements ActionListener {

    public static void main(String[] args) {
        new ShortenerFrame().setVisible(true);
    }    
    // This class is only a starting point. You may wish to add members and 
    // fields to complete the implementation of this class as per the
    // question on the assignment sheet.
    
    // Constants
    private static final int FRAME_WIDTH = 400;
    private static final int FRAME_HEIGHT = 260;
    
    // Instance variables -- GUI components
    private JPanel panel;
    private JLabel instructionLabel;
    private JTextArea inputArea;
    private JTextArea outputArea;
    private JButton shortenButton;
    private JButton copyClipboard;
    
    // Constructor
    public ShortenerFrame() {
        super("Shortener");

        //
        // Set up the frame
        setVisible(true);
        setSize( FRAME_WIDTH, FRAME_HEIGHT );
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        

        //
        // Set up the panel and layout manager
        panel = new JPanel();
        GridLayout grid = new GridLayout( 0, 1 );  // a one-column layout
        panel.setLayout( grid );
        
        add( panel );  // add panel to the JFrame

        //
        // Set up and add components
        instructionLabel = new JLabel( "Enter text in the field below and click 'Shorten'" );
        panel.add(instructionLabel);
        
        inputArea = new JTextArea();
        inputArea.setLineWrap(true);
        inputArea.setWrapStyleWord(true);
        panel.add( inputArea );
        
        shortenButton = new JButton("Shorten");
        panel.add(shortenButton);
        
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);
        panel.add(outputArea);

        copyClipboard = new JButton("Copy Output to Clipboard");
        panel.add(copyClipboard);

        shortenButton.addActionListener(this);
        copyClipboard.addActionListener(this);
        
    }

    public void actionPerformed(ActionEvent click){
        Object source = click.getSource();

        if(source == shortenButton) {
            String userInput = inputArea.getText();
            Shortener msgshort = new Shortener();
            outputArea.setText(msgshort.shortenMessage(userInput));
        }
        else if(source == copyClipboard) {
            StringSelection output = new StringSelection(outputArea.getText());
            Clipboard board = Toolkit.getDefaultToolkit().getSystemClipboard();
            board.setContents(output, null);
        }
    }
}
