/*
 * @(#)Utils.java
 *
 * Copyright (c) 2013 JASPER DISPLAY, Inc.
 * An Unpublished Work.  All Rights Reserved.
 *
 * JASPER DISPLAY PROPRIETARY:  Distribution of this source code
 * without permission from the copyright holder is strictly forbidden.
 */

package com.jasper.core.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Utils class
 *
 * @version 1.0 28 Aug 2013
 *
 * @author sonnv
 *
 */
public class Utils {
    
    public static String dateNow() {
        String rs = "";
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
        rs = dateFormat.format(date);
        
        return rs;
    }
    
}
