package network;
import java.net.*;
import java.io.*;


public class UrlConnectionReader
{
    public static void main(String[] args)
    {
        //String output  = getUrlContents("https://www.google.com");
        String output  = getUrlContents("http://txnsvc-dev.dr1.ei:8121/txnsvc/web-services/GlobalCompanyIdentifierService");
        System.out.println(output);
    }

    private static String getUrlContents(String theUrl)
    {
        StringBuilder content = new StringBuilder();
        // Use try and catch to avoid the exceptions
        try
        {

            //Proxy instance, proxy ip = 10.0.0.1 with port 8080
           // Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxy-chq.gtm.chq.ei", 8080));
            URL url = new URL(theUrl); // creating a url object
            URLConnection urlConnection = url.openConnection(); // creating a urlconnection object

            // wrapping the urlconnection in a bufferedreader
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            // reading from the urlconnection using the bufferedreader
            while ((line = bufferedReader.readLine()) != null)
            {
                content.append(line + "\n");
            }
            bufferedReader.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return content.toString();
    }
}