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
import java.awt.event.*;
import java.awt.*;
/**
 *
 * @author Jonathan Scott
 */
public class DSignerPaletteSelector extends JComboBox{
    
	private static final long serialVersionUID = 2797150881975851354L;

	/** Creates a new instance of DSignerPaletteSelector */
    public DSignerPaletteSelector() 
    {
        setMinimumSize(new Dimension(90,20));
        setPreferredSize(new Dimension(90,20));
        setMaximumSize(new Dimension(90,20));
        setEditable(false);
           addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e)
           {
               DSigner.PaletteSelected(getSelectedIndex());
           }
        });
    }
    
}
