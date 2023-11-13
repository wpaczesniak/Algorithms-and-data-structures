package pl.edu.pw.ee.aisd2023zlab4;

import org.junit.Before;
import org.junit.Test;
import java.lang.reflect.Field;
import java.util.Random;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


public class RedBlackTreeTest {
    private RedBlackTree<Character, Character> redBlackTree;

    private RedBlackTree<String, String> rbt;
    private RedBlackTree<Character, Character> map;
    private RedBlackTree<Integer, Integer> map2;
    private RedBlackTree<Character, Integer> map3;

    @Before
    public void setUp() {
        redBlackTree = new RedBlackTree<>();
        map = new RedBlackTree<>();
        map2 = new RedBlackTree<>();
        map3 = new RedBlackTree<>();
        rbt = new RedBlackTree<>();
    }
    @Test(expected = IllegalArgumentException.class)
    public void should_ThrowException_WhenTrySetNullKeyForCharacterKeysAndValue() {

        // given
        Character key = null;
        Character value = 'v';

        // when
        map.put(key, value);

        // then
        assert false;
    }
    @Test(expected = IllegalArgumentException.class)
    public void should_ThrowException_WhenTrySetNullKeyForIntegerKeysAndValue() {

        // given
        Integer key = null;
        Integer value = 1;

        // when
        map2.put(key, value);

        // then
        assert false;
    }
    @Test(expected = IllegalArgumentException.class)
    public void should_ThrowException_WhenTrySetNullKeyForCharacterKeysAndIntegerValues() {

        // given
        Character key = null;
        Integer value = 1;

        // when
        map3.put(key, value);

        // then
        assert false;
    }
    @Test(expected = IllegalArgumentException.class)
    public void should_ThrowException_WhenTrySetNullValueForCharacterKeysAndValue() {

        // given
        Character key = 'V';
        Character value = null;

        // when
        map.put(key, value);

        // then
        assert false;
    }
    @Test(expected = IllegalArgumentException.class)
    public void should_ThrowException_WhenTrySetNullValueForIntegerKeysAndValue() {

        // given
        Integer key = 1;
        Integer value = null;

        // when
        map2.put(key, value);

        // then
        assert false;
    }
    @Test(expected = IllegalArgumentException.class)
    public void should_ThrowException_WhenTrySetNullValueForCharacterKeysAndIntegerValues() {

        // given
        Character key = 'V';
        Integer value = null;

        // when
        map3.put(key, value);

        // then
        assert false;
    }
    @Test(expected = IllegalArgumentException.class)
    public void should_ThrowException_WhenTrySetNullKeyAndValueForCharacterKeysAndValue() {

        // given
        Character key = null;
        Character value = null;

        // when
        map.put(key, value);

        // then
        assert false;
    }
    @Test(expected = IllegalArgumentException.class)
    public void should_ThrowException_WhenTrySetNullKeyAndValueForIntegerKeysAndValues() {

        // given
        Integer key = null;
        Integer value = null;

        // when
        map2.put(key, value);

        // then
        assert false;
    }
    @Test(expected = IllegalArgumentException.class)
    public void should_ThrowException_WhenTrySetNullKeyAndValueForCharacterKeysAndIntegerValues() {

        // given
        Character key = null;
        Integer value = null;

        // when
        map3.put(key, value);

        // then
        assert false;
    }
    @Test(expected = IllegalArgumentException.class)
    public void should_ThrowException_WhenTryGetNullKeyForCharacterKeysAndValue() {

        // given
        Character key = null;

        // when
        map.get(key);

        // then
        assert false;
    }
    @Test(expected = IllegalArgumentException.class)
    public void should_ThrowException_WhenTryGetNullKeyForIntegerKeysAndValue() {

        // given
        Integer key = null;

        // when
        map2.get(key);

        // then
        assert false;
    }
    @Test(expected = IllegalArgumentException.class)
    public void should_ThrowException_WhenTryGetNullKeyForCharacterKeysAndIntegerValues() {

        // given
        Character key = null;

        // when
        map3.get(key);

        // then
        assert false;
    }
    @Test
    public void should_CorrectlyReturnNull_WhenTreeIsEmptyForCharacterKeysAndValue() {

        // given
        Character key = 'V';

        // when
        Character result = map.get(key);

        // then
        Character expected = null;
        assertEquals(expected, result);
    }
    @Test
    public void should_CorrectlyReturnNull_WhenTreeIsEmptyForIntegerKeysAndValue() {

        // given
        Integer key = 1;

        // when
        Integer result = map2.get(key);

        // then
        Integer expected = null;
        assertEquals(expected, result);
    }
    @Test
    public void should_CorrectlyReturnNull_WhenTreeIsEmptyForCharacterKeysAndIntegerValues() {

        // given
        Character key = 'V';

        // when
        Integer result = map3.get(key);

        // then
        Integer expected = null;
        assertEquals(expected, result);
    }
    @Test
    public void should_CorrectlyReturnNull_WhenTryGetValueButKeyDoestExistInTreeForCharacterKeysAndValue() {

        // given
        Character keyInMap = 'V';
        Character valueInMap = 'V';
        map.put(keyInMap, valueInMap);
        Character key = 'Z';

        // when
        Character result = map.get(key);

        // then
        Character expected = null;
        assertEquals(expected, result);
    }
    @Test
    public void should_CorrectlyReturnNull_WhenTryGetValueButKeyDoestExistInTreeForIntegerKeysAndValue() {

        // given
        Integer keyInMap = 1;
        Integer valueInMap = 1;
        map2.put(keyInMap, valueInMap);
        Integer key = 2;

        // when
        Integer result = map2.get(key);

        // then
        Character expected = null;
        assertEquals(expected, result);
    }
    @Test
    public void should_CorrectlyReturnNull_WhenTryGetValueButKeyDoestExistInTreeForCharacterKeysAndIntegerValues() {

        // given
        Character keyInMap = 'V';
        Integer valueInMap = 1;
        map3.put(keyInMap, valueInMap);
        Character key = 2;

        // when
        Integer result = map3.get(key);

        // then
        Character expected = null;
        assertEquals(expected, result);
    }
    @Test
    public void should_CorrectlyReturnValue_WhenTreeHasOneNodeForCharacterKeysAndValue() {

        // given
        Character key = 'V';
        Character value = 'V';

        map.put(key, value);

        // when
        Character result = map.get(key);

        // then
        Character expected = 'V';
        assertEquals(expected, result);
    }
    @Test
    public void should_CorrectlyReturnValue_WhenTreeHasOneNodeForIntegerKeysAndValue() {

        // given
        Integer key = 1;
        Integer value = 1;

        map2.put(key, value);

        // when
        Integer result = map2.get(key);

        // then
        Integer expected = 1;
        assertEquals(expected, result);
    }
    @Test
    public void should_CorrectlyReturnValue_WhenTreeHasOneNodeForCharacterKeysAndIntegerValues () {

        // given
        Character key = 'V';
        Integer value = 1;

        map3.put(key, value);

        // when
        Integer result = map3.get(key);

        // then
        Integer expected = 1;
        assertEquals(expected, result);
    }
    @Test
    public void should_CorrectlyReturnValue_WhenTreeHasTwoTheSameNodesForCharacterKeysAndValue() {

        // given
        Character key = 'V';
        Character value = 'V';

        map.put(key, value);
        map.put(key, value);

        // when
        Character result = map.get(key);

        // then
        Character expected = 'V';
        assertEquals(expected, result);
    }

    @Test
    public void should_CorrectlyReturnValue_WhenTreeHasTheSameNodeForIntegerKeysAndValue() {

        // given
        Integer key = 1;
        Integer value = 1;

        map2.put(key, value);
        map2.put(key, value);
        // when
        Integer result = map2.get(key);

        // then
        Integer expected = 1;
        assertEquals(expected, result);
    }
    @Test
    public void should_CorrectlyReturnValue_WhenTreeHasTwoTheSameNodesForCharacterKeysAndIntegerValues() {

        // given
        Character key = 'V';
        Integer value = 1;
        map3.put(key, value);
        map3.put(key, value);

        // when
        Integer result = map3.get(key);

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
        map.put(keyFirst, valueFirst);
        map.put(keySecond, valueSecond);

        // when
        Character result = map.get(keyFirst);

        // then
        Character expected = 'C';
        assertEquals(expected, result);
    }

    @Test
    public void should_CorrectlyReturnUpdateValue_WhenTheKeyExistForIntegerKeysAndValue() {

        // given
        Integer keyFirst = 1;
        Integer valueFirst = 1;
        Integer keySecond = 1;
        Integer valueSecond = 2;
        map2.put(keyFirst, valueFirst);
        map2.put(keySecond, valueSecond);

        // when
        Integer result = map2.get(keyFirst);

        // then
        Integer expected = 2;
        assertEquals(expected, result);
    }
    @Test
    public void should_CorrectlyReturnUpdateValue_WhenTheKeyExistForCharacterKeysAndIntegerValues() {

        // given
        Character keyFirst = 'V';
        Integer valueFirst = 1;
        Character keySecond = 'V';
        Integer valueSecond = 2;
        map3.put(keyFirst, valueFirst);
        map3.put(keySecond, valueSecond);

        // when
        Integer result = map3.get(keyFirst);

        // then
        Integer expected = 2;
        assertEquals(expected, result);
    }
    @Test
    public void should_CorrectlyReturnValue_WhenTreeHasTwoNodesForCharacterKeysAndValue() {

        // given
        Character keyFirst = 'U';
        Character valueFirst = 'U';
        Character keySecond = 'B';
        Character valueSecond = 'B';
        map.put(keyFirst, valueFirst);
        map.put(keySecond, valueSecond);

        // when
        Character resultFirst = map.get(keyFirst);
        Character resultSecond = map.get(keySecond);

        // then
        Character expectedFirst = 'U';
        Character expectedSecond = 'B';

        assertThat(resultFirst).isEqualTo(expectedFirst);
        assertThat(resultSecond).isEqualTo(expectedSecond);
    }

    @Test
    public void should_CorrectlyReturnValue_WhenTreeHasTwoNodesForIntegerKeysAndValue() {

        // given
        Integer keyFirst = 1;
        Integer valueFirst = 1;
        Integer keySecond = 2;
        Integer valueSecond = 2;
        map2.put(keyFirst, valueFirst);
        map2.put(keySecond, valueSecond);

        // when
        Integer resultFirst = map2.get(keyFirst);
        Integer resultSecond = map2.get(keySecond);

        // then
        Integer expectedFirst = 1;
        Integer expectedSecond = 2;

        assertThat(resultFirst).isEqualTo(expectedFirst);
        assertThat(resultSecond).isEqualTo(expectedSecond);
    }
    @Test
    public void should_CorrectlyReturnValue_WhenTreeHasTwoNodesForCharacterKeysAndIntegerValues() {

        // given
        Character keyFirst = 'U';
        Integer valueFirst = 1;
        Character keySecond = 'B';
        Integer valueSecond = 2;
        map3.put(keyFirst, valueFirst);
        map3.put(keySecond, valueSecond);

        // when
        Integer resultFirst = map3.get(keyFirst);
        Integer resultSecond = map3.get(keySecond);

        // then
        Integer expectedFirst = 1;
        Integer expectedSecond = 2;

        assertEquals(resultFirst, expectedFirst);
        assertEquals(resultSecond, expectedSecond);
    }
    @Test
    public void should_CorrectlyReturnValue_WhenTreeHasThreeNodesForCharacterKeysAndValue() {

        // given
        Character keyFirst = 'B';
        Character valueFirst = 'B';
        Character keySecond = 'U';
        Character valueSecond = 'U';
        Character keyThird = 'K';
        Character valueThird = 'K';
        map.put(keyFirst, valueFirst);
        map.put(keySecond, valueSecond);
        map.put(keyThird, valueThird);

        // when
        Character resultFirst = map.get(keyFirst);
        Character resultSecond = map.get(keySecond);
        Character resultThird = map.get(keyThird);

        // then
        Character expectedFirst = 'B';
        Character expectedSecond = 'U';
        Character expectedThird = 'K';

        assertThat(resultFirst).isEqualTo(expectedFirst);
        assertThat(resultSecond).isEqualTo(expectedSecond);
        assertThat(resultThird).isEqualTo(expectedThird);
    }
    @Test
    public void should_CorrectlyReturnValue_WhenTreeHasThreeNodesForIntegerKeysAndValue() {

        // given
        Integer keyFirst = 1;
        Integer valueFirst = 1;
        Integer keySecond = 2;
        Integer valueSecond = 2;
        Integer keyThird = 3;
        Integer valueThird = 3;
        map2.put(keyFirst, valueFirst);
        map2.put(keySecond, valueSecond);
        map2.put(keyThird, valueThird);

        // when
        Integer resultFirst = map2.get(keyFirst);
        Integer resultSecond = map2.get(keySecond);
        Integer resultThird = map2.get(keyThird);

        // then
        Integer expectedFirst = 1;
        Integer expectedSecond = 2;
        Integer expectedThird = 3;

        assertThat(resultFirst).isEqualTo(expectedFirst);
        assertThat(resultSecond).isEqualTo(expectedSecond);
        assertThat(resultThird).isEqualTo(expectedThird);
    }
    @Test
    public void should_CorrectlyReturnValue_WhenTreeHasThreeNodesForCharacterKeysAndIntegerValues() {

        // given
        Character keyFirst = 'U';
        Integer valueFirst = 1;
        Character keySecond = 'B';
        Integer valueSecond = 2;
        Character keyThird = 'K';
        Integer valueThird = 3;
        map3.put(keyFirst, valueFirst);
        map3.put(keySecond, valueSecond);
        map3.put(keyThird, valueThird);

        // when
        Integer resultFirst = map3.get(keyFirst);
        Integer resultSecond = map3.get(keySecond);
        Integer resultThird = map3.get(keyThird);

        // then
        Integer expectedFirst = 1;
        Integer expectedSecond = 2;
        Integer expectedThird = 3;

        assertThat(resultFirst).isEqualTo(expectedFirst);
        assertThat(resultSecond).isEqualTo(expectedSecond);
        assertThat(resultThird).isEqualTo(expectedThird);
    }
    @Test
    public void should_CorrectlyReturnArrayOfValues_WhenKeysAreInTheMapCaseFirst() {

        // given
        Character[] array = {'B', 'U', 'K', 'O', 'W', 'I', 'E', 'C'};
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], array[i]);
        }
        // when
        Character[] result = new Character[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = map.get(array[i]);
        }
        // then
        assertThat(result).isEqualTo(array);
    }
    @Test
    public void should_CorrectlyReturnArrayOfValues_WhenKeysAreInTheMapCaseSecond() {

        // given
        Character[] array = {'B', 'A', 'L', 'I', 'G', 'R', 'O', 'D'};
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], array[i]);
        }

        // when
        Character[] result = new Character[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = map.get(array[i]);
        }

        // then
        assertThat(result).isEqualTo(array);
    }
    @Test
    public void should_CorrectlyReturnValues_WhenKeysAreInTheMapCaseThird() {

        // given
        Character[] array = {'U', 'S', 'T', 'R', 'Z', 'Y', 'K', 'I'};
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], array[i]);
        }

        // when
        Character[] result = new Character[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = map.get(array[i]);
        }

        // then
        assertThat(result).isEqualTo(array);
    }
    @Test
    public void should_CorrectlyReturnArrayOfValues_WhenKeysAreInTheIntegerMap() {

        // given
        Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        for (int i = 0; i < array.length; i++) {
            map2.put(array[i], array[i]);
        }

        // when
        Integer[] result = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = map2.get(array[i]);
        }

        // then
        assertThat(result).isEqualTo(array);
    }
    @Test
    public void should_CorrectlyReturnArrayOfValues_WhenKeysAreCharacterButValueAreInteger() {

        // given
        Character[] arrayKeyCharacter = {'U', 'S', 'T', 'R', 'Z', 'Y', 'K', 'I'};
        Integer[] arrayValueInteger = {1, 2, 3, 4, 5, 6, 7, 8};
        for (int i = 0; i < arrayKeyCharacter.length; i++) {
            map3.put(arrayKeyCharacter[i], arrayValueInteger[i]);
        }

        // when
        Integer[] result = new Integer[arrayKeyCharacter.length];
        for (int i = 0; i < arrayKeyCharacter.length; i++) {
            result[i] = map3.get(arrayKeyCharacter[i]);
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
            map.put(array[i], array[i]);
        }

        // when
        Character[] result = new Character[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = map.get(array[i]);
        }

        // then
        assertThat(result).isEqualTo(array);
    }
    @Test
    public void should_CorrectlyReturnValues_WhenKeysAreArrayASCII() {

        // given
        Character[] asciiArray = new Character[94];
        for (int i = 0; i < 94; i++) {
            asciiArray[i] = (char) (i + 33);
            map.put(asciiArray[i], asciiArray[i]);
        }

        // when
        Character[] result = new Character[asciiArray.length];
        for (int i = 0; i < asciiArray.length; i++) {
            result[i] = map.get(asciiArray[i]);
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
            map2.put(array[i], array[i]);
        }
        Integer[] result = new Integer[size];
        Integer[] expected = new Integer[size];
        for (int i = 0; i < size; i++) {
            result[i] = map2.get(array[i]);
            expected[i] = array[i];

        }
        assertArrayEquals(expected, result);
    }
    @Test
    public void should_CorrectlyReturnValue_WhenWithoutRotateRBTHasTwoNodes() {

        // given
        Character firstKeyValue = 'W';
        Character secondKeyValue = 'E';
        redBlackTree.put(firstKeyValue, firstKeyValue);
        redBlackTree.put(secondKeyValue, secondKeyValue);

        // when
        Node<Character, Character> node = getRoot(redBlackTree);
        Character root = node.getValue();
        Character leftChild = node.getLeft().getValue();

        // then
        Character expectedRoot = 'W';
        Character expectedChildLeft = 'E';
        assertThat(root).isEqualTo(expectedRoot);
        assertThat(leftChild).isEqualTo(expectedChildLeft);
        assertTrue(node.isBlack());
        assertTrue(node.getLeft().isRed());
    }
    @Test
    public void should_CorrectlyRotateLeft_When_TreeHasOneRedRightBranch() {

        // given
        Character firstKeyValue = 'I';
        Character secondKeyValue = 'N';
        redBlackTree.put(firstKeyValue, firstKeyValue);

        // when
        redBlackTree.put(secondKeyValue, secondKeyValue);

        Node<Character, Character> node = getRoot(redBlackTree);
        Character root = node.getValue();
        Character leftChild = node.getLeft().getValue();

        // then
        Character expectedRoot = 'N';
        Character expectedLeftChild = 'I';

        assertThat(root).isEqualTo(expectedRoot);
        assertThat(leftChild).isEqualTo(expectedLeftChild);
        assertTrue(node.isBlack());
        assertTrue(node.getLeft().isRed());
    }
    @Test
    public void should_CorrectlyChangeColorsButWithoutRotate_WhenTreeHasTwoRedBranches() {

        // given
        Character firstKeyValue = 'B';
        Character secondKeyValue = 'A';
        Character thirdKeyValue = 'L';
        redBlackTree.put(firstKeyValue, firstKeyValue);
        redBlackTree.put(secondKeyValue, secondKeyValue);

        // when
        redBlackTree.put(thirdKeyValue, thirdKeyValue);

        // then
        Node<Character, Character> node = getRoot(redBlackTree);
        Character root = node.getValue();
        Character leftChild = node.getLeft().getValue();
        Character rightChild = node.getRight().getValue();

        Character expectedRoot = 'B';
        Character expectedLeftChild = 'A';
        Character expectedRightChild = 'L';

        assertEquals(root, expectedRoot);
        assertEquals(leftChild, expectedLeftChild);
        assertEquals(rightChild, expectedRightChild);

        assertTrue(node.getLeft().isBlack());
        assertTrue(node.getRight().isBlack());
        assertTrue(node.isBlack());
    }
    @Test
    public void should_CorrectlyRotateRightAndChangeColors_WhenTreeHasThreeNodes() {

        // given
        Character firstKeyValue = 'W';
        Character secondKeyValue = 'E';
        Character thirdKeyValue = 'A';
        redBlackTree.put(firstKeyValue, firstKeyValue);
        redBlackTree.put(secondKeyValue, secondKeyValue);
        redBlackTree.put(thirdKeyValue, thirdKeyValue);

        // when
        Node<Character, Character> node = getRoot(redBlackTree);
        Character root = node.getValue();
        Character leftChild = node.getLeft().getValue();
        Character rightChild = node.getRight().getValue();

        // then
        Character expectedRoot = 'E';
        Character expectedChildLeft = 'A';
        Character expectedChildRight = 'W';
        assertThat(root).isEqualTo(expectedRoot);
        assertThat(leftChild).isEqualTo(expectedChildLeft);
        assertThat(rightChild).isEqualTo(expectedChildRight);
        assertTrue(node.isBlack());
        assertTrue(node.getLeft().isBlack());
        assertTrue(node.getRight().isBlack());
    }
    @Test
    public void should_CorrectlyRotateLeftAndRightAndChangeColors_WhenTreeHasThreeNodes() {

        // given
        Character firstKeyValue = 'U';
        Character secondKeyValue = 'S';
        Character thirdKeyValue = 'T';
        redBlackTree.put(firstKeyValue, firstKeyValue);
        redBlackTree.put(secondKeyValue, secondKeyValue);
        redBlackTree.put(thirdKeyValue, thirdKeyValue);

        // when
        Node<Character, Character> node = getRoot(redBlackTree);
        Character root = node.getValue();
        Character leftChild = node.getLeft().getValue();
        Character rightChild = node.getRight().getValue();

        // then
        Character expectedRoot = 'T';
        Character expectedChildLeft = 'S';
        Character expectedChildRight = 'U';
        assertThat(root).isEqualTo(expectedRoot);
        assertThat(leftChild).isEqualTo(expectedChildLeft);
        assertThat(rightChild).isEqualTo(expectedChildRight);
        assertTrue(node.isBlack());
        assertTrue(node.getLeft().isBlack());
        assertTrue(node.getRight().isBlack());
    }
    @Test
    public void should_CorrectlyTwoLeftAndRightRotatesAndChangeColors_WhenTreeHasThreeNodes() {

        // given
        Character firstKeyValue = 'B';
        Character secondKeyValue = 'U';
        Character thirdKeyValue = 'K';
        redBlackTree.put(firstKeyValue, firstKeyValue);

        // when
        redBlackTree.put(secondKeyValue, secondKeyValue);
        redBlackTree.put(thirdKeyValue, thirdKeyValue);
        Node<Character, Character> node = getRoot(redBlackTree);
        Character root = node.getValue();
        Character leftChild = node.getLeft().getValue();
        Character rightChild = node.getRight().getValue();

        // then
        Character expectedRoot = 'K';
        Character expectedChildLeft = 'B';
        Character expectedChildRight = 'U';
        assertThat(root).isEqualTo(expectedRoot);
        assertThat(leftChild).isEqualTo(expectedChildLeft);
        assertThat(rightChild).isEqualTo(expectedChildRight);
        assertTrue(node.isBlack());
        assertTrue(node.getLeft().isBlack());
        assertTrue(node.getRight().isBlack());
    }
    @Test
    public void should_CorrectlyRightRotateWithChangeParentAndChangeColors_WhenTreeHasTwoRedBranchesOnTheLeft() {

        // given
        Character[] array = {'W', 'E', 'R', 'O', 'N', 'I', 'K'};
        for (int i = 0; i < array.length - 1; i++) {
            redBlackTree.put(array[i], array[i]);
        }

        // when
        redBlackTree.put(array[6], array[6]);
        Node<Character, Character> node = getRoot(redBlackTree);
        Character root = node.getValue();
        Character leftChild = node.getLeft().getValue();
        Character rightChild = node.getRight().getValue();
        Character childChangedParent = node.getRight().getLeft().getValue();

        // then
        Character expectedRoot = 'N';
        Character expectedChildLeft = 'I';
        Character expectedChildRight = 'R';
        Character expectedChildChangedParent = 'O';
        assertThat(root).isEqualTo(expectedRoot);
        assertThat(leftChild).isEqualTo(expectedChildLeft);
        assertThat(rightChild).isEqualTo(expectedChildRight);
        assertThat(childChangedParent).isEqualTo(expectedChildChangedParent);
        assertTrue(node.isBlack());
        assertTrue(node.getLeft().isBlack());
        assertTrue(node.getRight().isBlack());
        assertTrue(node.getRight().getLeft().isBlack());
    }
    @Test
    public void should_CorrectlyLeftRotateWithChangeParentAndChangeColors_WhenTreeHasOneRedBranchOnTheRight() {

        // given
        Character[] array = {'U', 'S', 'T', 'R', 'Z', 'Y'};
        for (int i = 0; i < array.length - 1; i++) {
            redBlackTree.put(array[i], array[i]);
        }

        // when
        redBlackTree.put(array[5], array[5]);
        Node<Character, Character> node = getRoot(redBlackTree);
        Character root = node.getValue();
        Character leftChild = node.getLeft().getValue();
        Character rightChild = node.getRight().getValue();
        Character childChangedParent = node.getLeft().getRight().getValue();

        // then
        Character expectedRoot = 'Y';
        Character expectedChildLeft = 'T';
        Character expectedChildRight = 'Z';
        Character expectedChildChangedParent = 'U';
        assertThat(root).isEqualTo(expectedRoot);
        assertThat(leftChild).isEqualTo(expectedChildLeft);
        assertThat(rightChild).isEqualTo(expectedChildRight);
        assertThat(childChangedParent).isEqualTo(expectedChildChangedParent);
        assertTrue(node.isBlack());
        assertTrue(node.getLeft().isRed());
        assertTrue(node.getRight().isBlack());
        assertTrue(node.getLeft().getRight().isBlack());
    }

    @Test
    public void should_CorrectlyGetValueAndChangedColor_WhenPutAfterTheLetterStepFirst() {

        // given
        Character[] array = {'B', 'U', 'K', 'O', 'W', 'I', 'E', 'C'};

        // when
        redBlackTree.put(array[0], array[0]);
        Node<Character, Character> node = getRoot(redBlackTree);
        Character root = node.getValue();

        // then
        Character expectedRoot = 'B';

        assertThat(root).isEqualTo(expectedRoot);
        assertTrue(node.isBlack());
    }
    @Test
    public void should_CorrectlyGetValueAndChangedColor_WhenPutAfterTheLetterStepSecond() {

        // given
        Character[] array = {'B', 'U', 'K', 'O', 'W', 'I', 'E', 'C'};
        redBlackTree.put(array[0], array[0]);

        // when
        redBlackTree.put(array[1], array[1]);
        Node<Character, Character> node = getRoot(redBlackTree);
        Character root = node.getValue();
        Character leftChild = node.getLeft().getValue();

        // then
        Character expectedRoot = 'U';
        Character expectedChildLeft = 'B';
        assertThat(root).isEqualTo(expectedRoot);
        assertThat(leftChild).isEqualTo(expectedChildLeft);
        assertTrue(node.isBlack());
        assertTrue(node.getLeft().isRed());
    }
    @Test
    public void should_CorrectlyGetValueAndChangedColor_WhenPutAfterTheLetterStepThird() {

        // given
        Character[] array = {'B', 'U', 'K', 'O', 'W', 'I', 'E', 'C'};
        redBlackTree.put(array[0], array[0]);
        redBlackTree.put(array[1], array[1]);

        // when
        redBlackTree.put(array[2], array[2]);
        Node<Character, Character> node = getRoot(redBlackTree);
        Character root = node.getValue();
        Character leftChild = node.getLeft().getValue();
        Character rightChild = node.getRight().getValue();

        // then
        Character expectedRoot = 'K';
        Character expectedChildLeft = 'B';
        Character expectedChildRight = 'U';
        assertThat(root).isEqualTo(expectedRoot);
        assertThat(leftChild).isEqualTo(expectedChildLeft);
        assertThat(rightChild).isEqualTo(expectedChildRight);
        assertTrue(node.isBlack());
        assertTrue(node.getLeft().isBlack());
        assertTrue(node.getRight().isBlack());
    }

    @Test
    public void should_CorrectlyGetValueAndChangedColor_WhenPutAfterTheLetterStepFourth() {

        // given
        Character[] array = {'B', 'U', 'K', 'O', 'W', 'I', 'E', 'C'};
        for (int i = 0; i < 3; i++) {
            redBlackTree.put(array[i], array[i]);
        }

        // when
        redBlackTree.put(array[3], array[3]);
        Node<Character, Character> node = getRoot(redBlackTree);
        Character root = node.getValue();
        Character leftChild = node.getLeft().getValue();
        Character rightChild = node.getRight().getValue();
        Character grandchildFirst = node.getRight().getLeft().getValue();

        // then
        Character expectedRoot = 'K';
        Character expectedChildLeft = 'B';
        Character expectedChildRight = 'U';
        Character expectedGrandchildFirst = 'O';
        assertThat(root).isEqualTo(expectedRoot);
        assertThat(leftChild).isEqualTo(expectedChildLeft);
        assertThat(rightChild).isEqualTo(expectedChildRight);
        assertThat(grandchildFirst).isEqualTo(expectedGrandchildFirst);

        assertTrue(node.isBlack());
        assertTrue(node.getLeft().isBlack());
        assertTrue(node.getRight().isBlack());
        assertTrue(node.getRight().getLeft().isRed());
    }

    @Test
    public void should_CorrectlyGetValueAndChangedColor_WhenPutAfterTheLetterStepFifth() {

        // given
        Character[] array = {'B', 'U', 'K', 'O', 'W', 'I', 'E', 'C'};
        for (int i = 0; i < 4; i++) {
            redBlackTree.put(array[i], array[i]);
        }

        // when
        redBlackTree.put(array[4], array[4]);
        Node<Character, Character> node = getRoot(redBlackTree);
        Character root = node.getValue();
        Character leftChild = node.getLeft().getValue();
        Character rightChild = node.getRight().getValue();
        Character grandchildFirst = node.getLeft().getLeft().getValue();
        Character grandchildSecond = node.getLeft().getRight().getValue();

        // then
        Character expectedRoot = 'U';
        Character expectedChildLeft = 'K';
        Character expectedChildRight = 'W';
        Character expectedGrandchildFirst = 'B';
        Character expectedGrandchildSecond = 'O';
        assertThat(root).isEqualTo(expectedRoot);
        assertThat(leftChild).isEqualTo(expectedChildLeft);
        assertThat(rightChild).isEqualTo(expectedChildRight);
        assertThat(grandchildFirst).isEqualTo(expectedGrandchildFirst);
        assertThat(grandchildSecond).isEqualTo(expectedGrandchildSecond);
        assertTrue(node.isBlack());
        assertTrue(node.getLeft().isRed());
        assertTrue(node.getRight().isBlack());
        assertTrue(node.getLeft().getRight().isBlack());
        assertTrue(node.getLeft().getLeft().isBlack());
    }

    @Test
    public void should_CorrectlyGetValueAndChangedColor_WhenPutAfterTheLetterStepSixth() {

        // given
        Character[] array = {'B', 'U', 'K', 'O', 'W', 'I', 'E', 'C'};
        for (int i = 0; i < 5; i++) {
            redBlackTree.put(array[i], array[i]);
        }

        // when
        redBlackTree.put(array[5], array[5]);
        Node<Character, Character> node = getRoot(redBlackTree);
        Character root = node.getValue();
        Character leftChild = node.getLeft().getValue();
        Character rightChild = node.getRight().getValue();
        Character grandchildFirst = node.getLeft().getLeft().getValue();
        Character grandchildSecond = node.getLeft().getRight().getValue();
        Character greatGrandchildFirst = node.getLeft().getLeft().getLeft().getValue();

        // then
        Character expectedRoot = 'U';
        Character expectedChildLeft = 'K';
        Character expectedChildRight = 'W';
        Character expectedGrandchildFirst = 'I';
        Character expectedGrandchildSecond = 'O';
        Character expectedGreatGrandchildFirst = 'B';

        assertThat(root).isEqualTo(expectedRoot);
        assertThat(leftChild).isEqualTo(expectedChildLeft);
        assertThat(rightChild).isEqualTo(expectedChildRight);
        assertThat(grandchildFirst).isEqualTo(expectedGrandchildFirst);
        assertThat(grandchildSecond).isEqualTo(expectedGrandchildSecond);
        assertThat(greatGrandchildFirst).isEqualTo(expectedGreatGrandchildFirst);
        assertTrue(node.isBlack());
        assertTrue(node.getLeft().isRed());
        assertTrue(node.getRight().isBlack());
        assertTrue(node.getLeft().getRight().isBlack());
        assertTrue(node.getLeft().getLeft().isBlack());
        assertTrue(node.getLeft().getLeft().getLeft().isRed());
    }

    @Test
    public void should_CorrectlyGetValueAndChangedColor_WhenPutAfterTheLetterStepSeventh() {

        // given
        Character[] array = {'B', 'U', 'K', 'O', 'W', 'I', 'E', 'C'};
        for (int i = 0; i < 6; i++) {
            redBlackTree.put(array[i], array[i]);
        }

        // when
        redBlackTree.put(array[6], array[6]);
        Node<Character, Character> node = getRoot(redBlackTree);
        Character root = node.getValue();
        Character leftChild = node.getLeft().getValue();
        Character rightChild = node.getRight().getValue();
        Character grandchildFirst = node.getLeft().getLeft().getValue();
        Character grandchildSecond = node.getLeft().getRight().getValue();
        Character grandchildThird = node.getRight().getLeft().getValue();
        Character gandchildFourth = node.getRight().getRight().getValue();

        // then
        Character expectedRoot = 'K';
        Character expectedChildLeft = 'E';
        Character expectedChildRight = 'U';
        Character expectedGrandchildFirst = 'B';
        Character expectedGrandchildSecond = 'I';
        Character expectedGrandchildThird = 'O';
        Character expectedGrandchildFourth = 'W';

        assertThat(root).isEqualTo(expectedRoot);
        assertThat(leftChild).isEqualTo(expectedChildLeft);
        assertThat(rightChild).isEqualTo(expectedChildRight);
        assertThat(grandchildFirst).isEqualTo(expectedGrandchildFirst);
        assertThat(grandchildSecond).isEqualTo(expectedGrandchildSecond);
        assertThat(grandchildThird).isEqualTo(expectedGrandchildThird);
        assertThat(gandchildFourth).isEqualTo(expectedGrandchildFourth);

        assertTrue(node.isBlack());
        assertTrue(node.getLeft().isBlack());
        assertTrue(node.getRight().isBlack());
        assertTrue(node.getLeft().getLeft().isBlack());
        assertTrue(node.getLeft().getRight().isBlack());
        assertTrue(node.getRight().getLeft().isBlack());
        assertTrue(node.getRight().getRight().isBlack());
    }

    @Test
    public void should_CorrectlyGetValueAndChangedColor_WhenPutAfterTheLetterStepEighth() {

        // given
        Character[] array = {'B', 'U', 'K', 'O', 'W', 'I', 'E', 'C'};
        for (int i = 0; i < 7; i++) {
            redBlackTree.put(array[i], array[i]);
        }

        // when
        redBlackTree.put(array[7], array[7]);
        Node<Character, Character> node = getRoot(redBlackTree);
        Character root = node.getValue();
        Character leftChild = node.getLeft().getValue();
        Character rightChild = node.getRight().getValue();
        Character grandchildFirst = node.getLeft().getLeft().getValue();
        Character grandchildSecond = node.getLeft().getRight().getValue();
        Character grandchildThird = node.getRight().getLeft().getValue();
        Character grandchildFourth = node.getRight().getRight().getValue();
        Character greatGrandchildFirst = node.getLeft().getLeft().getLeft().getValue();

        // then
        Character expectedRoot = 'K';
        Character expectedChildLeft = 'E';
        Character expectedChildRight = 'U';
        Character expectedGrandchildFirst = 'C';
        Character expectedGrandchildSecond = 'I';
        Character expectedGrandchildThird = 'O';
        Character expectedGrandchildFourth = 'W';
        Character expectedGreatGrandchildFirst = 'B';

        assertThat(root).isEqualTo(expectedRoot);
        assertThat(leftChild).isEqualTo(expectedChildLeft);
        assertThat(rightChild).isEqualTo(expectedChildRight);
        assertThat(grandchildFirst).isEqualTo(expectedGrandchildFirst);
        assertThat(grandchildSecond).isEqualTo(expectedGrandchildSecond);
        assertThat(grandchildThird).isEqualTo(expectedGrandchildThird);
        assertThat(grandchildFourth).isEqualTo(expectedGrandchildFourth);
        assertThat(greatGrandchildFirst).isEqualTo(expectedGreatGrandchildFirst);

        assertTrue(node.isBlack());
        assertTrue(node.getLeft().isBlack());
        assertTrue(node.getRight().isBlack());
        assertTrue(node.getLeft().getLeft().isBlack());
        assertTrue(node.getLeft().getRight().isBlack());
        assertTrue(node.getRight().getLeft().isBlack());
        assertTrue(node.getRight().getRight().isBlack());
        assertTrue(node.getLeft().getLeft().getLeft().isRed());
    }

    @Test
    public void should_CorrectlyRotatedAndChangedColors_WhenTreeHasEightNodesCaseFirst() {
        // given
        Character[] array = {'I', 'N', 'W', 'E', 'S', 'T', 'O', 'R'};
        for (int i = 0; i < 7; i++) {
            redBlackTree.put(array[i], array[i]);
        }

        // when
        redBlackTree.put(array[7], array[7]);

        // then
        Node<Character, Character> node =  getRoot(redBlackTree);

        Character root = node.getValue();
        Character leftGeatGrandchild = node.getLeft().getLeft().getLeft().getValue();
        Character rightChild = node.getRight().getValue();

        Character expectedRoot = 'R';
        Character expectedLeftGreatGrandchild = 'E';
        Character expectedRightChild = 'T';

        assertEquals(expectedRoot, root);
        assertEquals(expectedLeftGreatGrandchild, leftGeatGrandchild);
        assertEquals(expectedRightChild, rightChild);

        assertTrue(node.isBlack());
        assertTrue(node.getLeft().isBlack());
        assertTrue(node.getLeft().getLeft().getLeft().isRed());
        assertTrue(node.getRight().isBlack());
    }

    @Test
    public void should_CorrectlyRotatedAndChangedColors_WhenTreeHasEightNodesCaseSecond() {
        // given
        Character[] array = {'U', 'S', 'T', 'R', 'Z', 'Y', 'K', 'I'};
        for (int i = 0; i < 7; i++) {
            redBlackTree.put(array[i], array[i]);
        }

        // when
        redBlackTree.put(array[7], array[7]);

        // then
        Node<Character, Character> node = (Node<Character, Character>) getRoot(redBlackTree);

        Character root = node.getValue();
        Character leftGreatGrandchild = node.getLeft().getLeft().getLeft().getValue();
        Character rightGrandchild = node.getRight().getRight().getValue();

        Character expectedRoot = 'T';
        Character expectedLeftGreatGrandchild = 'I';
        Character expectedRightGrandchild = 'Z';

        assertEquals(expectedRoot, root);
        assertEquals(expectedLeftGreatGrandchild, leftGreatGrandchild);
        assertEquals(expectedRightGrandchild, rightGrandchild);

        assertTrue(node.isBlack());
        assertTrue(node.getLeft().getLeft().getLeft().isRed());
        assertTrue(node.getRight().getRight().isBlack());
    }


    @Test
    public void should_CorrectlyDeleteMaxNode_WhenPresentInTree() {
        // given
        RedBlackTree<Character, Integer> tree = new RedBlackTree<>();
        Character[] letters
                = {'A', 'B', 'C', 'D', 'E', 'F', 'G',
                'H', 'I', 'J', 'K', 'L', 'M', 'N'};
        for (int i = 0; i < letters.length; i++) {
            tree.put(letters[i], i);
        }

        // when
        tree.deleteMax();
        Integer actual = tree.get('O');

        // then
        Integer expected = null;
        assertEquals(expected, actual);
    }

    private Node<Character, Character> getRoot(RedBlackTree<Character, Character> rbt) {
        String fieldRoot = "root";

        try {
            Field field = rbt.getClass().getDeclaredField(fieldRoot);
            field.setAccessible(true);

            Node<Character, Character> node = (Node<Character, Character>) field.get(rbt);

            return node;

        } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}