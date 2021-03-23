package com.jan.challenges;

import com.jan.interfaces.IChallange;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UnitOfLengthConversionTest {

    IChallange unitOfLengthConversion = new UnitOfLengthConversion();

    @Test
    void testExecute_mm_to_x() {

        // mm to mm
        assertEquals(10.0, (double) unitOfLengthConversion.execute(new Object[]{UnitOfLengthConversion.FROM_MILLIMETER, UnitOfLengthConversion.TO_MILLIMETER, 10.0}));

        // mm to cm
        assertEquals(2.5, (double) unitOfLengthConversion.execute(new Object[]{UnitOfLengthConversion.FROM_MILLIMETER, UnitOfLengthConversion.TO_CENTIMETER, 25.0}));

        // mm to m
        assertEquals(19.846, (double) unitOfLengthConversion.execute(new Object[]{UnitOfLengthConversion.FROM_MILLIMETER, UnitOfLengthConversion.TO_METER, 19846.0}));

        // mm to km
        assertEquals(9.874986, (double) unitOfLengthConversion.execute(new Object[]{UnitOfLengthConversion.FROM_MILLIMETER, UnitOfLengthConversion.TO_KILOMETER, 9874986.0}));

        // mm to inch
        assertEquals(35.19685039356, (double) unitOfLengthConversion.execute(new Object[]{UnitOfLengthConversion.FROM_MILLIMETER, UnitOfLengthConversion.TO_INCH, 894.0}));

        // mm to feet
        assertEquals(5527.45406821936, (double) unitOfLengthConversion.execute(new Object[]{UnitOfLengthConversion.FROM_MILLIMETER, UnitOfLengthConversion.TO_FEET, 1684768.0}));

        // mm to mile
        assertEquals(1.2091765339685483, (double) unitOfLengthConversion.execute(new Object[]{UnitOfLengthConversion.FROM_MILLIMETER, UnitOfLengthConversion.TO_MILE, 1945981.0}));
    }


    @Test
    void testExecute_cm_to_x() {

        // cm to mm
        assertEquals(100.0, (double) unitOfLengthConversion.execute(new Object[]{UnitOfLengthConversion.FROM_CENTIMETER, UnitOfLengthConversion.TO_MILLIMETER, 10.0}));

        // cm to cm
        assertEquals(25.0, (double) unitOfLengthConversion.execute(new Object[]{UnitOfLengthConversion.FROM_CENTIMETER, UnitOfLengthConversion.TO_CENTIMETER, 25.0}));

        // cm to m
        assertEquals(198.46, (double) unitOfLengthConversion.execute(new Object[]{UnitOfLengthConversion.FROM_CENTIMETER, UnitOfLengthConversion.TO_METER, 19846.0}));

        // cm to km
        assertEquals(1.25845, (double) unitOfLengthConversion.execute(new Object[]{UnitOfLengthConversion.FROM_CENTIMETER, UnitOfLengthConversion.TO_KILOMETER, 125845.0}));

        // cm to inch
        assertEquals(1806.6929133785998, (double) unitOfLengthConversion.execute(new Object[]{UnitOfLengthConversion.FROM_CENTIMETER, UnitOfLengthConversion.TO_INCH, 4589.0}));

        // cm to feet
        assertEquals(868.9960629886499, (double) unitOfLengthConversion.execute(new Object[]{UnitOfLengthConversion.FROM_CENTIMETER, UnitOfLengthConversion.TO_FEET, 26487.0}));

        // cm to mile
        assertEquals(2.584121231849828, (double) unitOfLengthConversion.execute(new Object[]{UnitOfLengthConversion.FROM_CENTIMETER, UnitOfLengthConversion.TO_MILE, 415874.0}));
    }


    @Test
    void testExecute_m_to_x() {

        // m to mm
        assertEquals(3500, (double) unitOfLengthConversion.execute(new Object[]{UnitOfLengthConversion.FROM_METER, UnitOfLengthConversion.TO_MILLIMETER, 3.5}));

        // m to cm
        assertEquals(9870, (double) unitOfLengthConversion.execute(new Object[]{UnitOfLengthConversion.FROM_METER, UnitOfLengthConversion.TO_CENTIMETER, 98.7}));

        // m to m
        assertEquals(19846.0, (double) unitOfLengthConversion.execute(new Object[]{UnitOfLengthConversion.FROM_METER, UnitOfLengthConversion.TO_METER, 19846.0}));

        // m to km
        assertEquals(21.984, (double) unitOfLengthConversion.execute(new Object[]{UnitOfLengthConversion.FROM_METER, UnitOfLengthConversion.TO_KILOMETER, 21984.0}));

        // m to inch
        assertEquals(1889.7637795199998, (double) unitOfLengthConversion.execute(new Object[]{UnitOfLengthConversion.FROM_METER, UnitOfLengthConversion.TO_INCH, 48.0}));

        // m to feet
        assertEquals(40.3543307085, (double) unitOfLengthConversion.execute(new Object[]{UnitOfLengthConversion.FROM_METER, UnitOfLengthConversion.TO_FEET, 123.0}));

        // m to mile
        assertEquals(30.431032766802797, (double) unitOfLengthConversion.execute(new Object[]{UnitOfLengthConversion.FROM_METER, UnitOfLengthConversion.TO_MILE, 48974.0}));
    }


    @Test
    void testExecute_km_to_x() {

        // km to mm
        assertEquals(1.2e+7, (double) unitOfLengthConversion.execute(new Object[]{UnitOfLengthConversion.FROM_KILOMETER, UnitOfLengthConversion.TO_MILLIMETER, 12.0}));

        // km to cm
        assertEquals(800000, (double) unitOfLengthConversion.execute(new Object[]{UnitOfLengthConversion.FROM_KILOMETER, UnitOfLengthConversion.TO_CENTIMETER, 8.0}));

        // km to m
        assertEquals(9850.0, (double) unitOfLengthConversion.execute(new Object[]{UnitOfLengthConversion.FROM_KILOMETER, UnitOfLengthConversion.TO_METER, 9.85}));

        // km to km
        assertEquals(21984.0, (double) unitOfLengthConversion.execute(new Object[]{UnitOfLengthConversion.FROM_KILOMETER, UnitOfLengthConversion.TO_KILOMETER, 21984.0}));

        // km to inch
        assertEquals(387795.27558899997, (double) unitOfLengthConversion.execute(new Object[]{UnitOfLengthConversion.FROM_KILOMETER, UnitOfLengthConversion.TO_INCH, 9.85}));

        // km to feet
        assertEquals(6561.67979, (double) unitOfLengthConversion.execute(new Object[]{UnitOfLengthConversion.FROM_KILOMETER, UnitOfLengthConversion.TO_FEET, 2.0}));

        // km to mile
        assertEquals(98.17664836760001, (double) unitOfLengthConversion.execute(new Object[]{UnitOfLengthConversion.FROM_KILOMETER, UnitOfLengthConversion.TO_MILE, 158.0}));
    }


    @Test
    void testExecute_inch_to_x() {

        // inch to mm
        assertEquals(504545.6, (double) unitOfLengthConversion.execute(new Object[]{UnitOfLengthConversion.FROM_INCH, UnitOfLengthConversion.TO_MILLIMETER, 19864.0}));

        // inch to cm
        assertEquals(25072.34, (double) unitOfLengthConversion.execute(new Object[]{UnitOfLengthConversion.FROM_INCH, UnitOfLengthConversion.TO_CENTIMETER, 9871.0}));

        // inch to m
        assertEquals(499.8212, (double) unitOfLengthConversion.execute(new Object[]{UnitOfLengthConversion.FROM_INCH, UnitOfLengthConversion.TO_METER, 19678.0}));

        // inch to km
        assertEquals(13.9661138, (double) unitOfLengthConversion.execute(new Object[]{UnitOfLengthConversion.FROM_INCH, UnitOfLengthConversion.TO_KILOMETER, 549847.0}));

        // inch to inch
        assertEquals(4894.54, (double) unitOfLengthConversion.execute(new Object[]{UnitOfLengthConversion.FROM_INCH, UnitOfLengthConversion.TO_INCH, 4894.54}));

        // inch to feet
        assertEquals(16541.4933834, (double) unitOfLengthConversion.execute(new Object[]{UnitOfLengthConversion.FROM_INCH, UnitOfLengthConversion.TO_FEET, 198498.0}));

        // inch to mile
        assertEquals(7.2077651593572, (double) unitOfLengthConversion.execute(new Object[]{UnitOfLengthConversion.FROM_INCH, UnitOfLengthConversion.TO_MILE, 456684.0}));
    }


    @Test
    void testExecute_foot_to_x() {

        // foot to mm
        assertEquals(1568500.8, (double) unitOfLengthConversion.execute(new Object[]{UnitOfLengthConversion.FROM_FOOT, UnitOfLengthConversion.TO_MILLIMETER, 5146.0}));

        // foot to cm
        assertEquals(51419.76, (double) unitOfLengthConversion.execute(new Object[]{UnitOfLengthConversion.FROM_FOOT, UnitOfLengthConversion.TO_CENTIMETER, 1687.0}));

        // foot to m
        assertEquals(5997.8544, (double) unitOfLengthConversion.execute(new Object[]{UnitOfLengthConversion.FROM_FOOT, UnitOfLengthConversion.TO_METER, 19678.0}));

        // foot to km
        assertEquals(1651.9196832, (double) unitOfLengthConversion.execute(new Object[]{UnitOfLengthConversion.FROM_FOOT, UnitOfLengthConversion.TO_KILOMETER, 5419684.0}));

        // foot to inch
        assertEquals(1476.0, (double) unitOfLengthConversion.execute(new Object[]{UnitOfLengthConversion.FROM_FOOT, UnitOfLengthConversion.TO_INCH, 123.0}));

        // foot to feet
        assertEquals(198498.0, (double) unitOfLengthConversion.execute(new Object[]{UnitOfLengthConversion.FROM_FOOT, UnitOfLengthConversion.TO_FEET, 198498.0}));

        // foot to mile
        assertEquals(79.52161635600001, (double) unitOfLengthConversion.execute(new Object[]{UnitOfLengthConversion.FROM_FOOT, UnitOfLengthConversion.TO_MILE, 419874.0}));
    }

    @Test
    void testExecute_mile_to_x() {

        // foot to mm
        assertEquals(804670.0, (double) unitOfLengthConversion.execute(new Object[]{UnitOfLengthConversion.FROM_MILE, UnitOfLengthConversion.TO_MILLIMETER, 0.5}));

        // foot to cm
        assertEquals(321868.0, (double) unitOfLengthConversion.execute(new Object[]{UnitOfLengthConversion.FROM_MILE, UnitOfLengthConversion.TO_CENTIMETER, 2.0}));

        // mile to m
        assertEquals(8801480.459999999, (double) unitOfLengthConversion.execute(new Object[]{UnitOfLengthConversion.FROM_MILE, UnitOfLengthConversion.TO_METER, 5469.0}));

        // mile to km
        assertEquals(1981.097076027278, (double) unitOfLengthConversion.execute(new Object[]{UnitOfLengthConversion.FROM_MILE, UnitOfLengthConversion.TO_KILOMETER, 1230.9997117}));

        // foot to inch
        assertEquals(47520.0, (double) unitOfLengthConversion.execute(new Object[]{UnitOfLengthConversion.FROM_MILE, UnitOfLengthConversion.TO_INCH, 0.75}));

        // foot to feet
        assertEquals(25344, (double) unitOfLengthConversion.execute(new Object[]{UnitOfLengthConversion.FROM_MILE, UnitOfLengthConversion.TO_FEET, 4.8}));

        // mile to mile
        assertEquals(419874.0, (double) unitOfLengthConversion.execute(new Object[]{UnitOfLengthConversion.FROM_MILE, UnitOfLengthConversion.TO_MILE, 419874.0}));
    }
}
