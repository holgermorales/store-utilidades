package com.todo1.store.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * @author holger.morales
 */
public class JsonUtil {
    /**
     * Decodifica base64
     *
     * @author holger.morales
     * @history Jul 2, 2022 - 10:40:55 AM holger.morales
     *          Versión inicial.
     * @param data
     * @param gson
     * @return
     * @throws UnsupportedEncodingException
     */
    private String decodeJson(String data, Gson gson) throws UnsupportedEncodingException {
        final Map<Object, Object> inputMapParam = gson.fromJson(data, HashMap.class);
        final String jsonEncrypted = inputMapParam.get("dato").toString();
        final byte[] decodedByte = Base64.getDecoder().decode(jsonEncrypted);
        final String decodedString = new String(decodedByte, StandardCharsets.UTF_8);
        return URLDecoder.decode(decodedString, StandardCharsets.UTF_8.name());
    }

    /**
     * Obtiene un objeto json.
     *
     * @author holger.morales
     * @history Jul 2, 2022 - 10:41:48 AM holger.morales
     *          Versión inicial.
     * @param data
     * @return
     * @throws UnsupportedEncodingException
     */
    public JsonObject getJson(String data) throws UnsupportedEncodingException {
        final Gson gson = new Gson();
        final String decodedJson = this.decodeJson(data, gson);
        return new JsonParser().parse(decodedJson).getAsJsonObject();
    }

    /**
     * Serializa un string json a Json objeto.
     *
     * @author holger.morales
     * @history Jul 2, 2022 - 10:44:03 AM holger.morales
     *          Versión inicial.
     * @param json
     * @return
     */
    public JsonObject jsonDecoded(String json) {
        return new JsonParser().parse(json).getAsJsonObject();
    }

    /**
     * Serializa un string json a objeto definido por el usuario.
     *
     * @author holger.morales
     * @history Jul 2, 2022 - 10:42:37 AM holger.morales
     *          Versión inicial.
     * @param <T>
     * @param json
     * @param cls
     * @return
     */
    public <T> T jsonDecodedToClass(String json, Class<T> cls) {
        final Gson gson = new Gson();
        return gson.fromJson(json, cls);
    }

    /**
     * Obtiene a partir de json strin a un objeto definido por el usuario.
     * 
     * @author holger.morales
     * @history Jul 2, 2022 - 10:46:14 AM holger.morales
     *          Versión inicial.
     * @param <T>
     * @param data
     * @param cls
     * @return
     * @throws UnsupportedEncodingException
     */
    public <T> T jsonToClass(String data, Class<T> cls) throws UnsupportedEncodingException {
        final Gson gson = new Gson();
        final String decodedJson = this.decodeJson(data, gson);
        return gson.fromJson(decodedJson, cls);
    }

    /**
     * Obtiene a partir de un json string en forma de array y devuelve un listado de objetos de una clase dada.
     *
     * @author holger.morales
     * @history Jul 2, 2022 - 10:47:57 AM holger.morales
     *          Versión inicial.
     * @param <T>
     * @param json
     * @param cls
     * @return
     */
    public <T> List<T> jsonToList(String json, Class<T[]> cls) {
        final T[] jsonToObject = new Gson().fromJson(json, cls);
        return Arrays.asList(jsonToObject);
    }
}
