import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class BookingTest {

    LocalDateTime s1 = LocalDateTime.of(2025, 10, 8, 10, 0);
    LocalDateTime e1 = LocalDateTime.of(2025, 10, 8, 12, 0);
    VehicleType type= VehicleType.CAR;
    Vehicle v= new Vehicle(1,type,200.0);
    ParkingSlot pt =new ParkingSlot("1",ParkingSlotType.COMPACT);
    Booking book =new Booking(1,v,pt,s1,e1,200.0);

    @Test
    void testBookIdTest(){
        assertEquals(1,book.getBookingId(),"book id not match");
    }
    @Test
    void getVehicleTest(){
        assertNotNull(book.getVehicle(),"vehicle null");
        assertEquals(v,book.getVehicle(),"vehicle not match");
    }
    @Test
    void getParkingSlotsTest(){
        assertNotNull(book.getParkingSlot(),"parking slot null");
        assertEquals(pt, book.getParkingSlot(),"vehicle not match");
    }

    @Test
    void  getStartTimeTest(){
        assertEquals(s1,book.getStartTime(),"start time not match");
    }

    @Test
    void  getEndTime(){
        assertEquals(e1,book.getEndTime(),"end time not match");
    }

    @Test
    void  getAmountTest(){
        assertEquals(200.0,book.getAmount(),"amount not match");
    }
    @Test
    void  getBookingStatusTest(){
        assertEquals(BookingStatus.ACTIVE,book.getBookingStatus(),"booking status not match");
        System.out.println(book);
    }

    @Test
    void  completeBookingTest(){
      book.completeBooking();
      assertEquals(BookingStatus.COMPLETED,book.getBookingStatus(),"booking status not match");
    }

    @Test
    void  cancelBookingTest(){
        book.cancelBooking();
        assertEquals(BookingStatus.CANCELLED,book.getBookingStatus(),"booking status not match");
    }



















}
