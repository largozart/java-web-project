package com.bivgroup.module.dadataclient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.bivgroup.module.dadataclient.pojo.*;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public final class DaDataService {

    private static final String API_URL_IP = "https://suggestions.dadata.ru/suggestions/api/4_1/rs";

    private static final String REQUEST_METHOD_GET = "GET";
    private static final Logger LOGGER = LoggerFactory.getLogger(DaDataService.class);

    private final String authKey;
    private final String authSecret;


    /**
     * @param key
     * @param secret
     */
    public DaDataService(String key, String secret) {
        authKey = key;
        authSecret = secret;
    }

    public LocationResult iplocate(Request request) throws JsonProcessingException {
        return populate(LocationResult.class, "iplocate/address", request);
    }

    private <T> T populate(Class<T> tClass, String method, Request request) throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        return om.readValue(fetchJson(method, REQUEST_METHOD_GET, request), tClass);
    }

    private String fetchJson(String method, String requestMethod, Request request) {
        String toReturn = null;
        try {
            URL url = new URL(API_URL_IP + "/" + method + "?ip=" + request.ip);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(requestMethod);
            connection.addRequestProperty("Accept", "application/json");
            connection.addRequestProperty("Authorization", "Token " + authKey);
            InputStream inputStream = connection.getInputStream();
            toReturn = IOUtils.toString(inputStream, "UTF-8");
            inputStream.close();
        } catch (ProtocolException e) {
            LOGGER.error("Error fetching data", e);
        } catch (MalformedURLException e) {
            LOGGER.error("Error fetching data", e);
        } catch (IOException e) {
            LOGGER.error("Error fetching data", e);
        }

        return toReturn;
    }
}
