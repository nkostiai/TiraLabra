/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sorters;

import java.util.Arrays;
import static junit.framework.Assert.assertTrue;
import junit.framework.TestCase;

/**
 *
 * @author Admin
 */
public class SmoothSorterTest extends TestCase {

    private SmoothSorter sorterToTest;
    private CommonMethods cmethods;

    public SmoothSorterTest(String testName) {
        super(testName);
        cmethods = new CommonMethods();
        sorterToTest = new SmoothSorter();
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testSmoothSort() {
        for (int i = 0; i < 10; i++) {
            int[] arrayToSort = cmethods.giveRandomArray();
            int[] sortedArray = arrayToSort.clone();
            Arrays.sort(sortedArray);
            sorterToTest.smoothSort(arrayToSort);
            assertTrue(Arrays.equals(arrayToSort, sortedArray));
        }
    }
    
    public void testLeonardoNumberGenerator(){
        int[] leonardo = sorterToTest.formLeonardoSequence();
        assertTrue(Arrays.equals(new int[]{1,1,3,5,9}, Arrays.copyOfRange(leonardo, 0, 5)));
    }
    
    public void testCountOrderLength(){
        assertEquals(8, sorterToTest.countOrderLength(27));
        assertEquals(18, sorterToTest.countOrderLength(1000));
    }

}