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

import com.Friendcodes.DSigner.Menus.*;

/**
 *
 * @author Jonathan Scott
 */
public class DSignerMainWindow extends JFrame{
    
	private static final long serialVersionUID = -384694379585863606L;
	private DSignerDisplay display = new DSignerDisplay();
    private DSignerControlPanel controlpanel = new DSignerControlPanel();
    
    /** Creates a new instance of DSignerMainWindow */
    public DSignerMainWindow() {
        Container container = getContentPane();
        setPreferredSize(new Dimension(629,575));
        setMinimumSize(new Dimension(560,510));
        setMaximumSize(new Dimension(700,700));
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Exit when this frame is closed.  
        setTitle("DSigner lite");    // Sets Title
        DSignerMenuBar menu = new DSignerMenuBar();
        setJMenuBar(menu);
        container.add(display,BorderLayout.CENTER);
        container.add(controlpanel,BorderLayout.LINE_START);
        pack();
        center();
    }
    
    /** Gets the current DSignerDisplay */
    public DSignerDisplay getDisplay()
    {
        return display;
    }
    
    public DSignerControlPanel getControlPanel()
    {
        return controlpanel;
    }
    
    public void center() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point center = ge.getCenterPoint();
        Rectangle bounds = ge.getMaximumWindowBounds();
        int w = Math.max(bounds.width/2, Math.min(getWidth(), bounds.width));
        int h = Math.max(bounds.height/2, Math.min(getHeight(), bounds.height));
        int x = center.x - w/2, y = center.y - h/2;
        setBounds(x, y, w, h);
        if (w == bounds.width && h == bounds.height)
            setExtendedState(Frame.MAXIMIZED_BOTH);
        validate();
    }

}
