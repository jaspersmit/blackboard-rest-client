package org.jbsmit.blackboardRestClient.model;

import java.time.Instant;
import java.util.List;

public class CalendarItemRecurrence {
    /*
     * Recurrence count indicating how many times the calendar item should be repeated. Either this count OR the 'until' date is/'should be' set. When creating a calendar item, 'until' date will be used if both 'until' date and the count are set.
     */
    private int count;

    /*
     * Frequency of the calendar item repeated.
     *
     *
     * | Type      | Description
     *  | --------- | --------- |
     * | Monthly |  |
     * | Weekly |  |
     * | Daily |  |
     *
     */
    private Frequency frequency;

    /*
     * Interval between recurrences depends on the repeating type. For example, if the calendar times should be repeated every three weeks, you need set interval to 3 as well as frequency to "Weekly". Minimum and Maximum allowed Intervals are 1 and 100 respectively.
     */
    private int interval;

    /*
     * This property is used in conjunction with the 'Monthly' frequency and it indicates on which day of the month the calendar item is/'should be' repeated on. The valid values are valid month days, that is, 1 to 31. Either this OR both 'monthPosition' and 'repeatDay' should be set to create a recurring calendar item with 'Monthly' frequency.
     */
    private int monthRepeatDay;

    /*
     * This property is used in conjunction with the 'Monthly' frequency and it indicates that the calendar item is/'should be' repeated on nth occurrence of 'repeatDay' in the month. Valid values for 'monthPosition' are integers in the range of -1 and 4 inclusive: -1 for the last occurrence, 1 for the first occurrence, 2 for the second occurrence, and so on. 0 is not used.
     */
    private int monthPosition;

    /*
     * The original start date for the calendar item.
     */
    private Instant originalStart;

    /*
     * The original end date for the calendar item.
     */
    private Instant originalEnd;

    /*
     * Calendar item that's repeated is part of a recurring series of calendar events but the item has been changed since its original creation. In other words, the calendar item has been modified to no longer align with the recurring series (day/time changed for example) of events. This can only be true if the calendar item is repeatable.
     */
    private boolean repeatBroken;

    /*
     * For monthly recurring event, repeat by day of week.
     *
     *
     * | Type      | Description
     *  | --------- | --------- |
     * | Sunday |  |
     * | Monday |  |
     * | Tuesday |  |
     * | Wednesday |  |
     * | Thursday |  |
     * | Friday |  |
     * | Saturday |  |
     *
     */
    private RepeatDay repeatDay;

    /*
     * The date the calendar item should be repeated until. Either this 'until' date OR the count is/'should be' set. When creating a calendar item, 'until' date will be used if both 'until' date and the count are set.
     */
    private Instant until;

    /*
     * This property is used in conjunction with the 'Weekly' frequency and it indicates the days of the week the calendar item should be repeated on.
     */
    private List<BYDAYEnum> weekDays;


    public enum Frequency {
        Monthly,
        Weekly,
        Daily
    }

    public enum RepeatDay {
        Sunday,
        Monday,
        Tuesday,
        Wednesday,
        Thursday,
        Friday,
        Saturday
    }

    public int getCount() {
        return count;
    }

    public CalendarItemRecurrence setCount(int count) {
        this.count = count;
        return this;
    }

    public Frequency getFrequency() {
        return frequency;
    }

    public CalendarItemRecurrence setFrequency(Frequency frequency) {
        this.frequency = frequency;
        return this;
    }

    public int getInterval() {
        return interval;
    }

    public CalendarItemRecurrence setInterval(int interval) {
        this.interval = interval;
        return this;
    }

    public int getMonthRepeatDay() {
        return monthRepeatDay;
    }

    public CalendarItemRecurrence setMonthRepeatDay(int monthRepeatDay) {
        this.monthRepeatDay = monthRepeatDay;
        return this;
    }

    public int getMonthPosition() {
        return monthPosition;
    }

    public CalendarItemRecurrence setMonthPosition(int monthPosition) {
        this.monthPosition = monthPosition;
        return this;
    }

    public Instant getOriginalStart() {
        return originalStart;
    }

    public CalendarItemRecurrence setOriginalStart(Instant originalStart) {
        this.originalStart = originalStart;
        return this;
    }

    public Instant getOriginalEnd() {
        return originalEnd;
    }

    public CalendarItemRecurrence setOriginalEnd(Instant originalEnd) {
        this.originalEnd = originalEnd;
        return this;
    }

    public boolean getRepeatBroken() {
        return repeatBroken;
    }

    public CalendarItemRecurrence setRepeatBroken(boolean repeatBroken) {
        this.repeatBroken = repeatBroken;
        return this;
    }

    public RepeatDay getRepeatDay() {
        return repeatDay;
    }

    public CalendarItemRecurrence setRepeatDay(RepeatDay repeatDay) {
        this.repeatDay = repeatDay;
        return this;
    }

    public Instant getUntil() {
        return until;
    }

    public CalendarItemRecurrence setUntil(Instant until) {
        this.until = until;
        return this;
    }

    public List<BYDAYEnum> getWeekDays() {
        return weekDays;
    }

    public CalendarItemRecurrence setWeekDays(List<BYDAYEnum> weekDays) {
        this.weekDays = weekDays;
        return this;
    }
}

