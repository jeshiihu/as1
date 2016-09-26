package com.huynh.jess.jhuynh_habittracker;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Jess on 2016-09-26.
 */

public class DaysSetTest
{
    @Test
    public void isDayContainedEmpty() throws Exception
    {
        DaysSet days = new DaysSet();
        assert(days.size() == 0);
    }

    @Test
    public void addDaySingle() throws Exception
    {
        DaysSet days = new DaysSet();
        days.addDay(DaysSet.Day.Fri);
        assertTrue(days.isDayContained(DaysSet.Day.Fri));
    }

    @Test
    public void addDaySingleInvalid() throws Exception
    {
        DaysSet days = new DaysSet();
        days.addDay(DaysSet.Day.Fri);
        assertFalse(days.isDayContained(DaysSet.Day.Tue));
    }

    @Test
    public void addDayMultiple() throws Exception
    {
        DaysSet days = new DaysSet();
        days.addDay(DaysSet.Day.Fri);
        days.addDay(DaysSet.Day.Sun);
        days.addDay(DaysSet.Day.Wed);
        assertTrue(days.isDayContained(DaysSet.Day.Sun));
    }

    @Test
    public void addDayMultipleInvalid() throws Exception
    {
        DaysSet days = new DaysSet();
        days.addDay(DaysSet.Day.Fri);
        days.addDay(DaysSet.Day.Sun);
        days.addDay(DaysSet.Day.Wed);
        assertFalse(days.isDayContained(DaysSet.Day.Sat));
    }

    @Test
    public void removeDaySingle() throws Exception
    {
        DaysSet days = new DaysSet();
        days.addDay(DaysSet.Day.Fri);

        assert(days.size() == 1);

        days.removeDay(DaysSet.Day.Fri);
        assert(days.size() == 0);
    }
}
