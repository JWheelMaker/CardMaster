import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 12.12.2019
 * @author 
 */

public class KastenGUI extends JFrame {
    // Anfang Attribute
    private JLabel jLabel2 = new JLabel();
    private JSeparator jSeparator1 = new JSeparator();
    private JButton jButton1 = new JButton();
    private JButton jButton2 = new JButton();
    private JButton jButton3 = new JButton();
    private JButton jButton4 = new JButton();
    private JButton jButton5 = new JButton();
    private JSeparator jSeparator3 = new JSeparator();

    // Ende Attribute

    public KastenGUI() { 
        // Frame-Initialisierung
        super();


        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        int frameWidth = 1000; 
        int frameHeight = 500;
        setSize(frameWidth, frameHeight);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (d.width - getSize().width) / 2;
        int y = (d.height - getSize().height) / 2;
        setLocation(x, y);
        setTitle("KastenGUI");
        setResizable(false);
        Container cp = getContentPane();
        cp.setLayout(null);
        // Anfang Komponenten

        jLabel2.setBounds(464, 8, 105, 49);
        jLabel2.setText("KastenGUI");
        cp.add(jLabel2);
        jSeparator1.setBounds(24, 80, 945, 345);
        cp.add(jSeparator1);
        jButton1.setBounds(51, 103, 155, 297);
        jButton1.setText("Box1");
        jButton1.setMargin(new Insets(2, 2, 2, 2));
        jButton1.addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent evt) { 
                    jButton1_ActionPerformed(evt);
                }
            });
        cp.add(jButton1);
        jButton2.setBounds(232, 105, 155, 297);
        jButton2.setText("Box2");
        jButton2.setMargin(new Insets(2, 2, 2, 2));
        jButton2.addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent evt) { 
                    jButton2_ActionPerformed(evt);
                }
            });
        cp.add(jButton2);
        jButton3.setBounds(417, 108, 155, 297);
        jButton3.setText("Box3");
        jButton3.setMargin(new Insets(2, 2, 2, 2));
        jButton3.addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent evt) { 
                    jButton3_ActionPerformed(evt);
                }
            });
        cp.add(jButton3);
        jButton4.setBounds(599, 104, 155, 297);
        jButton4.setText("Box4");
        jButton4.setMargin(new Insets(2, 2, 2, 2));
        jButton4.addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent evt) { 
                    jButton4_ActionPerformed(evt);
                }
            });
        cp.add(jButton4);
        jButton5.setBounds(783, 104, 163, 297);
        jButton5.setText("Archiv");
        jButton5.setMargin(new Insets(2, 2, 2, 2));
        jButton5.addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent evt) { 
                    jButton5_ActionPerformed(evt);
                }
            });
        cp.add(jButton5);
        jSeparator3.setBounds(24, 440, 953, 9);
        cp.add(jSeparator3);
        // Ende Komponenten

        setVisible(true);
    } // end of public KastenGUI

    // Anfang Methoden

    public static void main(String[] args) {
        new KastenGUI();
    } // end of main

    public void jButton1_ActionPerformed(ActionEvent evt) {
        new BoxGUI1();
        setVisible(false);
    } // end of jButton1_ActionPerformed

    public void jButton2_ActionPerformed(ActionEvent evt) {
        new BoxGUI2();
        setVisible(false);
    } // end of jButton2_ActionPerformed

    public void jButton3_ActionPerformed(ActionEvent evt) {
        new BoxGUI3();
        setVisible(false);
    } // end of jButton3_ActionPerformed

    public void jButton4_ActionPerformed(ActionEvent evt) {
        new BoxGUI4();
        setVisible(false);
    } // end of jButton4_ActionPerformed

    public void jButton5_ActionPerformed(ActionEvent evt) {
        // TODO hier Quelltext einfügen

    } // end of jButton5_ActionPerformed

    // Ende Methoden
} // end of class KastenGUI
