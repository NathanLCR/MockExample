
public interface CalculatorDrive {

	public int add(int x, int y);
	
	public int sub(int x,int y);
	
	public int multiply(int x, int y);
	
	public int division(int x,int y) throws DivisionByZeroException;
}
