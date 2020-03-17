public class SuperCalculator {
	private CalculatorDrive calculatorDrive;
	
	public SuperCalculator(CalculatorDrive calculatorDrive) {
		this.calculatorDrive = calculatorDrive;
	}
	
	public int addAndDouble(int x,int y) {
		int result = this.calculatorDrive.add(x, y);
		
		return result*2;
	}
	
	public int addAndMultiply(int x,int y) {
		int result = this.calculatorDrive.add(x, y);
		result = this.calculatorDrive.multiply(result, y);		
		
		return result;
	}
	
	public int division(int x,int y) throws DivisionByZero {
		int result;
		try {
			result = this.calculatorDrive.division(x, y);
		}catch (DivisionByZero e) {
			throw new DivisionByZero();
		}
		
		return result;
	}
}





