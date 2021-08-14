/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.utils.encrypt;

import core.config.EnvConfig;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.Random;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Encrypts and decrypts a text with a given key.
 */
public class AesUtil {

    private static final int encodingBytes = 16;
    private static final int iterationCount = 65123;
    private static final int keyLength = 256;
    private static final byte[] iv = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private static final String padding = "AES/CBC/PKCS5Padding";
    private static final String algorithm = "PBKDF2WithHmacSHA256";
    private static final String cryptoSpecification = "AES";

    /**
     * Encrypts a text with the given key.
     *
     * @param inputText represents the text to encrypt
     * @param key       represents the SecretKey to encrypt with
     * @throws NoSuchAlgorithmException           when algorithm is not found
     * @throws NoSuchPaddingException             when padding match is not found
     * @throws BadPaddingException                when the padding is not valid
     * @throws IllegalBlockSizeException          when the block size is not valid
     * @throws InvalidAlgorithmParameterException when there is no match for the algorithm
     * @throws InvalidKeyException                when the key is invalid
     */
    public static String encrypt(final String inputText, final String key) throws InvalidAlgorithmParameterException,
            InvalidKeyException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException,
            NoSuchAlgorithmException {
        byte[] decodedKey = Base64.getDecoder().decode(key);
        SecretKey secretKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, cryptoSpecification);
        IvParameterSpec ivspec = new IvParameterSpec(iv);
        Cipher cipher = Cipher.getInstance(padding);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivspec);
        return Base64.getEncoder().encodeToString(cipher.doFinal(inputText.getBytes(StandardCharsets.UTF_8)));
    }

    /**
     * Decrypts a text with the retrieved key.
     *
     * @param inputText is the text to decrypt
     */
    public static String decryptText(final String inputText) {
        String key = EnvConfig.getInstance().getKey();
        return decrypt(inputText, key);
    }

    /**
     * Decrypts a text with the provided key.
     *
     * @param inputText is the text to decrypt
     */
    public static String decryptTextWithKey(final String inputText, final String key) {
        return decrypt(inputText, key);
    }

    /**
     * Decrypts a text with the provided key.
     *
     * @param inputText is the text to decrypt
     * @throws NoSuchAlgorithmException           when algorithm is not found
     * @throws NoSuchPaddingException             when padding match is not found
     * @throws BadPaddingException                when the padding is not valid
     * @throws IllegalBlockSizeException          when the block size is not valid
     * @throws InvalidAlgorithmParameterException when there is no match for the algorithm
     * @throws InvalidKeyException                when the key is invalid
     */

    private static String decrypt(final String inputText, final String key) {
        try {
            byte[] decodedKey = Base64.getDecoder().decode(key);
            SecretKey secretKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, cryptoSpecification);
            IvParameterSpec ivspec = new IvParameterSpec(iv);
            Cipher cipher = Cipher.getInstance(padding);
            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivspec);
            return new String(cipher.doFinal(Base64.getDecoder().decode(inputText)));
        } catch (Exception e) {
            throw new InvalidParameterException("Can't decrypt, invalid key or text");
        }
    }

    /**
     * Converts the provided String key to SecretKey with the predefined salt, iterationCount and keyLength values.
     *
     * @throws NoSuchAlgorithmException when algorithm is not found
     * @throws InvalidKeySpecException  when the key is invalid
     */
    public static String generateKey()
            throws NoSuchAlgorithmException, InvalidKeySpecException {
        SecretKeyFactory factory = SecretKeyFactory.getInstance(algorithm);
        KeySpec spec = new PBEKeySpec(generatePassword().toCharArray(), iv, iterationCount, keyLength);
        SecretKey tmp = factory.generateSecret(spec);
        SecretKeySpec key = new SecretKeySpec(tmp.getEncoded(), cryptoSpecification);
        String encodedKey = Base64.getEncoder().encodeToString(key.getEncoded());
        return encodedKey;
    }

    /**
     * Generates a password for the PBEkey specification.
     *
     * @return a String representing the password
     */
    private static String generatePassword() {
        Random random = new SecureRandom();
        byte[] salt = new byte[encodingBytes];
        random.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }
}
