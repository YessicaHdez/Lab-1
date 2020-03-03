package mx.tec.lab;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.boot.test.context.SpringBootTest;

@ExtendWith(MockitoExtension.class)

@SpringBootTest
class UsingMocksApplicationTests {
	@Mock
	List<String> swordsList;
	
	@Mock
	Map<String, String> translationMap;
	
	@InjectMocks
	DothrakiTranslator translator = new DothrakiTranslator();

	@Captor
	ArgumentCaptor<String> swordName;

	@Spy
	List<String> theWallCastlesList = new ArrayList<String>();

	@Mock
	List<String> direwolvesList;

	@Test
	public void whenUseMockAnnotation_thenMockIsInjected() {
	    direwolvesList.add("drogon");
	    verify(direwolvesList).add(anyString());
	    assertEquals(0, direwolvesList.size());
	 
	    when(direwolvesList.size()).thenReturn(100);
	    assertEquals(100, direwolvesList.size());
	}
	
	@Test
	public void whenUseSpyAnnotation_thenSpyIsInjected() {
	    theWallCastlesList.add("Castle Black");
	    theWallCastlesList.add("Eastwatch");
	 
	    verify(theWallCastlesList).add("Castle Black");
	    verify(theWallCastlesList).add("Eastwatch");
	 
	    assertEquals(2, theWallCastlesList.size());
	 
	    doReturn(100).when(theWallCastlesList).size();
	    assertEquals(100, theWallCastlesList.size());
	}
	
	@Test
	public void whenUseCaptorAnnotation_thenTheSame() {
		swordsList.add("needle");
	    verify(swordsList).add(swordName.capture());
	 
	    assertEquals("needle", swordName.getValue());
	}
	
	@Test
	public void whenUseInjectMocksAnnotation_thenCorrect() {
	    when(translationMap.get("khaleesi")).thenReturn("queen");
	 
	    assertEquals("queen", translator.getTranslation("khaleesi"));
	}
	
}
