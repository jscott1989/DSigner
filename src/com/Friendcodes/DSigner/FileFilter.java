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

public class FileFilter extends javax.swing.filechooser.FileFilter
{
    private final String FileType;
    private final String Desc;
    public FileFilter(String aFiletype,String aDesc)
    {
        FileType = aFiletype;
        Desc = aDesc;
    }
    public boolean accept(File f) 
    {
        return f.isDirectory() || f.getName().toLowerCase().endsWith("."+FileType);
    }
    
    public String getDescription() 
    {
        return Desc;
    }
}