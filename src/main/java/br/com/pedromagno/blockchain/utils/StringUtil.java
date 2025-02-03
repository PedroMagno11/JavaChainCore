package br.com.pedromagno.blockchain.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

import com.google.gson.GsonBuilder;


/**
 * Essa classe tem por finalidade manipular strings.
 * Todas as strings devem ser manipuladas por esta classe.
 *
 * @author Pedro Magno <pedromagnopro@gmail.com>
 * @since 30/01/2025
 *
 */


public class StringUtil {

    // Aplica sha256 a string e retorna o resultado
    public static String applySha256(String input){

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // Aplica sha256 ao input
            byte[] hash = digest.digest(input.getBytes(StandardCharsets.UTF_8));

            // Conterá o hash como um hexadecimal
            StringBuilder hexString = new StringBuilder(); // This will contain hash as hexidecimal

            for (byte b : hash) {

                String hex = Integer.toHexString(0xff & b);

                if (hex.length() == 1) hexString.append('0');

                hexString.append(hex);
            }

            return hexString.toString();
        }
        catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    //Tranforma um objeto em uma string json
    public static String getJson(Object object) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(object);
    }

    //Retorna a string de dificuldade alvo, para comparar com o hash. Por exemplo, dificuldade de 5 retornará "00000"
    public static String getDificultyString(int difficulty) {
        return new String(new char[difficulty]).replace('\0', '0');
    }

}