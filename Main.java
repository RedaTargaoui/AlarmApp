/**
 * @file Main.java
 * @brief The test file
 * @author Reda TARGAOUI
 * @version 1.0
 * @date 04/25/2023
 */

import javax.swing.*;

public class Main {
    /**
     * @fn main()
     * @brief Principal function
     */
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Alarm();
            }
        });

    }
}
