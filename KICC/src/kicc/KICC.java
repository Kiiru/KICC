/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kicc;

/**
 *
 * @author mwangi
 */

import javax.swing.JOptionPane;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class KICC {

    /**
     * @param args the command line arguments
     */
    
    private static double height, base;
    
    /**
     * 
     * @param args
     * This program calculates the distance a ball travels after it is dropped from a tall building
     * 
     * Assumptions
     * -----------
     * Assuming that the base angle never changes
     * and the height of the bounce reduces to 25% of original height
     * the ball makes Isosceles triangle after a complete bounce
     * 
     */
    
    public static void main(String[] args) {
        
        // Prompt user to input building height
        String bHeight = JOptionPane.showInputDialog("Please insert height");
        double h = Double.parseDouble(bHeight);
        
        double angle = (double) 70.0;
        
        // get the balls first bounce height (assuming 25% of building height).
        double h1 = (double) ((0.25) * h);
        
        // get the length of first base 
        // length say a = 2h/tan@
        // first convert the base angle to radians
        double rad = Math.toRadians(angle);
        double base1 = (2 * h1) / Math.tan(rad);
        
        /**
         * 
         * Assuming that the base angle never changes
         * and the height of the bounce reduces to 25% of original height
         * the ball makes Isosceles triangle after a complete bounce
         * lets get the base for height > 0
         * 
         */
        
        height = h1;
        
        List<Double> storeBases = new ArrayList<Double>();
        
        while (height > 0){
            double newH = (double) ((0.25) * height);
            double newBase = (2 * newH) / Math.tan(rad);
            storeBases.add(newBase);
            height = newH;
        }
        
        /**
         * Now lets get the length of all the newBase 
         */
        Iterator<Double> baseIterator = storeBases.iterator();
        
         double i = 0;
         while (baseIterator.hasNext()){
			i = i + baseIterator.next();
		}
        
         double totalBase = i + base1;
        
         System.out.println(totalBase);
         JOptionPane.showMessageDialog(null, "Total distance travelled " + totalBase);
        
    }
    
}
