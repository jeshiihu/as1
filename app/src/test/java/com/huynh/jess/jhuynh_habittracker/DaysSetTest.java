package com.huynh.jess.jhuynh_habittracker;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Jess on 2016-09-26.
 */

public class DaysSetTest
{
    @Test
    public void testIsDayContainedEmpty() throws Exception
    {
        DaysSet days = new DaysSet();
        assert(days.size() == 0);
    }

    @Test
    public void testAddDaySingle() throws Exception
    {
        DaysSet days = new DaysSet();
        days.addDay(DaysSet.Day.Friday);
        assertTrue(days.isDayContained(DaysSet.Day.Friday));
    }

    @Test
    public void testAddDaySingleInvalid() throws Exception
    {
        DaysSet days = new DaysSet();
        days.addDay(DaysSet.Day.Friday);
        assertFalse(days.isDayContained(DaysSet.Day.Tuesday));
    }

    @Test
    public void testAddDayMultiple() throws Exception
    {
        DaysSet days = new DaysSet();
        days.addDay(DaysSet.Day.Friday);
        days.addDay(DaysSet.Day.Sunday);
        days.addDay(DaysSet.Day.Wednesday);
        assertTrue(days.isDayContained(DaysSet.Day.Sunday));
    }

    @Test
    public void testAddDayMultipleInvalid() throws Exception
    {
        DaysSet days = new DaysSet();
        days.addDay(DaysSet.Day.Friday);
        days.addDay(DaysSet.Day.Sunday);
        days.addDay(DaysSet.Day.Wednesday);
        assertFalse(days.isDayContained(DaysSet.Day.Saturday));
    }

    @Test
    public void testRemoveEmpty() throws Exception
    {
        DaysSet days = new DaysSet();
        days.removeDay(DaysSet.Day.Friday); // make sure no exception thrown
    }

    @Test
    public void testRemoveDaySingle() throws Exception
    {
        DaysSet days = new DaysSet();
        days.addDay(DaysSet.Day.Friday);

        assert(days.size() == 1);

        days.removeDay(DaysSet.Day.Friday);
        assert(days.size() == 0);
    }

    @Test
    public void testRemoveDayMultiple() throws Exception
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
