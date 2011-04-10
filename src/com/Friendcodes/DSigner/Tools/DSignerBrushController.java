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

package com.Friendcodes.DSigner.Tools;

import com.Friendcodes.DSigner.DSigner;

/**
 *
 * @author Jonathan Scott
 */
public class DSignerBrushController extends DSignerToolController
{
    public void selected() { }
    public void mouseMoved(int x,int y) { }
    public void mousePressed(int x,int y)
    { 
        if (x > 0) { DSigner.draw(x-1,y); }
        if (x < DSigner.getEditing().getWidth()-1) {DSigner.draw(x+1,y);}
        DSigner.draw(x,y);
        if (y > 0) {DSigner.draw(x,y-1);}
        if (y < DSigner.getEditing().getHeight()-1) {DSigner.draw(x,y+1);}
    }
    public void mouseDragged(int x,int y)
    {
        if (x > 0) { DSigner.draw(x-1,y); }
        if (x < DSigner.getEditing().getWidth()-1) {DSigner.draw(x+1,y);}
        DSigner.draw(x,y);
        if (y > 0) {DSigner.draw(x,y-1);}
        if (y < DSigner.getEditing().getHeight()-1) {DSigner.draw(x,y+1);}
    }
    public void mouseReleased(int x,int y){ }
}
