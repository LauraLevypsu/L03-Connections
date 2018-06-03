package connections;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;

public class app
{
    public static void main(String args[])
    {
        /*try
        {
            InetAddress addr = InetAddress.getByName("www.ncdc.noaa.gov/cdo-web/api/v2/datasets");
            //NOAA Token if someone figures that out: wyYHemlmRuFKCNLHqauEjyhsqDwLDfMR
            System.out.println("Canon Host Name: " + addr.getCanonicalHostName());
            System.out.println("Host Name: " + addr.getHostName());
            System.out.println("Host Address: " + addr.getHostAddress());
            System.out.println("Reachable: " + addr.isReachable(5000));
            
            
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }*/
        
        
        try {
            URL url = new URL("http://www.psu.edu");
            System.out.println(url.getProtocol());
            System.out.println(url.getFile());
            System.out.println(url.getPath());
            System.out.println(url.getHost());
            System.out.println(url.getDefaultPort());
        }
        catch(IOException e){
            e.printStackTrace();
        }
        
        
    }
}

/*

Twitter info: https://developer.twitter.com/en/docs/tweets/search/api-reference/get-search-tweets.html

Twitter API get request
$ curl --request GET 
 --url 'https://api.twitter.com/1.1/search/tweets.json?q=nasa&result_type=popular' 
 --header 'authorization: OAuth oauth_consumer_key="consumer-key-for-app", 
 oauth_nonce="generated-nonce", oauth_signature="generated-signature", 
 oauth_signature_method="HMAC-SHA1", oauth_timestamp="generated-timestamp", 
 oauth_token="access-token-for-authed-user", oauth_version="1.0"'

*/