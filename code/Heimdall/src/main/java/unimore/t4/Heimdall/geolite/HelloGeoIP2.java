package unimore.t4.Heimdall.geolite;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.record.City;
import com.maxmind.geoip2.record.Country;
import com.maxmind.geoip2.record.Location;
import com.maxmind.geoip2.record.Postal;
import com.maxmind.geoip2.record.Subdivision;

public class HelloGeoIP2 {
    DatabaseReader reader = null;

    public HelloGeoIP2(String stringa_di_prova_per_cercare) {

        // A File object pointing to your GeoLite2 database
        File dbFile = new File(new File("").getAbsolutePath() + File.separator
                + "geo"+ File.separator + "GeoLite2-City.mmdb");

        System.out.println(dbFile.getAbsolutePath());
        System.out.println(stringa_di_prova_per_cercare);

        // This creates the DatabaseReader object,
        // which should be reused across lookups.

        DatabaseReader reader = null;
        try {
            this.reader = new DatabaseReader.Builder(dbFile).build();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }






    }

    public List<String> getthelocationbyip(String ip){

        InetAddress ipAddress = null;
        try {
            ipAddress = InetAddress.getByName("35.233.102.46");
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        CityResponse response = null;
        try {
            response = reader.city(ipAddress);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (GeoIp2Exception e) {
            throw new RuntimeException(e);
        }
        // Country Info
        Country country = response.getCountry();
        Location location = response.getLocation();

        City city = response.getCity();
        List<String> ritorno = new ArrayList<>();

        ritorno.add(country.getName());
        ritorno.add( city.getName());
        ritorno.add(String.valueOf(location.getLatitude()));
        ritorno.add(String.valueOf(location.getLongitude()));

        /*
        System.out.println("Country IsoCode: "+ country.getIsoCode()); // 'US'
        System.out.println("Country Name: "+ country.getName()); // 'United States'
        System.out.println(country.getNames().get("zh-CN")); // '美国'

        Subdivision subdivision = response.getMostSpecificSubdivision();
        System.out.println("Subdivision Name: " +subdivision.getName()); // 'Minnesota'
        System.out.println("Subdivision IsoCode: "+subdivision.getIsoCode()); // 'MN'

        // City Info.
        City city = response.getCity();
        System.out.println("City Name: "+ city.getName()); // 'Minneapolis'

        // Postal info
        Postal postal = response.getPostal();
        System.out.println(postal.getCode()); // '55455'

        // Geo Location info.
        Location location = response.getLocation();

        // Latitude
        System.out.println("Latitude: "+ location.getLatitude()); // 44.9733

        // Longitude
        System.out.println("Longitude: "+ location.getLongitude()); // -93.2323
           */
        return ritorno;
    }
}