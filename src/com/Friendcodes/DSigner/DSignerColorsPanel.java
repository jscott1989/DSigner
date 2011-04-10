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
public class DSignerColorsPanel extends JPanel {
    
	private static final long serialVersionUID = -6682237714780427589L;
	private boolean PBN = false;
    
    /** Creates a new instance of DSignerColorsPanel */
    public DSignerColorsPanel() 
    {
        setLayout(new FlowLayout());
        setMinimumSize(new Dimension(30,50));
        setMaximumSize(new Dimension(90,180));
    }
    
    public void addColor(Color c)
    {
        if (getComponents().length == 0)
        {
            add(new DSignerColorButton(c,true,0,PBN));
        } else {
            add(new DSignerColorButton(c,getComponents().length,PBN));
        }
    }
    
    public void setPBN(boolean b)
    {
        PBN = b;
        for (Component cb : getComponents())
        {
            DSignerColorButton cbb = (DSignerColorButton) cb;
            cbb.setPBN(b);
        }
    }
    
}
