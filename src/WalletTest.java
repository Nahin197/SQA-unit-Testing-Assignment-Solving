import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WalletTest {



   @Test
    public void initial_wallet_balance_check() {
       Wallet w=new Wallet();
       System.out.println(w.getBalance());

       assertEquals(0.0,w.getBalance(),"Intial balance should be zero");

   }

   @Test
    public void adding_balance_then_check() {

       Wallet w1=new Wallet(12);
       assertEquals(12,w1.getBalance(),"adding balance should be equal to 12");

   }

   @Test
    public void addFundTest() {
       Wallet w1=new Wallet(12);
       w1.addFunds(12);
       assertEquals(24,w1.getBalance(),"adding funds should be equal to 24");

   }
    @Test
    public void deductFundsTest() {
        Wallet w1=new Wallet(12);
        w1.addFunds(20);
        w1.deductFunds(12);
        assertEquals(20,w1.getBalance(),"Deducting funds should be equal to 20");

    }
    @Test
    public void deductFundsExceptionTest() {
        Wallet w1=new Wallet(12);
        w1.addFunds(20);
        InsufficientFundsException ex= assertThrows(
                InsufficientFundsException.class,
                () -> w1.deductFunds(200)  // withdraw more than available
        );

        assertEquals("Insufficient funds in wallet.", ex.getMessage());

    }
    @Test
    public void deductFundsInvalidExceptionTest() {
        Wallet w1=new Wallet(12);

        InvalidAmountException ex= assertThrows(
                InvalidAmountException.class,
                () -> w1.addFunds(-2)

        );

        assertEquals("Invalid amount. Amount must be positive.", ex.getMessage());

    }

    @Test
    public void TranferFundsTest() {

        Wallet toWallet=new Wallet();
        Wallet w1=new Wallet(12);

        InvalidAmountException ex= assertThrows(
                InvalidAmountException.class,
                () -> w1.transferFunds(toWallet,-2)

        );

//        assertEquals("Invalid amount. Amount must be positive.", ex.getMessage());


        InsufficientFundsException In = assertThrows(

                InsufficientFundsException.class,
                () -> w1.transferFunds(toWallet,20)

        );

//        assertEquals("Insufficient funds in wallet.",In.getMessage());


      // here im checking whether the tranfer balance
        double a=w1.getBalance();
        double b=8;
        w1.transferFunds(toWallet,b);
         double c=a-b;

         assertAll("TranferFundsTest Method Testing",
                () -> assertEquals("Invalid amount. Amount must be positive.", ex.getMessage()) ,
                () -> assertEquals("Insufficient funds in wallet.",In.getMessage()),
                () -> assertEquals(c,w1.getBalance()),
                () -> assertEquals(b,toWallet.getBalance())


        );


    }







}
