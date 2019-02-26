package utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.tomcat.util.codec.binary.Base64;

/**
 *
 * @author Amer Shaker
 */
public class Utility {

    private static final String IMAGE_ENCODING = "UTF-8";

    public static String readImage(InputStream inputStream) {
        ByteArrayOutputStream outputStram = new ByteArrayOutputStream();
        String imageURL = null;

        try {
            int byteValue = inputStream.read();
            while (byteValue != -1) {
                outputStram.write((char) byteValue);
                byteValue = inputStream.read();
            }

            byte[] bindaryImage = Base64.encodeBase64(outputStram.toByteArray());
            imageURL = new String(bindaryImage, IMAGE_ENCODING);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } finally {
            try {
                outputStram.close();
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        }

        return imageURL;
    }
}