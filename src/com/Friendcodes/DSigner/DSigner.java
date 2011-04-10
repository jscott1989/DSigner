/******************************************************************************
*    DSigner Lite - A Decal Editor for Nintendo DS Games                      *
*    Copyright (C) 2007 Jonathan Scott                                        *
*                                                                             *
*    This program is free software; you can redistribute it and/or modify     *
*    it under the terms of the GNU General Public License as published by     *
*    the Free Software Foundation; either version 2 of the License, or        *
*    (at your option) any later version.                                      *
*                                                                             *
*    This program is distributed in the hope that it will be useful,          *
*    but WITHOUT ANY WARRANTY; without even the implied warranty of           *
*    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the            *
*    GNU General Public License for more details.                             *
*                                                                             *
*    You should have received a copy of the GNU General Public License along  *
*    with this program; if not, write to the Free Software Foundation, Inc.,  *
*    51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.              *
*                                                                             *
*    You can contact the original author at sunderlandafc@gmail.com           *
******************************************************************************/
package com.Friendcodes.DSigner;

import java.net.*;
import java.io.*;
import java.util.*;
import java.util.List;
import com.Friendcodes.DS.*;
import java.awt.image.*;
import java.awt.geom.*;
import java.awt.*;
import javax.imageio.*;
import javax.swing.*;

import com.Friendcodes.DSigner.Tools.*;

/** 
 * @author Jonathan Scott
 * @version b5
 */
public class DSigner {
    public static final String DSignerServer = "friendcodes.com";
    public static BufferedImage imgOriginal = new BufferedImage(64,64,BufferedImage.TYPE_INT_RGB);
    public static GameImage imgEditing = new GameImage(GameImage.MARIO_KART,imgOriginal);
    public static Graphics2D g2Original = (Graphics2D) imgOriginal.getGraphics();
    public static final int GAME_MARIO_KART = 0;
    public static final int GAME_ANIMAL_CROSSING_WILD_WORLD = 1;
    public static final int GAME_NEED_FOR_SPEED_MOST_WANTED = 2;
    public static final int GAME_NEED_FOR_SPEED_UNDERGROUND_2 = 3;
    public static final int GAME_TONY_HAWKS_AMERICAN_SK8LAND = 4;
    public static int currentgame = 0;
    public static int currentpalette = 0;
    private static DSignerColorButton selColor = new DSignerColorButton(Color.BLACK,0,false);
    private static List<Game> game = new ArrayList<Game>();
    private static DSignerTool currenttool = new DSignerTool("Pencil",new DSignerPencilController());
    
    static {
        game.add(new Game("Mario Kart"));
        game.get(GAME_MARIO_KART).addPalette("Mario Kart",GameImage.MARIO_KART);
        game.add(new Game("Animal Crossing: Wild World"));
        game.get(GAME_ANIMAL_CROSSING_WILD_WORLD).addPalette("Palette 1", GameImage.ANIMAL_CROSSING_1);
        game.get(GAME_ANIMAL_CROSSING_WILD_WORLD).addPalette("Palette 2", GameImage.ANIMAL_CROSSING_2);
        game.get(GAME_ANIMAL_CROSSING_WILD_WORLD).addPalette("Palette 3", GameImage.ANIMAL_CROSSING_3);
        game.get(GAME_ANIMAL_CROSSING_WILD_WORLD).addPalette("Palette 4", GameImage.ANIMAL_CROSSING_4);
        game.get(GAME_ANIMAL_CROSSING_WILD_WORLD).addPalette("Palette 5", GameImage.ANIMAL_CROSSING_5);
        game.get(GAME_ANIMAL_CROSSING_WILD_WORLD).addPalette("Palette 6", GameImage.ANIMAL_CROSSING_6);
        game.get(GAME_ANIMAL_CROSSING_WILD_WORLD).addPalette("Palette 7", GameImage.ANIMAL_CROSSING_7);
        game.get(GAME_ANIMAL_CROSSING_WILD_WORLD).addPalette("Palette 8", GameImage.ANIMAL_CROSSING_8);
        game.get(GAME_ANIMAL_CROSSING_WILD_WORLD).addPalette("Palette 9", GameImage.ANIMAL_CROSSING_9);
        game.get(GAME_ANIMAL_CROSSING_WILD_WORLD).addPalette("Palette 10", GameImage.ANIMAL_CROSSING_10);
        game.get(GAME_ANIMAL_CROSSING_WILD_WORLD).addPalette("Palette 11", GameImage.ANIMAL_CROSSING_11);
        game.get(GAME_ANIMAL_CROSSING_WILD_WORLD).addPalette("Palette 12", GameImage.ANIMAL_CROSSING_12);
        game.get(GAME_ANIMAL_CROSSING_WILD_WORLD).addPalette("Palette 13", GameImage.ANIMAL_CROSSING_13);
        game.get(GAME_ANIMAL_CROSSING_WILD_WORLD).addPalette("Palette 14", GameImage.ANIMAL_CROSSING_14);
        game.get(GAME_ANIMAL_CROSSING_WILD_WORLD).addPalette("Palette 15", GameImage.ANIMAL_CROSSING_15);
        game.get(GAME_ANIMAL_CROSSING_WILD_WORLD).addPalette("Palette 16", GameImage.ANIMAL_CROSSING_16);
        game.add(new Game("Need4Speed: Most Wanted"));
        game.get(GAME_NEED_FOR_SPEED_MOST_WANTED).addPalette("Most Wanted", GameImage.NEED_FOR_SPEED_MOST_WANTED);
        game.add(new Game("Need4Speed: Underground 2"));
        game.get(GAME_NEED_FOR_SPEED_UNDERGROUND_2).addPalette("Underground 2", GameImage.NEED_FOR_SPEED_UNDERGROUND_2);
        game.add(new Game("Tony Hawks American Sk8land"));
        game.get(GAME_TONY_HAWKS_AMERICAN_SK8LAND).addPalette("Grafitti",GameImage.TONY_HAWKS_AMERICAN_SK8LAND_GRAFITTI);
        game.get(GAME_TONY_HAWKS_AMERICAN_SK8LAND).addPalette("Decks",GameImage.TONY_HAWKS_AMERICAN_SK8LAND_DECK);
    }
    
    private static DSignerMainWindow mainwindow = new DSignerMainWindow();
    
    public static void main(String[] args) 
    {
            mainwindow.setVisible(true);
            Rectangle2D rect = new Rectangle2D.Double();
            rect.setFrame(0,0,imgOriginal.getWidth(),imgOriginal.getHeight());
            g2Original.setColor(Color.WHITE);
            g2Original.fill(rect);
            imgEditing.setImage(imgOriginal);
            mainwindow.getDisplay().setImage(imgEditing.getImage(),imgEditing.getPBN());
            mainwindow.getControlPanel().getPreview().setImage(imgEditing.getImage());
            for (int i = 0;i<game.size();i++)
            {
                mainwindow.getControlPanel().getGameSelector().addItem(game.get(i).getName());
            }
            
            // Check for Remote Open/Import
            
            if (args.length > 0)
            {
                if (args[0].equalsIgnoreCase("open"))
                {
                    
                try
                {
                    if (!args[1].equals("")){ DSigner.open(new URL(args[1])); }
                } catch (java.net.MalformedURLException e)
                {
                    JOptionPane.showMessageDialog(null,"Error - Incorrect URL Specified");
                } catch (java.lang.NullPointerException e)
                {
                    JOptionPane.showMessageDialog(null,"Error - Incorrect URL Specified");
                }
                } else if (args[0].equalsIgnoreCase("import"))
                {
                try
                {
                    if (!args[1].equals("")){ DSigner.importImage(new URL(args[1])); }
                } catch (java.net.MalformedURLException e)
                {
                    JOptionPane.showMessageDialog(null,"Error - Incorrect URL Specified");
                } catch (java.lang.NullPointerException e)
                {
                    JOptionPane.showMessageDialog(null,"Error - Incorrect URL Specified");
                }
                }
            }
    }
    
    public static DSignerMainWindow getWindow()
    {
        return mainwindow;
    }
    
    public static BufferedImage getOriginal()
    {
        return imgOriginal;
    }
    
    public static BufferedImage getEditing()
    {
        return imgEditing.getImage();
    }
    
    public static void mousePressed(int x,int y)
    {   
        currenttool.mousePressed(x,y);
    }
    public static void mouseDragged(int x,int y)
    {   
        currenttool.mouseDragged(x,y);
    }
    public static void mouseMoved(int x,int y)
    {   
        currenttool.mouseMoved(x,y);
    }
    public static void mouseReleased(int x,int y)
    {   
        currenttool.mouseReleased(x,y);
    }
    
    public static void draw(int x,int y)
    {
        mainwindow.getDisplay().draw(x,y);
        imgEditing.draw(x,y);
        mainwindow.getControlPanel().getPreview().draw(x,y);
        
        int zWidth = (imgOriginal.getWidth()/imgEditing.getImage().getWidth());
        int zHeight = (imgOriginal.getHeight()/imgEditing.getImage().getHeight());
        
        Rectangle2D rect = new Rectangle2D.Double();
        rect.setFrame(zWidth*x,zHeight*y,zWidth-1,zHeight-1);
        g2Original.draw(rect);
    }
    
    public static void fill(int x,int y)
    {
        if (imgEditing.getImage().getRGB(x,y) != g2Original.getColor().getRGB())
        {
            Color oldc = new Color(imgEditing.getImage().getRGB(x,y));
            fill(x,y,oldc);
        }  
    }
    
    public static void fill(int x,int y, Color oldc)
    {
        if (imgEditing.getImage().getRGB(x,y) == oldc.getRGB())
        {
            try {
            draw(x,y);
            if (x > 0) { fill(x-1,y,oldc); }
            if (x < imgEditing.getImage().getWidth()-1) {fill(x+1,y,oldc);}
            if (y > 0) {fill(x,y-1,oldc);}
            if (y < imgEditing.getImage().getHeight()-1) {fill(x,y+1,oldc);}
            } catch (StackOverflowError e)
            {}
        
        }
    }
    public static void clear()
    {
        Rectangle2D rect = new Rectangle2D.Double();
        rect.setFrame(0,0,imgOriginal.getWidth(),imgOriginal.getHeight());
        g2Original.setColor(Color.WHITE);
        g2Original.fill(rect);
        imgEditing.setImage(imgOriginal);
        mainwindow.getControlPanel().getPreview().setImage(imgEditing.getImage());
        mainwindow.getDisplay().setImage(imgEditing.getImage(),imgEditing.getPBN());
    }
    
    public static void openRandom()
    {
        Socket socket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        try 
        {
            socket = new Socket(DSigner.DSignerServer, 2542);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } 
        catch (UnknownHostException e) 
        {
            JOptionPane.showMessageDialog(null,"The DSigner server is offline. Try again later.");
            return;
        }
        catch (IOException e) 
        {
            JOptionPane.showMessageDialog(null,"The DSigner server is offline. Try again later.");
            return;
        }

        out.println("r "+Integer.toString(DSigner.getCurrentGame()));
        try {
        String DSignerFile = in.readLine();
        int p = Integer.parseInt(DSignerFile.split(" ")[1]);
        URL DSignerURL = new URL(DSignerFile.split(" ")[0]);
        mainwindow.getControlPanel().getPaletteSelector().setSelectedIndex(p);
        open(DSignerURL);

        out.close();
        in.close();
        socket.close();
        } 
        catch (IOException e)
        {
            JOptionPane.showMessageDialog(null,"Error reading URL");
            return;
        }
    }
    public static void open(File file)
    {
        try {
            BufferedImage img = ImageIO.read(file);
            Graphics g = imgOriginal.getGraphics();
            g.drawImage(img,0,0,64,64,null);
            g.dispose();
            imgEditing.setImage(imgOriginal);
            mainwindow.getControlPanel().getPreview().setImage(imgEditing.getImage());
            mainwindow.getDisplay().setImage(imgEditing.getImage(),imgEditing.getPBN());
        } catch (IOException e)
        {
            JOptionPane.showMessageDialog(null,"Error opening file");
        }
    }
    
    public static void open(URL url)
    {
        try {
            BufferedImage img = ImageIO.read(url);
            Graphics g = imgOriginal.getGraphics();
            g.drawImage(img,0,0,64,64,null);
            g.dispose();
            imgEditing.setImage(imgOriginal);
            mainwindow.getControlPanel().getPreview().setImage(imgEditing.getImage());
            mainwindow.getDisplay().setImage(imgEditing.getImage(),imgEditing.getPBN());
        } catch (IOException e)
        {
            JOptionPane.showMessageDialog(null,"Error opening file");
        }
    }
    
    public static void importImage(File file)
    {
        try {
            BufferedImage imgImport = ImageIO.read(file);
                    Color p1 = new Color(imgImport.getRGB(0,0));
        if(p1.getRed() == 1) {
            // Possible DSigner Image
            mainwindow.getControlPanel().getGameSelector().setSelectedIndex(p1.getGreen());
            mainwindow.getControlPanel().getPaletteSelector().setSelectedIndex(p1.getBlue());
            
            BufferedImage imgConvert = new BufferedImage(imgEditing.getImage().getWidth(),imgEditing.getImage().getHeight(),BufferedImage.TYPE_INT_RGB);
            
            int YStart = imgConvert.getHeight()+3;
            int zoomWidth = 5;
        
             if (imgConvert.getHeight() == 64){ zoomWidth = 2; }
            
            for (int x = 0;x<imgConvert.getWidth();x++)
            {
                for (int y = 0;y<imgConvert.getHeight();y++)
                {
                    Color c = new Color(imgImport.getRGB(x*(zoomWidth+1)+1,YStart + (y*(zoomWidth+1)+1)));
                    imgConvert.setRGB(x,y,c.getRGB());
                }
            }
            
            g2Original.drawImage(imgConvert,0,0,imgOriginal.getWidth(),imgOriginal.getHeight(),null);
            imgEditing.setImage(imgOriginal);
            mainwindow.getControlPanel().getPreview().setImage(imgEditing.getImage());
            mainwindow.getDisplay().setImage(imgEditing.getImage(),imgEditing.getPBN());
        } else {
           // Definately not DSigner - stay well clear :p
            JOptionPane.showMessageDialog(null,"Not a DSigner lite file.");
        }
        } catch (IOException e)
        {
            JOptionPane.showMessageDialog(null,"Error opening file.");
        }

    }
    
    public static void importImage(URL file)
    {
        try
        {
            BufferedImage imgImport = ImageIO.read(file);
                    Color p1 = new Color(imgImport.getRGB(0,0));
        if(p1.getRed() == 1) {
            // Possible DSigner Image
            mainwindow.getControlPanel().getGameSelector().setSelectedIndex(p1.getGreen());
            mainwindow.getControlPanel().getPaletteSelector().setSelectedIndex(p1.getBlue());
            
            BufferedImage imgConvert = new BufferedImage(imgEditing.getImage().getWidth(),imgEditing.getImage().getHeight(),BufferedImage.TYPE_INT_RGB);
            
            int YStart = imgConvert.getHeight()+3;
            int zoomWidth = 5;
        
             if (imgConvert.getHeight() == 64){ zoomWidth = 2; }
            
            for (int x = 0;x<imgConvert.getWidth();x++)
            {
                for (int y = 0;y<imgConvert.getHeight();y++)
                {
                    Color c = new Color(imgImport.getRGB(x*(zoomWidth+1)+1,YStart + (y*(zoomWidth+1)+1)));
                    imgConvert.setRGB(x,y,c.getRGB());
                }
            }
            
            g2Original.drawImage(imgConvert,0,0,imgOriginal.getWidth(),imgOriginal.getHeight(),null);
            imgEditing.setImage(imgOriginal);
            mainwindow.getControlPanel().getPreview().setImage(imgEditing.getImage());
            mainwindow.getDisplay().setImage(imgEditing.getImage(),imgEditing.getPBN());
        } else {
           // Definately not DSigner - stay well clear :p
            JOptionPane.showMessageDialog(null,"Not a DSigner lite file.");
        }
        } catch (IOException e)
        {
            JOptionPane.showMessageDialog(null,"Error opening file.");
        }

    }
    
    public static void save(File file)
        throws java.io.IOException
    {
        ImageIO.write(imgEditing.getImage(),"PNG",file);
    }
    
    public static void export(File file)
        throws java.io.IOException
    {   
        Double w = Math.ceil(193.0/(imgEditing.getImage().getHeight()/imgEditing.getImage().getWidth()));
        int TheWidth = w.intValue();
        int TheHeight = (214+imgEditing.getImage().getHeight());
        
        BufferedImage imgExport = new BufferedImage(TheWidth,TheHeight,BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = (Graphics2D) imgExport.getGraphics();
        g2.setColor(Color.WHITE);
        Rectangle2D rect = new Rectangle2D.Double();
        rect.setFrame(0,0,TheWidth,TheHeight);
        g2.fill(rect);
        g2.setColor(new Color(66,65,66));
        Line2D line = new Line2D.Double();
        line.setLine(1,0,TheWidth-1,0);
        g2.draw(line);
        line.setLine(0,1,0,TheHeight-1);
        g2.draw(line);
        line.setLine(TheWidth-1,0,TheWidth-1,TheHeight-1);
        g2.draw(line);
        line.setLine(0,TheHeight-1,TheWidth-1,TheHeight-1);
        g2.draw(line);
        line.setLine(1,1+imgEditing.getImage().getHeight(),TheWidth-1,1+imgEditing.getImage().getHeight());
        g2.draw(line);
        line.setLine(1,2+imgEditing.getImage().getHeight(),TheWidth-1,2+imgEditing.getImage().getHeight());
        g2.draw(line);
        line.setLine(1,TheHeight-19,TheWidth-1,TheHeight-19);
        g2.draw(line);
        line.setLine(1+imgEditing.getImage().getWidth(),1,1+imgEditing.getImage().getWidth(),imgEditing.getImage().getHeight());
        g2.draw(line);
        
        g2.drawImage(imgEditing.getImage(),1,1,null);
        
        int YStart = imgEditing.getImage().getHeight()+3;
        
        int zoomWidth = 5;
        
        if (imgEditing.getImage().getHeight() == 64){ zoomWidth = 2; }
        for (int x = 0;x< TheWidth;x=x+(zoomWidth+1))
        {
                line.setLine(x,YStart,x,TheHeight-19);
                g2.draw(line);
        }
        
        for (int y  = YStart; y<(TheHeight-19);y=y+(zoomWidth+1))
        {
                line.setLine(1,y,TheWidth-1,y);
                g2.draw(line);
        }
        
        for (int x = 0;x<imgEditing.getImage().getWidth();x++)
        {
            for (int y = 0;y<imgEditing.getImage().getHeight();y++)
            {
                rect.setFrame(x*(zoomWidth+1)+1,YStart + (y*(zoomWidth+1)+1),zoomWidth,zoomWidth);
                g2.setColor(new Color(imgEditing.getImage().getRGB(x,y)));
                g2.fill(rect);
            }
        }
        
        
        Color c = new Color(1,currentgame,currentpalette);
        imgExport.setRGB(0,0,c.getRGB());
        
        
        URL fileDSigner = DSigner.class.getResource("DSigner.png");
        BufferedImage imgDSignerLogo = ImageIO.read(fileDSigner);
        int xspacing = (TheWidth-imgDSignerLogo.getWidth())/2;
        int yspacing = (19-imgDSignerLogo.getHeight())/2;
        YStart = TheHeight-19;
        g2.drawImage(imgDSignerLogo,xspacing,YStart+yspacing,null);
        
        URL filePalette = DSigner.class.getResource("p"+currentgame+"-"+currentpalette+".png");
        BufferedImage imgPalette = ImageIO.read(filePalette);
        xspacing = imgEditing.getImage().getWidth()+2;
        int aWidth = (TheWidth - xspacing)-1;
        int aHeight = imgEditing.getImage().getHeight();
        g2.drawImage(imgPalette,xspacing,1,aWidth,aHeight,null);
        ImageIO.write(imgExport,"PNG",file);

    }
    public static void PaletteSelected(int index)
    {
        if (index>=0){
        currentpalette = index;
        mainwindow.getControlPanel().getColorsPanel().removeAll();
        
        for (int i = 0;i<GameImage.getColors(game.get(currentgame).getPalettes().get(currentpalette).getID());i++)
        {
            mainwindow.getControlPanel().getColorsPanel().addColor(GameImage.getColor(game.get(currentgame).getPalettes().get(currentpalette).getID(),i));
        }
        
        mainwindow.getControlPanel().getColorsPanel().repaint();
        
        imgEditing.setImage(imgOriginal,game.get(currentgame).getPalettes().get(currentpalette).getID());
        mainwindow.getDisplay().setImage(imgEditing.getImage(),imgEditing.getPBN());
        mainwindow.getControlPanel().getPreview().setImage(imgEditing.getImage());
  
        ColorSelected(GameImage.getColor(game.get(currentgame).getPalettes().get(currentpalette).getID(),0),0);
        mainwindow.getControlPanel().getColorsPanel().revalidate();
        }
    }
    
    public static void ColorSelected(Color c, int n)
    {
        g2Original.setColor(c);
        mainwindow.getDisplay().setColor(c,n);
        mainwindow.getControlPanel().getPreview().setColor(c);
    }
    
    public static void ColorSelected(Color c, DSignerColorButton b,int n)
    {
        g2Original.setColor(c);
        mainwindow.getDisplay().setColor(c,n);
        mainwindow.getControlPanel().getPreview().setColor(c);
        selColor.setSelected(false);
        selColor = b;
    }
    
    public static void GameSelected(int index)
    {
        currentgame = index;
        
        mainwindow.getControlPanel().getPaletteSelector().removeAllItems();
        for (int i = 0;i<game.get(index).getPalettes().size();i++)
        {
            mainwindow.getControlPanel().getPaletteSelector().addItem(game.get(index).getPalettes().get(i).getName());
        }
    }
    
    public static void ToolSelected(DSignerTool tool)
    {
        currenttool.setSelected(false);
        currenttool = tool;
    }
    
    public static int getCurrentGame()
    {
        return currentgame;
    }
    
    public static int getCurrentPalette()
    {
        return currentpalette;
    }
    
    public static void setPBN(boolean b)
    {
        mainwindow.getDisplay().setPBN(b);
        mainwindow.getControlPanel().getColorsPanel().setPBN(b);
    }
}

class Game
{
    private String Name;
    private List<Palette> palette = new ArrayList<Palette>();
    public Game(String aName)
    {
        Name = aName;
    }
    public String getName()
    {
        return Name;
    }
    public List<Palette> getPalettes()
    {
        return palette;
    }
    
    public void addPalette(String aName,int aPalette)
    {
        palette.add(new Palette(aName,aPalette));
    }
}

class Palette
{
    private String Name;
    private int ID;
    public Palette(String aName, int aID)
    {
        Name = aName;
        ID = aID;
    }
    public String getName()
    {
        return Name;
    }
    public int getID()
    {
        return ID;
    }
}
