package test;

public class Execution extends Deno
{
	public void beta()
	{
		System.out.println("Abstract method beta");
	}
	public static void main(String[] args)
	{
	   Execution e = new Execution();
		e.alpha();
		e.beta();
	}
}
