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

import javax.swing.*;

/**
 *
 * @author Jonathan Scott
 */
public class DSignerMenuBar extends JMenuBar{
    
	private static final long serialVersionUID = 8564608413491673550L;

	/** Creates a new instance of DSignerMenuBar */
    public DSignerMenuBar() {
        DSignerFileMenu filemenu = new DSignerFileMenu();
        DSignerViewMenu viewmenu = new DSignerViewMenu();
        //DSignerGalleryMenu gallerymenu = new DSignerGalleryMenu();
        //DSignerHelpMenu helpmenu = new DSignerHelpMenu();
        add(filemenu);
        add(viewmenu);
        //add(gallerymenu);
        //add(helpmenu);
    }
    
}
