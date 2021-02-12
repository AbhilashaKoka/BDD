//package Utility;
//import java.security.SecureRandom;
//import java.security.cert.X509Certificate;
//import javax.net.ssl.HttpsURLConnection;
//import javax.net.ssl.SSLContext;
//import javax.net.ssl.TrustManager;
//import javax.net.ssl.X509TrustManager;
//import javax.ws.rs.client.Client;
//import javax.ws.rs.client.ClientBuilder;
//public class cererror {
//	ClientConfig clientConfig = getClientConfig();
//	TrustManager[] trustAllCerts = new TrustManager[] { 
    //new X509TrustManager() {
//	public X509Certificate[] getAcceptedIssuers() {
//  return null;
//	}
//
//	public void checkClientTrusted(X509Certificate[] certs, String authType) {
//	}
//
//	public void checkServerTrusted(X509Certificate[] certs, String authType) {
//	}
//	} 
//};
//	SSLContext sc = null;
//	try {
//	    sc = SSLContext.getInstance("TLS");
//	    sc.init(null, trustAllCerts, new SecureRandom());
//	    HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
//	    } catch (Exception e) {
//	    // do nothing
//	    }
//	    Client client = ClientBuilder.newBuilder().withConfig(clientConfig).sslContext(sc).hostnameVerifier((s1, s2) -> true)
//	    .build();
//
//}
