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

package com.Friendcodes.DSigner.Menus;

import com.Friendcodes.DSigner.*;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author Jonathan Scott
 */
public class DSignerGalleryMenu extends JMenu {
    
	private static final long serialVersionUID = 2411848056522972341L;

	/** Creates a new instance of DSignerFileMenu */
    public DSignerGalleryMenu() {
        setText("Gallery");
        setMnemonic(KeyEvent.VK_G);
        getAccessibleContext().setAccessibleDescription("The Gallery Menu");
        addRandom();
        //addUpload();
    }
    
    private void addRandom()
    {
        JMenuItem menuItem = new JMenuItem("Random");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription("Get a Random DSign");
        ActionListener listener = new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                DSigner.openRandom();
            }
        };
       menuItem.addActionListener(listener);
       add(menuItem);
    }
/**    
    private void addUpload()
    {
        JMenuItem menuItem = new JMenuItem("Upload");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, ActionEvent.CTRL_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription("Upload DSign to Gallery");
        ActionListener listener = new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                DSignerUploadWindow uw = new DSignerUploadWindow();
                uw.setVisible(true);
            }
        };
       menuItem.addActionListener(listener);
       add(menuItem);
    }
    */
    
}