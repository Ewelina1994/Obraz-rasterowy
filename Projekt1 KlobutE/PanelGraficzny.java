import java.awt.*;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;

public class PanelGraficzny extends JPanel
{
    //obiekt do przechowywania grafiki
    BufferedImage plotno;
    //konstruktor
    public PanelGraficzny() 
    {
        super();   

        ustawRozmiar(new Dimension(400,400));
        wyczysc();
    }
    //wczytanie obrazka z pliku
    public void wczytajPlikGraficzny(String sciezka) 
    {
        //obiekt reprezentujący plik graficzny o podanej ścieżce
        File plikGraficzny = new File(sciezka);
        //próba odczytania pliku graficznego do bufora
        try {
            plotno = ImageIO.read(plikGraficzny);  
            //odczytanie rozmiaru obrazka
            Dimension rozmiar = new Dimension(plotno.getWidth(), plotno.getHeight());        
            //ustalenie rozmiaru panelu zgodnego z rozmiarem obrazka
            //setPreferredSize(rozmiar);
            //setMaximumSize(rozmiar);
            //ustalenie obramowania
            setBorder(BorderFactory.createLineBorder(Color.black));    
            repaint();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Blad odczytu pliku: " + sciezka); 
            e.printStackTrace();
        }
    }  

    public void zapiszPlikGraficzny(String sciezka)
    {
        //obiekt reprezentujący plik graficzny o podanej ścieżce
        File plikGraficzny = new File(sciezka); 
        //próba zapisania pliku graficznego z bufora
        try {
            if(plotno != null)
            {
                if(!ImageIO.write(plotno, sciezka.substring(sciezka.lastIndexOf('.') + 1), new File(sciezka)))
                {
                    JOptionPane.showMessageDialog(null,"Nie udało sie zapisać pliku w " + sciezka);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Brak obrazu do zapisania");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Nie udało sie zapisać pliku w " + sciezka);
        } 
    }

    public void wyczysc()
    {
        //wyrysowanie białego tła
        Graphics2D g = (Graphics2D) plotno.getGraphics();
        g.setColor(Color.white);
        g.fillRect(0, 0, plotno.getWidth(), plotno.getHeight());
        //ustalenie obramowania
        setBorder(BorderFactory.createLineBorder(Color.black)); 
        repaint();
    }

    public void ustawRozmiar(Dimension r)
    {
        plotno = new BufferedImage((int)r.getWidth(), (int)r.getHeight(), BufferedImage.TYPE_INT_RGB);
        setPreferredSize(r);     
        setMaximumSize(r);
    }

    public void kopiuj(BufferedImage wejscie)
    {
        ustawRozmiar(new Dimension(wejscie.getWidth(),wejscie.getHeight()));         
        Color ci;
        int czerw, ziel, nieb;

        for(int i=0; i<wejscie.getWidth(); i++)
            for(int j=0; j<wejscie.getHeight(); j++)
            {
                //jak dostać się do składowych poszczególnych pikseli w obiekcie BufferedImage
                ci = new Color(wejscie.getRGB(i,j)); 
                czerw = ci.getRed();
                ziel = ci.getGreen();
                nieb = ci.getBlue();

                int sz = (czerw+ziel+nieb)/3;
                //jak ustawić kolor piksala w obiekcie BufferedImage
                Color gColor= new Color(sz, sz, sz);
                plotno.setRGB(i,j,gColor.getRGB());
            }  
        repaint();

    }

    public void szaryR(BufferedImage wejscie)
    {
        ustawRozmiar(new Dimension(wejscie.getWidth(),wejscie.getHeight()));         
        Color ci;
        int czerw, ziel, nieb, a;

        for(int i=0; i<wejscie.getWidth(); i++)
            for(int j=0; j<wejscie.getHeight(); j++)
            {
                //jak dostać się do składowych poszczególnych pikseli w obiekcie BufferedImage
                ci = new Color(wejscie.getRGB(i,j)); 
                czerw = ci.getRed();
                ziel = ci.getGreen();
                nieb = ci.getBlue();

                int sz = czerw;
                //jak ustawić kolor piksala w obiekcie BufferedImage
                Color gColor= new Color(sz, sz, sz);
                plotno.setRGB(i,j,gColor.getRGB());
            }  
        repaint();

    }

    public void szaryG(BufferedImage wejscie)
    {
        ustawRozmiar(new Dimension(wejscie.getWidth(),wejscie.getHeight()));         
        Color ci;
        int czerw, ziel, nieb, a;

        for(int i=0; i<wejscie.getWidth(); i++)
            for(int j=0; j<wejscie.getHeight(); j++)
            {
                //jak dostać się do składowych poszczególnych pikseli w obiekcie BufferedImage
                ci = new Color(wejscie.getRGB(i,j)); 
                czerw = ci.getRed();
                ziel = ci.getGreen();
                nieb = ci.getBlue();

                int sz = ziel;
                //jak ustawić kolor piksala w obiekcie BufferedImage
                Color gColor= new Color(sz, sz, sz);
                plotno.setRGB(i,j,gColor.getRGB());
            }  
        repaint();

    }

    public void szaryB(BufferedImage wejscie)
    {
        ustawRozmiar(new Dimension(wejscie.getWidth(),wejscie.getHeight()));         
        Color ci;
        int czerw, ziel, nieb;

        for(int i=0; i<wejscie.getWidth(); i++)
            for(int j=0; j<wejscie.getHeight(); j++)
            {
                //jak dostać się do składowych poszczególnych pikseli w obiekcie BufferedImage
                ci = new Color(wejscie.getRGB(i,j)); 
                czerw = ci.getRed();
                ziel = ci.getGreen();
                nieb = ci.getBlue();

                int sz = nieb;
                //jak ustawić kolor piksala w obiekcie BufferedImage
                Color gColor= new Color(sz, sz, sz);
                plotno.setRGB(i,j,gColor.getRGB());
            }  
        repaint();

    }

    public void szaryJUW(BufferedImage wejscie)
    {
        ustawRozmiar(new Dimension(wejscie.getWidth(),wejscie.getHeight()));         
        Color ci;
        float czerw, ziel, nieb;

        for(int i=0; i<wejscie.getWidth(); i++)
            for(int j=0; j<wejscie.getHeight(); j++)
            {
                //jak dostać się do składowych poszczególnych pikseli w obiekcie BufferedImage
                ci = new Color(wejscie.getRGB(i,j)); 
                czerw = ci.getRed();
                ziel = ci.getGreen();
                nieb = ci.getBlue();

                int sz = (int)(0.299 *czerw) + (int)(0.587*ziel) + (int)(0.114*nieb);
                //jak ustawić kolor piksala w obiekcie BufferedImage
                Color gColor= new Color(sz, sz, sz);
                plotno.setRGB(i,j,gColor.getRGB());
            }  
        repaint();
        //sreednia wazona
        //negacja

    }

    public void jasnosc(BufferedImage wejscie, int k)
    {
        ustawRozmiar(new Dimension(wejscie.getWidth(),wejscie.getHeight()));         
        Color ci;

        for(int i=0; i<wejscie.getWidth(); i++)
            for(int j=0; j<wejscie.getHeight(); j++)
            {
                //jak dostać się do składowych poszczególnych pikseli w obiekcie BufferedImage
                ci = new Color(wejscie.getRGB(i,j)); 
                int czerw = ci.getRed()+k;
                int ziel = ci.getGreen()+k;
                int nieb = ci.getBlue()+k;
                
                if(czerw > 255)
                    czerw = 255;
                else if(czerw < 0)
                    czerw = 0;
                if(ziel > 255)
                    ziel = 255;
                else if(ziel < 0)
                    ziel = 0;
                if(nieb > 255)
                    nieb = 255;
                else if(nieb < 0)
                    nieb = 0;

                //jak ustawić kolor piksala w obiekcie BufferedImage
                Color gColor= new Color(czerw, ziel, nieb);
                plotno.setRGB(i,j,gColor.getRGB());
            }  
        repaint();

    }

    public void kontrast(BufferedImage wejscie, int k)
    {
        ustawRozmiar(new Dimension(wejscie.getWidth(),wejscie.getHeight()));         
        Color ci;
        
        int czerw, ziel, nieb;
        
        for(int i=0;i<wejscie.getWidth();i++)
        {
            for(int j=0;j<wejscie.getHeight();j++)
            {

                ci = new Color(wejscie.getRGB(i,j));
                czerw = ci.getRed()*k;
                ziel = ci.getGreen()*k;
                nieb =ci.getBlue()*k;

                if(czerw > 255)
                    czerw = 255;
                else if(czerw < 0)
                    czerw = 0;
                if(ziel > 255)
                    ziel = 255;
                else if(ziel < 0)
                    ziel = 0;
                if(nieb > 255)
                    nieb = 255;
                else if(nieb < 0)
                    nieb = 0;

                Color gColor= new Color(czerw, ziel, nieb);
                plotno.setRGB(i,j,gColor.getRGB());
            }  
            repaint();
        }
    }

    public void negacja(BufferedImage wejscie)
    {
        ustawRozmiar(new Dimension(wejscie.getWidth(),wejscie.getHeight()));         
        Color ci;
        int czerw, ziel, nieb, a;

        for(int i=0; i<wejscie.getWidth(); i++)
            for(int j=0; j<wejscie.getHeight(); j++)
            {
                //jak dostać się do składowych poszczególnych pikseli w obiekcie BufferedImage
                ci = new Color(wejscie.getRGB(i,j)); 
                czerw = 255-ci.getRed();
                ziel = 255-ci.getGreen();
                nieb = 255-ci.getBlue();

                //jak ustawić kolor piksala w obiekcie BufferedImage
                Color gColor= new Color(czerw, ziel, nieb);
                plotno.setRGB(i,j,gColor.getRGB());
            }  
        repaint();
    }

    public void zmiZakJas(BufferedImage wejscie)
    {
        ustawRozmiar(new Dimension(wejscie.getWidth(),wejscie.getHeight()));         
        Color ci;
        int czerw, ziel, nieb;
        int LmaxR = 0;
        int LminR = 255;
        int LmaxG = 0;
        int LminG = 255;
        int LmaxB = 0;
        int LminB = 255;
        for(int i=0; i<wejscie.getWidth(); i++)
        {
            for(int j=0; j<wejscie.getHeight(); j++)
            {
                //jak dostać się do składowych poszczególnych pikseli w obiekcie BufferedImage
                ci = new Color(wejscie.getRGB(i,j)); 
                czerw =ci.getRed();
                ziel = ci.getGreen();
                nieb =ci.getBlue();

                if(czerw > LmaxR)
                    LmaxR = (int)czerw;
                else if(ziel > LmaxG)
                    LmaxG = (int)ziel;
                else if(nieb > LmaxB)
                    LmaxB = (int)nieb;

                if(czerw < LminR)
                    LminR = (int)czerw;
                else if(ziel < LminG)
                    LminG = (int)ziel;
                else if(nieb < LminB)
                    LminB = (int)nieb;
            }

        }
        for(int i=0;i<wejscie.getWidth();i++)
        {
            for(int j=0;j<wejscie.getHeight();j++)
            {

                ci = new Color(wejscie.getRGB(i,j));
                int dzielR=LmaxR-LminR;
                if(dzielR==0) dzielR=1;
                int dzielG=LmaxR-LminR;
                if(dzielG==0) dzielG=1;
                int dzielB=LmaxR-LminR;
                if(dzielB==0) dzielB=1;
                
                czerw = (255*(ci.getRed()-LminR))/dzielR;
                ziel = (255*(ci.getGreen()-LminG))/dzielG;
                nieb = (255*(ci.getBlue()-LminB))/dzielB;

                if(czerw > 255)
                    czerw = 255;
                else if(czerw < 0)
                    czerw = 0;
                if(ziel > 255)
                    ziel = 255;
                else if(ziel < 0)
                    ziel = 0;
                if(nieb > 255)
                    nieb = 255;
                else if(nieb < 0)
                    nieb = 0;

                Color gColor= new Color((int)czerw, (int)ziel, (int)nieb);
                plotno.setRGB(i,j,gColor.getRGB());
            }  
            repaint();
        }
    }

    //przesłonięta metoda paintComponent z klasy JPanel do rysowania
    @Override
    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        //wyrysowanie naszego płótna na panelu 
        g2d.drawImage(plotno, 0, 0, this);
    }    

}
