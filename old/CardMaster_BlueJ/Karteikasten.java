import java.util.Scanner; 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
/**
 * @RE Enterprise Inc.
 * @a0.1
 */
public class Karteikasten
{
    // Bezugsobjekte
    public Queue <Karte> box1 = new Queue();
    public Queue <Karte> box2 = new Queue();
    public Queue <Karte> box3 = new Queue();
    public Queue <Karte> box4 = new Queue();
    public Queue <Karte> zaehlen = new Queue();
    public Stack <Karte> archiv = new Stack();
    // Attribute
    private String answerUser="";
    private  int boxnummer;
    public int zaehler1;
    public int zaehler2;
    public int zaehler3;
    public int zaehler4;
    private String q;
    // Konstruktor
    public Karteikasten()
    {

    }

    // Dienste
    public void addCard(int pBoxnummer, Karte pKarte) {
        boxnummer = pBoxnummer;
        Karte karte = pKarte;
        switch (boxnummer) {
            case(1): box1.enqueue(karte); break;
            case(2): box2.enqueue(karte); break;
            case(3): box3.enqueue(karte); break;
            case(4): box4.enqueue(karte); break;
        }
        JOptionPane.showMessageDialog(null, "Die Karte wurde hinzugefügt.");
    }

    public void controlAnswer(String pAnswerUser)
    {
        answerUser=pAnswerUser;
        switch (boxnummer)
        {
            case (1) :
            if (answerUser==box1.front().getAntwort())
            { JOptionPane.showMessageDialog(null, "Richtig");
                box2.enqueue(box1.front());
                box1.dequeue();
            } 
            else 
            {  JOptionPane.showMessageDialog(null, "Falsch");
                box1.enqueue(box1.front());
                box1.dequeue();
            }
            break;
            case (2) :
            if (answerUser==box2.front().getAntwort())
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
            if (answerUser==box3.front().getAntwort())
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
            if (answerUser==box4.front().getAntwort())
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

    public void length()
    {
        if (!box1.isEmpty())
        {
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
    }
    
    public void setBoxnummer(int pBoxnummer)
    { 
        boxnummer=pBoxnummer;
    }
    
    public void question()
    {
        switch (boxnummer)
        {
         case (1) :
         q=box1.front().getFrage();
         break;
         case (2) :
         q=box2.front().getFrage();
         break;
         case (3) :
         q=box3.front().getFrage();
         break;
         case (4) :
         q=box4.front().getFrage();
         break;
         default : 
         break;
        }
    }
    
    public String getQ()
    { return q;}
}