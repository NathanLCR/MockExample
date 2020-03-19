import static org.junit.jupiter.api.Assertions.*;

import org.easymock.EasyMock;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*
 * Testes feitos com strict mock
 * O diferencial do strict mock, é que ele além de verificar os comportamentos,
 * também verifica a ordem de chamadas dos métodos e comportamentos. * 
 * */

class SuperCalculatorTestWithStricMock {
	@Mock
	private CalculatorDrive mock;	
	
	@TestSubject
	private SuperCalculator superCalculator;

	@BeforeEach
	public void setUp() {		
		mock = EasyMock.createStrictMock(CalculatorDrive.class); //01
		
		superCalculator = new SuperCalculator(mock); //02
		
	}
	
	@Test
	void addAndMultiplyTest1() {	
		EasyMock.expect(mock.add(10, 10)).andReturn(20); //03
		EasyMock.expect(mock.multiply(20, 10)).andReturn(200); //03						
		EasyMock.replay(mock); //04		
		int result = superCalculator.addAndMultiply(10, 10);
		assertEquals(200,result); //05
		EasyMock.verify(mock); //06
	}
	
	@Test
	void addAndMultiplyTest2() {	
		EasyMock.expect(mock.multiply(20, 10)).andReturn(200); //03	
		EasyMock.expect(mock.add(10, 10)).andReturn(20); //03						
		EasyMock.replay(mock); //04		
		int result = superCalculator.addAndMultiply(10, 10);
		assertEquals(200,result); //05
		EasyMock.verify(mock); //06
	}
	/*
	 * O teste acima, vai falhar apenas porque ele espera que seja chamado o método
	 * multiply e depois o add, mas no método multiply, da classe SuperCalculator,
	 * o método add é chamado primeiro, e só depois o multiply.
	 * */
}





