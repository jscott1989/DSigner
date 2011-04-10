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
/**
 *
 * @author Jonathan Scott
 */
public class DSignerPreview extends JPanel{
    
	private static final long serialVersionUID = 3899621427152967641L;
	private BufferedImage imgDisplay = new BufferedImage(32,32,BufferedImage.TYPE_INT_RGB);
    Graphics2D g2display = (Graphics2D) imgDisplay.getGraphics();
    /** Creates a new instance of DSignerPreview */
    public DSignerPreview() {
        setMinimumSize(new Dimension(32,32));
        setMaximumSize(new Dimension(70,70));
    }
    
    public DSignerPreview(BufferedImage i) {
        this();
        setImage(i);
    }

    public void setImage(BufferedImage i)
    {
        imgDisplay = i;
        repaint();
    }
    
    public void setColor(Color c)
    {
        g2display.setColor(c);
    }
    
    public void draw(int x, int y)
    {
        imgDisplay.setRGB(x,y,g2display.getColor().getRGB());
        repaint();
    }
    
    public void paintComponent(Graphics g)
    {
      int leftspace = (getWidth() - imgDisplay.getWidth())/2;
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      g2.drawImage(imgDisplay,leftspace+1,1,null);
      Rectangle2D rect = new Rectangle2D.Double(leftspace,0,imgDisplay.getWidth()+1,imgDisplay.getHeight()+1);
      g2.draw(rect);
    }
}
