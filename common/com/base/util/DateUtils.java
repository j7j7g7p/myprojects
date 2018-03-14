package com.base.util;

import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class DateUtils
{

    public DateUtils()
    {
    }

    public static String sub(Date date, Date date1)
    {
        long l = date.getTime() / 1000L;
        long l1 = date1.getTime() / 1000L;
        long l2 = l1 - l;
        long l3 = l2 / 24L / 60L / 60L;
        long l4 = (l2 - l3 * 24L * 60L * 60L) / 3600L;
        long l5 = (l2 - l3 * 24L * 60L * 60L - l4 * 60L * 60L) / 60L;
        long l6 = l2 - l3 * 24L * 60L * 60L - l4 * 60L * 60L - l5 * 60L;
        String s = l3 != 0L ? (new StringBuilder()).append(l3).append("\u5929 ").toString() : "";
        String s1 = l4 != 0L ? (new StringBuilder()).append(l4).append("\u5C0F\u65F6 ").toString() : "";
        String s2 = l5 != 0L ? (new StringBuilder()).append(l5).append("\u5206\u949F ").toString() : "";
        String s3 = l6 != 0L ? (new StringBuilder()).append(l6).append("\u79D2").toString() : "";
        String s4 = (new StringBuilder()).append(s).append(s1).append(s2).append(s3).toString();
        return s4;
    }

    public static int getProcess(Date date, Date date1)
    {
        long l = date.getTime() / 1000L;
        long l1 = date1.getTime() / 1000L;
        long l2 = now().getTime() / 1000L;
        long l3 = l1 - l2;
        long l4 = l1 - l;
        Double double1 = Double.valueOf(((double)l3 * 100D) / (double)l4);
        int i = 100 - double1.intValue();
        if(i > 100)
            i = 100;
        if(i < 0)
            i = 0;
        return i;
    }

    public static String getStr(Date date)
    {
        if(date == null)
        {
            return null;
        } else
        {
            SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return simpledateformat.format(date);
        }
    }

    public static String getStr(long l)
    {
        long l1 = now().getTime();
        Date date = new Date(l1 + l);
        return getStr(date);
    }

    public static String nowStr()
    {
        return getStr(now());
    }

    public static String nowStrYYYYMMddHHmmssSSS()
    {
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String s = simpledateformat.format(now());
        return s;
    }

    public static String nowStr2()
    {
        return getStr(new Date());
    }

    public static long nowTime()
    {
        Date date = now();
        long l = date.getTime();
        return l;
    }

    public static Date now()
    {
        return new Date();
    }

    public static Date getDate(String s)
    {
        Date date = null;
        try
        {
            SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            date = simpledateformat.parse(s);
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        return date;
    }

    public static int getInt(double d)
    {
        return (new Double(d)).intValue();
    }

    public static String uuid()
    {
        UUID uuid1 = UUID.randomUUID();
        return uuid1.toString();
    }

    public static boolean isNull(String s)
    {
        return s == null || "".equals(s) || s.equalsIgnoreCase("null");
    }

    public static String nullToEmpty(String s)
    {
        if(s == null || "".equals(s) || s.equalsIgnoreCase("null"))
            return "";
        else
            return s;
    }

    public static String emptyToNull(String s)
    {
        if(s == null || "".equals(s) || s.equalsIgnoreCase("null"))
            return null;
        else
            return s;
    }

    public static Date adjust(Date date)
    {
        long l = nowTime();
        long l1 = date.getTime();
        long l2 = (new Date()).getTime();
        long l3 = l1 + (l2 - l);
        Date date1 = new Date(l3);
        return date1;
    }

    public static String nowLocal()
    {
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String s = simpledateformat.format(new Date());
        return s;
    }

    public static void main(String args[])
        throws Exception
    {
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpledateformat.parse("2012-03-01 10:00:00");
        Date date1 = simpledateformat.parse("2012-03-01 10:06:00");
        System.out.println(getProcess(date, date1));
        System.out.println(nowLocal());
    }
}


/*
	DECOMPILATION REPORT

	Decompiled from: D:\workspace\section2\iRoad\web\WEB-INF\lib\framework.jar
	Total time: 109 ms
	Jad reported messages/errors:
	Exit status: 0
	Caught exceptions:
*/