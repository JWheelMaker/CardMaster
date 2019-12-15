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

public class box extends JFrame {
  // Anfang Attribute
  private JLabel jLabel1 = new JLabel();
  private JLabel jLabel2 = new JLabel();
  private JTextField jTextField1 = new JTextField();
  private JButton jButton1 = new JButton();
  private JLabel jLabel3 = new JLabel();
  private JLabel jLabel4 = new JLabel();
  private JButton jButton2 = new JButton();
  // Ende Attribute
  
  public box() { 
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
    setTitle("box");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    jLabel1.setBounds(448, 24, 110, 20);
    jLabel1.setText("Box 1");
    cp.add(jLabel1);
    jLabel2.setBounds(33, 60, 110, 20);
    jLabel2.setText("Karte hinzufügen");
    cp.add(jLabel2);
    jTextField1.setBounds(31, 96, 150, 20);
    cp.add(jTextField1);
    jButton1.setBounds(23, 142, 75, 25);
    jButton1.setText("hinzufügen");
    jButton1.setMargin(new Insets(2, 2, 2, 2));
    jButton1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton1_ActionPerformed(evt);
      }
    });
    cp.add(jButton1);
    jLabel3.setBounds(282, 91, 110, 20);
    jLabel3.setText("Karten abfragen");
    cp.add(jLabel3);
    jLabel4.setBounds(279, 119, 110, 20);
  public void jButton1_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    
  } // end of jButton1_ActionPerformed

  public void jButton2_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    
  } // end of jButton2_ActionPerformed

  // Ende Methoden
} // end of class box

