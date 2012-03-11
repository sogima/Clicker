 /**
 * Copyright (C) <year>  <name of author>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program. If not, see <http://www.gnu.org/licenses/>
 */
package clicker;

import java.awt.Robot;
import java.awt.event.InputEvent;

/**
 * Class used to implement an automatic clicker.
 * The number of clicks si specified as a parameter.
 * It starts to click in the current position of the mouse, after
 * a small amount of time used to set the position, until it finishes.
 */
public class Clicker
{
    /** Field corresponding to a Robot that simulates user's actions */
    private static Robot r;

    /**
     * Default constructor used for initialize the java Robot
     */
    public Clicker()
    {
        try
        {
            r = new Robot();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Method used to execute some clicks repeatedly.
     * @param numClick Numbers of clicks to execute
     */
    public void ClickByNum(Integer numClick)
    {
        int count = 0;
        while (count++ < numClick)
        {
            r.mousePress(InputEvent.BUTTON1_MASK);
            r.mouseRelease(InputEvent.BUTTON1_MASK);
        }
    }

    /**
     * Method used to click for a fixed amount of time.
     * @param numSec Number of seconds on which click repeteadly
     */
    public void ClickByTime(Integer numSec)
    {
        long start = System.currentTimeMillis();
        while (true)
        {
            long end = System.currentTimeMillis();
            if ((end - start) / 1000 >= numSec)
                break;
            r.mousePress(InputEvent.BUTTON1_MASK);
            r.mouseRelease(InputEvent.BUTTON1_MASK);
        }
    }
}
