package com.bxy.cassandra.db;

import org.apache.commons.net.util.Base64;
import org.springframework.stereotype.Service;

@Service
public class EncryptionInterface {

    public static String encrypt(String texto) {
        return new String(Base64.encodeBase64(texto.getBytes()));
    }

    public static String decrypt(String texto) {
        return new String(Base64.decodeBase64(texto.getBytes()));
    }
}
