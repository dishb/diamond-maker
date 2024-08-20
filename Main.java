// import javax.swing.*;
// import java.awt.event.*;
import java.util.Scanner;
import kareltherobot.*;

public class Main implements Directions {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("\nPlease enter the side length of the diamond below.");
        System.out.println("Enter a number (15 or below) or good results aren't guaranteed.\n");

        String input = s.nextLine();
        int length = Integer.parseInt(input);
        s.close();

        int winWidth = (2 * length) - 1;
        int winLength = (2 * length);

        Robot r = new Robot(1, winWidth / 2, East, (length * 4) - 4);

        World.setVisible(true);
        World.setSize(winLength, winWidth);
        World.setDelay(3);
        
        // Make a diamond with a specified length
        diamond(length, r);

        // Get the robot out of the way so we can see the beeper underneath
        r.move();
        r.move();
    }

    // Creates a diamond with sides of 'length' and with robot 'r'
    public static void diamond(int length, Robot r) {
        diagonal(length, r);
        r.turnLeft();
        diagonal(length - 1, r);
        r.turnLeft();
        diagonal(length - 1, r);
        r.turnLeft();
        diagonal(length - 2, r);
    }

    // Turns the robot 'r' right, which is left 3 times
    public static void turnRight(Robot r) {
        for (int i = 0; i < 3; i++) {
            r.turnLeft();
        }
    }

    // Makes a diagonal line 'length' long with beepers and the robot 'r'
    public static void diagonal(int length, Robot r) {
        for (int i = 0; i < length; i++) {
            r.move();
            r.turnLeft();
            r.move();
            r.putBeeper();
            turnRight(r);
        }
    }
}
