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

import java.awt.image.*;
import java.awt.*;
import java.awt.Graphics2D;
import java.util.*;
/**
 *
 * @author Jonathan Scott
 */
public class GameImage {
    private BufferedImage image;
    private int[][] PBN = new int[64][64];
    private Color color;
    public static int MARIO_KART = 0;
    public static int ANIMAL_CROSSING_1 = 1;
    public static int ANIMAL_CROSSING_2 = 2;
    public static int ANIMAL_CROSSING_3 = 3;
    public static int ANIMAL_CROSSING_4 = 4;
    public static int ANIMAL_CROSSING_5 = 5;
    public static int ANIMAL_CROSSING_6 = 6;
    public static int ANIMAL_CROSSING_7 = 7;
    public static int ANIMAL_CROSSING_8 = 8;
    public static int ANIMAL_CROSSING_9 = 9;
    public static int ANIMAL_CROSSING_10 = 10;
    public static int ANIMAL_CROSSING_11 = 11;
    public static int ANIMAL_CROSSING_12 = 12;
    public static int ANIMAL_CROSSING_13 = 13;
    public static int ANIMAL_CROSSING_14 = 14;
    public static int ANIMAL_CROSSING_15 = 15;
    public static int ANIMAL_CROSSING_16 = 16;
    public static int NEED_FOR_SPEED_UNDERGROUND_2 = 17;
    public static int NEED_FOR_SPEED_MOST_WANTED = 18;
    public static int TONY_HAWKS_AMERICAN_SK8LAND_GRAFITTI = 19;
    public static int TONY_HAWKS_AMERICAN_SK8LAND_DECK = 20;
    
    private static ArrayList<DSPalette> palette = new ArrayList<DSPalette>();
    private static ArrayList<Size> pSize = new ArrayList<Size>();
    private int CurrentPalette = MARIO_KART;
    
    static {
        // MARIO KART
        palette.add(new DSPalette());
        palette.get(MARIO_KART).addColor(new Color(0,255,0));
        palette.get(MARIO_KART).addColor(new Color(0,0,0));
        palette.get(MARIO_KART).addColor(new Color(0,81,24));
        palette.get(MARIO_KART).addColor(new Color(255,247,255));
        palette.get(MARIO_KART).addColor(new Color(0,255,255));
        palette.get(MARIO_KART).addColor(new Color(132,134,132));
        palette.get(MARIO_KART).addColor(new Color(0,0,247));
        palette.get(MARIO_KART).addColor(new Color(107,73,33));
        palette.get(MARIO_KART).addColor(new Color(132,32,247));
        palette.get(MARIO_KART).addColor(new Color(247,0,0));
        palette.get(MARIO_KART).addColor(new Color(206,0,140));
        palette.get(MARIO_KART).addColor(new Color(239,150,16));
        palette.get(MARIO_KART).addColor(new Color(247,89,247));
        palette.get(MARIO_KART).addColor(new Color(255,207,156));
        palette.get(MARIO_KART).addColor(new Color(247,255,0));
        pSize.add(new Size(32,32));
        
        // ANIMAL CROSSING
        palette.add(new DSPalette());
        palette.get(ANIMAL_CROSSING_1).addColor(new Color(217,39,27));
        palette.get(ANIMAL_CROSSING_1).addColor(new Color(239,114,24));
        palette.get(ANIMAL_CROSSING_1).addColor(new Color(236,141,47));
        palette.get(ANIMAL_CROSSING_1).addColor(new Color(252,211,33));
        palette.get(ANIMAL_CROSSING_1).addColor(new Color(195,231,21));
        palette.get(ANIMAL_CROSSING_1).addColor(new Color(133,198,56));
        palette.get(ANIMAL_CROSSING_1).addColor(new Color(99,193,47));
        palette.get(ANIMAL_CROSSING_1).addColor(new Color(1,125,55));
        palette.get(ANIMAL_CROSSING_1).addColor(new Color(0,81,121));
        palette.get(ANIMAL_CROSSING_1).addColor(new Color(1,115,177));
        palette.get(ANIMAL_CROSSING_1).addColor(new Color(30,100,134));
        palette.get(ANIMAL_CROSSING_1).addColor(new Color(130,105,188));
        palette.get(ANIMAL_CROSSING_1).addColor(new Color(201,116,219));
        palette.get(ANIMAL_CROSSING_1).addColor(new Color(0,0,0));
        palette.get(ANIMAL_CROSSING_1).addColor(new Color(255,255,255));
        pSize.add(new Size(32,32));

        palette.add(new DSPalette());
        palette.get(ANIMAL_CROSSING_2).addColor(new Color(250,121,125));
        palette.get(ANIMAL_CROSSING_2).addColor(new Color(255,124,166));
        palette.get(ANIMAL_CROSSING_2).addColor(new Color(254,144,194));
        palette.get(ANIMAL_CROSSING_2).addColor(new Color(253,143,220));
        palette.get(ANIMAL_CROSSING_2).addColor(new Color(230,133,247));
        palette.get(ANIMAL_CROSSING_2).addColor(new Color(190,100,233));
        palette.get(ANIMAL_CROSSING_2).addColor(new Color(166,64,224));
        palette.get(ANIMAL_CROSSING_2).addColor(new Color(85,108,150));
        palette.get(ANIMAL_CROSSING_2).addColor(new Color(61,150,122));
        palette.get(ANIMAL_CROSSING_2).addColor(new Color(88,180,137));
        palette.get(ANIMAL_CROSSING_2).addColor(new Color(130,206,146));
        palette.get(ANIMAL_CROSSING_2).addColor(new Color(167,226,157));
        palette.get(ANIMAL_CROSSING_2).addColor(new Color(214,234,174));
        palette.get(ANIMAL_CROSSING_2).addColor(new Color(11,10,13));
        palette.get(ANIMAL_CROSSING_2).addColor(new Color(255,255,255));
        pSize.add(new Size(32,32));
        
        palette.add(new DSPalette());
        palette.get(ANIMAL_CROSSING_3).addColor(new Color(188,5,9));
        palette.get(ANIMAL_CROSSING_3).addColor(new Color(165,9,83));
        palette.get(ANIMAL_CROSSING_3).addColor(new Color(117,4,115));
        palette.get(ANIMAL_CROSSING_3).addColor(new Color(176,19,181));
        palette.get(ANIMAL_CROSSING_3).addColor(new Color(138,20,180));
        palette.get(ANIMAL_CROSSING_3).addColor(new Color(105,18,168));
        palette.get(ANIMAL_CROSSING_3).addColor(new Color(86,16,149));
        palette.get(ANIMAL_CROSSING_3).addColor(new Color(12,90,123));
        palette.get(ANIMAL_CROSSING_3).addColor(new Color(17,114,34));
        palette.get(ANIMAL_CROSSING_3).addColor(new Color(10,197,35));
        palette.get(ANIMAL_CROSSING_3).addColor(new Color(80,190,11));
        palette.get(ANIMAL_CROSSING_3).addColor(new Color(113,169,14));
        palette.get(ANIMAL_CROSSING_3).addColor(new Color(150,189,13));
        palette.get(ANIMAL_CROSSING_3).addColor(new Color(0,0,0));
        palette.get(ANIMAL_CROSSING_3).addColor(new Color(255,255,255));
        pSize.add(new Size(32,32));
        
        palette.add(new DSPalette());
        palette.get(ANIMAL_CROSSING_4).addColor(new Color(35,17,161));
        palette.get(ANIMAL_CROSSING_4).addColor(new Color(106,133,220));
        palette.get(ANIMAL_CROSSING_4).addColor(new Color(187,211,254));
        palette.get(ANIMAL_CROSSING_4).addColor(new Color(0,97,139));
        palette.get(ANIMAL_CROSSING_4).addColor(new Color(56,154,180));
        palette.get(ANIMAL_CROSSING_4).addColor(new Color(208,225,252));
        palette.get(ANIMAL_CROSSING_4).addColor(new Color(0,146,91));
        palette.get(ANIMAL_CROSSING_4).addColor(new Color(31,206,147));
        palette.get(ANIMAL_CROSSING_4).addColor(new Color(87,237,180));
        palette.get(ANIMAL_CROSSING_4).addColor(new Color(8,197,36));
        palette.get(ANIMAL_CROSSING_4).addColor(new Color(72,197,148));
        palette.get(ANIMAL_CROSSING_4).addColor(new Color(63,171,109));
        palette.get(ANIMAL_CROSSING_4).addColor(new Color(76,180,82));
        palette.get(ANIMAL_CROSSING_4).addColor(new Color(3,137,27));
        palette.get(ANIMAL_CROSSING_4).addColor(new Color(255,255,255));
        pSize.add(new Size(32,32));
        
        palette.add(new DSPalette());
        palette.get(ANIMAL_CROSSING_5).addColor(new Color(145,57,121));
        palette.get(ANIMAL_CROSSING_5).addColor(new Color(189,63,156));
        palette.get(ANIMAL_CROSSING_5).addColor(new Color(220,113,198));
        palette.get(ANIMAL_CROSSING_5).addColor(new Color(189,67,71));
        palette.get(ANIMAL_CROSSING_5).addColor(new Color(209,117,118));
        palette.get(ANIMAL_CROSSING_5).addColor(new Color(209,158,159));
        palette.get(ANIMAL_CROSSING_5).addColor(new Color(138,157,80));
        palette.get(ANIMAL_CROSSING_5).addColor(new Color(183,195,155));
        palette.get(ANIMAL_CROSSING_5).addColor(new Color(242,239,217));
        palette.get(ANIMAL_CROSSING_5).addColor(new Color(229,128,191));
        palette.get(ANIMAL_CROSSING_5).addColor(new Color(201,129,167));
        palette.get(ANIMAL_CROSSING_5).addColor(new Color(186,115,130));
        palette.get(ANIMAL_CROSSING_5).addColor(new Color(156,72,89));
        palette.get(ANIMAL_CROSSING_5).addColor(new Color(136,49,68));
        palette.get(ANIMAL_CROSSING_5).addColor(new Color(255,255,255));
        pSize.add(new Size(32,32));
        
        palette.add(new DSPalette());
        palette.get(ANIMAL_CROSSING_6).addColor(new Color(251,1,3));
        palette.get(ANIMAL_CROSSING_6).addColor(new Color(249,0,96));
        palette.get(ANIMAL_CROSSING_6).addColor(new Color(253,138,197));
        palette.get(ANIMAL_CROSSING_6).addColor(new Color(253,162,228));
        palette.get(ANIMAL_CROSSING_6).addColor(new Color(136,49,68));
        palette.get(ANIMAL_CROSSING_6).addColor(new Color(172,64,114));
        palette.get(ANIMAL_CROSSING_6).addColor(new Color(184,125,146));
        palette.get(ANIMAL_CROSSING_6).addColor(new Color(232,150,186));
        palette.get(ANIMAL_CROSSING_6).addColor(new Color(68,200,168));
        palette.get(ANIMAL_CROSSING_6).addColor(new Color(107,212,199));
        palette.get(ANIMAL_CROSSING_6).addColor(new Color(140,245,229));
        palette.get(ANIMAL_CROSSING_6).addColor(new Color(188,247,246));
        palette.get(ANIMAL_CROSSING_6).addColor(new Color(119,118,121));
        palette.get(ANIMAL_CROSSING_6).addColor(new Color(0,0,0));
        palette.get(ANIMAL_CROSSING_6).addColor(new Color(255,255,255));
        pSize.add(new Size(32,32));
        
        palette.add(new DSPalette());
        palette.get(ANIMAL_CROSSING_7).addColor(new Color(55,39,230));
        palette.get(ANIMAL_CROSSING_7).addColor(new Color(113,89,237));
        palette.get(ANIMAL_CROSSING_7).addColor(new Color(171,164,254));
        palette.get(ANIMAL_CROSSING_7).addColor(new Color(223,221,252));
        palette.get(ANIMAL_CROSSING_7).addColor(new Color(1,204,0));
        palette.get(ANIMAL_CROSSING_7).addColor(new Color(82,237,90));
        palette.get(ANIMAL_CROSSING_7).addColor(new Color(140,253,147));
        palette.get(ANIMAL_CROSSING_7).addColor(new Color(204,250,200));
        palette.get(ANIMAL_CROSSING_7).addColor(new Color(203,0,9));
        palette.get(ANIMAL_CROSSING_7).addColor(new Color(236,72,74));
        palette.get(ANIMAL_CROSSING_7).addColor(new Color(237,177,189));
        palette.get(ANIMAL_CROSSING_7).addColor(new Color(233,207,212));
        palette.get(ANIMAL_CROSSING_7).addColor(new Color(121,118,120));
        palette.get(ANIMAL_CROSSING_7).addColor(new Color(0,0,0));
        palette.get(ANIMAL_CROSSING_7).addColor(new Color(255,255,255));
        pSize.add(new Size(32,32));
        
        palette.add(new DSPalette());
        palette.get(ANIMAL_CROSSING_8).addColor(new Color(19,40,69));
        palette.get(ANIMAL_CROSSING_8).addColor(new Color(52,74,106));
        palette.get(ANIMAL_CROSSING_8).addColor(new Color(121,137,161));
        palette.get(ANIMAL_CROSSING_8).addColor(new Color(188,198,212));
        palette.get(ANIMAL_CROSSING_8).addColor(new Color(141,12,44));
        palette.get(ANIMAL_CROSSING_8).addColor(new Color(177,77,108));
        palette.get(ANIMAL_CROSSING_8).addColor(new Color(190,126,148));
        palette.get(ANIMAL_CROSSING_8).addColor(new Color(233,180,196));
        palette.get(ANIMAL_CROSSING_8).addColor(new Color(176,53,186));
        palette.get(ANIMAL_CROSSING_8).addColor(new Color(208,80,214));
        palette.get(ANIMAL_CROSSING_8).addColor(new Color(229,146,233));
        palette.get(ANIMAL_CROSSING_8).addColor(new Color(241,206,243));
        palette.get(ANIMAL_CROSSING_8).addColor(new Color(119,117,119));
        palette.get(ANIMAL_CROSSING_8).addColor(new Color(0,0,0));
        palette.get(ANIMAL_CROSSING_8).addColor(new Color(255,255,255));
        pSize.add(new Size(32,32));
        
        palette.add(new DSPalette());
        palette.get(ANIMAL_CROSSING_9).addColor(new Color(15,253,15));
        palette.get(ANIMAL_CROSSING_9).addColor(new Color(252,21,18));
        palette.get(ANIMAL_CROSSING_9).addColor(new Color(253,0,254));
        palette.get(ANIMAL_CROSSING_9).addColor(new Color(90,250,90));
        palette.get(ANIMAL_CROSSING_9).addColor(new Color(252,88,83));
        palette.get(ANIMAL_CROSSING_9).addColor(new Color(253,134,252));
        palette.get(ANIMAL_CROSSING_9).addColor(new Color(150,252,152));
        palette.get(ANIMAL_CROSSING_9).addColor(new Color(252,148,146));
        palette.get(ANIMAL_CROSSING_9).addColor(new Color(250,181,251));
        palette.get(ANIMAL_CROSSING_9).addColor(new Color(218,252,221));
        palette.get(ANIMAL_CROSSING_9).addColor(new Color(250,217,216));
        palette.get(ANIMAL_CROSSING_9).addColor(new Color(249,219,250));
        palette.get(ANIMAL_CROSSING_9).addColor(new Color(121,119,121));
        palette.get(ANIMAL_CROSSING_9).addColor(new Color(0,0,0));
        palette.get(ANIMAL_CROSSING_9).addColor(new Color(255,255,255));
        pSize.add(new Size(32,32));
        
        palette.add(new DSPalette());
        palette.get(ANIMAL_CROSSING_10).addColor(new Color(1,47,222));
        palette.get(ANIMAL_CROSSING_10).addColor(new Color(14,253,15));
        palette.get(ANIMAL_CROSSING_10).addColor(new Color(240,252,16));
        palette.get(ANIMAL_CROSSING_10).addColor(new Color(84,114,216));
        palette.get(ANIMAL_CROSSING_10).addColor(new Color(88,250,90));
        palette.get(ANIMAL_CROSSING_10).addColor(new Color(243,251,103));
        palette.get(ANIMAL_CROSSING_10).addColor(new Color(150,162,214));
        palette.get(ANIMAL_CROSSING_10).addColor(new Color(150,250,153));
        palette.get(ANIMAL_CROSSING_10).addColor(new Color(247,252,170));
        palette.get(ANIMAL_CROSSING_10).addColor(new Color(187,193,212));
        palette.get(ANIMAL_CROSSING_10).addColor(new Color(219,251,220));
        palette.get(ANIMAL_CROSSING_10).addColor(new Color(247,249,223));
        palette.get(ANIMAL_CROSSING_10).addColor(new Color(120,120,120));
        palette.get(ANIMAL_CROSSING_10).addColor(new Color(0,0,0));
        palette.get(ANIMAL_CROSSING_10).addColor(new Color(255,255,255));
        pSize.add(new Size(32,32));
        
        palette.add(new DSPalette());
        palette.get(ANIMAL_CROSSING_11).addColor(new Color(225,0,0));
        palette.get(ANIMAL_CROSSING_11).addColor(new Color(254,1,196));
        palette.get(ANIMAL_CROSSING_11).addColor(new Color(247,9,253));
        palette.get(ANIMAL_CROSSING_11).addColor(new Color(159,5,235));
        palette.get(ANIMAL_CROSSING_11).addColor(new Color(5,26,233));
        palette.get(ANIMAL_CROSSING_11).addColor(new Color(3,154,146));
        palette.get(ANIMAL_CROSSING_11).addColor(new Color(75,246,1));
        palette.get(ANIMAL_CROSSING_11).addColor(new Color(129,189,105));
        palette.get(ANIMAL_CROSSING_11).addColor(new Color(213,234,175));
        palette.get(ANIMAL_CROSSING_11).addColor(new Color(188,62,155));
        palette.get(ANIMAL_CROSSING_11).addColor(new Color(192,15,61));
        palette.get(ANIMAL_CROSSING_11).addColor(new Color(140,11,43));
        palette.get(ANIMAL_CROSSING_11).addColor(new Color(120,120,120));
        palette.get(ANIMAL_CROSSING_11).addColor(new Color(0,0,0));
        palette.get(ANIMAL_CROSSING_11).addColor(new Color(255,255,255));
        pSize.add(new Size(32,32));
        
        palette.add(new DSPalette());
        palette.get(ANIMAL_CROSSING_12).addColor(new Color(20,84,110));
        palette.get(ANIMAL_CROSSING_12).addColor(new Color(2,66,92));
        palette.get(ANIMAL_CROSSING_12).addColor(new Color(19,36,104));
        palette.get(ANIMAL_CROSSING_12).addColor(new Color(49,45,128));
        palette.get(ANIMAL_CROSSING_12).addColor(new Color(175,80,144));
        palette.get(ANIMAL_CROSSING_12).addColor(new Color(172,48,118));
        palette.get(ANIMAL_CROSSING_12).addColor(new Color(144,66,111));
        palette.get(ANIMAL_CROSSING_12).addColor(new Color(163,28,101));
        palette.get(ANIMAL_CROSSING_12).addColor(new Color(124,49,86));
        palette.get(ANIMAL_CROSSING_12).addColor(new Color(88,13,50));
        palette.get(ANIMAL_CROSSING_12).addColor(new Color(66,1,31));
        palette.get(ANIMAL_CROSSING_12).addColor(new Color(140,245,229));
        palette.get(ANIMAL_CROSSING_12).addColor(new Color(66,197,167));
        palette.get(ANIMAL_CROSSING_12).addColor(new Color(30,171,137));
        palette.get(ANIMAL_CROSSING_12).addColor(new Color(255,255,255));
        pSize.add(new Size(32,32));
        
        palette.add(new DSPalette());
        palette.get(ANIMAL_CROSSING_13).addColor(new Color(156,206,189));
        palette.get(ANIMAL_CROSSING_13).addColor(new Color(97,176,153));
        palette.get(ANIMAL_CROSSING_13).addColor(new Color(175,223,208));
        palette.get(ANIMAL_CROSSING_13).addColor(new Color(206,233,226));
        palette.get(ANIMAL_CROSSING_13).addColor(new Color(163,168,140));
        palette.get(ANIMAL_CROSSING_13).addColor(new Color(155,155,155));
        palette.get(ANIMAL_CROSSING_13).addColor(new Color(140,154,145));
        palette.get(ANIMAL_CROSSING_13).addColor(new Color(153,139,156));
        palette.get(ANIMAL_CROSSING_13).addColor(new Color(88,204,173));
        palette.get(ANIMAL_CROSSING_13).addColor(new Color(226,30,75));
        palette.get(ANIMAL_CROSSING_13).addColor(new Color(255,9,241));
        palette.get(ANIMAL_CROSSING_13).addColor(new Color(138,157,80));
        palette.get(ANIMAL_CROSSING_13).addColor(new Color(36,177,140));
        palette.get(ANIMAL_CROSSING_13).addColor(new Color(0,0,0));
        palette.get(ANIMAL_CROSSING_13).addColor(new Color(255,255,255));
        pSize.add(new Size(32,32));
        
        palette.add(new DSPalette());
        palette.get(ANIMAL_CROSSING_14).addColor(new Color(234,218,218));
        palette.get(ANIMAL_CROSSING_14).addColor(new Color(223,203,205));
        palette.get(ANIMAL_CROSSING_14).addColor(new Color(205,183,187));
        palette.get(ANIMAL_CROSSING_14).addColor(new Color(197,177,177));
        palette.get(ANIMAL_CROSSING_14).addColor(new Color(178,160,160));
        palette.get(ANIMAL_CROSSING_14).addColor(new Color(165,147,145));
        palette.get(ANIMAL_CROSSING_14).addColor(new Color(151,135,135));
        palette.get(ANIMAL_CROSSING_14).addColor(new Color(137,117,115));
        palette.get(ANIMAL_CROSSING_14).addColor(new Color(119,99,101));
        palette.get(ANIMAL_CROSSING_14).addColor(new Color(105,86,85));
        palette.get(ANIMAL_CROSSING_14).addColor(new Color(92,69,73));
        palette.get(ANIMAL_CROSSING_14).addColor(new Color(77,57,55));
        palette.get(ANIMAL_CROSSING_14).addColor(new Color(62,44,44));
        palette.get(ANIMAL_CROSSING_14).addColor(new Color(56,10,45));
        palette.get(ANIMAL_CROSSING_14).addColor(new Color(43,43,43));
        pSize.add(new Size(32,32));
        
        palette.add(new DSPalette());
        palette.get(ANIMAL_CROSSING_15).addColor(new Color(255,255,255));
        palette.get(ANIMAL_CROSSING_15).addColor(new Color(237,237,237));
        palette.get(ANIMAL_CROSSING_15).addColor(new Color(219,219,219));
        palette.get(ANIMAL_CROSSING_15).addColor(new Color(201,201,201));
        palette.get(ANIMAL_CROSSING_15).addColor(new Color(183,183,183));
        palette.get(ANIMAL_CROSSING_15).addColor(new Color(163,163,163));
        palette.get(ANIMAL_CROSSING_15).addColor(new Color(146,146,146));
        palette.get(ANIMAL_CROSSING_15).addColor(new Color(128,128,128));
        palette.get(ANIMAL_CROSSING_15).addColor(new Color(110,110,110));
        palette.get(ANIMAL_CROSSING_15).addColor(new Color(91,91,91));
        palette.get(ANIMAL_CROSSING_15).addColor(new Color(73,73,73));
        palette.get(ANIMAL_CROSSING_15).addColor(new Color(54,54,54));
        palette.get(ANIMAL_CROSSING_15).addColor(new Color(38,38,38));
        palette.get(ANIMAL_CROSSING_15).addColor(new Color(19,19,19));
        palette.get(ANIMAL_CROSSING_15).addColor(new Color(0,0,0));
        pSize.add(new Size(32,32));
        
        palette.add(new DSPalette());
        palette.get(ANIMAL_CROSSING_16).addColor(new Color(251,114,111));
        palette.get(ANIMAL_CROSSING_16).addColor(new Color(219,27,38));
        palette.get(ANIMAL_CROSSING_16).addColor(new Color(238,49,143));
        palette.get(ANIMAL_CROSSING_16).addColor(new Color(242,59,247));
        palette.get(ANIMAL_CROSSING_16).addColor(new Color(7,6,120));
        palette.get(ANIMAL_CROSSING_16).addColor(new Color(33,36,242));
        palette.get(ANIMAL_CROSSING_16).addColor(new Color(1,193,37));
        palette.get(ANIMAL_CROSSING_16).addColor(new Color(53,246,169));
        palette.get(ANIMAL_CROSSING_16).addColor(new Color(183,212,101));
        palette.get(ANIMAL_CROSSING_16).addColor(new Color(249,247,147));
        palette.get(ANIMAL_CROSSING_16).addColor(new Color(148,0,29));
        palette.get(ANIMAL_CROSSING_16).addColor(new Color(255,71,158));
        palette.get(ANIMAL_CROSSING_16).addColor(new Color(251,128,205));
        palette.get(ANIMAL_CROSSING_16).addColor(new Color(0,0,0));
        palette.get(ANIMAL_CROSSING_16).addColor(new Color(255,255,255));
        pSize.add(new Size(32,32));
        
        // NEED FOR SPEED: UNDERGROUND 2
        
        palette.add(new DSPalette());
        palette.get(NEED_FOR_SPEED_UNDERGROUND_2).addColor(new Color(243,89,80));
        palette.get(NEED_FOR_SPEED_UNDERGROUND_2).addColor(new Color(88,80,125));
        palette.get(NEED_FOR_SPEED_UNDERGROUND_2).addColor(new Color(60,164,82));
        palette.get(NEED_FOR_SPEED_UNDERGROUND_2).addColor(new Color(46,190,160));
        palette.get(NEED_FOR_SPEED_UNDERGROUND_2).addColor(new Color(101,105,167));
        palette.get(NEED_FOR_SPEED_UNDERGROUND_2).addColor(new Color(195,181,72));
        palette.get(NEED_FOR_SPEED_UNDERGROUND_2).addColor(new Color(51,201,218));
        palette.get(NEED_FOR_SPEED_UNDERGROUND_2).addColor(new Color(137,59,120));
        palette.get(NEED_FOR_SPEED_UNDERGROUND_2).addColor(new Color(245,213,37));
        palette.get(NEED_FOR_SPEED_UNDERGROUND_2).addColor(new Color(175,165,190));
        palette.get(NEED_FOR_SPEED_UNDERGROUND_2).addColor(new Color(205,123,161));
        palette.get(NEED_FOR_SPEED_UNDERGROUND_2).addColor(new Color(110,105,110));
        palette.get(NEED_FOR_SPEED_UNDERGROUND_2).addColor(new Color(191,63,63));
        palette.get(NEED_FOR_SPEED_UNDERGROUND_2).addColor(new Color(255,255,255));
        palette.get(NEED_FOR_SPEED_UNDERGROUND_2).addColor(new Color(62,179,77));
        palette.get(NEED_FOR_SPEED_UNDERGROUND_2).addColor(new Color(46,46,46));
        pSize.add(new Size(32,32));
        
        // NEED FOR SPEED: MOST WANTED
        
        palette.add(new DSPalette());
        palette.get(NEED_FOR_SPEED_MOST_WANTED).addColor(new Color(1,226,0));
        palette.get(NEED_FOR_SPEED_MOST_WANTED).addColor(new Color(255,255,255));
        palette.get(NEED_FOR_SPEED_MOST_WANTED).addColor(new Color(0,130,0));
        palette.get(NEED_FOR_SPEED_MOST_WANTED).addColor(new Color(195,195,195));
        palette.get(NEED_FOR_SPEED_MOST_WANTED).addColor(new Color(0,46,0));
        palette.get(NEED_FOR_SPEED_MOST_WANTED).addColor(new Color(0,0,0));
        palette.get(NEED_FOR_SPEED_MOST_WANTED).addColor(new Color(156,204,252));
        palette.get(NEED_FOR_SPEED_MOST_WANTED).addColor(new Color(251,204,0));
        palette.get(NEED_FOR_SPEED_MOST_WANTED).addColor(new Color(2,0,252));
        palette.get(NEED_FOR_SPEED_MOST_WANTED).addColor(new Color(251,0,0));
        palette.get(NEED_FOR_SPEED_MOST_WANTED).addColor(new Color(0,0,129));
        palette.get(NEED_FOR_SPEED_MOST_WANTED).addColor(new Color(130,0,0));
        palette.get(NEED_FOR_SPEED_MOST_WANTED).addColor(new Color(129,0,131));
        palette.get(NEED_FOR_SPEED_MOST_WANTED).addColor(new Color(251,1,249)); 
        pSize.add(new Size(32,32));
        
        // TONY HAWKS AMERICAN SK8LAND: GRAFITTI
        
        palette.add(new DSPalette());
        palette.get(TONY_HAWKS_AMERICAN_SK8LAND_GRAFITTI).addColor(new Color(255,255,255));
        palette.get(TONY_HAWKS_AMERICAN_SK8LAND_GRAFITTI).addColor(new Color(0,128,0));
        palette.get(TONY_HAWKS_AMERICAN_SK8LAND_GRAFITTI).addColor(new Color(0,128,255));
        palette.get(TONY_HAWKS_AMERICAN_SK8LAND_GRAFITTI).addColor(new Color(128,0,0));
        palette.get(TONY_HAWKS_AMERICAN_SK8LAND_GRAFITTI).addColor(new Color(128,0,128));
        palette.get(TONY_HAWKS_AMERICAN_SK8LAND_GRAFITTI).addColor(new Color(128,128,0));
        palette.get(TONY_HAWKS_AMERICAN_SK8LAND_GRAFITTI).addColor(new Color(0,0,0));
        palette.get(TONY_HAWKS_AMERICAN_SK8LAND_GRAFITTI).addColor(new Color(0,255,255));
        palette.get(TONY_HAWKS_AMERICAN_SK8LAND_GRAFITTI).addColor(new Color(255,128,64));
        palette.get(TONY_HAWKS_AMERICAN_SK8LAND_GRAFITTI).addColor(new Color(0,0,255));
        palette.get(TONY_HAWKS_AMERICAN_SK8LAND_GRAFITTI).addColor(new Color(0,255,0));
        palette.get(TONY_HAWKS_AMERICAN_SK8LAND_GRAFITTI).addColor(new Color(255,0,0));
        palette.get(TONY_HAWKS_AMERICAN_SK8LAND_GRAFITTI).addColor(new Color(255,255,0));
        palette.get(TONY_HAWKS_AMERICAN_SK8LAND_GRAFITTI).addColor(new Color(255,0,255));
        palette.get(TONY_HAWKS_AMERICAN_SK8LAND_GRAFITTI).addColor(new Color(192,192,192));
        pSize.add(new Size(64,64));
        
        // TONY HAWKS AMERICAN SK8LAND: DECKS
        
        palette.add(new DSPalette());
        palette.get(TONY_HAWKS_AMERICAN_SK8LAND_DECK).addColor(new Color(255,255,255));
        palette.get(TONY_HAWKS_AMERICAN_SK8LAND_DECK).addColor(new Color(0,128,0));
        palette.get(TONY_HAWKS_AMERICAN_SK8LAND_DECK).addColor(new Color(0,128,255));
        palette.get(TONY_HAWKS_AMERICAN_SK8LAND_DECK).addColor(new Color(128,0,0));
        palette.get(TONY_HAWKS_AMERICAN_SK8LAND_DECK).addColor(new Color(128,0,128));
        palette.get(TONY_HAWKS_AMERICAN_SK8LAND_DECK).addColor(new Color(128,128,0));
        palette.get(TONY_HAWKS_AMERICAN_SK8LAND_DECK).addColor(new Color(0,0,0));
        palette.get(TONY_HAWKS_AMERICAN_SK8LAND_DECK).addColor(new Color(0,255,255));
        palette.get(TONY_HAWKS_AMERICAN_SK8LAND_DECK).addColor(new Color(255,128,64));
        palette.get(TONY_HAWKS_AMERICAN_SK8LAND_DECK).addColor(new Color(0,0,255));
        palette.get(TONY_HAWKS_AMERICAN_SK8LAND_DECK).addColor(new Color(0,255,0));
        palette.get(TONY_HAWKS_AMERICAN_SK8LAND_DECK).addColor(new Color(255,0,0));
        palette.get(TONY_HAWKS_AMERICAN_SK8LAND_DECK).addColor(new Color(255,255,0));
        palette.get(TONY_HAWKS_AMERICAN_SK8LAND_DECK).addColor(new Color(255,0,255));
        palette.get(TONY_HAWKS_AMERICAN_SK8LAND_DECK).addColor(new Color(192,192,192));
        pSize.add(new Size(32,64));

    }
    
    public static int getColors(int p)
    {
        return palette.get(p).color.size();
    }
    
    public static Color getColor(int p,int index)
    {
        return palette.get(p).color.get(index);
    }
    
    /** Create a new GameImage
     * @param Palette Target Palette
     * @param img Original Image
     */
    public GameImage(int Palette, BufferedImage img) 
    {
        setColor(Color.BLACK);
        image = new BufferedImage(pSize.get(Palette).getWidth(),pSize.get(Palette).getHeight(),BufferedImage.TYPE_INT_RGB); 
        PBN = new int[image.getWidth()][image.getHeight()];
        Graphics2D g2 = (Graphics2D) image.getGraphics();
        g2.drawImage(img,0,0,pSize.get(Palette).getWidth(),pSize.get(Palette).getHeight(),null);
        CurrentPalette = Palette;
        for (int x=0;x<pSize.get(Palette).getWidth();x++)
        {
            for (int y=0;y<pSize.get(Palette).getHeight();y++)
            {
                int RGB = image.getRGB(x,y);
                Color c = new Color(RGB);
                c = palette.get(Palette).ClosestColor(c);
                PBN[x][y] = palette.get(Palette).intClosestColor(c);
                image.setRGB(x,y,c.getRGB());
            }
        }
    }
    
    public void setImage(BufferedImage img)
    {
        Graphics2D g2 = (Graphics2D) image.getGraphics();
        if ((image.getWidth() != pSize.get(CurrentPalette).getWidth())||(image.getHeight() != pSize.get(CurrentPalette).getHeight())) 
        {
         image = new BufferedImage(pSize.get(CurrentPalette).getWidth(),pSize.get(CurrentPalette).getHeight(),BufferedImage.TYPE_INT_RGB);   
         PBN = new int[image.getWidth()][image.getHeight()];
         g2 = (Graphics2D) image.getGraphics();
        }
        g2.drawImage(img,0,0,pSize.get(CurrentPalette).getWidth(),pSize.get(CurrentPalette).getHeight(),null);
        for (int x=0;x<pSize.get(CurrentPalette).getWidth();x++)
        {
            for (int y=0;y<pSize.get(CurrentPalette).getHeight();y++)
            {
                int RGB = image.getRGB(x,y);
                Color c = new Color(RGB);
                c = palette.get(CurrentPalette).ClosestColor(c);
                PBN[x][y] = palette.get(CurrentPalette).intClosestColor(c);
                image.setRGB(x,y,c.getRGB());
            }
        }
    }
    public void setImage(BufferedImage img, int p)
    {
        CurrentPalette = p;
        Graphics2D g2 = (Graphics2D) image.getGraphics();
        if ((image.getWidth() != pSize.get(CurrentPalette).getWidth())||(image.getHeight() != pSize.get(CurrentPalette).getHeight())) 
        {
         image = new BufferedImage(pSize.get(CurrentPalette).getWidth(),pSize.get(CurrentPalette).getHeight(),BufferedImage.TYPE_INT_RGB);
         PBN = new int[image.getWidth()][image.getHeight()];
         g2 = (Graphics2D) image.getGraphics();
        }
        g2.drawImage(img,0,0,pSize.get(CurrentPalette).getWidth(),pSize.get(CurrentPalette).getHeight(),null);
        for (int x=0;x<pSize.get(CurrentPalette).getWidth();x++)
        {
            for (int y=0;y<pSize.get(CurrentPalette).getHeight();y++)
            {
                int RGB = image.getRGB(x,y);
                Color c = new Color(RGB);
                c = palette.get(CurrentPalette).ClosestColor(c);
                PBN[x][y] = palette.get(CurrentPalette).intClosestColor(c);
                image.setRGB(x,y,c.getRGB());
            }
        }
    }
    
    public void setColor(Color c)
    {
        color = c;
    }
    
    public void draw(int x,int y)
    {
        image.setRGB(x,y,color.getRGB());
    }
    
    public BufferedImage getImage()
    {
        return image;
    }
    
    public int[][] getPBN()
    {
        return PBN;
    }
}


class Size
{
    /** Create a new Size
     * @param Width the Width
     * @param Height the Height
     */
    private int Width;
    private int Height;
    public Size(int w, int h)
    {
        Width = w;
        Height = h;
    }
    public int getWidth()
    {
        return Width;
    }
    
    public int getHeight()
    {
        return Height;
    }
}
