/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package pl.edu.pw.ee.aisd_lab_0;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author userl
 */
public class BSearchTest {
    
    @Before
    public void setUp(){
        BSearch = new BSearch();
    }
    
    
    @Test
    public void shouldReturnCorrectWhenSearchSmallThenFirst(){
        //given
        
        int[] nums = {1,2,3,4,5};
        int toFind = 0;
        
        
        
        //when
        int result = BSearch.search(nums,toFind);
        
        
        
        //then
        
        
    }
    
}
