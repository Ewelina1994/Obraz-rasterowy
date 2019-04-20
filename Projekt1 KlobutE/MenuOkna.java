import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JTextField;
public class MenuOkna extends JMenuBar
{
    JMenu plik = new JMenu("Plik");
    JMenuItem otworzPlik = new JMenuItem("Otworz plik");
    JMenuItem zapiszPlik = new JMenuItem("Zapisz plik");
    JMenuItem  zakoncz = new JMenuItem("Zakończ");
    
    JMenu LewyPanel=new JMenu("Lewy panel");
    JMenuItem WyczyscLewy=new JMenuItem("Wyczyść lewy");
    
    JMenu PrawyPanel=new JMenu("Prawy panel");
    JMenuItem WyczyscPrawy=new JMenuItem("Wyczyść prawy");
    
    JMenu operacje = new JMenu("Operacje");
    JMenuItem szary=new JMenuItem("Szary");
    JMenuItem bSzaryR=new JMenuItem("Szary czerwony");
    JMenuItem bSzaryG=new JMenuItem("Szary zielony");
    JMenuItem bSzaryB=new JMenuItem("Szary niebieski");
    JMenuItem juw=new JMenuItem("Szary JUW");
    JMenuItem negacja=new JMenuItem("Negacja");
    JMenuItem zmZakrJas=new JMenuItem("Zmiana zakresu jasności");
    
    JTextField jasnosc=new JTextField();
    JButton bJasnosc=new JButton("Jasnść");
    JTextField kontrast=new JTextField();
    JButton bKontrast=new JButton("Kontrast");
    
    public MenuOkna()
    {
        //menu Plik
        plik.add(otworzPlik);
        plik.add(zapiszPlik);        
        //linia oddzielająca JMenuItem        
        plik.add(new JSeparator());        
        plik.add(zakoncz);     
        add(plik);  
        
        LewyPanel.add(WyczyscLewy);
        add(LewyPanel);      
        
        PrawyPanel.add(WyczyscPrawy);
        add(PrawyPanel); 
        
        operacje.add(szary);
        operacje.add(bSzaryR);
        operacje.add(bSzaryG);
        operacje.add(bSzaryB);
        operacje.add(juw);
        operacje.add(zmZakrJas);
        operacje.add(negacja);
        add(operacje); 
        
        add(bJasnosc);
        add(jasnosc);
        add(bKontrast);
        add(kontrast);
        /*
        bSkaluj.setBounds(50,100,100,20);
        bWyczyscLewy.setBounds(150,100,100,20);
        bWyczyscPrawy.setBounds(250,100,100,20);
       
        */
        //plik.add(bSkaluj);
    }
}
