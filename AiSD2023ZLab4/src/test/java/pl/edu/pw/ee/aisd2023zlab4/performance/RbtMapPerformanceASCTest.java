package pl.edu.pw.ee.aisd2023zlab4.performance;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.String.format;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;
import org.junit.Before;
import org.junit.Test;
import pl.edu.pw.ee.aisd2023zlab4.RbtMap;
import pl.edu.pw.ee.aisd2023zlab4.services.MapInterface;


public class RbtMapPerformanceASCTest {

    private static final Logger LOG = Logger.getLogger(RbtMapPerformanceASCTest.class.getName());
    private final String filename = "rbtPerformanceASCResults.txt";

    @Before
    public void setup() {
        removeFileBeforeStart();
    }

    @Test
    public void countTreeHeightDependingOnDataSize() {
        MapInterface<String, String> map = new RbtMap<>();
        int currentSize = 0;
        int maxSize = 1_000_000;
        int step = 100;

        int nOfPuts;

        while (currentSize < maxSize) {
            putRandomData(map, step);
            currentSize += step;

            nOfPuts = getNumOfPuts(map);
            saveResult(currentSize, nOfPuts);
        }

    }

    private void removeFileBeforeStart() {
        File f = new File(filename);

        f.delete();
    }

    private void putRandomData(MapInterface<String, String> map, int nOfData) {
        String randomNumber;
        List<String> sortedKeys = new ArrayList<>();

        for (int i = 0; i < nOfData; i++) {
            randomNumber = UUID.randomUUID().toString();
            sortedKeys.add(randomNumber);
        }


        Collections.sort(sortedKeys);

        for (String keyAndValue : sortedKeys) {
            map.setValue(keyAndValue, keyAndValue);
        }


    }

    private void saveResult(int currentSize, int nOfPuts) {
        File f = new File(filename);

        try (FileWriter fw = new FileWriter(f, true); BufferedWriter writer = new BufferedWriter(fw)) {
            writer.append(format("size: %4d | nOfPuts: %d\n", currentSize, nOfPuts));

        } catch (IOException e) {
            LOG.severe("Caught an error while saving results.");
            throw new RuntimeException(e);
        }

    }

    private int getNumOfPuts(MapInterface<String, String> map) {
        String fieldTree = "tree";
        String fieldNumOfPuts = "currentNumOfPut";

        try {
            Field tree = map.getClass().getDeclaredField(fieldTree);
            tree.setAccessible(true);

            Object rbtTree = tree.get(map);

            Field currentNumOfPut = rbtTree.getClass().getDeclaredField(fieldNumOfPuts);
            currentNumOfPut.setAccessible(true);

            int numOfPuts = currentNumOfPut.getInt(rbtTree);

            return numOfPuts;

        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }

}


