package io.pivotal.apps.mochibackend.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class CompareDates {

  private static final DateFormat JUST_DATE = new SimpleDateFormat("yyyy-MM-dd");

  private static Date stripTime(Date fullDate) throws ParseException {
    return JUST_DATE.parse(JUST_DATE.format(fullDate));
  }

  static boolean areSameDate(Date date1, Date date2) {
    try {
      return stripTime(date1).equals(stripTime(date2));
    } catch (ParseException e) {
      return false;
    }
  }
}
