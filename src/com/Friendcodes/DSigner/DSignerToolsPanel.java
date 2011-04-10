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
import com.Friendcodes.DSigner.Tools.*;

/**
 *
 * @author Jonathan Scott
 */
public class DSignerToolsPanel extends JPanel{
    
	private static final long serialVersionUID = 3194323760628882852L;

	/** Creates a new instance of DSignerToolsPanel */
    public DSignerToolsPanel() 
    {
        setLayout(new FlowLayout());
        setMinimumSize(new Dimension(30,50));
        setMaximumSize(new Dimension(90,150));
        
        add(new DSignerTool("Pencil",new DSignerPencilController(),true));
        add(new DSignerTool("Brush",new DSignerBrushController()));
        add(new DSignerTool("Fill",new DSignerFillController()));
    }
    
}
