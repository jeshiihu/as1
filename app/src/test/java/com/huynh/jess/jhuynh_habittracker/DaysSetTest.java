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
        days.addDay(DaysSet.Day.Friday);
        assertTrue(days.isDayContained(DaysSet.Day.Friday));
    }

    @Test
    public void addDaySingleInvalid() throws Exception
    {
        DaysSet days = new DaysSet();
        days.addDay(DaysSet.Day.Friday);
        assertFalse(days.isDayContained(DaysSet.Day.Tuesday));
    }

    @Test
    public void addDayMultiple() throws Exception
    {
        DaysSet days = new DaysSet();
        days.addDay(DaysSet.Day.Friday);
        days.addDay(DaysSet.Day.Sunday);
        days.addDay(DaysSet.Day.Wednesday);
        assertTrue(days.isDayContained(DaysSet.Day.Sunday));
    }

    @Test
    public void addDayMultipleInvalid() throws Exception
    {
        DaysSet days = new DaysSet();
        days.addDay(DaysSet.Day.Friday);
        days.addDay(DaysSet.Day.Sunday);
        days.addDay(DaysSet.Day.Wednesday);
        assertFalse(days.isDayContained(DaysSet.Day.Saturday));
    }

    @Test
    public void removeEmpty() throws Exception
    {
        DaysSet days = new DaysSet();
        days.removeDay(DaysSet.Day.Friday); // make sure no exception thrown
    }

    @Test
    public void removeDaySingle() throws Exception
    {
        DaysSet days = new DaysSet();
        days.addDay(DaysSet.Day.Friday);

        assert(days.size() == 1);

        days.removeDay(DaysSet.Day.Friday);
        assert(days.size() == 0);
    }

    @Test
    public void removeDayMultiple() throws Exception
    {
        DaysSet days = new DaysSet();
        days.addDay(DaysSet.Day.Friday);
        days.addDay(DaysSet.Day.Sunday);
        days.addDay(DaysSet.Day.Wednesday);

        assert(days.size() == 3);

        days.removeDay(DaysSet.Day.Sunday);
        assert(days.size() == 2);
    }
}
