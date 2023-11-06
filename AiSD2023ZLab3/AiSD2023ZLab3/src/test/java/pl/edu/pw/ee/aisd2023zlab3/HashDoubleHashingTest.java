package pl.edu.pw.ee.aisd2023zlab3;

import org.junit.Test;

import pl.edu.pw.ee.aisd2023zlab3.services.HashTable;
import pl.edu.pw.ee.aisd2023zlab3.utils.AdvancedGetters;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static pl.edu.pw.ee.aisd2023zlab3.utils.AdvancedGetters.getNumOfElems;

public class HashDoubleHashingTest {

    @Test(expected = IllegalArgumentException.class)
    public void should_ThrowException_When_InitailSizeIsEqualToThree() {
        // given
        int initialSize = 1;

        // when
        HashTable<Double> hash = new HashDoubleHashing<>(initialSize);

        // then
        assert false;
    }

    @Test
    public void should_CorrectlyAddNewElems_WhenNotExistInHashTable() {
        // given
        HashTable<String> unusedNames = new HashDoubleHashing<>();
        String newEleme = "P. Czarnek";

        // when
        int nOfElemsBeforePut = getNumOfElems(unusedNames);
        unusedNames.put(newEleme);
        int nOfElemsAfterPut = getNumOfElems(unusedNames);

        // then
        assertThat(nOfElemsBeforePut).isEqualTo(0);
        assertThat(nOfElemsAfterPut).isEqualTo(1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_ThrowException_WhenAddingNullElement() {
        // given
        HashTable<String> hashTable = new HashDoubleHashing<>();


        // when
        hashTable.put(null);

        // then
        assert false;
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_ThrowException_WhenTryGetNullElementFromTwentyElements() {
        // given
        HashTable<Double> hashTable = new HashDoubleHashing<>();
        for (int i = 0; i < 20; i++)
            hashTable.put(i + 1.5);
        // when

        hashTable.get(null);

        // then
        assert false;
    }

    @Test(expected = IllegalStateException.class)
    public void should_ThrowException_WhenTryGetOneElementFromEmptyHashTable() {
        // given
        HashTable<String> hash = new HashDoubleHashing<>();
        String element = "Wroclaw";

        // when
        hash.get(element);

        // then
        assert false;
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_ThrowException_WhenTryGetOneElementThatDontExistInHashTable() {
        // given
        HashTable<String> hash = new HashDoubleHashing<>();
        String elementInHash = "Monika";
        String elementTryToGet = "Wojtek";
        hash.put(elementInHash);

        // when
        hash.get(elementTryToGet);

        // then
        assert false;
    }

    @Test(expected = IllegalStateException.class)
    public void should_ThrowException_WhenTryDeleteElementDontExist() {
        // given
        HashTable<String> hash = new HashDoubleHashing<>(3);
        String element = "Warszawa";

        // when
        hash.delete(element);

        // then
        assert false;
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_ThrowException_WhenTryToDeleteOneElementThatDontExistInHashTable() {
        // given
        HashTable<String> hash = new HashDoubleHashing<>(3);
        String elementInHashTable = "Warszawa";
        String elementTryDelete = "Krakow";
        hash.put(elementInHashTable);

        // when
        hash.delete(elementTryDelete);

        // then
        assert false;
    }

    @Test(expected = IllegalStateException.class)
    public void should_ThrowException_WhenTrySecondDeleteTheSameElement() {
        // given
        HashTable<String> hash = new HashDoubleHashing<>(3);
        String element = "Warszawa";
        hash.put(element);

        // when
        hash.delete(element);
        hash.delete(element);

        // then
        assert false;
    }

    @Test
    public void should_CorrectlyNumsOfNumber_WhenAddTwoElements() {
        // given
        HashTable<String> hashTable = new HashDoubleHashing<>(2);
        String firstElement = "Monika";
        String secondElement = "Wojtek";

        // when
        hashTable.put(firstElement);
        int numOfElemsAfterFirstAdd = getNumOfElems(hashTable);
        hashTable.put(secondElement);
        int numOfElemsAfterSecondAdd = getNumOfElems(hashTable);

        // then
        int expectedAfterFirstAdd = 1;
        int expectedAfterSecondAdd = 2;

        assertThat(numOfElemsAfterFirstAdd).isEqualTo(expectedAfterFirstAdd);
        assertThat(numOfElemsAfterSecondAdd).isEqualTo(expectedAfterSecondAdd);
    }

    @Test
    public void should_CorrectlyNumsOfNumber_WhenAddThreeElements() {
        // given
        HashTable<String> hashTable = new HashDoubleHashing<>(2);
        String firstElement = "Monika";
        String secondElement = "Wojtek";
        String thirdElement = "Andrzej";

        // when
        hashTable.put(firstElement);
        int numOfElemsAfterFirstAdd = getNumOfElems(hashTable);
        hashTable.put(secondElement);
        int numOfElemsAfterSecondAdd = getNumOfElems(hashTable);
        hashTable.put(thirdElement);
        int numOfElemsAfterThirdAdd = getNumOfElems(hashTable);

        // then
        int expectedAfterFirstAdd = 1;
        int expectedAfterSecondAdd = 2;
        int expectedAfterThirdAdd = 3;
        assertThat(numOfElemsAfterFirstAdd).isEqualTo(expectedAfterFirstAdd);
        assertThat(numOfElemsAfterSecondAdd).isEqualTo(expectedAfterSecondAdd);
        assertThat(numOfElemsAfterThirdAdd).isEqualTo(expectedAfterThirdAdd);
    }

    @Test
    public void should_CorrectlyNumsOfNumber_WhenAddTwentyElements() {
        // given
        HashTable<Double> hashTable = new HashDoubleHashing<>(2);

        // when
        for (int i = 0; i < 20; i++)
            hashTable.put(i + 1.5);
        int numOfElems = getNumOfElems(hashTable);

        // then
        int expected = 20;
        assertThat(numOfElems).isEqualTo(expected);
    }


    @Test
    public void should_CorrectlyNumOfElems_WhenWantAddTheSameElement() {
        // given
        HashTable<String> hashTable = new HashDoubleHashing<>();
        String firstElement = "Krakow";
        String secondElement = "Krakow";
        String thirdElement = "Wroclaw";
        hashTable.put(firstElement);
        hashTable.put(thirdElement);
        // when
        int beforeAddNumOfElems = AdvancedGetters.getNumOfElems(hashTable);
        hashTable.put(secondElement);
        int afterAddNumOfElems = AdvancedGetters.getNumOfElems(hashTable);

        // then
        assertThat(beforeAddNumOfElems).isEqualTo(2);
        assertThat(afterAddNumOfElems).isEqualTo(2);
    }

    @Test
    public void should_CorrectlyGetElement_WhenOneElementExist() {
        // given
        HashTable<String> hashTable = new HashDoubleHashing<>();
        String element = "Warszawa";
        hashTable.put(element);

        // when
        String result = hashTable.get(element);

        // then
        String expected = element;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void should_CorrectlyGetFirstElement_WhenTwoElementsExist() {
        // given
        HashTable<String> hashTable = new HashDoubleHashing<>();
        String firstElement = "Warszawa";
        String secondElement = "Krakow";
        hashTable.put(firstElement);
        hashTable.put(secondElement);

        // when
        String result = hashTable.get(firstElement);

        // then
        String expected = firstElement;
        assertThat(result).isEqualTo(expected);
    }


    @Test
    public void should_CorrectlyGetSecondElement_WhenTwoElementsExist() {
        // given
        HashTable<String> hashTable = new HashDoubleHashing<>();
        String firstElement = "Warszawa";
        String secondElement = "Krakow";
        hashTable.put(firstElement);
        hashTable.put(secondElement);

        // when
        String result = hashTable.get(secondElement);

        // then
        String expected = secondElement;
        assertThat(result).isEqualTo(expected);
    }


    @Test
    public void should_CorrectlyGetFirstElement_WhenHaveThreeElements() {
        // given
        HashTable<String> hashTable = new HashDoubleHashing<>();
        String[] elements = {"Wetlina", "Bukowiec", "Bieszczady"};
        hashTable.put(elements[0]);
        hashTable.put(elements[1]);
        hashTable.put(elements[2]);

        // when
        String result = hashTable.get("Wetlina");

        // then
        String expected = elements[0];
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void should_CorrectlyGetMiddleElement_WhenHaveTreeElements() {
        // given
        HashTable<String> hashTable = new HashDoubleHashing<>();
        String[] elements = {"Wetlina", "Bukowiec", "Bieszczady"};
        hashTable.put(elements[0]);
        hashTable.put(elements[1]);
        hashTable.put(elements[2]);

        // when
        String result = hashTable.get("Bukowiec");

        // then
        String expected = elements[1];
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void should_CorrectlyGetLastElement_WhenHaveThreeElements() {
        // given
        HashTable<String> hashTable = new HashDoubleHashing<>();
        String[] elements = {"Wetlina", "Bukowiec", "Bieszczady"};
        hashTable.put(elements[0]);
        hashTable.put(elements[1]);
        hashTable.put(elements[2]);

        // when
        String result = hashTable.get("Bieszczady");

        // then
        String expected = elements[2];
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void should_CorrectlyGotElements_WhenSixElementsInHashTable() {
        // given
        HashTable<Double> hashTable = new HashDoubleHashing<>(2);
        Double[] getElements = new Double[6];
        Double[] elements = {3.6, 5.7, 8.9, 23.6, 54.1, 324.4};

        for (int i = 0; i < 6; i++)
            hashTable.put(elements[i]);

        // when
        for (int i = 0; i < 6; i++) {
            getElements[i] = hashTable.get(elements[i]);
        }

        // then
        assertArrayEquals(elements, getElements);
    }

    @Test
    public void should_CorrectlyNumberOfElements_WhenDeleteElementInHashTable() {
        // given
        HashTable<String> hashTable = new HashDoubleHashing<>(3);
        String element = "Warszawa";
        hashTable.put(element);

        // when
        int beforeDeleteNumOfElems = getNumOfElems(hashTable);
        hashTable.delete(element);
        int afterDeleteNumOfElems = getNumOfElems(hashTable);

        // then
        assertThat(beforeDeleteNumOfElems).isEqualTo(1);
        assertThat(afterDeleteNumOfElems).isEqualTo(0);
    }


    @Test
    public void should_CorrectlyNumberOfElements_WhenOneElemWasDeleted() {
        // given
        HashTable<String> hashTable = new HashDoubleHashing<>(2);
        String elementToDelete = "Warszawa";
        String elementOneConst = "Krakow";
        String elementSecondConst = "Wroclaw";
        hashTable.put(elementOneConst);
        hashTable.put(elementSecondConst);
        hashTable.put(elementToDelete);

        // when
        int beforeDeleteNumOfElems = getNumOfElems(hashTable);
        hashTable.delete(elementToDelete);
        int afterDeleteNumOfElems = getNumOfElems(hashTable);

        // then
        assertThat(beforeDeleteNumOfElems).isEqualTo(3);
        assertThat(afterDeleteNumOfElems).isEqualTo(2);
    }

    @Test
    public void should_CorrectlyAddAndDeleteAndAddTheSameElement_WhenExistOneElementInHashTable() {
        // given
        HashTable<String> hashTable = new HashDoubleHashing<>(3);
        String element = "Warszawa";
        hashTable.put(element);

        // when
        int beforeDeleteNumOfElems = getNumOfElems(hashTable);
        hashTable.delete(element);
        int afterDeleteNumOfElems = getNumOfElems(hashTable);
        hashTable.put(element);
        int afterReAddNumOfElemes = getNumOfElems(hashTable);

        // then
        assertThat(beforeDeleteNumOfElems).isEqualTo(1);
        assertThat(afterDeleteNumOfElems).isEqualTo(0);
        assertThat(afterReAddNumOfElemes).isEqualTo(1);
    }

    @Test
    public void should_CorrectlyNumbersOfElementsAfterDeleteFirstElement_WhenTwoElementExistInHashTable() {
        // given
        HashTable<String> hashTable = new HashDoubleHashing<>(3);
        String firstElement = "Warszawa";
        String secondElement = "Krakow";
        hashTable.put(firstElement);
        hashTable.put(secondElement);

        // when
        int beforeDeleteNumbersOfElements = getNumOfElems(hashTable);
        hashTable.delete(firstElement);
        int afterDeleteNumbersOfElements = getNumOfElems(hashTable);

        // then
        assertThat(beforeDeleteNumbersOfElements).isEqualTo(2);
        assertThat(afterDeleteNumbersOfElements).isEqualTo(1);
    }

    @Test
    public void should_CorrectlyNumbersOfElementsAfterDeleteSecondElement_WhenTwoElementExistInHashTable() {
        // given
        HashTable<String> hashTable = new HashDoubleHashing<>(3);
        String firstElement = "Warszawa";
        String secondElement = "Krakow";
        hashTable.put(firstElement);
        hashTable.put(secondElement);

        // when
        int beforeDeleteNumbersOfElements = getNumOfElems(hashTable);
        hashTable.delete(secondElement);
        int afterDeleteNumbersOfElements = getNumOfElems(hashTable);

        // then
        assertThat(beforeDeleteNumbersOfElements).isEqualTo(2);
        assertThat(afterDeleteNumbersOfElements).isEqualTo(1);
    }

    @Test
    public void should_CorrectlyNumbersOfElementsAfterDeleteFirstElement_WhenThreeElementExistInHashTable() {
        // given
        HashTable<String> hashTable = new HashDoubleHashing<>();
        String[] elements = {"Wetlina", "Bukowiec", "Bieszczady"};
        hashTable.put(elements[0]);
        hashTable.put(elements[1]);
        hashTable.put(elements[2]);

        // when
        int beforeDeleteNumbersOfElements = getNumOfElems(hashTable);
        hashTable.delete(elements[0]);
        int afterDeleteNumbersOfElements = getNumOfElems(hashTable);

        // then
        assertThat(beforeDeleteNumbersOfElements).isEqualTo(3);
        assertThat(afterDeleteNumbersOfElements).isEqualTo(2);
    }

    @Test
    public void should_CorrectlyNumbersOfElementsAfterDeleteMiddleElement_WhenThreeElementExistInHashTable() {
        // given
        HashTable<String> hashTable = new HashDoubleHashing<>();
        String[] elements = {"Wetlina", "Bukowiec", "Bieszczady"};
        hashTable.put(elements[0]);
        hashTable.put(elements[1]);
        hashTable.put(elements[2]);

        // when
        int beforeDeleteNumbersOfElements = getNumOfElems(hashTable);
        hashTable.delete(elements[1]);
        int afterDeleteNumbersOfElements = getNumOfElems(hashTable);

        // then
        assertThat(beforeDeleteNumbersOfElements).isEqualTo(3);
        assertThat(afterDeleteNumbersOfElements).isEqualTo(2);
    }

    @Test
    public void should_CorrectlyNumbersOfElementsAfterDeleteLastElement_WhenThreeElementExistInHashTable() {
        // given
        HashTable<String> hashTable = new HashDoubleHashing<>();
        String[] elements = {"Wetlina", "Bukowiec", "Bieszczady"};
        hashTable.put(elements[0]);
        hashTable.put(elements[1]);
        hashTable.put(elements[2]);

        // when
        int beforeDeleteNumbersOfElements = getNumOfElems(hashTable);
        hashTable.delete(elements[2]);
        int afterDeleteNumbersOfElements = getNumOfElems(hashTable);

        // then
        assertThat(beforeDeleteNumbersOfElements).isEqualTo(3);
        assertThat(afterDeleteNumbersOfElements).isEqualTo(2);
    }

}