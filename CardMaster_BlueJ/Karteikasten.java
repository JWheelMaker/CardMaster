import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.BufferedReader;
public class Karteikasten
{
    private Queue <Karte> box1 = new Queue();
    private Queue <Karte> box2 = new Queue();
    private Queue <Karte> box3 = new Queue();
    private Queue <Karte> box4 = new Queue();

    private Stack <Karte> archiv = new Stack();

    public Queue <Karte> zaehlen = new Queue();
    public Stack <Karte> zaehlenStack = new Stack();

    public int zaehler1;
    public int zaehler2;
    public int zaehler3;
    public int zaehler4;
    public int zaehler5;

    public String textLabel10;

    public Karteikasten()
    {
        new KastenGUI();
    }

    public void out(String pOutput) {
        System.out.println(pOutput);
    }

    public void save() {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new BufferedWriter(new FileWriter("saves/box1.txt")));
            while(!box1.isEmpty()) {
                pw.println(box1.front().getFrage());
                pw.println(box1.front().getAntwort());

                zaehlen.enqueue(box1.front());
                box1.dequeue();
            }

            while(!zaehlen.isEmpty()) {
                box1.enqueue(zaehlen.front());
                zaehlen.dequeue();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (pw != null){
                pw.flush();
                pw.close();
            }
        }

        try {
            pw = new PrintWriter(new BufferedWriter(new FileWriter("saves/box2.txt")));
            while(!box2.isEmpty()) {
                pw.println(box2.front().getFrage());
                pw.println(box2.front().getAntwort());

                zaehlen.enqueue(box2.front());
                box2.dequeue();
            }

            while(!zaehlen.isEmpty()) {
                box2.enqueue(zaehlen.front());
                zaehlen.dequeue();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (pw != null){
                pw.flush();
                pw.close();
            }
        }

        try {
            pw = new PrintWriter(new BufferedWriter(new FileWriter("saves/box3.txt")));
            while(!box3.isEmpty()) {
                pw.println(box3.front().getFrage());
                pw.println(box3.front().getAntwort());

                zaehlen.enqueue(box3.front());
                box3.dequeue();
            }

            while(!zaehlen.isEmpty()) {
                box3.enqueue(zaehlen.front());
                zaehlen.dequeue();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (pw != null){
                pw.flush();
                pw.close();
            }
        }

        try {
            pw = new PrintWriter(new BufferedWriter(new FileWriter("saves/box4.txt")));
            while(!box4.isEmpty()) {
                pw.println(box4.front().getFrage());
                pw.println(box4.front().getAntwort());

                zaehlen.enqueue(box4.front());
                box4.dequeue();
            }

            while(!zaehlen.isEmpty()) {
                box4.enqueue(zaehlen.front());
                zaehlen.dequeue();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (pw != null){
                pw.flush();
                pw.close();
            }
        }

        try {
            pw = new PrintWriter(new BufferedWriter(new FileWriter("saves/archiv.txt")));
            while(!archiv.isEmpty()) {
                pw.println(archiv.top().getFrage());
                pw.println(archiv.top().getAntwort());

                zaehlenStack.push(archiv.top());
                archiv.pop();
            }

            while(!zaehlenStack.isEmpty()) {
                archiv.push(zaehlenStack.top());
                zaehlenStack.pop();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (pw != null){
                pw.flush();
                pw.close();
            }
        }
    }

    public void load() {
        File file1 = new File("saves/box1.txt");
        if (!file1.canRead() || !file1.isFile()) {
            System.exit(0);
        }
        BufferedReader in1 = null;
        try {
            in1 = new BufferedReader(new FileReader("saves/box1.txt"));
            String zeile = null;
            while ((zeile = in1.readLine()) != null) {
                String frage = zeile;
                String antwort = in1.readLine();
                box1.enqueue(new Karte(frage, antwort));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in1 != null)
                try {
                    in1.close();
                } catch (IOException e) {
                }
        }

        File file2 = new File("saves/box2.txt");
        if (!file2.canRead() || !file2.isFile()) {
            System.exit(0);
        }
        BufferedReader in2 = null;
        try {
            in2 = new BufferedReader(new FileReader("saves/box2.txt"));
            String zeile = null;
            while ((zeile = in2.readLine()) != null) {
                String frage = zeile;
                String antwort = in2.readLine();
                box2.enqueue(new Karte(frage, antwort));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in2 != null)
                try {
                    in2.close();
                } catch (IOException e) {
                }
        }

        File file3 = new File("saves/box3.txt");
        if (!file3.canRead() || !file3.isFile()) {
            System.exit(0);
        }
        BufferedReader in3 = null;
        try {
            in3 = new BufferedReader(new FileReader("saves/box3.txt"));
            String zeile = null;
            while ((zeile = in3.readLine()) != null) {
                String frage = zeile;
                String antwort = in3.readLine();
                box3.enqueue(new Karte(frage, antwort));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in3 != null)
                try {
                    in3.close();
                } catch (IOException e) {
                }
        }

        File file4 = new File("saves/box4.txt");
        if (!file4.canRead() || !file4.isFile()) {
            System.exit(0);
        }
        BufferedReader in4 = null;
        try {
            in4 = new BufferedReader(new FileReader("saves/box4.txt"));
            String zeile = null;
            while ((zeile = in4.readLine()) != null) {
                String frage = zeile;
                String antwort = in4.readLine();
                box4.enqueue(new Karte(frage, antwort));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in4 != null)
                try {
                    in4.close();
                } catch (IOException e) {
                }
        }

        File file5 = new File("saves/archiv.txt");
        if (!file5.canRead() || !file5.isFile()) {
            System.exit(0);
        }
        BufferedReader in5 = null;
        try {
            in5 = new BufferedReader(new FileReader("saves/archiv.txt"));
            String zeile = null;
            while ((zeile = in5.readLine()) != null) {
                String frage = zeile;
                String antwort = in5.readLine();
                archiv.push(new Karte(frage, antwort));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in5 != null)
                try {
                    in5.close();
                } catch (IOException e) {
                }
        }
    }

    public void controlAnswer(int pBoxnummer, String pAnswerUser)
    {
        String answerUser=pAnswerUser;
        int boxnummer = pBoxnummer;
        switch (boxnummer)
        {
            case (1) :
            if (answerUser.equals(box1.front().getAntwort()))
            { textLabel10="Richtig";
                box2.enqueue(box1.front());
                box1.dequeue();
            } 
            else 
            {   textLabel10="Falsch, richtig wäre " + box1.front().getAntwort();
                box1.enqueue(box1.front());
                box1.dequeue();
            }
            break;
            case (2) :
            if (answerUser.equals(box2.front().getAntwort()))
            { textLabel10="Richtig";
                box3.enqueue(box2.front());
                box2.dequeue();
            } 
            else 
            {  textLabel10="Falsch, richtig wäre " + box2.front().getAntwort();
                box1.enqueue(box2.front());
                box2.dequeue();
            }
            break;
            case (3) :
            if (answerUser.equals(box3.front().getAntwort()))
            { textLabel10="Richtig";
                box4.enqueue(box3.front());
                box3.dequeue();
            } 
            else 
            {  textLabel10="Falsch, richtig wäre " + box3.front().getAntwort();
                box2.enqueue(box3.front());
                box3.dequeue();
            }
            break;
            case (4) :
            if (answerUser.equals(box4.front().getAntwort()))
            { textLabel10="Richtig";
                archiv.push(box4.front());
                box4.dequeue();
            } 
            else 
            {  textLabel10="Falsch, richtig wäre " + box4.front().getAntwort();
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

        } else {zaehler1 = 0;}
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

        } else {zaehler2 = 0;}
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

        } else {zaehler3 = 0;}
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

        } else {zaehler4 = 0;}

        int wantedZaehler = 0;
        switch(pBoxnummer) {
            case(1): wantedZaehler = zaehler1; break;
            case(2): wantedZaehler = zaehler2; break;
            case(3): wantedZaehler = zaehler3; break;
            case(4): wantedZaehler = zaehler4; break;
        }
        return wantedZaehler;
    }

    public void archivAusgeben() {
        int i = 1;
        out("Folgende Karten leigen bereits im Archiv (Frage/Antwort)");
        out("");
        while(!archiv.isEmpty()) {
            zaehlenStack.push(archiv.top());
            archiv.pop();
        }
        while(!zaehlenStack.isEmpty()){
            System.out.print(i + ". " + zaehlenStack.top().getFrage());
            out(" " + zaehlenStack.top().getAntwort());

            archiv.push(zaehlenStack.top());
            zaehlenStack.pop();

            i += 1;
        }
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

        private JButton jButton6 = new JButton();
        private JButton jButton7 = new JButton();

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

            jButton6.setBounds(10, 10, 75, 25);
            jButton6.setText("speichern");
            jButton6.setMargin(new Insets(2, 2, 2, 2));
            jButton6.addActionListener(new ActionListener() { 
                    public void actionPerformed(ActionEvent evt) { 
                        jButton6_ActionPerformed(evt);
                    }
                });
            cp.add(jButton6);

            jButton7.setBounds(90, 10, 75, 25);
            jButton7.setText("laden");
            jButton7.setMargin(new Insets(2, 2, 2, 2));
            jButton7.addActionListener(new ActionListener() { 
                    public void actionPerformed(ActionEvent evt) { 
                        jButton7_ActionPerformed(evt);
                    }
                });
            cp.add(jButton7);
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
            archivAusgeben();
        } // end of jButton5_ActionPerformed

        public void jButton6_ActionPerformed(ActionEvent evt) {
            save();
        }

        public void jButton7_ActionPerformed(ActionEvent evt) {
            load();
            new KastenGUI();
            setVisible(false);
        }
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
        private JLabel jLabel10 = new JLabel();
        private JLabel jLabel11 = new JLabel();
        private JLabel jLabel12 = new JLabel();

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

            jLabel10.setBounds(500, 80, 200, 200);
            jLabel10.setText("");
            cp.add(jLabel10);

            jLabel11.setBounds(282, 140, 110, 20);
            jLabel11.setText("");
            cp.add(jLabel11);

            jLabel12.setBounds(60, 195, 200, 35);
            jLabel12.setText("");
            cp.add(jLabel12);

            setVisible(true);
        } // end of public BoxGUI1

        // Anfang Methoden

        public void jButton1_ActionPerformed(ActionEvent evt) {
            if(!jTextField1.getText().equals("") && !jTextField2.getText().equals("")) {
                switch(boxnummer) {
                    case(1): box1.enqueue(new Karte(jTextField1.getText(), jTextField2.getText())); break;
                    case(2): box2.enqueue(new Karte(jTextField1.getText(), jTextField2.getText())); break;
                    case(3): box3.enqueue(new Karte(jTextField1.getText(), jTextField2.getText())); break;
                    case(4): box4.enqueue(new Karte(jTextField1.getText(), jTextField2.getText())); break;
                }
                jLabel12.setText("Neue Karte in Box " + boxnummer + " erstellt!");
                jTextField1.setText("");
                jTextField2.setText("");
            } else {
                jLabel12.setText("Bitte füllen Sie alle Felder aus!");
            }
        } // end of jButton1_ActionPerformed
        public void jButton2_ActionPerformed(ActionEvent evt) {
            switch(boxnummer) {
                case(1): if(!box1.isEmpty()) {controlAnswer(boxnummer, jTextField3.getText()); jLabel10.setText(textLabel10); break;}
                else {jLabel10.setText("Box " + boxnummer + " ist leer!"); } break;
                case(2): if(!box2.isEmpty()) {controlAnswer(boxnummer, jTextField3.getText()); jLabel10.setText(textLabel10); break;}
                else {jLabel10.setText("Box " + boxnummer + " ist leer!"); } break;
                case(3): if(!box3.isEmpty()) {controlAnswer(boxnummer, jTextField3.getText()); jLabel10.setText(textLabel10); break;}
                else {jLabel10.setText("Box " + boxnummer + " ist leer!"); } break;
                case(4): if(!box4.isEmpty()) {controlAnswer(boxnummer, jTextField3.getText()); jLabel10.setText(textLabel10); break;}
                else {jLabel10.setText("Box " + boxnummer + " ist leer!"); } break;
            }
            jTextField3.setText("");
        } // end of jButton2_ActionPerformed

        public void jButton3_ActionPerformed(ActionEvent evt) {
            switch(boxnummer) {
                case(1): if(!box1.isEmpty()) {jLabel11.setText(box1.front().getFrage()); break;}
                else {jLabel11.setText("Box " + boxnummer + " ist leer!"); } break;
                case(2): if(!box2.isEmpty()) {jLabel11.setText(box2.front().getFrage()); break;}
                else {jLabel11.setText("Box " + boxnummer + " ist leer!"); } break;
                case(3): if(!box3.isEmpty()) {jLabel11.setText(box3.front().getFrage()); break;}
                else {jLabel11.setText("Box " + boxnummer + " ist leer!"); } break;
                case(4): if(!box4.isEmpty()) {jLabel11.setText(box4.front().getFrage()); break;}
                else {jLabel11.setText("Box " + boxnummer + " ist leer!"); } break;
            }
        } // end of jButton2_ActionPerformed

        public void jButton4_ActionPerformed(ActionEvent evt) {
            setVisible(false);
            new KastenGUI();
        } // end of jButton2_ActionPerformed
        // Ende Methoden
    } // end of class BoxGUI1
}