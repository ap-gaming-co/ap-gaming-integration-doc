package com.ludus.seamless.wallet;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.digest.DigestUtils;

public class Signature {

    private static final Logger LOG = Logger.getLogger(Signature.class.getName());

    private static final String INIT_VECTOR = "RandomInitVector";

    private static final String AGENT_CODE = "SU107";              // Agent Code was provided
    private static final String AES_KEY = "rlpc3VsNcxXmrBXZ";     // AES key was provided
    private static final String AGENT_KEY = "b4dc8714-5d67-4798-a4eb-9478227c72ad";     // Agent key was provided 
    private static final String TIMESTAMP = String.valueOf(System.currentTimeMillis());

    private static final String ALGORITHM = "AES";

    // Signature that you need generated. 
    // [We created it from our system. You need to create the same signature for comparison.]
    private static final String SIGNATURE_VERIFY = "B9Bp7loOzhvgHLLYg71A0v5yXKXTik87AjKCD8ZQSSVobuVHBkAVk8gxfwmWRglLCHm+CNaxnCa1neINbhRYMQ==";

    public static void main(String[] args) {
        Signature signature = new Signature();
        String token = signature.encode();
        if (SIGNATURE_VERIFY.equals(token)) {
            System.out.println("Your signature was verified.");
            String tokenDecode = signature.decode(token);
            System.out.println(tokenDecode);
            String[] tmp = tokenDecode.split("\\|");
            System.out.println("UserCode: " + tmp[0]);
            System.out.println("Timestamp: " + tmp[1]);
        } else {
            LOG.log(Level.WARNING, "This is not your signature.");
        }
    }

    public String encode() {
        String hashToken = DigestUtils.md5Hex(AGENT_CODE + TIMESTAMP + AGENT_KEY);
        String token = String.format("%s|%s|%s", AGENT_CODE, TIMESTAMP, hashToken);
        return encryptAES(token);
    }

    public String decode(String token) {
        return decryptAES(token);
    }

    /**
     * encrypt AES
     *
     * @param secretKey key for AES.
     * @param tokenPayload
     * @return
     */
    private String encryptAES(String token) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(AES_KEY.getBytes(), ALGORITHM);
            IvParameterSpec iv = new IvParameterSpec(INIT_VECTOR.getBytes("UTF-8"));
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, iv);
            byte[] encrypted = cipher.doFinal(token.getBytes());
            return Base64.getEncoder().encodeToString(encrypted);
        } catch (UnsupportedEncodingException | InvalidAlgorithmParameterException |
                InvalidKeyException | NoSuchAlgorithmException | BadPaddingException |
                IllegalBlockSizeException | NoSuchPaddingException ex) {
            LOG.log(Level.SEVERE, ex, () -> String.format("An exceptionn occurred "
                    + "when encript key: %s, plain text: %s, exception %s", AES_KEY, token, ex));
        }
        return null;
    }

    private static String decryptAES(String encryptedText) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(AES_KEY.getBytes(), ALGORITHM);
            IvParameterSpec iv = new IvParameterSpec(INIT_VECTOR.getBytes("UTF-8"));
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, iv);
            byte[] original = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
            return new String(original);
        } catch (UnsupportedEncodingException | InvalidAlgorithmParameterException | InvalidKeyException |
                NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException ex) {
            LOG.log(Level.INFO,
                    "An exceptionn occurred when decrypt key: {0}, encryptedText: "
                    + "{1}, exception {2}", new Object[]{AES_KEY, encryptedText, ex.toString()});

        }
        return null;
    }
}
