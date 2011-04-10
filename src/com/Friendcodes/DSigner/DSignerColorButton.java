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
import java.awt.geom.*;
import java.awt.event.*;
import com.Friendcodes.DS.*;


/**
 *
 * @author Jonathan Scott
 */
public class DSignerColorButton extends JPanel implements MouseListener{
    
	private static final long serialVersionUID = -3022199085718533796L;
	private boolean selected = false;
    private int n = 0;
    private boolean PBN = false;
    
    /** Creates a new instance of DSignerColorButton */
    public DSignerColorButton(Color c, int p, boolean pb) 
    {
        setMinimumSize(new Dimension(10,10));
        setPreferredSize(new Dimension(20,20));
        setMaximumSize(new Dimension(40,40));
        setBackground(c);
        addMouseListener(this);
        n = p;
        PBN = pb;
    }
    
    public DSignerColorButton(Color c, Boolean b,int p, boolean pb)
    {
        this(c,p, pb);
        mousePressed(null);
    }
    
    public void mouseExited(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    public void mouseClicked(MouseEvent e){}
    public void mousePressed(MouseEvent event)
    {
        DSigner.ColorSelected(getBackground(),this,n);
        setSelected(true);
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Rectangle2D rect = new Rectangle2D.Double();
        rect.setFrame(0,0,getWidth()-1,getHeight()-1);
        Graphics2D g2 = (Graphics2D) g;
        if (selected == true)
        {
            g2.setColor(Color.RED);
        } else {
            g2.setColor(Color.BLACK);
        }
        g2.draw(rect);
        
        if (PBN)
        {
              if (DSPalette.ColorDifference(getBackground(),Color.BLACK) < DSPalette.ColorDifference(getBackground(),Color.WHITE))
              {
                  g2.setColor(Color.WHITE);
              }
              else
              {
                  g2.setColor(Color.BLACK);
              }
              Font fnt = new Font("Ariel",Font.PLAIN,10);
              FontMetrics fm   = g.getFontMetrics(fnt);
              rect = fm.getStringBounds(Integer.toString(n), g);
              int textHeight = (int)(rect.getHeight()); 
              int textWidth  = (int)(rect.getWidth());
              int panelHeight= getHeight();
              int panelWidth = getWidth();
              int x = (panelWidth  - textWidth)  / 2;
              int y = (panelHeight - textHeight) / 2  + fm.getAscent();
            g2.drawString(Integer.toString(n),x,y);
        }
    }
    public void setSelected(boolean b)
    {
        selected = b;
        repaint();
    }
    
    public void setPBN(boolean b)
    {
        PBN = b;
        repaint();
    }
    
}
