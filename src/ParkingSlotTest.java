import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;


public class ParkingSlotTest {

    ParkingSlotType parType= ParkingSlotType.COMPACT;

    ParkingSlot par = new ParkingSlot("1",parType);


    @Test
    public void slotIDTest() {

        String slotID = par.getSlotId();
        assertEquals(slotID, par.getSlotId());

    }

    @Test
    public void slotTypeTest() {

       assertSame(parType, par.getSlotType());
    }
    @Test
    public void isActiveTest() {

        assertTrue(par.isActive());
    }

//    @Test
//    public void isactiveTest() {
//
//        assertTrue(par.isActive());
//    }

    @Test
    public void getWalletTest() {

      assertNotNull(par.getWallet());
    }
    @Test
    public void getBookingsTest() {

        assertNotNull(par.getBookings());

    }

    @Test
    public void isCompatible_IFisActiveTest() {

        VehicleType vType=VehicleType.MOTORCYCLE;
        LocalDateTime start = LocalDateTime.of(2025, 10, 8, 18, 0);
        LocalDateTime end = LocalDateTime.of(2025, 10, 8, 18, 0);

        boolean a= par.isActive();
        System.out.println(a);
        assertTrue(par.isCompatible(vType,start,end));

    }

    @Test
    public void deactivateTest() {

        par.deactivate();
        assertFalse(par.isActive());

        VehicleType vType=VehicleType.MOTORCYCLE;
        LocalDateTime start = LocalDateTime.of(2025, 10, 8, 18, 0);
        LocalDateTime end = LocalDateTime.of(2025, 10, 8, 20, 0);

        assertFalse(par.isCompatible(vType,start,end));


    }

    @Test
    public void vehicleCompatibilityTypeTest() {


        LocalDateTime s1 = LocalDateTime.of(2025, 10, 8, 10, 0);
        LocalDateTime e1 = LocalDateTime.of(2025, 10, 8, 12, 0);

        //Testing for car
        //car mainly uses Regular and large

        //testing using Compact which is unvalid

        ParkingSlotType parType= ParkingSlotType.COMPACT;

        ParkingSlot par1 = new ParkingSlot("1",parType);
        VehicleType type = VehicleType.CAR;

        assertFalse(par1.isCompatible(type, e1, s1));

        //Car, real Compatibility Test
        parType= ParkingSlotType.LARGE;
        ParkingSlot par2 = new ParkingSlot("1",parType);

        assertTrue(par2.isCompatible(type, e1, s1),"Only Large and regular valid for Car type");



    }

    @Test
    public void isCompatibleTesting_foroverlap_forNotOverlap() {

//        ParkingSlot par = new ParkingSlot("1",parType);

        VehicleType type=VehicleType.MOTORCYCLE;



        //creating booking 1
        Vehicle v1=new Vehicle(1,VehicleType.CAR,new Wallet());
        LocalDateTime s1 = LocalDateTime.of(2025, 10, 8, 10, 0);
        LocalDateTime e1 = LocalDateTime.of(2025, 10, 8, 12, 0);
//        ParkingSlot slot1 = new ParkingSlot("1",ParkingSlotType.COMPACT);

        Booking b1=new Booking(1,v1,par,s1,e1,200);

        //creating booking 2

        Vehicle v2=new Vehicle(2,VehicleType.MICROCAR,new Wallet());
        LocalDateTime s2 = LocalDateTime.of(2025, 10, 8, 13, 0);
        LocalDateTime e2 = LocalDateTime.of(2025, 10, 8, 15, 0);

        Booking b2=new Booking(2,v2,par,s2,e2 ,200);

        //creating booking 3

        Vehicle v3=new Vehicle(3,VehicleType.BICYCLE,new Wallet());
        LocalDateTime s3 = LocalDateTime.of(2025, 10, 8, 16, 0);
        LocalDateTime e3 = LocalDateTime.of(2025, 10, 8, 18, 0);

        Booking b3=new Booking(3,v3,par,s3,e3 ,200);

        par.getBookings().add(b1);
        par.getBookings().add(b2);
        par.getBookings().add(b3);

        //Now testing isCompatible method
        VehicleType vType=VehicleType.MOTORCYCLE;


        LocalDateTime start = LocalDateTime.of(2025, 10, 8, 18, 0);
        LocalDateTime end = LocalDateTime.of(2025, 10, 8, 19, 0);


        //for not time overlapping problem
        System.out.println( par.isActive());
        assertTrue(par.isCompatible(vType,start,end),"Time overlapping problem");



        //for time overlapping testing

        VehicleType vType1=VehicleType.MOTORCYCLE;
        LocalDateTime start1 = LocalDateTime.of(2025, 10, 8, 15, 0);
        LocalDateTime end1 = LocalDateTime.of(2025, 10, 8, 18, 0);

        assertFalse(par.isCompatible(vType1,start1,end1),"No time overlapping problem");

    }

    @Test
    public void incorrectTimeRangeTest() {
        ParkingSlot par = new ParkingSlot("1",parType);

        VehicleType type=VehicleType.MOTORCYCLE;



        //creating booking 1
        Vehicle v1=new Vehicle(1,VehicleType.CAR,new Wallet());
        LocalDateTime s1 = LocalDateTime.of(2025, 10, 8, 10, 0);
        LocalDateTime e1 = LocalDateTime.of(2025, 10, 8, 12, 0);
//        ParkingSlot slot1 = new ParkingSlot("1",ParkingSlotType.COMPACT);

        Booking b1=new Booking(1,v1,par,s1,e1,200);

        //creating booking 2

        Vehicle v2=new Vehicle(2,VehicleType.MICROCAR,new Wallet());
        LocalDateTime s2 = LocalDateTime.of(2025, 10, 8, 12, 0);
        LocalDateTime e2 = LocalDateTime.of(2025, 10, 8, 15, 0);

        Booking b2=new Booking(2,v2,par,s2,e2 ,200);

        //creating booking 3

        Vehicle v3=new Vehicle(3,VehicleType.BICYCLE,new Wallet());
        LocalDateTime s3 = LocalDateTime.of(2025, 10, 8, 15, 0);
        LocalDateTime e3 = LocalDateTime.of(2025, 10, 8, 18, 0);

        Booking b3=new Booking(3,v3,par,s3,e3 ,200);

        par.getBookings().add(b1);
        par.getBookings().add(b2);
        par.getBookings().add(b3);


        //Testing invalid time order where startTime is after endTime
        VehicleType vType = VehicleType.CAR;
        LocalDateTime start = LocalDateTime.of(2025, 10, 8, 18, 0);
        LocalDateTime end = LocalDateTime.of(2025, 10, 8, 18, 0);

       //testing for same start and end time
        boolean result = par.isCompatible(vType, start, end);
        System.out.println(result);
        assertFalse(result);


        LocalDateTime start1 = LocalDateTime.of(2025, 10, 8, 18, 0);
        LocalDateTime end1 = LocalDateTime.of(2025, 10, 8, 10, 0);

        //testing for start > end time
        boolean result1 = par.isCompatible(vType, start, end);
        System.out.println(result1);
        assertFalse(result1);


    }


    @Test
    public void nullVehicleTypeCompatibilityTest() {

        VehicleType vType = null;
        LocalDateTime start = LocalDateTime.of(2025, 10, 8, 10, 0);
        LocalDateTime end = LocalDateTime.of(2025, 10, 8, 12, 0);

//        assertFalse(result, "System should return false when VehicleType is null but currently throws exception.");
        assertThrows(Exception.class,()->par.isCompatible(vType, start, end));
    }


    @Test
    public void startAndEndTimeNUllTesting() {

        ParkingSlot par = new ParkingSlot("1",parType);

        VehicleType type=VehicleType.MOTORCYCLE;



        //creating booking 1
        Vehicle v1=new Vehicle(1,VehicleType.CAR,new Wallet());
        LocalDateTime s1 = LocalDateTime.of(2025, 10, 8, 10, 0);
        LocalDateTime e1 = LocalDateTime.of(2025, 10, 8, 12, 0);
//        ParkingSlot slot1 = new ParkingSlot("1",ParkingSlotType.COMPACT);

        Booking b1=new Booking(1,v1,par,s1,e1,200);

        //creating booking 2

        Vehicle v2=new Vehicle(2,VehicleType.MICROCAR,new Wallet());
        LocalDateTime s2 = LocalDateTime.of(2025, 10, 8, 13, 0);
        LocalDateTime e2 = LocalDateTime.of(2025, 10, 8, 15, 0);

        Booking b2=new Booking(2,v2,par,s2,e2 ,200);

        //creating booking 3
        Vehicle v3=new Vehicle(3,VehicleType.BICYCLE,new Wallet());
        LocalDateTime s3 = LocalDateTime.of(2025, 10, 8, 16, 0);
        LocalDateTime e3 = LocalDateTime.of(2025, 10, 8, 18, 0);

        Booking b3=new Booking(3,v3,par,s3,e3 ,200);

        par.getBookings().add(b1);
        par.getBookings().add(b2);
        par.getBookings().add(b3);


        VehicleType vType = VehicleType.MOTORCYCLE;
        LocalDateTime start = null;
        LocalDateTime end = null;

         assertThrows(Exception.class,()->par.isCompatible(vType, start, end));

    }

    @Test
    public void timesNUllTestWithoutAnyBookingTimes() {

        //here im tesing with null times where there are no booking times in the system

        ParkingSlot par = new ParkingSlot("1",parType);
        VehicleType type=VehicleType.MOTORCYCLE;
        Vehicle v1=new Vehicle(1,VehicleType.CAR,new Wallet());
        LocalDateTime s1 =null;
        LocalDateTime e1 = null;
        boolean result=par.isCompatible(type,s1,e1);

        assertTrue(result);



    }


    @Test
    public void invalidParkingSlotID() {

        assertThrows(Exception.class,()->new ParkingSlot("acvd",parType));

    }

    @Test
    public void  parkingslotTypeNUllTest() {

        assertThrows(Exception.class, () -> new ParkingSlot("1", null));

    }
    @Test
    public void BookingFrom_curentday_to_another_day_test() {

        ParkingSlot par = new ParkingSlot("1", ParkingSlotType.LARGE);


        Vehicle v1 = new Vehicle(1, VehicleType.CAR, new Wallet());

        LocalDateTime s = LocalDateTime.of(2025, 10, 8, 23, 0);
        LocalDateTime e = LocalDateTime.of(2025, 10, 9, 1, 0);
        boolean nextDayResult = par.isCompatible(VehicleType.CAR, s, e);
        assertTrue(nextDayResult);
    }










}
