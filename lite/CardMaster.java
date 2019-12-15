import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
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
