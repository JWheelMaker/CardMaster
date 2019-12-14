import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class Karteikasten
{
    private Queue <Karte> box1 = new Queue();
    private Queue <Karte> box2 = new Queue();
    private Queue <Karte> box3 = new Queue();
    private Queue <Karte> box4 = new Queue();

    private Stack <Karte> archiv = new Stack();

    public Karteikasten()
    {
        new KastenGUI();
    }

    public void addKarte(String pFrage, String pAntwort) {
        box1.enqueue(new Karte(pFrage, pAntwort));
    }

    public void save() {

    }

    public void load() {

    }

    private class KastenGUI extends JFrame {
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

        public void jButton1_ActionPerformed(ActionEvent evt) {
            new BoxGUI(1);
            setVisible(false);
        } // end of jButton1_ActionPerformed

        public void jButton2_ActionPerformed(ActionEvent evt) {
            new BoxGUI(2);
            setVisible(false);
        } // end of jButton2_ActionPerformed

        public void jButton3_ActionPerformed(ActionEvent evt) {
            new BoxGUI(3);
            setVisible(false);
        } // end of jButton3_ActionPerformed

        public void jButton4_ActionPerformed(ActionEvent evt) {
            new BoxGUI(4);
            setVisible(false);
        } // end of jButton4_ActionPerformed

        public void jButton5_ActionPerformed(ActionEvent evt) {
            // TODO hier Quelltext einfügen

        } // end of jButton5_ActionPerformed

        // Ende Methoden
    } // end of class KastenGUI
    public class BoxGUI extends JFrame {
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
        // Ende Attribute

        public BoxGUI(int pBoxnummer) { 
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
            setTitle("Box " + pBoxnummer);
            setResizable(false);
            Container cp = getContentPane();
            cp.setLayout(null);
            // Anfang Komponenten

            jLabel1.setBounds(448, 24, 110, 20);
            jLabel1.setText("Box " + pBoxnummer);
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

        public void jButton1_ActionPerformed(ActionEvent evt) {

        } // end of jButton1_ActionPerformed

        public void jButton2_ActionPerformed(ActionEvent evt) {
            // TODO hier Quelltext einfügen

        } // end of jButton2_ActionPerformed

        // Ende Methoden
    } // end of class BoxGUI1

}
