package connections;

import java.io.IOException;
import java.net.InetAddress;

public class app {


    public static void main(String args[])
    {
        try
        {
            InetAddress addr = InetAddress.getByName("www.psu.edu");
            System.out.println("1. "+addr.getCanonicalHostName());
            System.out.println("2. "+addr.getHostAddress());
            System.out.println("3. "+addr.isReachable(5000));
            System.out.println("4. "+addr.getHostName());
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

    }
}
