package mx.tec.lab;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;

public class palindromeVerifierTest {

	
	@Test 
	public void givenAString_WhenVerify_ThenTrue() {
		//Given
		String input = "a";
		boolean expected = true;
		//When
		boolean actual = palindromeVerifier.verify(input);
		//Then
		assertEquals(expected,actual);
		
	}
	@Test 
	public void givenTwoDifferentCharacters_WhenVerify_ThenFalse() {
		//Given
		String input = "ab";
		boolean expected = false;
		//When
		boolean actual = palindromeVerifier.verify(input);
		//Then
		assertEquals(expected,actual);
		
	}
	@Test 
	public void givenTwoEqualsCharacters_WhenVerify_ThenTrue() {
		//Given
		String input = "aa";
		boolean expected = true;
		//When
		boolean actual = palindromeVerifier.verify(input);
		//Then
		assertEquals(expected,actual);
		
	}
	@Test 
	public void givenThreeLetterWordPalindrome_WhenVerify_ThenTrue() {
		//Given
		String input = "aba";
		boolean expected = true;
		//When
		boolean actual = palindromeVerifier.verify(input);
		//Then
		assertEquals(expected,actual);	
	}
	@Test 
	public void givenFourLetterWordPalindrome_WhenVerify_ThenTrue() {
		//Given
		String input = "abba";
		boolean expected = true;
		//When
		boolean actual = palindromeVerifier.verify(input);
		//Then
		assertEquals(expected,actual);	
	}
	@Test 
	public void givenASentencePalindrome_WhenVerify_ThenTrue() {
		//Given
		String input = "abba";
		boolean expected = true;
		//When
		boolean actual = palindromeVerifier.verify(input);
		//Then
		assertEquals(expected,actual);	
	}
}
