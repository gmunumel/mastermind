package mastermind.tests;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import mastermind.models.Code;
import mastermind.models.Color;

public class CodeTest {

	private Code code;
	
	@Before
    public void before() {
        code = new Code("BBRV");
    }
	
	@Test
    public void testGetBlacksAndWhites() {
		Code kode = new Code("RBBB");
		HashMap<Color, Integer> result = 
				new HashMap<Color, Integer>();
		result.put(Color.BLANCO, 2);
		result.put(Color.NEGRO, 1);
        assertEquals(result, code.getBlacksAndWhites(kode)); 
    }
	
	@Test
    public void testGetBlacksAndWhitesNotMatch() {
		Code kode = new Code("AAAA");
		HashMap<Color, Integer> result = 
				new HashMap<Color, Integer>();
		result.put(Color.BLANCO, 0);
		result.put(Color.NEGRO, 0);
        assertEquals(result, code.getBlacksAndWhites(kode));
    }
	
	@Test
    public void testGetBlacksAndWhitesWinner() {
		Code kode = new Code("BBRV");
		HashMap<Color, Integer> result = 
				new HashMap<Color, Integer>();
		result.put(Color.BLANCO, 0);
		result.put(Color.NEGRO, 4);
        assertEquals(result, code.getBlacksAndWhites(kode));
    }
	
	@Test
    public void testGetBlacksAndWhitesWithOneWhite() {
		Code kode = new Code("AABN");
		HashMap<Color, Integer> result = 
				new HashMap<Color, Integer>();
		result.put(Color.BLANCO, 1);
		result.put(Color.NEGRO, 0);
        assertEquals(result, code.getBlacksAndWhites(kode));
    }
	
	@Test
    public void testGetBlacksAndWhitesWithTwoWhites() {
		Code kode = new Code("NNBB");
		HashMap<Color, Integer> result = 
				new HashMap<Color, Integer>();
		result.put(Color.BLANCO, 2);
		result.put(Color.NEGRO, 0);
        assertEquals(result, code.getBlacksAndWhites(kode));
    } 
	
	@Test
    public void testGetBlacksAndWhitesWithThreeWhites() {
		Code kode = new Code("VRBN");
		HashMap<Color, Integer> result = 
				new HashMap<Color, Integer>();
		result.put(Color.BLANCO, 3);
		result.put(Color.NEGRO, 0);
        assertEquals(result, code.getBlacksAndWhites(kode));
    }
}
