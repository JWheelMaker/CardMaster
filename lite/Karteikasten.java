import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Karteikasten
{
    private Queue <Karte> box1 = new Queue();
    private Queue <Karte> box2 = new Queue();
    private Queue <Karte> box3 = new Queue();
    private Queue <Karte> box4 = new Queue();

    private Stack <Karte> archiv = new Stack();

    public Queue <Karte> zaehlen = new Queue();

    public int zaehler1;
    public int zaehler2;
    public int zaehler3;
    public int zaehler4;

    public Karteikasten()
    {
        new KastenGUI();
    }

    public void out(String pOutput) {
        System.out.println(pOutput);
    }

    public void save() {
        //nur am Ende ausführen, leert alle Boxen!!
        File b1save = new File("saves/box1.txt");
        File b2save = new File("saves/box2.txt");
        File b3save = new File("saves/box3.txt");
        File b4save = new File("saves/box4.txt");
        File arSave = new File("saves/archiv.txt");

        try {
            FileWriter writer1 = new FileWriter(b1save);

            while(!box1.isEmpty()) {
                writer1.write(box1.front().getFrage() + "\n");
                writer1.write("Hallo Testib");
                writer1.write(box1.front().getAntwort() + "\n");
                box1.dequeue();
            }

        } catch(IOException e) {
            e.printStackTrace();
        }

        try {
            FileWriter writer2 = new FileWriter(b2save);

            while(!box2.isEmpty()) {
                writer2.write(box2.front().getFrage() + "\n");
                writer2.write(box2.front().getAntwort() + "\n");
                box2.dequeue();
            }

        } catch(IOException e) {
            e.printStackTrace();
        }

        try {
            FileWriter writer3 = new FileWriter(b3save);

            while(!box3.isEmpty()) {
                writer3.write(box3.front().getFrage() + "\n");
                writer3.write(box3.front().getAntwort() + "\n");
                box3.dequeue();
            }

        } catch(IOException e) {
            e.printStackTrace();
        }

        try {
            FileWriter writer4 = new FileWriter(b4save);

            while(!box4.isEmpty()) {
                writer4.write(box4.front().getFrage() + "\n");
                writer4.write(box4.front().getAntwort() + "\n");
                box4.dequeue();
            }

        } catch(IOException e) {
            e.printStackTrace();
        }

        try {
            FileWriter writer5 = new FileWriter(arSave);

            while(!box1.isEmpty()) {
                writer5.write(archiv.top().getFrage() + "\n");
                writer5.write(archiv.top().getAntwort() + "\n");
                archiv.pop();
            }

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void load() {
        File b1save = new File("/saves/box1.txt");
        File b2save = new File("/saves/box2.txt");
        File b3save = new File("/saves/box3.txt");
        File b4save = new File("/saves/box4.txt");
        File arSave = new File("/saves/archiv.txt");
        Scanner scanner;

        try {
            scanner = new Scanner(b1save);

            while(scanner.hasNextLine()) {
                String frage = scanner.nextLine();
                String antwort = scanner.nextLine();
                box1.enqueue(new Karte(frage, antwort));
            }

        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            scanner = new Scanner(b2save);

            while(scanner.hasNextLine()) {
                String frage = scanner.nextLine();
                String antwort = scanner.nextLine();
                box2.enqueue(new Karte(frage, antwort));
            }

        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            scanner = new Scanner(b3save);

            while(scanner.hasNextLine()) {
                String frage = scanner.nextLine();
                String antwort = scanner.nextLine();
                box3.enqueue(new Karte(frage, antwort));
            }

        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            scanner = new Scanner(b4save);

            while(scanner.hasNextLine()) {
                String frage = scanner.nextLine();
                String antwort = scanner.nextLine();
                box4.enqueue(new Karte(frage, antwort));
            }

        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            scanner = new Scanner(arSave);

            while(scanner.hasNextLine()) {
                String frage = scanner.nextLine();
                String antwort = scanner.nextLine();
                archiv.push(new Karte(frage, antwort));
            }

        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void controlAnswer(int pBoxnummer, String pAnswerUser)
    {
        String answerUser=pAnswerUser;
        int boxnummer = pBoxnummer;
        String answer = box1.front().getAntwort();
        switch (boxnummer)
        {
            case (1) :
            if (answerUser.equals(box1.front().getAntwort()))
            { JOptionPane.showMessageDialog(null, "Richtig");
                box2.enqueue(box1.front());
                box1.dequeue();
            } 
            else 
            {   System.out.println("Falsch");
                box1.enqueue(box1.front());
                box1.dequeue();
            }
            break;
            case (2) :
            if (answerUser.equals(box2.front().getAntwort()))
            { JOptionPane.showMessageDialog(null, "Richtig");
                box3.enqueue(box2.front());
                box2.dequeue();
            } 
            else 
            {  JOptionPane.showMessageDialog(null, "Falsch");
                box1.enqueue(box2.front());
                box2.dequeue();
            }
            break;
            case (3) :
            if (answerUser.equals(box3.front().getAntwort()))
            { JOptionPane.showMessageDialog(null, "Richtig");
                box4.enqueue(box3.front());
                box3.dequeue();
            } 
            else 
            {  JOptionPane.showMessageDialog(null, "Falsch");
                box2.enqueue(box3.front());
                box3.dequeue();
            }
            break;
            case (4) :
            if (answerUser.equals(box4.front().getAntwort()))
            { JOptionPane.showMessageDialog(null, "Richtig");
                archiv.push(box4.front());
                box4.dequeue();
            } 
            else 
            {  JOptionPane.showMessageDialog(null, "Falsch");
                box3.enqueue(box4.front());
                box4.dequeue();
            }
            break;
        }
    }

    public int length(int pBoxnummer)
    {
        if (!box1.isEmpty())
        {
            zaehler1 = 0;
            while(!box1.isEmpty())
            { zaehler1=zaehler1+1;
                zaehlen.enqueue(box1.front());
                box1.dequeue();
            }
            while(!zaehlen.isEmpty())
            { box1.enqueue(zaehlen.front());
                zaehlen.dequeue();
            }

        }
        if (!box2.isEmpty())
        {
            zaehler2 = 0;
            while(!box2.isEmpty())
            { zaehler2=zaehler2+1;
                zaehlen.enqueue(box2.front());
                box2.dequeue();
            }
            while(!zaehlen.isEmpty())
            { box2.enqueue(zaehlen.front());
                zaehlen.dequeue();
            }

        }
        if (!box1.isEmpty())
        {
            zaehler3 = 0;
            while(!box3.isEmpty())
            { zaehler3=zaehler3+1;
                zaehlen.enqueue(box3.front());
                box3.dequeue();
            }
            while(!zaehlen.isEmpty())
            { box3.enqueue(zaehlen.front());
                zaehlen.dequeue();
            }

        }
        if (!box4.isEmpty())
        {
            zaehler4 = 0;
            while(!box4.isEmpty())
            { zaehler4=zaehler4+1;
                zaehlen.enqueue(box4.front());
                box4.dequeue();
            }
            while(!zaehlen.isEmpty())
            { box4.enqueue(zaehlen.front());
                zaehlen.dequeue();
            }

        }
        int wantedZaehler = 0;
        switch(pBoxnummer) {
            case(1): wantedZaehler = zaehler1; break;
            case(2): wantedZaehler = zaehler2; break;
            case(3): wantedZaehler = zaehler3; break;
            case(4): wantedZaehler = zaehler4; break;
        }
        return wantedZaehler;
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

        private JLabel jLabel3 = new JLabel();
        private JLabel jLabel4 = new JLabel();
        private JLabel jLabel5 = new JLabel();
        private JLabel jLabel6 = new JLabel();

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
            setTitle("Karteikasten");
            setResizable(false);
            Container cp = getContentPane();
            cp.setLayout(null);
            // Anfang Komponenten

            jLabel2.setBounds(464, 8, 105, 49);
            jLabel2.setText("Karteikasten");
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

            jLabel3.setBounds(125, 400, 105, 49);
            jLabel3.setText("" + length(1));
            cp.add(jLabel3);

            jLabel4.setBounds(310, 400, 105, 49);
            jLabel4.setText("" + length(2));
            cp.add(jLabel4);

            jLabel5.setBounds(500, 400, 105, 49);
            jLabel5.setText("" + length(3));
            cp.add(jLabel5);

            jLabel6.setBounds(680, 400, 105, 49);
            jLabel6.setText("" + length(4));
            cp.add(jLabel6);

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
        private JButton jButton3 = new JButton();
        private JButton jButton4 = new JButton();

        private JLabel jLabel8 = new JLabel();
        private JTextField jTextField3 = new JTextField();
        private JLabel jLabel9 = new JLabel();
        Container cp = getContentPane();

        private int boxnummer;
        // Ende Attribute

        public BoxGUI(int pBoxnummer) { 
            // Frame-Initialisierung
            super();
            boxnummer = pBoxnummer;
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            int frameWidth = 1000; 
            int frameHeight = 500;
            setSize(frameWidth, frameHeight);
            Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
            int x = (d.width - getSize().width) / 2;
            int y = (d.height - getSize().height) / 2;
            setLocation(x, y);
            setTitle("Box " + boxnummer);
            setResizable(false);
            Container cp = getContentPane();
            cp.setLayout(null);
            // Anfang Komponenten

            jLabel1.setBounds(448, 24, 110, 20);
            jLabel1.setText("Box " + boxnummer);
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
            jLabel3.setText("Box abfragen");
            cp.add(jLabel3);
            jButton3.setBounds(282, 116, 110, 20);
            jButton3.setText("Frage anzeigen");
            jButton3.setMargin(new Insets(2, 2, 2, 2));
            jButton3.addActionListener(new ActionListener() { 
                    public void actionPerformed(ActionEvent evt) { 
                        jButton3_ActionPerformed(evt);
                    }
                });
            cp.add(jButton3);
            jTextField3.setBounds(500, 116, 150, 20);
            cp.add(jTextField3);
            jButton2.setBounds(500, 140, 75, 25);
            jButton2.setText("überprüfen");
            jButton2.setMargin(new Insets(2, 2, 2, 2));
            jButton2.addActionListener(new ActionListener() { 
                    public void actionPerformed(ActionEvent evt) { 
                        jButton2_ActionPerformed(evt);
                    }
                });
            cp.add(jButton2);
            jLabel9.setBounds(500, 91, 110, 20);
            jLabel9.setText("Antwort eingeben");
            cp.add(jLabel9);
            jSeparator1.setBounds(36, 53, 916, 26);
            cp.add(jSeparator1);
            jLabel5.setBounds(33, 200, 110, 20);

            jButton4.setBounds(20, 20, 75, 25);
            jButton4.setText("zurück");
            jButton4.setMargin(new Insets(2, 2, 2, 2));
            jButton4.addActionListener(new ActionListener() { 
                    public void actionPerformed(ActionEvent evt) { 
                        jButton4_ActionPerformed(evt);
                    }
                });
            cp.add(jButton4);

            setVisible(true);
        } // end of public BoxGUI1

        // Anfang Methoden

        public void jButton1_ActionPerformed(ActionEvent evt) {
            switch(boxnummer) {
                case(1): box1.enqueue(new Karte(jTextField1.getText(), jTextField2.getText())); out("Neue Karte in Box " + boxnummer + " erstellt!"); break;
                case(2): box2.enqueue(new Karte(jTextField1.getText(), jTextField2.getText())); out("Neue Karte in Box " + boxnummer + " erstellt!"); break;
                case(3): box3.enqueue(new Karte(jTextField1.getText(), jTextField2.getText())); out("Neue Karte in Box " + boxnummer + " erstellt!"); break;
                case(4): box4.enqueue(new Karte(jTextField1.getText(), jTextField2.getText())); out("Neue Karte in Box " + boxnummer + " erstellt!"); break;
            }
        } // end of jButton1_ActionPerformed

        public void jButton2_ActionPerformed(ActionEvent evt) {
            controlAnswer(boxnummer, jTextField3.getText());
        } // end of jButton2_ActionPerformed

        public void jButton3_ActionPerformed(ActionEvent evt) {
            switch(boxnummer) {
                case(1): out(box1.front().getFrage()); break;
                case(2): out(box2.front().getFrage()); break;
                case(3): out(box3.front().getFrage()); break;
                case(4): out(box4.front().getFrage()); break;
            }
        } // end of jButton2_ActionPerformed

        public void jButton4_ActionPerformed(ActionEvent evt) {
            setVisible(false);
            new KastenGUI();
        } // end of jButton2_ActionPerformed
        // Ende Methoden
    } // end of class BoxGUI1

}
