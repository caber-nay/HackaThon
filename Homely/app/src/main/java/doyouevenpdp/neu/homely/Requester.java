package doyouevenpdp.neu.homely;

import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Requester {

    public Requester() {
    }

    public String processMakeRequest(String path) {

        StringBuilder result = null;

        try {
            result = new StringBuilder();
            Log.d("NayTag","here");
            URL url = new URL(path);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            rd.close();
        } catch (Exception e) {
            Log.d("NayTag","exception");
            System.out.println(e);
        }
        Log.d("NayTag",result.toString());
        return result.toString();
    }

    public String requestLogin(String email, String password) {
        String url = "http://ec2-34-211-148-99.us-west-2.compute.amazonaws.com:8888/user/login?email=" + email + "&password=" + password;
        return processMakeRequest(url);
    }
}
