package connections;

import com.sun.net.httpserver.Headers;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Client {

    public static void main(String[] args)
    {
        System.out.println("THE CLIENT\n");


        /*int startyear = 2017;
        int startmonth = 11;
        int startday = 10;

        int endyear = 2017;
        int endmonth = 12;
        int endday = 25;*/


        try
        {
            System.out.print("Client connecting... ");

            /*URL url = new URL("http://www.ncdc.noaa.gov/swdiws/xml/warn/"
                    +startyear+startmonth+startday+
                    ":"+endyear+endmonth+endday);*/

            URL url = new URL("https://api.twitter.com/1.1/search/tweets.json");

            String urlString = url.toString();

            Headers header = new Headers();

            String token = "2874292722-FTI8Ak0b7XcchnyCNS2OASn3XnT4Ba1zwAISMXN";

            InetAddress address = InetAddress.getByName(new URL(urlString).getHost()); //, header = token


            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");


            String key = "token =";
            String value= token;


            Map<String, String> parameters = new HashMap<>();
            parameters.put(key, value);

            con.setDoOutput(true);
            DataOutputStream out = new DataOutputStream(con.getOutputStream());
            out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
            out.flush();
            out.close();

            //con.setRequestProperty(key, value);

            try (Socket cSocket = new Socket(address, 80);
                 PrintWriter outWriter = new PrintWriter(cSocket.getOutputStream(), true);
                 BufferedReader br = new BufferedReader(new InputStreamReader(cSocket.getInputStream())))
            {
                System.out.println("Success\n");
                Scanner scnr = new Scanner(System.in);

                String searchTerm;
                while (true)
                {
                    System.out.print("Enter a search term (\"Q\" to quit): ");
                    String inputLine = scnr.nextLine();
                    if (inputLine.equalsIgnoreCase("q"))
                    {
                        break;
                    }
                    else {
                        searchTerm= inputLine;
                    }
                    System.out.println(inputLine);
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
