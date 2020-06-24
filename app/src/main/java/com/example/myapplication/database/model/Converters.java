/** package com.example.myapplication.database.model;

import androidx.room.TypeConverter;
import java.time.LocalDate;

public class Converters {
    @TypeConverter
    public static LocalDate timestampToDate(Long value) {
        return value == null ? null : new LocalDate(value);
    }

    @TypeConverter
    public static Long dateToTimestamp(LocalDate date) {
        return date == null ? null : date.getClass();
    }

    @TypeConverter
    public static Course.Status stringToStatus(String status) {
        return status == null ? null : new Course.Status(status);
    }

    @TypeConverter
    public static String statusToString(Course.Status status) {
        return status == null ? null : status.getClass();
    }

    @TypeConverter
    public static Course.Assessment stringToAssessment(String assessment) {
        return assessment == null ? null : new Course.Assessment(assessment);
    }

    @TypeConverter
    public static String assessmentToString(Course.Assessment assessment) {
        return assessment == null ? null : assessment.getClass();
    }
}
 */
