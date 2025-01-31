package br.com.pedromagno.blockchain.utils;

import java.security.MessageDigest;

/**
 * Essa classe tem por finalidade manipular textos.
 * Todos os textos devem ser manipulados por esta classe.
 *
 * @author Pedro Magno <pedromagnopro@gmail.com>
 * @since 30/01/2025
 *
 */

public class TextoUtil {

    // Aplica sha256 a string e retorna o resultado
    public static String aplicarSha256(String input){

        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            // Aplica sha256 ao input
            byte[] hash = digest.digest(input.getBytes());

            // Conterá o hash como um hexadecimal
            StringBuffer hexString = new StringBuffer();

            for (int i = 0; i < hash.length; i++) {

                String hex = Integer.toHexString(0xff & hash[i]);

                if(hex.length() == 1){
                    hexString.append('0');
                }

                hexString.append(hex);
            }

            return hexString.toString();

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
