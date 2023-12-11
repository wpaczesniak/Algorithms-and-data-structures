package pl.edu.pw.ee.aisd2023zlab5;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public final class WriteAndRead {

    public static void writeFileBinary(String pathToFile, String writeText) {
        createNewFile(pathToFile);

        try (FileOutputStream fileOutputStream = new FileOutputStream(pathToFile);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);) {

            while (writeText.length() % 8 != 0) {
                writeText += "0";
            }

            for (int i = 0; i < writeText.length(); i += 8) {
                String byteString = writeText.substring(i, i + 8);
                int parsedByte = 0xFF & Integer.parseInt(byteString, 2);

                bufferedOutputStream.write(parsedByte);
            }

            bufferedOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readFileBinary(String pathToFile) {
        checkFileExist(pathToFile);

        String result = "";

        try (FileInputStream fileInputStream = new FileInputStream(pathToFile);
                BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);) {

            int byteCode;

            while ((byteCode = bufferedInputStream.read()) != -1) {

                result += String.format("%08d", Integer.parseInt(Integer.toString(byteCode, 2), 10));
            }

            bufferedInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;

    }

    public static void createNewFile(String pathToFile) {
        File file = new File(pathToFile);

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void checkFileExist(String pathToFile) {
        File file = new File(pathToFile);

        if (!file.exists() || !file.isFile()) {
            throw new IllegalArgumentException("File does not exist!");
        }
    }

}
