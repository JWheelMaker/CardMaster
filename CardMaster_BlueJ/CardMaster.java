import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
/**
 * @Ernsting & Rademacher Enterprise Inc.
 * @1.0
 */
public class CardMaster
{
    private Karteikasten kk = new Karteikasten();
    public CardMaster()
    {

    }

    public void savetest() {
        kk.save();
    }

    public void loadtest() {
        kk.load();
    }
}
