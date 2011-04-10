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
/**
 *
 * @author Jonathan Scott
 */
public class DSignerControlPanel extends JPanel{
    
	private static final long serialVersionUID = -4915781651750791378L;
	private DSignerPreview Preview = new DSignerPreview();
    private DSignerGameSelector gameselector = new DSignerGameSelector();
    private DSignerPaletteSelector paletteselector = new DSignerPaletteSelector();
    private DSignerColorsPanel colorspanel = new DSignerColorsPanel();
    private DSignerToolsPanel toolspanel = new DSignerToolsPanel();
 
    /** Creates a new instance of DSignerControlPanel */
    public DSignerControlPanel() {
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        setMinimumSize(new Dimension(100,200));
        setPreferredSize(new Dimension(100,507));
        setMaximumSize(new Dimension(100,600));
        add(toolspanel);
        add(gameselector);
        add(paletteselector);
        add(colorspanel);
        add(Preview);
    }
    
    public DSignerPreview getPreview()
    {
        return Preview;
    }
    
    public DSignerGameSelector getGameSelector()
    {
        return gameselector;
    }
    
    public DSignerPaletteSelector getPaletteSelector()
    {
        return paletteselector;
    }
    
    public DSignerColorsPanel getColorsPanel()
    {
        return colorspanel;
    }
    
}
