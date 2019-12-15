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
    private int boxnummer;
    private Karte karte;

    // Konstruktor
    public Karteikasten()
    {

    }

    // Dienste
    public void addCard(int pBoxnummer, Karte pKarte) {
        boxnummer = pBoxnummer;
        karte = pKarte;
        switch (boxnummer) {
            case(1): box1.enqueue(karte); save(1, karte); break;
            case(2): box2.enqueue(karte); break;
            case(3): box3.enqueue(karte); break;
            case(4): box4.enqueue(karte); break;
        }
    }

    public void save(int boxnummer, Karte karte) {
        try {
            File b1Save = new File("saves/box1.txt");
            File b2Save = new File("saves/box2.txt");
            File b3Save = new File("saves/box3.txt");
            File b4Save = new File("saves/box4.txt");
            File archivSave = new File("saves/archiv.txt");
            FileWriter writer1 = new FileWriter(b1Save);
            FileWriter writer2 = new FileWriter(b2Save);
            FileWriter writer3 = new FileWriter(b3Save);
            FileWriter writer4 = new FileWriter(b4Save);
            FileWriter writer5 = new FileWriter(archivSave);

            switch (boxnummer) {
                case(1): writer1.write(karte.getFrage() + "\n" + karte.getAntwort() + "\n"); break;
                case(2): writer2.write(karte.getFrage() + "\n" + karte.getAntwort() + "\n"); break;
                case(3): writer3.write(karte.getFrage() + "\n" + karte.getAntwort() + "\n"); break;
                case(4): writer4.write(karte.getFrage() + "\n" + karte.getAntwort() + "\n"); break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void load() {
        try {
            File b1Save = new File("saves/box1.txt");
            File b2Save = new File("saves/box2.txt");
            File b3Save = new File("saves/box3.txt");
            File b4Save = new File("saves/box4.txt");
            File archivSave = new File("saves/archiv.txt");
            Scanner scanner1 = new Scanner(b1Save);
            Scanner scanner2 = new Scanner(b2Save);
            Scanner scanner3 = new Scanner(b3Save);
            Scanner scanner4 = new Scanner(b4Save);
            Scanner scanner5 = new Scanner(archivSave);

            while(scanner1.hasNextLine()) {
                String lineFrage = scanner1.nextLine();
                String lineAntwort = scanner1.nextLine();
                box1.enqueue(new Karte(lineFrage, lineAntwort));
            }

            scanner.close();

        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}