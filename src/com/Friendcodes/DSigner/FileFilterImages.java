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

import java.io.*;
/**
 *
 * @author Jonathan Scott
 */
public class FileFilterImages extends javax.swing.filechooser.FileFilter
{
    public boolean accept(File f)
    {
       FileFilter[] filters = new FileFilter[4];
       filters[0] = new FileFilter("bmp","Bitmap Files (.bmp)");
       filters[1] = new FileFilter("png","PNG Files (.png)");
       filters[2] = new FileFilter("jpg","Jpg Files (.jpg)");
       filters[3] = new FileFilter("gif","Gif Files (.gif)");
       
       for (FileFilter x: filters)
       {
           if (x.accept(f))
           {
               return true;
           }
       }
       return false;
    }
    
    public String getDescription()
    {
        return "Image Files ()";
    }
}
