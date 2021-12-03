package assignment1;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("This is Marc Maslen's assignment");



        Earth example = new Earth();
        example.readDataMap("C:\\Users\\marcm\\OneDrive\\Computer science year 1\\CE152 Object orientated\\src\\assignment1\\earth.xyz");
        example.readDataArray("C:\\\\Users\\\\marcm\\\\OneDrive\\\\Computer science year 1\\\\CE152 Object orientated\\\\src\\\\assignment1\\\\earth.xyz");


        //System.out.println("Input sea level: ");
        //int riseSeaLevel = input.nextInt();





        JFrame jf = new JFrame("earth");
        jf.getContentPane().setPreferredSize(new Dimension(1920, 1080));
        map mp = new map("C:\\Users\\marcm\\OneDrive\\Computer science year 1\\CE152 Object orientated\\src\\assignment1\\earth.xyz");
        jf.add(mp);
        jf.pack();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
/*

        Earth example = new Earth();
        example.readDataMap("C:\\Users\\marcm\\OneDrive\\Computer science year 1\\CE152 Object orientated\\src\\assignment1\\earth.xyz");
        System.out.println(example.mapOfEarth);
        example.generateMap(0.5);*/
    }
}
