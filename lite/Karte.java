/**
 * @RE Enterprise Inc.
 * @a0.1
 */
public class Karte
{
    // Bezugsobjekte

    // Attribute
    private String frage = ("");
    private String antwort = ("");
    // Konstruktor
    public Karte(String pFrage, String pAntwort)
    {
        antwort = pAntwort;
        frage = pFrage;
    }

    // Dienste
    public String getFrage() {
        return frage;
    }

    public String getAntwort() {
        return antwort;
    }
}
