package Project;


public class RedCode {

	private RedCodeStrategy strategy;
	public void setRedCodeStrategy(RedCodeStrategy method)
	{
		this.strategy = method;
	}
	
	public void solutionSelected(String text)
	{
		strategy.deviationMethod(text);
	}
	
}
	
	

