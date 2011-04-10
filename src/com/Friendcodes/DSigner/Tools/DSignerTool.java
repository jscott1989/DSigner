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

package com.Friendcodes.DSigner.Tools;

import com.Friendcodes.DSigner.DSigner;
import javax.swing.*;
import java.awt.image.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;

/**
 *
 * @author Jonathan Scott
 */


public class DSignerTool extends JPanel 
{
	private static final long serialVersionUID = -3732202799461249701L;
	private String toolName;
    private BufferedImage imgDisplay;
    private DSignerToolController controller;
    private Boolean selected = false;
    
    /** Creates a new instance of DSignerTool */
    public DSignerTool(String n, DSignerToolController c) 
    {
        toolName = n;
        try {
            imgDisplay = ImageIO.read(this.getClass().getResource(toolName + ".png"));
        } catch (java.io.IOException e)
        {
            e.printStackTrace();
        }
        setMinimumSize(new Dimension(20,20));
        setPreferredSize(new Dimension(30,30));
        setMaximumSize(new Dimension(40,40));
        controller = c;
        addMouseListener(new MouseAdapter(){
            
            public void mousePressed(MouseEvent e)
            {
                if (!selected)
                {
                    selected();
                }
            }            
        });
    }
    
    public DSignerTool(String n, DSignerToolController c,Boolean s)
    {
        this(n,c);
        selected();
    }
    
    public void setSelected(Boolean s)
    {
        selected = s;
        repaint();
    }
    
    public void selected()
    {
        DSigner.ToolSelected(this);
        setSelected(true);
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        RoundRectangle2D rect = new RoundRectangle2D.Double();
        rect.setFrame(0,0,getWidth()-1,getHeight()-1);
        if (selected) {
            g2.setColor(new Color(150,150,150));
            g2.fill(rect);
            g2.setColor(Color.BLACK);
            g2.draw(rect);
            
        }
        g.drawImage(imgDisplay,0,0,getWidth(),getHeight(),0,0,imgDisplay.getWidth(),imgDisplay.getHeight(),null);
        
    }
    
    public void mousePressed(int x,int y)
    {
        controller.mousePressed(x,y);
    }
    
    public void mouseReleased(int x,int y)
    {
        controller.mouseReleased(x,y);
    }
    
    public void mouseDragged(int x,int y)
    {
        controller.mouseDragged(x,y);
    }
    
    public void mouseMoved(int x,int y)
    {
        controller.mouseMoved(x,y);
    }
}
