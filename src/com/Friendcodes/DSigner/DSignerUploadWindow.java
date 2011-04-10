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

/**
 *
 * @author Jonathan Scott
 */
public class DSignerUploadWindow extends JFrame {
    
	private static final long serialVersionUID = 6801055236745041452L;

	/** Creates a new instance of DSignerUploadWindow */
    public DSignerUploadWindow() 
    {
        setTitle("Upload");
        SpringLayout layout = new SpringLayout();
        getContentPane().setLayout(layout);
        JLabel lblusername = new JLabel("Username: ");
        JLabel lblpassword = new JLabel("Password: ");
        JLabel lbltitle = new JLabel("Title: ");
        JLabel lbldescription = new JLabel("Description");
       
        JTextField txtusername = new JTextField(14);
        JTextField txtpassword = new JTextField(14);
        JTextField txttitle = new JTextField(14);
        add(lblusername);
        layout.putConstraint(SpringLayout.WEST,lblusername,5,SpringLayout.WEST,getContentPane());
        layout.putConstraint(SpringLayout.NORTH,lblusername,5,SpringLayout.NORTH,getContentPane());
        add(txtusername);
        layout.putConstraint(SpringLayout.WEST,txtusername,5,SpringLayout.EAST,lblusername);
        layout.putConstraint(SpringLayout.NORTH,txtusername,5,SpringLayout.NORTH,getContentPane());
        add(lblpassword);
        layout.putConstraint(SpringLayout.WEST,lblpassword,5,SpringLayout.WEST,getContentPane());
        layout.putConstraint(SpringLayout.NORTH,lblpassword,5,SpringLayout.SOUTH,txtusername);
        add(txtpassword);
        layout.putConstraint(SpringLayout.WEST,txtpassword,5,SpringLayout.EAST,lblusername);
        layout.putConstraint(SpringLayout.NORTH,txtpassword,5,SpringLayout.SOUTH,txtusername);
        add(lbltitle);
        layout.putConstraint(SpringLayout.WEST,lbltitle,5,SpringLayout.WEST,getContentPane());
        layout.putConstraint(SpringLayout.NORTH,lbltitle,15,SpringLayout.SOUTH,txtpassword);
        add(txttitle);
        layout.putConstraint(SpringLayout.WEST,txttitle,5,SpringLayout.EAST,lblusername);
        layout.putConstraint(SpringLayout.NORTH,txttitle,15,SpringLayout.SOUTH,txtpassword);
        add(lbldescription);
        layout.putConstraint(SpringLayout.WEST,lbldescription,5,SpringLayout.WEST,getContentPane());
        layout.putConstraint(SpringLayout.NORTH,lbldescription,5,SpringLayout.SOUTH,txttitle);
        JTextArea txtdescription = new JTextArea(10,20);
        JScrollPane scrldescription = new JScrollPane(txtdescription);
        add(scrldescription);
        layout.putConstraint(SpringLayout.WEST,scrldescription,10,SpringLayout.WEST,getContentPane());
        layout.putConstraint(SpringLayout.NORTH,scrldescription,5,SpringLayout.SOUTH,lbldescription);
        JButton btnupload = new JButton("Upload");
        add(btnupload);
        layout.putConstraint(SpringLayout.WEST,btnupload,90,SpringLayout.WEST,getContentPane());
        layout.putConstraint(SpringLayout.NORTH,btnupload,5,SpringLayout.SOUTH,scrldescription);
        layout.putConstraint(SpringLayout.EAST,getContentPane(),5,SpringLayout.EAST,txtusername);
        layout.putConstraint(SpringLayout.SOUTH,getContentPane(),20,SpringLayout.SOUTH,btnupload);
        pack();        
        setResizable(false);
        setLocationRelativeTo(null);
        
    }
    
}
