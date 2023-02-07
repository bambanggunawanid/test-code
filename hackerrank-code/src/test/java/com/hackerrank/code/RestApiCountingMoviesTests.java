package com.hackerrank.code;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.jupiter.api.Test;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class RestApiCountingMoviesTests {
    // the url is https://jsonmock.hackerrank.com/api/movies/search/?Title=maze

    @Test
    void test1() {
        String substr = "maze";
        int totalObject = getNumberOfMovies(substr);
        System.out.println(totalObject);
    }

    static int getNumberOfMovies(String substr) {
        try {
            String url = "https://jsonmock.hackerrank.com/api/moviesdata/search/?Title=substr" + substr;
            String result = getDataJsonRestAPI(url);
            if(result == null) {
                return 0;
            }
            Gson gson = new Gson();
            JsonObject resultJson = gson.fromJson(result, JsonObject.class);
            System.out.println(resultJson);
            System.out.println(resultJson.get("data").getAsJsonArray().size());
            return resultJson.get("total").getAsInt();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    static String getDataJsonRestAPI(String url) {
        String result = null;
        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            int responseCode = con.getResponseCode();
            System.out.println("GET Response Code :: " + responseCode);
            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                result = response.toString();
            } else {
                System.out.println("GET request not worked");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
