package pl.edu.pw.ee.aisd2023zlab3.performance;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static java.util.logging.Level.SEVERE;
import java.util.logging.Logger;
import org.junit.Test;


import static java.lang.String.format;
import pl.edu.pw.ee.aisd2023zlab3.HashLinearProbing;
import pl.edu.pw.ee.aisd2023zlab3.services.HashTable;

public class HashLinearProbingPerformanceTest {

    private static final String WORDS_FILEPATH = "src/main/resources/wordlist_100_000.txt";
    private static final Logger LOG = Logger.getLogger(HashLinearProbingPerformanceTest.class.getName());

    @Test
    public void measurePerfomanceOfHashes() {
        int nOfRepeats = 30;
        int[] initialSizes = {4095, 8191, 16_383, 65_927, 131_357, 263_293, 524_413};
        String[] words = prepareWords();

        HashTable<String> hash;
        List<Long> times;
        long startTime, measuredTime;

        for (int size : initialSizes) {
            times = new ArrayList<>();

            for (int i = 0; i < nOfRepeats; i++) {
                hash = new HashLinearProbing<>(size);
                startTime = System.nanoTime();

                putWordsIntoHash(hash, words);

                measuredTime = System.nanoTime() - startTime;
                times.add(measuredTime);
            }

            countAndPrintMinAvgTime(times, size);
        }

    }

    private void putWordsIntoHash(HashTable<String> hash, String[] words) {
        int n = words.length;

        for (int i = 0; i < n; i++) {
            hash.put(words[i]);
        }
    }

    private String[] prepareWords() {
        List<String> words = new ArrayList<>();
        String line;
        int counter = 0;
        int maxNumWords = 100_000;

        try (FileReader fReader = new FileReader(WORDS_FILEPATH);
                BufferedReader buffReader = new BufferedReader(fReader)) {

            while ((line = buffReader.readLine()) != null && counter < maxNumWords) {
                words.add(line);
                counter++;
            }

        } catch (IOException e) {
            LOG.log(SEVERE, "[Error] An error ocurred during preparing words.", e);
        }

        return words.toArray(new String[0]);
    }

    private void countAndPrintMinAvgTime(List<Long> timesAsList, int initSize) {
        int n = timesAsList.size();
        int startId = 10;
        int endId = 20;

        long sum = 0;
        long avgTime;

        timesAsList.sort(null);

        for (int i = startId; i < endId && i < n; i++) {
            sum += timesAsList.get(i);
        }

        avgTime = sum / (endId - startId);

        System.out.println(format("Init size: %10d | Time: %15d", initSize, avgTime));
    }

}
