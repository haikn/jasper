/*
 * @(#)EduUIMainProg.java
 *
 * Copyright (c) 2013 JASPER DISPLAY, Inc.
 * An Unpublished Work.  All Rights Reserved.
 *
 * JASPER DISPLAY PROPRIETARY:  Distribution of this source code
 * without permission from the copyright holder is strictly forbidden.
 */
package com.jasper;

import java.io.IOException;


public class EduUIMainProg {

	public static void main(String[] args) throws IOException{
            KeyReader keyreader = new KeyReader();
            boolean key = keyreader.verifyKey();
            if(key == false) {
                System.exit(0);
            }
            
            EduPatternShowOn.main(args);
	}
}
