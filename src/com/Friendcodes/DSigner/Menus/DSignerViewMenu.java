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
public class DSignerViewMenu extends JMenu {
    
	private static final long serialVersionUID = -2161727138993467746L;

	/** Creates a new instance of DSignerFileMenu */
    public DSignerViewMenu() {
        setText("View");
        setMnemonic(KeyEvent.VK_V);
        getAccessibleContext().setAccessibleDescription("The View Menu");
        addGrid();
        addPBN();
    }
    
    private void addGrid()
    {
        JCheckBoxMenuItem cbMenuItem = new JCheckBoxMenuItem("Grid",true);
        cbMenuItem.setMnemonic(KeyEvent.VK_G);
        add(cbMenuItem);
        ActionListener listener = new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                DSigner.getWindow().getDisplay().switchGrid();
            }
        };
       cbMenuItem.addActionListener(listener);
       add(cbMenuItem);
    }
    
    private void addPBN()
    {
        final JCheckBoxMenuItem cbMenuItem = new JCheckBoxMenuItem("Paint By Numbers",false);
        cbMenuItem.setMnemonic(KeyEvent.VK_P);
        add(cbMenuItem);
        ActionListener listener = new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                DSigner.setPBN(cbMenuItem.getState());
            }
        };
       cbMenuItem.addActionListener(listener);
       add(cbMenuItem);
    }
}