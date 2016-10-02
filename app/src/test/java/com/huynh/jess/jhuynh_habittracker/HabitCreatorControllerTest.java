package com.huynh.jess.jhuynh_habittracker;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Jess on 2016-09-29.
 */

public class HabitCreatorControllerTest
{
    @Test
    public void testSetTitle()
    {
        HabitCreatorController manager = new HabitCreatorController();
        manager.setTitle("Eat a cookie");

        assertSame(manager.getTitle(),"Eat a cookie");
    }

    @Test
    public void testSetDateByDate() throws Exception
    {
        HabitCreatorController manager = new HabitCreatorController();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse("2016-01-13");
        manager.setCreatedDateByDate(date);

        assert(manager.getCreatedDate().equals("2016-01-13"));
    }

    @Test
    public void testSetDateByStringValid()
    {
        HabitCreatorController manager = new HabitCreatorController();
        manager.setCreatedDateByStr("2013-09-20");
        assert(manager.getCreatedDate().equals("2013-09-20"));
    }

    @Test
    public void testSetDateByStringInvalid() throws Exception
    {
        HabitCreatorController manager = new HabitCreatorController();
        manager.setCreatedDateByStr("2013-09-80000");
        assert(manager.getCreatedDate().equals("2013-09-80000"));
    }

    @Test
    public void testSetDateByStringInvalidAlpha() throws Exception
    {
        HabitCreatorController manager = new HabitCreatorController();
        manager.setCreatedDateByStr("2l13-09-08");
        assert(manager.getCreatedDate().equals("2l13-09-08"));
    }

    @Test // since we tested DaysSet we know what ever we call from it will work, hopefully!
    public void testGetDaySetEmpty()
    {
        HabitCreatorController manager = new HabitCreatorController();
        assert(manager.getDaysSet().isEmpty());
    }

    @Test // since we tested DaysSet we know what ever we call from it will work, hopefully!
    public void testSetDaySet()
    {
        HabitCreatorController manager = new HabitCreatorController();
        DaysSet days = new DaysSet();
        manager.setDaysSet(days);

        assertSame(manager.getDaysSet(), days);
    }

    @Test
    public void isValidTitleInvalid()
    {
        HabitCreatorController manager = new HabitCreatorController();
        assertFalse(manager.isValidTitle());
    }

    @Test
    public void isValidTitleValid()
    {
        HabitCreatorController manager = new HabitCreatorController();
        manager.setTitle("Clean");

        assert(manager.isValidTitle());
    }

    @Test
    public void isValidDateInvalid()
    {
        HabitCreatorController manager = new HabitCreatorController();
        manager.setCreatedDateByStr("20166-09-28");

        assertFalse(manager.isValidDate());
    }

    @Test
    public void isValidDateInvalidAlpha()
    {
        HabitCreatorController manager = new HabitCreatorController();
        manager.setCreatedDateByStr("2000-a9-29");
        assertFalse(manager.isValidDate());
    }

    @Test
    public void isValidDateValid()
    {
        HabitCreatorController manager = new HabitCreatorController();
        manager.setCreatedDateByStr("2016-09-28");
        assert(manager.isValidDate());
    }

    @Test
    public void isValidRepeatSelectionInvalid()
    {
        HabitCreatorController manager = new HabitCreatorController();
        DaysSet days = new DaysSet();
        manager.setDaysSet(days);

        assertFalse(manager.isValidRepeatSelection());
    }

    @Test
    public void isValidRepeatSelectionValid()
    {
        HabitCreatorController manager = new HabitCreatorController();
        DaysSet days = new DaysSet();
        days.addDay(DaysSet.Day.Monday);
        days.addDay(DaysSet.Day.Saturday);
        manager.setDaysSet(days);

        assert(manager.isValidRepeatSelection());
    }

    public void generateCreatedHabit() throws Exception
    {
        HabitCreatorController manager = new HabitCreatorController();
        manager.setTitle("clean");
        manager.setCreatedDateByStr("1995-12-13");
        manager.getDaysSet().addDay(DaysSet.Day.Monday);

        assert(manager.generateCreatedHabit().getTitle().equals("clean"));
        assert(manager.generateCreatedHabit().getDays().equals("clean"));
        assert(manager.generateCreatedHabit().getTitle().equals("clean"));
    }
}
