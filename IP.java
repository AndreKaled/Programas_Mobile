import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.stream.Collectors;

public class IP {
    String ipLocal, nomeMaquina, loopback, ipGlobal;

    public IP() throws UnknownHostException {
        ipLocal = InetAddress.getLocalHost().getHostAddress();
        nomeMaquina = InetAddress.getLocalHost().getHostName();
        loopback = Inet6Address.getLoopbackAddress().getHostAddress();
        try {
            ipGlobal = URLReader(new URL("https://api.ipify.org/"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

	public static String URLReader(URL url) throws IOException {
	    try (InputStream in = url.openStream())
	    {
	        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
	        return reader.lines().collect(Collectors.joining(System.lineSeparator()));
	    }
	}

    public String getIpLocal() {
        return ipLocal;
    }

    public String getNomeMaquina() {
        return nomeMaquina;
    }

    public String getLoopback() {
        return loopback;
    }

    public String getIpGlobal() {
        return ipGlobal;
    }
}