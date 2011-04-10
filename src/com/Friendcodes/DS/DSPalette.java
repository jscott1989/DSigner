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

package com.Friendcodes.DS;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 *
 * @author Jonathan Scott
 * @version 1.0
 */

public class DSPalette {
    List<Color> color = new ArrayList<Color>();
    
    /**
     * Returns the amount of colors in the palette
     */
    public int getColors()
    {
        return color.size();
    }
    
    /**
     * Sets a colour in the palette
     * @param index The color index
     * @param c The color
     */
    public void setColor(int index, Color c)
    {
        color.set(index,c);
    }
    
    /**
     * Adds a color to the palette
     * @param c The color
     */
    public void addColor(Color c)
    {
        color.add(c);
    }
    
    /**
     *
     * Gets a colour in the palette
     * @param index The color index
     */
    public Color getColor(int index)
    {
        return color.get(index);
    }
    
    
    /**
     *
     * Gets the closest colour from the palette
     * @param c Color to match
     */
    public Color ClosestColor(Color c)
    {
        if (color.size() < 2)
        {
            // ERROR - NOT ENOUGH ENTRIES
            throw new IllegalStateException("Not enough colors in palette");
        }
        
        int LowestDif = 0;
        int LowestDifn = ColorDifference(color.get(0),c);
        for (int x = 1;x<color.size();x++)
        {
            int cdif = ColorDifference(color.get(x),c);
            if (cdif < LowestDifn)
            {
                LowestDifn = cdif;
                LowestDif = x;
            }
        }
        return color.get(LowestDif);
    }
    
    /**
     *
     * Gets the palette-specific number closest to a specified colour
     * @param c Color
     */    
    public int intClosestColor(Color c)
    {
        if (color.size() < 2)
        {
            // ERROR - NOT ENOUGH ENTRIES
            throw new IllegalStateException("Not enough colors in palette");
        }
        
        int LowestDif = 0;
        int LowestDifn = ColorDifference(color.get(0),c);
        for (int x = 1;x<color.size();x++)
        {
            int cdif = ColorDifference(color.get(x),c);
            if (cdif < LowestDifn)
            {
                LowestDifn = cdif;
                LowestDif = x;
            }
        }
        return LowestDif;
    }
    
    /**
     *
     * Finds the difference between two given colors
     * @param a Color a
     * @param b Color b
     */
        public static int ColorDifference(Color a, Color b)
    {
        int redDif = ((a.getRed()-b.getRed())*(a.getRed()-b.getRed()));
        int blueDif = ((a.getBlue()-b.getBlue())*(a.getBlue()-b.getBlue()));
        int greenDif = ((a.getGreen()-b.getGreen())*(a.getGreen()-b.getGreen()));
        int cDif = redDif + blueDif + greenDif;
        if (cDif < 0){ cDif = (cDif+cDif+cDif);}
        return cDif;
    }
    
}
