package pl.edu.pw.ee.aisd2023zlab5;

import static org.junit.Assert.assertEquals;

import java.io.BufferedWriter;
import java.io.File;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;

import org.junit.Before;
import org.junit.Test;

public class HuffmanTest {
    private Huffman huffman;

    private final String dataFileName = "data.txt";
    private final String pathToFile = "src/main/file/data.txt";
    private final String pathToFileTest = "src/main/file/test.txt";

    private final String pathToFileDontExist = "src/main/file/fakeFile.txt";


    @Before
    public void setUp() {
        huffman = new Huffman();
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_ThrowIllegalArgumentException_WhenPathToFileIncorrect() {
        // given
        String pathToFileIncorrect = "Incorrect";


        // when
        huffman.codeHuffman(pathToFileIncorrect);

        // then
        assert false;
    }


    @Test(expected = IllegalArgumentException.class)
    public void should_ThrowIllegalArgumentException_WhenFileDataDoesNotExist() {
        // given
        File file = new File(dataFileName);
        if (file.exists()) {
            file.delete();
        }

        // when
        huffman.codeHuffman(pathToFileDontExist);

        // then
        assert false;
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_ThrowIllegalArgumentException_WhenFileDataIsEmpty() {
        // given
        File file = new File(dataFileName);

        try {
            file.createNewFile();
            new PrintWriter(dataFileName).close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // when
        huffman.codeHuffman(pathToFileTest);

        // then
        assert false;
    }

    @Test
    public void should_correctlyDecodeTree_WhenFileHasOneChar() {
        // given
        File dataFile = new File(dataFileName);
        String data = "Z";
        try {
            dataFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        writeData(pathToFile, data);

        // when
        String decodeCode = huffman.codeHuffman(pathToFile);

        String expected = "10000000";
        assertEquals(expected, decodeCode);
    }

    @Test
    public void should_correctlyDecodeTree_WhenFileHasTwoChars() {
        // given
        File dataFile = new File(dataFileName);

        String data = "AB";

        try {
            dataFile.createNewFile();
            new PrintWriter(dataFileName).close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        writeData(pathToFile, data);

        // when
        String decodeCode = huffman.codeHuffman(pathToFile);

        // then
        String expected = "01011000";
        assertEquals(decodeCode , expected);
    }

    @Test
    public void should_EncodeAndDecSDFDSode_When_FileHasFourChars() {
        // given
        File dataFile = new File(dataFileName);

        String data = "ABBA";

        try {
            dataFile.createNewFile();
            new PrintWriter(dataFileName).close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        writeData(pathToFile, data);

        // when
        String decodeCode = huffman.codeHuffman(pathToFile);

        // then
        String expected = "01011000";
        assertEquals(decodeCode , expected);

    }

    @Test
    public void should_correctlyDecodeTree_WhenFileHasFourChars() {
        // given
        File dataFile = new File(dataFileName);

        String data = "NIEMANIE";

        try {
            dataFile.createNewFile();
            new PrintWriter(dataFileName).close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        writeData(pathToFile, data);

        // when
        String decodeCode = huffman.codeHuffman(pathToFile);


        String expected = "001000101010110110111000";
        // then
        assertEquals(expected, decodeCode);

    }

    @Test
    public void should_correctlyDecodeTree_When_FileHasTwoChars() {
        // given
        File dataFile = new File(dataFileName);

        String data = "więc jeszcze seta, znakomicie padniemy, ale zgódźcie się ze z tylu różnych dróg przez życie każdy ma prawo wybrać źle";

        try {
            dataFile.createNewFile();
            new PrintWriter(dataFileName).close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        writeData(pathToFile, data);

        // when
        String decode = huffman.codeHuffman(pathToFile);

        String result = "000100000010010001001001100101010011010011100101000101010101011010110010111000101111001011110101011111010111111000110001100100011010001101001011010101101011011011001101110110111101110011110011111001111110111111100000";

        // then
        assertEquals(result, decode);



    }

    @Test
    public void should_correctCostTree_WhenGiveISODExample() {
        // given
        File dataFile = new File(dataFileName);

        String data = "więc jeszcze seta, znakomicie padniemy, ale zgódźcie się że z tylu różnych dróg przez życie każdy ma prawo wybrać źle";

        try {
            dataFile.createNewFile();
            new PrintWriter(dataFileName).close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        writeData(pathToFile, data);

        // when
        huffman.codeHuffman(pathToFile);


        huffman.buildHuffmanTree();
        int cost = huffman.calculateTreeCost();

        // Then
        int expectedCost = 520;

        assertEquals(expectedCost, cost);
    }


    private void writeData(String pathToFile, String data) {

        try (FileWriter fileWriter = new FileWriter(pathToFile, Charset.forName("UTF-8"));
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);) {

            bufferedWriter.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}