import java.io.*;
import javax.imageio.*;

import java.awt.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;


public class MojeOkno extends JFrame implements ActionListener
{
    //Tworzymy panele okna głównego
    PanelGraficzny lewy = new PanelGraficzny();
    PanelGraficzny prawy = new PanelGraficzny();   
    //Tworzymy menu okna 
    MenuOkna menu = new MenuOkna();
    //scieżka dostępu wraz z nazwą pliku
    String sciezkaDoPlik;  
    int jasn;
    int kont;
    //Konstruktor
    public MojeOkno() {
        //wywolanie konstruktora klasy nadrzednej (JFrame)
        super("Projekt pierwszy - obrazy rasterowe Klobut Ewelina");
        //ustawienie standardowej akcji po naciśnięciu przycisku zamkniecia
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //blokada zmiany rozmiaru okna
        setResizable (false);
        //rozmieszczenie elementow - menadzer rozkladu
        //FlowLayout ustawia elementy jeden za drugim
        //w tym przypadku dodatkowo wysrodkowane na ekranie, z odstępem w pionie i poziomie
        setLayout(new FlowLayout(FlowLayout.CENTER, 3, 2));
        //setSize(200, 700);
	//setLocation(50,50);
	
        //ustawienie stworzonego menu
        setJMenuBar(menu);
       
        //dodanie paneli
        add(lewy);
        add(prawy);
        
        //przypisanie obsługi akcji
        ustawNasluchZdarzen();        
        dopasujSieDoZawartosci();
        //wyswietlenie naszej ramki
        setVisible(true);
    }

    private void ustawNasluchZdarzen()
    //czyli kto kogo podsłuchuje
    {
        menu.otworzPlik.addActionListener(this); 
        menu.zapiszPlik.addActionListener(this); 
        menu.zakoncz.addActionListener(this);  
        
        menu.szary.addActionListener(this); 
        menu.WyczyscLewy.addActionListener(this);
        menu.WyczyscPrawy.addActionListener(this);  
        
        menu.bSzaryR.addActionListener(this); 
        menu.bSzaryG.addActionListener(this);
        menu.bSzaryB.addActionListener(this);
        menu.juw.addActionListener(this);
        
        menu.negacja.addActionListener(this);
        menu.jasnosc.addActionListener(this);
        menu.bJasnosc.addActionListener(this);
        menu.kontrast.addActionListener(this);
        menu.bKontrast.addActionListener(this);
        menu.zmZakrJas.addActionListener(this);
    }
    //METODY OBSŁUGI ZDARZEŃ DLA INTERFEJSÓW
    //ActionListener
    @Override
    public void actionPerformed(ActionEvent e)
    {
        //pobieramy etykietę z przycisku
        String label = e.getActionCommand();
        if(label.equals("Otworz plik"))
        {
            otworzPlik();
        }      
        else if(label.equals("Zapisz plik"))
        {
            zapiszPlik();
        } 
        else if(label.equals("Zakończ"))
        {
            System.exit(0);
        }    
        else if(label.equals("Wyczyść lewy"))
        {
            lewy.wyczysc();       
        }      
        else if(label.equals("Szary"))
        {
           int w = prawy.plotno.getWidth();
            int h = prawy.plotno.getHeight();            
          
            prawy.kopiuj(lewy.plotno);
            
        }           
        else if(label.equals("Wyczyść prawy"))
        {
            prawy.wyczysc();          
        } 
        
        else if(label.equals("Szary czerwony"))
        {
            int w = prawy.plotno.getWidth();
            int h = prawy.plotno.getHeight();            
           
            prawy.szaryR(lewy.plotno);
                      
        } 
        else if(label.equals("Szary zielony"))
        {
            int w = prawy.plotno.getWidth();
            int h = prawy.plotno.getHeight();            
        
            prawy.szaryG(lewy.plotno);
                      
        }
        
        else if(label.equals("Szary niebieski"))
        {
            int w = prawy.plotno.getWidth();
            int h = prawy.plotno.getHeight();            
           
            prawy.szaryB(lewy.plotno);
                      
        }
        
        else if(label.equals("Szary JUW"))
        {
            int w = prawy.plotno.getWidth();
            int h = prawy.plotno.getHeight();            
           
            prawy.szaryJUW(lewy.plotno);
                      
        }
        
        else if(label.equals("Negacja"))
        {
            int w = prawy.plotno.getWidth();
            int h = prawy.plotno.getHeight();            
            
            prawy.negacja(lewy.plotno);
                      
        }
        else if(label.equals("Jasnść"))
        {
            int w = prawy.plotno.getWidth();
            int h = prawy.plotno.getHeight(); 
            jasn=Integer.parseInt(menu.jasnosc.getText());
         
            prawy.jasnosc(lewy.plotno, jasn);
                      
        }
        else if(label.equals("Kontrast"))
        {
            int w = prawy.plotno.getWidth();
            int h = prawy.plotno.getHeight(); 
            kont=Integer.parseInt(menu.kontrast.getText());
            //skopiuj prawy panel na bazie lewego
            prawy.kontrast(lewy.plotno, kont);
                      
        }
        else if(label.equals("Zmiana zakresu jasności"))
        {
            int w = prawy.plotno.getWidth();
            int h = prawy.plotno.getHeight(); 
            
            prawy.zmiZakJas(lewy.plotno);
                      
        }
    }   

    //akcja w przypadku wyboru "otwórz plik z menu"
    private void otworzPlik()
    {
        //okno dialogowe do wyboru pliku graficznego
        JFileChooser otworz= new JFileChooser();            
        //zdefiniowanie filtra dla wybranych typu plików
        FileNameExtensionFilter filtr = new FileNameExtensionFilter("JPG & BMP & PNG Images", "jpg", "bmp", "png");
        //ustawienie filtra dla JFileChooser
        otworz.setFileFilter(filtr);
        //wyświetlenie okna dialogowego wyboru pliku
        int wynik = otworz.showOpenDialog(this);
        //analiza rezultatu zwróconego przez okno dialogowe
        if (wynik == JFileChooser.APPROVE_OPTION)   
        {
            //wyłuskanie ścieżki do wybranego pliku
            sciezkaDoPlik= otworz.getSelectedFile().getPath();    
            int w = lewy.plotno.getWidth();
            int h = lewy.plotno.getHeight();
            //wczytanie pliku graficznego na lewy panel
            lewy.wczytajPlikGraficzny(sciezkaDoPlik);  
            if(w != lewy.plotno.getWidth() || h != lewy.plotno.getHeight())
               dopasujSieDoZawartosci();
        }
    } 

    private void zapiszPlik()
    {
        //okno dialogowe do wyboru pliku graficznego
        JFileChooser zapisz;
        //otwarcie JFileChoosera w tym samym katalogu, z którego wczytano plik
        if(sciezkaDoPlik != null)
            zapisz = new JFileChooser(sciezkaDoPlik);    
        else
            zapisz = new JFileChooser();
        //zdefiniowanie filtra dla wybranych typu plików
        FileNameExtensionFilter filtr = new FileNameExtensionFilter("JPG & BMP & PNG Images", "jpg", "bmp", "png");
        //ustawienie filtra dla JFileChooser
        zapisz.setFileFilter(filtr);
        //wyświetlenie okna dialogowego wyboru pliku
        int wynik = zapisz.showSaveDialog(this);      
        //analiza rezultatu zwróconego przez okno dialogowe
        if (wynik == JFileChooser.APPROVE_OPTION)   
        {
            //wyłuskanie ścieżki do wybranego pliku
            sciezkaDoPlik= zapisz.getSelectedFile().getPath();    
            //JOptionPane.showMessageDialog(null,"Blad odczytu pliku: " + sciezkaDoPlik); 
            prawy.zapiszPlikGraficzny(sciezkaDoPlik);
        }        
    }

    private void dopasujSieDoZawartosci()
    {
        //dostosowanie okna do zawartości
        pack();   
        //wyśrodkowanie ramki
        setLocationRelativeTo(null);           
    }
}
