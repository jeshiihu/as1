package com.huynh.jess.jhuynh_habittracker;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by Jess on 2016-09-29.
 */

public class HabitCreatorManagerTest
{
    @Test
    public void testSetTitle()
    {
        HabitCreatorManager manager = new HabitCreatorManager();
        manager.setTitle("Eat a cookie");

        assertSame(manager.getTitle(),"Eat a cookie");
    }

    @Test
    public void testSetDateByDate() throws Exception
    {
        HabitCreatorManager manager = new HabitCreatorManager();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse("2016-01-13");
        manager.setCreatedDateByDate(date);

        assert(manager.getCreatedDate().equals("2016-01-13"));
    }

    @Test
    public void testSetDateByStringValid()
    {
        HabitCreatorManager manager = new HabitCreatorManager();
        manager.setCreatedDateByStr("2013-09-20");
        assert(manager.getCreatedDate().equals("2013-09-20"));
    }

    @Test
    public void testSetDateByStringInvalid() throws Exception
    {
        HabitCreatorManager manager = new HabitCreatorManager();
        manager.setCreatedDateByStr("2013-09-80000");
        assert(manager.getCreatedDate().equals("2013-09-80000"));
    }

    @Test
    public void testSetDateByStringInvalidAlpha() throws Exception
    {
        HabitCreatorManager manager = new HabitCreatorManager();
        manager.setCreatedDateByStr("2l13-09-08");
        assert(manager.getCreatedDate().equals("2l13-09-08"));
    }

    @Test // since we tested DaysSet we know what ever we call from it will work, hopefully!
    public void testGetDaySetEmpty()
    {
        HabitCreatorManager manager = new HabitCreatorManager();
        assert(manager.getDaysSet().isEmpty());
    }

    @Test // since we tested DaysSet we know what ever we call from it will work, hopefully!
    public void testSetDaySet()
    {
        HabitCreatorManager manager = new HabitCreatorManager();
        DaysSet days = new DaysSet();
        manager.setDaysSet(days);

        assertSame(manager.getDaysSet(), days);
    }

    @Test
    public void isValidTitleInvalid()
    {
        HabitCreatorManager manager = new HabitCreatorManager();
        assertFalse(manager.isValidTitle());
    }

    @Test
    public void isValidTitleValid()
    {
        HabitCreatorManager manager = new HabitCreatorManager();
        manager.setTitle("Clean");

        assert(manager.isValidTitle());
    }

    @Test
    public void isValidDateInvalid()
    {
        HabitCreatorManager manager = new HabitCreatorManager();
        manager.setCreatedDateByStr("20166-09-28");

        assertFalse(manager.isValidDate());
    }

    @Test
    public void isValidDateInvalidAlpha()
    {
        HabitCreatorManager manager = new HabitCreatorManager();
        manager.setCreatedDateByStr("2000-a9-29");
        assertFalse(manager.isValidDate());
    }

    @Test
    public void isValidDateValid()
    {
        HabitCreatorManager manager = new HabitCreatorManager();
        manager.setCreatedDateByStr("2016-09-28");
        assert(manager.isValidDate());
    }

    @Test
    public void isValidRepeatSelectionInvalid()
    {
        HabitCreatorManager manager = new HabitCreatorManager();
        DaysSet days = new DaysSet();
        manager.setDaysSet(days);

        assertFalse(manager.isValidRepeatSelection());
    }

    @Test
    public void isValidRepeatSelectionValid()
    {
        HabitCreatorManager manager = new HabitCreatorManager();
        DaysSet days = new DaysSet();
        days.addDay(DaysSet.Day.Monday);
        days.addDay(DaysSet.Day.Saturday);
        manager.setDaysSet(days);

        assert(manager.isValidRepeatSelection());
    }

    public void generateCreatedHabit() throws Exception
    {
        HabitCreatorManager manager = new HabitCreatorManager();
        manager.setTitle("clean");
        manager.setCreatedDateByStr("1995-12-13");
        manager.getDaysSet().addDay(DaysSet.Day.Monday);

        assert(manager.generateCreatedHabit().getTitle().equals("clean"));
        assert(manager.generateCreatedHabit().getDays().equals("clean"));
        assert(manager.generateCreatedHabit().getTitle().equals("clean"));
    }
}
