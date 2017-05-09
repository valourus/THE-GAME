/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.jme3.math.Vector3f;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author valouru
 */
//@RunWith(Suite.class)
//@Suite.SuiteClasses({})
public class NewTestSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void test()
    {
        float x = 999;
        Vector3f viewDirection = new Vector3f(0,0,-1);
        Vector3f direction = new Vector3f(0,0,-1);
        if(!direction.equals(Vector3f.ZERO))
            x = viewDirection.angleBetween(direction);
        System.out.println(x);
        assertEquals(0.0, x, 0);
    }
}
