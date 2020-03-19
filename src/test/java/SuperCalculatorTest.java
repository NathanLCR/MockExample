import static org.junit.jupiter.api.Assertions.*;

import org.easymock.EasyMock;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SuperCalculatorTest {
	@Mock
	private CalculatorDrive mock;	
	
	@TestSubject
	private SuperCalculator superCalculator;

	@BeforeEach
	public void setUp() {		
		mock = EasyMock.createMock(CalculatorDrive.class);  //01
		
		superCalculator = new SuperCalculator(mock); //02
		
	}
	
	@Test
	public void addAndDoubleTest1() {
		EasyMock.expect(mock.add(10, 20)).andReturn(30); //03
		EasyMock.replay(mock); //04
		int result = superCalculator.addAndDouble(10,20);
		assertEquals(60, result); //05
		EasyMock.verify(mock); //06
	}	
	@Test
	public void addAndDoubleTest2() {
		EasyMock.expect(mock.add(20, 10)).andReturn(30); //03
		EasyMock.replay(mock); //04
		
		int result = superCalculator.addAndDouble(10,20);
		assertEquals(60, result); //05
		EasyMock.verify(mock); //06
	}
	/*
	 * O teste acima vai falhar porque o mock espera que a função
	 * add de CalculatorDrive seja chamada com o parâmetros (20,10)
	 * em vez disso ela é chamada com os parâmetros (10,20)
	 * 
	 * */
	
	@Test
	public void addAndDoubleTest3() {
		EasyMock.expect(mock.add(10, 20)).andReturn(30); //03
		EasyMock.expect(mock.multiply(10, 20)).andReturn(30); //03
		EasyMock.replay(mock); //04
		int result = superCalculator.addAndDouble(10,20); 
		assertEquals(60, result); //05
		EasyMock.verify(mock); //06
	}
	/*
	 * O teste acima vai falhar porque o mock espera que a função
	 * multiply seja chamada, porém ela não é
	 * 
	 * */	
	
	@Test
	public void addAndDoubleTest4() {
		EasyMock.expect(mock.add(10, 20)).andReturn(30).times(2); //03
		EasyMock.replay(mock); //04
		int result = superCalculator.addAndDouble(10,20);
		assertEquals(60, result); //05
		EasyMock.verify(mock); //06
	}
	/*
	 * O teste acima vai falhar pois é esperado que a função add
	 * seja chamada duas vezes, porem ela não é
	 * 
	 * */
	
	@Test
	public void addAndMultiplyTest() {				
		EasyMock.expect(mock.add(10, 10)).andReturn(20); //03
		EasyMock.expect(mock.multiply(20, 10)).andReturn(200); //03		
		EasyMock.replay(mock); //04		
		int result = superCalculator.addAndMultiply(10, 10);
		assertEquals(200,result); //05
		EasyMock.verify(mock); //06
	}
	
	@Test
	public void divisionByZeroTest() throws DivisionByZeroException{
		EasyMock.expect(mock.division(10, 0)).andThrow(new DivisionByZeroException()); //03		
		EasyMock.replay(mock); //04
		
		Assertions.assertThrows(DivisionByZeroException.class, ()->{
			superCalculator.division(10, 0);
		}); //05
		EasyMock.verify(mock); //06
	}
}





