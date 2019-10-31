package com.kevinzcf.poster.utils;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * @author kevinzcf
 * @version 2019
 */
public class JsonUtil {

    public static <T> T fromJson(String url, Class<T> classOfT) {
        Gson gson = new Gson();
        String json = null;
        try {
            json = readUrl(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        T out = gson.fromJson(json, classOfT);

        return out;
    }

    private static String readUrl(String urlString) throws Exception {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);

            return buffer.toString();
        } finally {
            if (reader != null)
                reader.close();
        }
    }

}
