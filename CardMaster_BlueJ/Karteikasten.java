import java.util.Scanner; 
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
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
    public Stack <Karte> archiv = new Stack();
    // Attribute

    // Konstruktor
    public Karteikasten()
    {

    }

    // Dienste
    public void addCard(int pBoxnummer, Karte pKarte) {
        int boxnummer = pBoxnummer;
        Karte karte = pKarte;
        switch (boxnummer) {
            case(1): box1.enqueue(karte); break;
            case(2): box2.enqueue(karte); break;
            case(3): box3.enqueue(karte); break;
            case(4): box4.enqueue(karte); break;
        }
    }

    public static void save() {
        FileWriter writer;
        File datei = new File("saves/save.txt");

        try {
            writer = new FileWriter(datei, true);
            writer.write("Ich bin eine Datei!\n");
            writer.write("HAllo");
            writer.write("Test");
            writer.flush();
            writer.close();

            //anwenden für karten speichern
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void load() {
        try {
            File datei = new File("saves/save.txt");
            Scanner scanner = new Scanner(datei);

            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
                System.out.println(" (" + line.length() + ")");
            }
            
            scanner.close();

        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}