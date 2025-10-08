
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VehicleTest {


    VehicleType vehicleType=VehicleType.CAR;

    Wallet w=new Wallet();

    Vehicle v=new Vehicle(1,vehicleType,w);


    @Test

    public void getVehicleIdTest() {

        assertEquals(1,v.getVehicleId(),"vehicle id is not correct");

    }

    @Test

    public void getVehicleTypeTest() {
//        vehicleType=VehicleType.TRUCK;

        assertEquals(vehicleType,v.getVehicleType(),"vehicle type is not correct");

    }
    @Test
    public void getWalletTest() {
//        Wallet w1=new Wallet();
        assertEquals(w,v.getWallet(),"wallet is not correct");


    }


    @Test
    public void vehicleWalletBalanceTest() {
        Vehicle v1=new Vehicle(1,vehicleType,200);

        assertEquals(200,v1.wallet.getBalance(),"vehicle id is not correct");


    }

    @Test
    public void tosrtingTest() {
      //  Vehicle v1=new Vehicle();
       assertNotNull(v,"this object should not be null");


    }



}
