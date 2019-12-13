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

public class BoxGUI1 extends JFrame {
  // Anfang Attribute
  private JLabel jLabel1 = new JLabel();
  private JLabel jLabel2 = new JLabel();
  private JTextField jTextField1 = new JTextField();
  private JTextField jTextField2 = new JTextField();
  private JButton jButton1 = new JButton();
  private JLabel jLabel3 = new JLabel();
  private JLabel jLabel4 = new JLabel();
  private JButton jButton2 = new JButton();
  private JSeparator jSeparator1 = new JSeparator();
  private JLabel jLabel5 = new JLabel();
  private JLabel jLabel6 = new JLabel();
  private JLabel jLabel7 = new JLabel();
  private Karteikasten kk = new Karteikasten();
  // Ende Attribute
  
  public BoxGUI1() { 
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
    setTitle("Box 1");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    jLabel1.setBounds(448, 24, 110, 20);
    jLabel1.setText("Box 1");
    cp.add(jLabel1);
    jLabel2.setBounds(60, 92, 110, 20);
    jLabel2.setText("Karte hinzufügen");
    cp.add(jLabel2);
    jLabel6.setBounds(5, 116, 110, 20);
    jLabel6.setText("Frage:");
    cp.add(jLabel6);
    jLabel7.setBounds(5, 140, 110, 20);
    jLabel7.setText("Antwort:");
    cp.add(jLabel7);
    jTextField1.setBounds(60, 116, 150, 20);
    cp.add(jTextField1);
    jTextField2.setBounds(60, 140, 150, 20);
    cp.add(jTextField2);
    jButton1.setBounds(60, 170, 75, 25);
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
    jLabel4.setText("Frage anzeigen");
    cp.add(jLabel4);
    jButton2.setBounds(280, 149, 75, 25);
    jButton2.setText("überprüfen");
    jButton2.setMargin(new Insets(2, 2, 2, 2));
    jButton2.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton2_ActionPerformed(evt);
      }
    });
    cp.add(jButton2);
    jSeparator1.setBounds(36, 53, 916, 26);
    cp.add(jSeparator1);
    jLabel5.setBounds(33, 200, 110, 20);
    //jLabel5.setText("hi");
    cp.add(jLabel5);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public BoxGUI1
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new BoxGUI1();
  } // end of main
  
  public void jButton1_ActionPerformed(ActionEvent evt) {
    kk.addCard(1, new Karte(jTextField1.getText(), jTextField2.getText()));
  } // end of jButton1_ActionPerformed

  public void jButton2_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    
  } // end of jButton2_ActionPerformed

  // Ende Methoden
} // end of class BoxGUI1
