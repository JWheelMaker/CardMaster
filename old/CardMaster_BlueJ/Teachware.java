import java.util.Scanner; 


public class Teachware
{
    public void options()
    {
        int opt;
        Scanner scan = new Scanner(System.in);
        
        //Einfache Anzeige der Optionen auf dem Terminal (Dies können Sie auch auf andere Weise umsetzen).
        System.out.println("(1) Karte anlegen | (2) Box lernen | (3) Programm beenden");
        opt = scan.nextInt();
        
        switch (opt)
        {
            case 1: addCard(); break;
            case 2: learnBox(); break;
            case 3: break;
            default: options(); break; //rekursiver Methodenaufruf
        }
        
    }
    
    public void addCard(){}
    public void learnBox(){}
}
