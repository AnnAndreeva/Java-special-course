package FirstPackage;
public class SecondClass {
	private int arg1, arg2;

	public SecondClass () {}
	public SecondClass (int arg1, int arg2) {
       		this.arg1 = arg1;
       		this.arg2 = arg2;
  	}

	public int getArg1() {
      		return arg1;
 	}

 	public void setArg1(int arg1) {
      	 	this.arg1 = arg1;
 	}

	public int getArg2() {
      	 	return arg2;
 	}
 	public void setArg2(int arg2) {
      	 	this.arg2 = arg2;
 	}

	public int sumArg(){
		int res;
		res = this.arg1+this.arg2;
		return res;
	}
}