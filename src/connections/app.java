package connections;

import java.io.IOException;
import java.net.InetAddress;

public class app
{
    public static void main(String args[])
    {
        try
        {
            InetAddress addr = InetAddress.getByName("www.psu.edu");
            System.out.println(addr.getCanonicalHostName());
            System.out.println(addr.getHostAddress());
            System.out.println(addr.isReachable(5000));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

    }
}

// Test commit from @Adriannosaurus