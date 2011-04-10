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
import java.io.*;
import java.net.*;
import com.Friendcodes.DSigner.FileFilter;

/**
 *
 * @author Jonathan Scott
 */
public class DSignerFileMenu extends JMenu {
    
	private static final long serialVersionUID = -497745713534106618L;

	/** Creates a new instance of DSignerFileMenu */
    public DSignerFileMenu() {
        setText("File");
        setMnemonic(KeyEvent.VK_F); // Pressing F opens File Menu
        getAccessibleContext().setAccessibleDescription("The File Menu");
        addNew();
        addOpen();
        addOpenFromUrl();
        addSave();
        addSeparator();
        addImport();
        addImportFromUrl();
        addExport();
        addSeparator();
        addExit();
    }
    
    private void addNew()
    {
        JMenuItem menuItem = new JMenuItem("New");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription("Create a new DSign");
        ActionListener listener = new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                DSigner.clear(); // Clear the image
            }
        };
       menuItem.addActionListener(listener);
       add(menuItem);
    }
    
     private void addOpen()
    {
        JMenuItem menuItem = new JMenuItem("Open");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription("Open a DSign");
        ActionListener listener = new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                JFileChooser filechooser = new JFileChooser();
                filechooser.addChoosableFileFilter(new FileFilterImages());
                int returnVal = filechooser.showOpenDialog(null);
                if(returnVal == JFileChooser.APPROVE_OPTION) 
                {
                DSigner.open(filechooser.getSelectedFile().getAbsoluteFile());
                }
                
            }
        };
       menuItem.addActionListener(listener);
       add(menuItem);
    }
    
     private void addOpenFromUrl()
    {
        JMenuItem menuItem = new JMenuItem("Open from URL");
        menuItem.getAccessibleContext().setAccessibleDescription("Open a DSign from a URL");
        ActionListener listener = new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                try
                {
                    String sURL = JOptionPane.showInputDialog(null,"Image Address");
                    if (!sURL.equals("")){ DSigner.open(new URL(sURL)); }
                } catch (java.net.MalformedURLException e)
                {
                    JOptionPane.showMessageDialog(null,"Error - Incorrect URL Specified");
                } catch (java.lang.NullPointerException e)
                {
                    
                }
            }
        };
       menuItem.addActionListener(listener);
       add(menuItem);
    }
     
     
     private void addSave()
    {
        JMenuItem menuItem = new JMenuItem("Save");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription("Save To File");
        ActionListener listener = new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                JFileChooser filechooser = new JFileChooser();
                filechooser.addChoosableFileFilter(new FileFilter("png","PNG File"));
                int returnVal = filechooser.showSaveDialog(null);
                if(returnVal == JFileChooser.APPROVE_OPTION) 
                {
                    try
                    {
                        String filetosave = filechooser.getSelectedFile().getAbsoluteFile().toString();
                        if (!filetosave.endsWith(".png")){ filetosave = filetosave + ".png";}
                        DSigner.save(new File(filetosave));
                    }
                    catch (IOException exception)
                    {
                        exception.printStackTrace();
                    }
                }
                
            }
        };
       menuItem.addActionListener(listener);
       add(menuItem);
    }

     private void addImport()
    {
        JMenuItem menuItem = new JMenuItem("Import");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription("Import a DSign");
        ActionListener listener = new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                JFileChooser filechooser = new JFileChooser();
                filechooser.addChoosableFileFilter(new FileFilterImages());
                int returnVal = filechooser.showOpenDialog(null);
                if(returnVal == JFileChooser.APPROVE_OPTION) 
                {
                    DSigner.importImage(filechooser.getSelectedFile().getAbsoluteFile());
                }
                
            }
        };
       menuItem.addActionListener(listener);
       add(menuItem);
    }

     private void addImportFromUrl()
    {
        JMenuItem menuItem = new JMenuItem("Import from URL");
        menuItem.getAccessibleContext().setAccessibleDescription("Import a DSign from a URL");
        ActionListener listener = new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                try
                {
                    String sURL = JOptionPane.showInputDialog(null,"Image Address");
                    if (!sURL.equals("")){ DSigner.importImage(new URL(sURL)); }
                } catch (java.net.MalformedURLException e)
                {
                    JOptionPane.showMessageDialog(null,"Error - Incorrect URL Specified");
                } catch (java.lang.NullPointerException e)
                {
                    
                }
            }
        };
       menuItem.addActionListener(listener);
       add(menuItem);
    }
     
     private void addExport()
    {
        JMenuItem menuItem = new JMenuItem("Export");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription("Export To File");
        ActionListener listener = new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                JFileChooser filechooser = new JFileChooser();
                filechooser.addChoosableFileFilter(new FileFilter("png","PNG File"));
                int returnVal = filechooser.showSaveDialog(null);
                if(returnVal == JFileChooser.APPROVE_OPTION) 
                {
                    try
                    {
                        String filetosave = filechooser.getSelectedFile().getAbsoluteFile().toString();
                        if (!filetosave.endsWith(".png")){ filetosave = filetosave + ".png";}
                        DSigner.export(new File(filetosave));
                    }
                    catch (IOException exception)
                    {
                        exception.printStackTrace();
                    }
                }
                
            }
        };
       menuItem.addActionListener(listener);
       add(menuItem);
    }
     
    private void addExit()
    {
        JMenuItem menuItem = new JMenuItem("Exit");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription("Exit DSigner");
        ActionListener listener = new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                System.exit(0);
            }
        };
       menuItem.addActionListener(listener);
       add(menuItem);
    }
    
}