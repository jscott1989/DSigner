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

import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.geom.*;
import com.Friendcodes.DS.*;
import java.awt.event.*;

/**
 *
 * @author Jonathan Scott
 */
public class DSignerDisplay extends JPanel{
    
	private static final long serialVersionUID = 5092604265862914727L;
	private boolean showGrid = true;
    private boolean showPBN = false;
    private BufferedImage imgDisplay = new BufferedImage(32,32,BufferedImage.TYPE_INT_RGB);
    private Graphics g = imgDisplay.getGraphics();
    private int[][] PBN = new int[64][64];
    private int pColor = 0;
    FontMetrics PBNfm = null;
    Font fnt = null;
    

    /** Creates a new instance of DSignerDisplay
     * @param img The image to display
     */
    public DSignerDisplay(BufferedImage img) 
    {
        imgDisplay = img;
        setPreferredSize(new Dimension(513,513));
        setMinimumSize(new Dimension(100,100));
        setMaximumSize(new Dimension(600,600));
        addMouseListener(new MouseHandler());
        addMouseMotionListener(new MouseMotionHandler());
    }
    
    /** Creates a new instance of DSignerDisplay
     */
    public DSignerDisplay() 
    {
        BufferedImage img = new BufferedImage(32,32,BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = (Graphics2D) img.getGraphics();
        g2.setBackground(Color.WHITE);
        imgDisplay = img;
        setPreferredSize(new Dimension(513,513));
        setMinimumSize(new Dimension(100,100));
        setMaximumSize(new Dimension(600,600));
        addMouseListener(new MouseHandler());
        addMouseMotionListener(new MouseMotionHandler());
    }
    
    /** Changes the image
     * @param img image to set
     */
    public void setImage(BufferedImage img, int[][] p)
    {
        imgDisplay = img;
        PBN = p;
        repaint();
    }
    
    public void paintComponent(Graphics g)
    {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      Rectangle2D rect = new Rectangle2D.Double();
      int zoomWidth = getWidth()/imgDisplay.getWidth();
      int zoomHeight = getHeight()/imgDisplay.getHeight();
      for (int x = 0;x<imgDisplay.getWidth();x++)
      {
          for (int y = 0;y<imgDisplay.getHeight();y++)
          {
              int pixel = imgDisplay.getRGB(x,y);
              Color color = new Color(pixel);
              g2.setColor(color);
              if (showGrid) {
                rect.setFrame((double)(x*zoomWidth)+1,(double)(y*zoomHeight)+1,(double)zoomWidth-1,(double)zoomHeight-1);
              }
              else
              {
                  rect.setFrame((double)x*zoomWidth,(double)y*zoomHeight,(double)zoomWidth,(double)zoomHeight);
              }
              g2.fill(rect);
          }
      }
      if (showGrid) {drawGrid(g2);}
      if (showPBN) {drawPBN(g2);}
    }
    
    private void drawPBN(Graphics2D g2)
    {
      int zoomWidth = getWidth()/imgDisplay.getWidth();
      int zoomHeight = getHeight()/imgDisplay.getHeight();
      int PBNsize = 20;
      fnt = new Font("Ariel",Font.PLAIN,PBNsize);
      PBNfm = g2.getFontMetrics(fnt);
      Rectangle2D rect = PBNfm.getStringBounds("99", g2);
      int textHeight = (int)(rect.getHeight()); 
      int textWidth  = (int)(rect.getWidth());
      while ((textHeight >= zoomHeight)||(textWidth > zoomWidth))
      {
        PBNsize--;
        fnt = new Font("Ariel",Font.PLAIN,PBNsize);
        PBNfm   = g2.getFontMetrics(fnt);
        rect = PBNfm.getStringBounds("99", g2);
        textHeight = (int)(rect.getHeight()); 
        textWidth  = (int)(rect.getWidth());
      }
      
      g2.setFont(fnt);
      int PBNx = (zoomWidth  - textWidth)  / 2;
      int PBNy = (zoomHeight - textHeight) / 2  + PBNfm.getAscent();
      for (int x = 0;x<imgDisplay.getWidth();x++)
      {
          for (int y = 0;y<imgDisplay.getHeight();y++)
          {
              if (DSPalette.ColorDifference(new Color(imgDisplay.getRGB(x,y)),Color.BLACK) < DSPalette.ColorDifference(new Color(imgDisplay.getRGB(x,y)),Color.WHITE))
              {
                  g2.setColor(Color.WHITE);
              }
              else
              {
                  g2.setColor(Color.BLACK);
              }
            rect = PBNfm.getStringBounds(Integer.toString(PBN[x][y]), g);
            textHeight = (int)(rect.getHeight()); 
            textWidth  = (int)(rect.getWidth());
            PBNx = (zoomWidth  - textWidth)  / 2;
            PBNy = (zoomHeight - textHeight) / 2  + PBNfm.getAscent();
            g2.drawString(Integer.toString(PBN[x][y]),x*zoomWidth+PBNx,y*zoomHeight+PBNy);
          }
      }
    }
    private void drawGrid(Graphics2D g2)
    {
      g2.setColor(Color.BLACK);
      int zoomWidth = getWidth()/imgDisplay.getWidth();
      int zoomHeight = getHeight()/imgDisplay.getHeight();
        for (int x = 0; x<=(zoomWidth*imgDisplay.getWidth()); x=x+zoomWidth)
        {
            g2.drawLine(x,0,x,zoomHeight*imgDisplay.getHeight());
        }
        for (int y = 0; y<=(zoomHeight*imgDisplay.getHeight()); y=y+zoomHeight)
        {
            g2.drawLine(0,y,(zoomWidth*imgDisplay.getWidth()),y);
        }
    }
    public BufferedImage getImage()
    {
        return imgDisplay;
    }
    
    public void setColor(Color c, int p)
    {
        g.setColor(c);
        pColor = p;
    }
    
    public void draw(int x,int y)
    {
        imgDisplay.setRGB(x,y,g.getColor().getRGB());
        PBN[x][y] =pColor;
      int zoomWidth = getWidth()/imgDisplay.getWidth();
      int zoomHeight = getHeight()/imgDisplay.getHeight();
        Graphics2D g2 = (Graphics2D) getGraphics();
        int pixel = imgDisplay.getRGB(x,y);
        Color color = new Color(pixel);
        g2.setColor(color);
        Rectangle2D rect = new Rectangle2D.Double();
              if (showGrid) {
                rect.setFrame((double)(x*zoomWidth)+1,(double)(y*zoomHeight)+1,(double)zoomWidth-1,(double)zoomHeight-1);
              }
              else
              {
                  rect.setFrame((double)x*zoomWidth,(double)y*zoomHeight,(double)zoomWidth,(double)zoomHeight);
              }
        g2.fill(rect);
        
        if (showPBN) { 
            g2.setFont(fnt);
              if (DSPalette.ColorDifference(new Color(imgDisplay.getRGB(x,y)),Color.BLACK) < DSPalette.ColorDifference(new Color(imgDisplay.getRGB(x,y)),Color.WHITE))
              {
                  g2.setColor(Color.WHITE);
              }
              else
              {
                  g2.setColor(Color.BLACK);
              }
            rect = PBNfm.getStringBounds(Integer.toString(PBN[x][y]), g);
            int textHeight = (int)(rect.getHeight()); 
            int textWidth  = (int)(rect.getWidth());
            int PBNx = (zoomWidth  - textWidth)  / 2;
            int PBNy = (zoomHeight - textHeight) / 2  + PBNfm.getAscent();
            g2.drawString(Integer.toString(PBN[x][y]),x*zoomWidth+PBNx,y*zoomHeight+PBNy);
        }
    }
    
    public void setPBN(boolean b)
    {
        showPBN = b;
        repaint();
    }
    
    public void switchGrid()
    {
        showGrid = !showGrid;
        repaint();
    }
}


class MouseHandler extends MouseAdapter
{
    public void mousePressed(MouseEvent event)
    {
        int zoomWidth = DSigner.getWindow().getDisplay().getWidth()/DSigner.getWindow().getDisplay().getImage().getWidth();
        int zoomHeight = DSigner.getWindow().getDisplay().getHeight()/DSigner.getWindow().getDisplay().getImage().getHeight();
        int x = event.getX()/zoomWidth;
        int y = event.getY()/zoomHeight;
        if ((x<DSigner.getWindow().getDisplay().getImage().getWidth())&&(x>=0))
        {
            if ((y<DSigner.getWindow().getDisplay().getImage().getHeight())&&(y>=0))
            {
                DSigner.mousePressed(x,y);
            }
        }
    }

    public void mouseReleased(MouseEvent event)
    {
        int zoomWidth = DSigner.getWindow().getDisplay().getWidth()/DSigner.getWindow().getDisplay().getImage().getWidth();
        int zoomHeight = DSigner.getWindow().getDisplay().getHeight()/DSigner.getWindow().getDisplay().getImage().getHeight();
        int x = event.getX()/zoomWidth;
        int y = event.getY()/zoomHeight;
        if ((x<DSigner.getWindow().getDisplay().getImage().getWidth())&&(x>=0))
        {
            if ((y<DSigner.getWindow().getDisplay().getImage().getHeight())&&(y>=0))
            {
                DSigner.mouseReleased(x,y);
            }
        }
    }
}

class MouseMotionHandler extends MouseMotionAdapter
{
    public void mouseDragged(MouseEvent event)
    {
        int zoomWidth = DSigner.getWindow().getDisplay().getWidth()/DSigner.getWindow().getDisplay().getImage().getWidth();
        int zoomHeight = DSigner.getWindow().getDisplay().getHeight()/DSigner.getWindow().getDisplay().getImage().getHeight();
        int x = event.getX()/zoomWidth;
        int y = event.getY()/zoomHeight;
        if ((x<DSigner.getWindow().getDisplay().getImage().getWidth())&&(x>=0))
        {
            if ((y<DSigner.getWindow().getDisplay().getImage().getHeight())&&(y>=0))
            {
                DSigner.mouseDragged(x,y);
            }
        }
    }
   
    public void mouseMoved(MouseEvent event)
    {
        int zoomWidth = DSigner.getWindow().getDisplay().getWidth()/DSigner.getWindow().getDisplay().getImage().getWidth();
        int zoomHeight = DSigner.getWindow().getDisplay().getHeight()/DSigner.getWindow().getDisplay().getImage().getHeight();
        int x = event.getX()/zoomWidth;
        int y = event.getY()/zoomHeight;
        if ((x<DSigner.getWindow().getDisplay().getImage().getWidth())&&(x>=0))
        {
            if ((y<DSigner.getWindow().getDisplay().getImage().getHeight())&&(y>=0))
            {
                DSigner.mouseMoved(x,y);
            }
        }
    }
}



