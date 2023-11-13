package pl.edu.pw.ee.aisd2023zlab4;

import org.junit.Before;
import org.junit.Test;
import java.util.Random;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RbtMapTest {

    private RbtMap<Character, Character> map;
    private RbtMap<Integer, Integer> map2;
    private RbtMap<Character, Integer> map3;

    @Before
    public void setUp() {
        map = new RbtMap<>();
        map2 = new RbtMap<>();
        map3 = new RbtMap<>();
    }
    @Test(expected = IllegalArgumentException.class)
    public void should_ThrowException_WhenTrySetNullKeyForCharacterKeysAndValue() {

        // given
        Character key = null;
        Character value = 'v';

        // when
        map.setValue(key, value);

        // then
        assert false;
    }
    @Test(expected = IllegalArgumentException.class)
    public void should_ThrowException_WhenTrySetNullKeyForIntegerKeysAndValues() {
        // given
        Integer key = null;
        Integer value = 1;

        // when
        map2.setValue(key, value);

        // then
        assert false;
    }
    @Test(expected = IllegalArgumentException.class)
    public void should_ThrowException_WhenTrySetNullKeyForCharacterKeysAndIntegerValues() {
        // given
        Character key = null;
        Integer value = 1;

        // when
        map3.setValue(key, value);

        // then
        assert false;
    }
    @Test(expected = IllegalArgumentException.class)
    public void should_ThrowException_WhenTrySetNullValueForCharacterKeysAndValue() {

        // given
        Character key = 'V';
        Character value = null;

        // when
        map.setValue(key, value);

        // then
        assert false;
    }
    @Test(expected = IllegalArgumentException.class)
    public void should_ThrowException_WhenTrySetNullValueForIntegerKeysAndValues() {

        // given
        Integer key = 1;
        Integer value = null;

        // when
        map2.setValue(key, value);

        // then
        assert false;
    }
    @Test(expected = IllegalArgumentException.class)
    public void should_ThrowException_WhenTrySetNullValueForCharacterKeysAndIntegerValues() {

        // given
        Character key = 'V';
        Integer value = null;

        // when
        map3.setValue(key, value);

        // then
        assert false;
    }
    @Test(expected = IllegalArgumentException.class)
    public void should_ThrowException_WhenTrySetNullKeyAndValueForCharacterKeysAndValue() {

        // given
        Character key = null;
        Character value = null;

        // when
        map.setValue(key, value);

        // then
        assert false;
    }
    @Test(expected = IllegalArgumentException.class)
    public void should_ThrowException_WhenTrySetNullKeyAndValueForIntegerKeysAndValues() {

        // given
        Integer key = null;
        Integer value = null;

        // when
        map2.setValue(key, value);

        // then
        assert false;
    }
    @Test(expected = IllegalArgumentException.class)
    public void should_ThrowException_WhenTrySetNullKeyAndValueForCharacterKeysAndIntegerValues() {

        // given
        Character key = null;
        Integer value = null;

        // when
        map3.setValue(key, value);

        // then
        assert false;
    }
    @Test(expected = IllegalArgumentException.class)
    public void should_ThrowException_WhenTryGetNullKeyForCharacterKeysAndValue() {

        // given
        Character key = null;

        // when
        map.getValue(key);

        // then
        assert false;
    }
    @Test(expected = IllegalArgumentException.class)
    public void should_ThrowException_WhenTryGetNullKeyForIntegerKeysAndValues() {

        // given
        Integer key = null;

        // when
        map2.getValue(key);

        // then
        assert false;
    }
    @Test(expected = IllegalArgumentException.class)
    public void should_ThrowException_WhenTryGetNullKeyForCharacterKeysAndIntegerValues() {

        // given
        Character key = null;

        // when
        map3.getValue(key);

        // then
        assert false;
    }
    @Test
    public void should_CorrectlyReturnNull_WhenMapIsEmptyForCharacterKeysAndValue() {

        // given
        Character key = 'V';

        // when
        Character result = map.getValue(key);

        // then
        Character expected = null;
        assertEquals(expected, result);
    }
    @Test
    public void should_CorrectlyReturnNull_WhenMapIsEmptyForIntegerKeysAndValues() {

        // given
        Integer key = 1;

        // when
        Integer result = map2.getValue(key);

        // then
        Integer expected = null;
        assertEquals(expected, result);
    }
    @Test
    public void should_CorrectlyReturnNull_WhenCharacterIntegerMapIsEmptyForCharacterKeysAndIntegerValues() {

        // given
        Character key = 'V';

        // when
        Integer result = map3.getValue(key);

        // then
        Integer expected = null;
        assertEquals(expected, result);
    }
    @Test
    public void should_CorrectlyReturnNull_WhenWantToGetValueButKeyDoestExistInMapForCharacterKeysAndValue() {
        // given
        Character keyInMap = 'V';
        Character valueInMap = 'V';
        map.setValue(keyInMap, valueInMap);
        Character key = 'Z';

        // when
        Character result = map.getValue(key);

        // then
        Character expected = null;
        assertEquals(expected, result);
    }
    @Test
    public void should_CorrectlyReturnNull_WhenGetValueButKeyDoestExistInMapForIntegerKeysAndValues() {

        // given
        Integer keyInMap = 1;
        Integer valueInMap = 1;
        map2.setValue(keyInMap, valueInMap);
        Integer key = 2;

        // when
        Integer result = map2.getValue(key);

        // then
        Character expected = null;
        assertEquals(expected, result);
    }
    @Test
    public void should_CorrectlyReturnNull_WhenGetValueButKeyDoestExistInMapForCharacterKeysAndIntegerValues() {

        // given
        Character keyInMap = 'V';
        Integer valueInMap = 1;
        map3.setValue(keyInMap, valueInMap);
        Character key = 2;

        // when
        Integer result = map3.getValue(key);

        // then
        Character expected = null;
        assertEquals(expected, result);
    }
    @Test
    public void should_CorrectlyReturnValue_WhenMapHasOneNodeForCharacterKeysAndValue() {

        // given
        Character key = 'V';
        Character value = 'V';
        map.setValue(key, value);

        // when
        Character result = map.getValue(key);

        // then
        Character expected = 'V';
        assertEquals(expected, result);
    }
    @Test
    public void should_CorrectlyReturnValue_WhenMapHasOneNodeForIntegerKeysAndValues() {

        // given
        Integer key = 1;
        Integer value = 1;
        map2.setValue(key, value);

        // when
        Integer result = map2.getValue(key);

        // then
        Integer expected = 1;
        assertEquals(expected, result);
    }
    @Test
    public void should_CorrectlyReturnValue_WhenMapHasOneNodesForCharacterKeysAndIntegerValues() {

        // given
        Character key = 'V';
        Integer value = 1;
        map3.setValue(key, value);

        // when
        Integer result = map3.getValue(key);

        // then
        Integer expected = 1;
        assertEquals(expected, result);
    }
    @Test
    public void should_CorrectlyReturnValue_WhenMapHasTwoTheSameNodesForCharacterKeysAndValue() {

        // given
        Character key = 'V';
        Character value = 'V';
        map.setValue(key, value);
        map.setValue(key, value);

        // when
        Character result = map.getValue(key);

        // then
        Character expected = 'V';
        assertEquals(expected, result);
    }
    @Test
    public void should_CorrectlyReturnValue_WhenMapHasTheSameNodeForIntegerKeysAndValues() {

        // given
        Integer key = 1;
        Integer value = 1;
        map2.setValue(key, value);
        map2.setValue(key, value);
        // when
        Integer result = map2.getValue(key);

        // then
        Integer expected = 1;
        assertEquals(expected, result);
    }
    @Test
    public void should_CorrectlyReturnValue_WhenMapHasTwoTheSameNodesForCharacterKeysAndIntegerValues() {

        // given
        Character key = 'V';
        Integer value = 1;
        map3.setValue(key, value);
        map3.setValue(key, value);

        // when
        Integer result = map3.getValue(key);

        // then
        Integer expected = 1;
        assertEquals(expected, result);
    }
    @Test
    public void should_CorrectlyReturnUpdateValue_WhenTheKeyExistsForCharacterKeysAndValue() {

        // given
        Character keyFirst = 'V';
        Character valueFirst = 'O';
        Character keySecond = 'V';
        Character valueSecond = 'C';
        map.setValue(keyFirst, valueFirst);
        map.setValue(keySecond, valueSecond);

        // when
        Character result = map.getValue(keyFirst);

        // then
        Character expected = 'C';
        assertEquals(expected, result);
    }
    @Test
    public void should_CorrectlyReturnUpdateValue_WhenInIntegerMapTheKeyExistForIntegerKeysAndValues() {

        // given
        Integer keyFirst = 1;
        Integer valueFirst = 1;
        Integer keySecond = 1;
        Integer valueSecond = 2;
        map2.setValue(keyFirst, valueFirst);
        map2.setValue(keySecond, valueSecond);

        // when
        Integer result = map2.getValue(keyFirst);

        // then
        Integer expected = 2;
        assertEquals(expected, result);
    }
    @Test
    public void should_CorrectlyReturnUpdateValue_WhenTheKeyExistsForCharacterKeysAndIntegerValues() {
        // given
        Character keyFirst = 'V';
        Integer valueFirst = 1;


        Character keySecond = 'V';
        Integer valueSecond = 2;

        map3.setValue(keyFirst, valueFirst);
        map3.setValue(keySecond, valueSecond);

        // when
        Integer result = map3.getValue(keyFirst);

        // then
        Integer expected = 2;
        assertEquals(expected, result);
    }
    @Test
    public void should_CorrectlyReturnValue_WhenMapHasTwoNodesForCharacterKeysAndValue() {

        // given
        Character keyFirst = 'U';
        Character valueFirst = 'U';
        Character keySecond = 'B';
        Character valueSecond = 'B';
        map.setValue(keyFirst, valueFirst);
        map.setValue(keySecond, valueSecond);

        // when
        Character resultFirst = map.getValue(keyFirst);
        Character resultSecond = map.getValue(keySecond);

        // then
        Character expectedFirst = 'U';
        Character expectedSecond = 'B';

        assertThat(resultFirst).isEqualTo(expectedFirst);
        assertThat(resultSecond).isEqualTo(expectedSecond);
    }
    @Test
    public void should_CorrectlyReturnValue_WhenMapHasTwoNodesForIntegerKeysAndValues() {

        // given
        Integer keyFirst = 1;
        Integer valueFirst = 1;
        Integer keySecond = 2;
        Integer valueSecond = 2;
        map2.setValue(keyFirst, valueFirst);
        map2.setValue(keySecond, valueSecond);

        // when
        Integer resultFirst = map2.getValue(keyFirst);
        Integer resultSecond = map2.getValue(keySecond);

        // then
        Integer expectedFirst = 1;
        Integer expectedSecond = 2;

        assertThat(resultFirst).isEqualTo(expectedFirst);
        assertThat(resultSecond).isEqualTo(expectedSecond);
    }
    @Test
    public void should_CorrectlyReturnValue_WhenRBTHasTwoNodesForCharacterKeysAndIntegerValues() {

        // given
        Character keyFirst = 'U';
        Integer valueFirst = 1;
        Character keySecond = 'B';
        Integer valueSecond = 2;
        map3.setValue(keyFirst, valueFirst);
        map3.setValue(keySecond, valueSecond);

        // when
        Integer resultFirst = map3.getValue(keyFirst);
        Integer resultSecond = map3.getValue(keySecond);

        // then
        Integer expectedFirst = 1;
        Integer expectedSecond = 2;

        assertEquals(resultFirst, expectedFirst);
        assertEquals(resultSecond, expectedSecond);
    }
    @Test
    public void should_CorrectlyReturnValue_WhenMapHasThreeNodesForCharacterKeysAndValue() {
        // given
        Character keyFirst = 'B';
        Character valueFirst = 'B';
        Character keySecond = 'U';
        Character valueSecond = 'U';
        Character keyThird = 'K';
        Character valueThird = 'K';
        map.setValue(keyFirst, valueFirst);
        map.setValue(keySecond, valueSecond);
        map.setValue(keyThird, valueThird);

        // when
        Character resultFirst = map.getValue(keyFirst);
        Character resultSecond = map.getValue(keySecond);
        Character resultThird = map.getValue(keyThird);

        // then
        Character expectedFirst = 'B';
        Character expectedSecond = 'U';
        Character expectedThird = 'K';

        assertThat(resultFirst).isEqualTo(expectedFirst);
        assertThat(resultSecond).isEqualTo(expectedSecond);
        assertThat(resultThird).isEqualTo(expectedThird);
    }
    @Test
    public void should_CorrectlyReturnValue_WhenMapHasThreeNodesForIntegerKeysAndValues() {
        // given
        Integer keyFirst = 1;
        Integer valueFirst = 1;
        Integer keySecond = 2;
        Integer valueSecond = 2;
        Integer keyThird = 3;
        Integer valueThird = 3;
        map2.setValue(keyFirst, valueFirst);
        map2.setValue(keySecond, valueSecond);
        map2.setValue(keyThird, valueThird);

        // when
        Integer resultFirst = map2.getValue(keyFirst);
        Integer resultSecond = map2.getValue(keySecond);
        Integer resultThird = map2.getValue(keyThird);

        // then
        Integer expectedFirst = 1;
        Integer expectedSecond = 2;
        Integer expectedThird = 3;

        assertThat(resultFirst).isEqualTo(expectedFirst);
        assertThat(resultSecond).isEqualTo(expectedSecond);
        assertThat(resultThird).isEqualTo(expectedThird);
    }
    @Test
    public void should_CorrectlyReturnValue_WhenMapHasTwoNodesForCharacterKeysAndIntegerValues() {
        // given
        Character keyFirst = 'U';
        Integer valueFirst = 1;
        Character keySecond = 'B';
        Integer valueSecond = 2;
        Character keyThird = 'K';
        Integer valueThird = 3;
        map3.setValue(keyFirst, valueFirst);
        map3.setValue(keySecond, valueSecond);
        map3.setValue(keyThird, valueThird);

        // when
        Integer resultFirst = map3.getValue(keyFirst);
        Integer resultSecond = map3.getValue(keySecond);
        Integer resultThird = map3.getValue(keyThird);

        // then
        Integer expectedFirst = 1;
        Integer expectedSecond = 2;
        Integer expectedThird = 3;

        assertThat(resultFirst).isEqualTo(expectedFirst);
        assertThat(resultSecond).isEqualTo(expectedSecond);
        assertThat(resultThird).isEqualTo(expectedThird);
    }
    @Test
    public void should_CorrectlyReturnArrayOfValues_WhenKeysAndValueAreInTheMapCaseFirst() {

        // given
        Character[] array = {'B', 'U', 'K', 'O', 'W', 'I', 'E', 'C'};
        for (int i = 0; i < array.length; i++) {
            map.setValue(array[i], array[i]);
        }
        // when
        Character[] result = new Character[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = map.getValue(array[i]);
        }
        // then
        assertThat(result).isEqualTo(array);
    }
    @Test
    public void should_CorrectlyReturnArrayOfValues_WhenKeysAndValueAreInTheMapCaseSecond() {

        // given
        Character[] array = {'B', 'A', 'L', 'I', 'G', 'R', 'O', 'D'};
        for (int i = 0; i < array.length; i++) {
            map.setValue(array[i], array[i]);
        }

        // when
        Character[] result = new Character[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = map.getValue(array[i]);
        }

        // then
        assertThat(result).isEqualTo(array);
    }
    @Test
    public void should_CorrectlyReturnValues_WhenKeysAndValueAreInTheMapCaseThird() {

        // given
        Character[] array = {'U', 'S', 'T', 'R', 'Z', 'Y', 'K', 'I'};
        for (int i = 0; i < array.length; i++) {
            map.setValue(array[i], array[i]);
        }

        // when
        Character[] result = new Character[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = map.getValue(array[i]);
        }

        // then
        assertThat(result).isEqualTo(array);
    }
    @Test
    public void should_CorrectlyReturnArrayOfValues_WhenKeysAreInTheIntegerMapCaseFirst() {

        // given
        Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        for (int i = 0; i < array.length; i++) {
            map2.setValue(array[i], array[i]);
        }

        // when
        Integer[] result = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = map2.getValue(array[i]);
        }

        // then
        assertThat(result).isEqualTo(array);
    }
    @Test
    public void should_CorrectlyReturnArrayOfValues_WhenKeysAreInTheIntegerMapCaseSecond() {

        // given
        Character[] arrayKeyCharacter = {'U', 'S', 'T', 'R', 'Z', 'Y', 'K', 'I'};
        Integer[] arrayValueInteger = {1, 2, 3, 4, 5, 6, 7, 8};
        for (int i = 0; i < arrayKeyCharacter.length; i++) {
            map3.setValue(arrayKeyCharacter[i], arrayValueInteger[i]);
        }

        // when
        Integer[] result = new Integer[arrayKeyCharacter.length];
        for (int i = 0; i < arrayKeyCharacter.length; i++) {
            result[i] = map3.getValue(arrayKeyCharacter[i]);
        }

        // then
        assertThat(result).isEqualTo(arrayValueInteger);
    }
    @Test
    public void should_CorrectlyReturnValues_WhenKeysAreLatinAlphabet() {

        // given
        Character[] array = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
                'L', 'M', 'N', 'O', 'P', 'R', 'S', 'T', 'U', 'W', 'Y', 'Z'};
        for (int i = 0; i < array.length; i++) {
            map.setValue(array[i], array[i]);
        }

        // when
        Character[] result = new Character[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = map.getValue(array[i]);
        }

        // then
        assertThat(result).isEqualTo(array);
    }
    @Test
    public void should_CorrectlyReturnValues_WhenKeysAreArrayASCII() {

        // given
        Character[] asciiArray = new Character[94];
        for (int i = 0; i < 94; i++) {
            asciiArray[i] = (char) (i+33);
            map.setValue(asciiArray[i], asciiArray[i]);
        }

        // when
        Character[] result = new Character[asciiArray.length];
        for (int i = 0; i < asciiArray.length; i++) {
            result[i] = map.getValue(asciiArray[i]);
        }

        // then
        assertThat(result).isEqualTo(asciiArray);
    }
    @Test
    public void should_GetValues_WhenDataIsRandom() {

        //given
        int seed = 7312;
        int size = 1_000_000;
        Random rand = new Random(seed);
        Integer[] array = new Integer[size];


        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt();
        }

        //when
        for (int i = 0; i < size; i++) {
            map2.setValue(array[i], array[i]);
        }
        Integer [] result = new Integer[size];
        Integer [] expected = new Integer[size];
        for (int i = 0; i < size; i++) {
            result[i] = map2.getValue(array[i]);
            expected[i] = array[i];

        }
        assertArrayEquals(expected, result);
    }
}
