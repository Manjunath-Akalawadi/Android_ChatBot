package com.manju7.chatbot;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpDataHandles {

    static String stream = null;

    public HttpDataHandles() {
    }

    public String GetHttpData(String url){

        try {

            URL url1 = new URL(url);
            HttpURLConnection urlConnection = (HttpURLConnection)url1.openConnection();

            if (urlConnection.getResponseCode()==HttpURLConnection.HTTP_OK){

                InputStream inputStream = new BufferedInputStream(urlConnection.getInputStream());

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();
                String line;

                while ((line = bufferedReader.readLine())!=null)
                    stringBuilder.append(line);
                stream = stringBuilder.toString();
                urlConnection.disconnect();

            }

        }catch (MalformedURLException e){

                e.printStackTrace();
        }catch (IOException e){

            e.printStackTrace();
        }
            return stream;
    }

}
