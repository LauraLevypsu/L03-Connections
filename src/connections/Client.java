package connections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.util.Scanner;

public class Client {

    public static void main(String[] args)
    {
        System.out.println("THE CLIENT\n");


        int startyear = 2017;
        int startmonth = 11;
        int startday = 10;

        int endyear = 2017;
        int endmonth = 12;
        int endday = 25;


        try
        {
            System.out.print("Client connecting... ");
            //i think localAdd might b an inaccurate name.
            URL url = new URL("http://www.ncdc.noaa.gov/swdiws/'xml'/'warn'/"
                    +startyear+startmonth+startday+
                    ":"+endyear+endmonth+endday);

            String urlString = url.toString();

            InetAddress address = InetAddress.getByName(new URL(urlString).getHost());

            try (Socket cSocket = new Socket(address, 6000);//last value (the boolean one) refers to the stream
                 PrintWriter out = new PrintWriter(cSocket.getOutputStream(), true);
                 BufferedReader br = new BufferedReader(new InputStreamReader(cSocket.getInputStream())))
            {
                System.out.println("Success\n");
                Scanner scnr = new Scanner(System.in);
                while (true)
                {
                    System.out.print("Enter a message (\"Q\" to quit): ");
                    String inputLine = scnr.nextLine();
                    if (inputLine.equalsIgnoreCase("q"))
                    {
                        break;
                    }
                    out.println(inputLine);
                    String response = br.readLine();
                    System.out.println("   Server response: " + response);
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        System.out.println("\nGoodbye");

    }

}
