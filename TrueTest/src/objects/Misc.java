package objects;

public class Misc extends Item {
	private String name;
	public Misc(String n, String d, String sN, int val, int wt, int rar, int iT) {
		super(d, sN, val, wt, rar, iT);
		name = n;
	}

	public Misc() {
		name = "trash";
	}

	public Misc(int iT, int rar) {
		super(iT, rar);
		name = Formula.miscName();
	}

	public Misc(int iT, int rar, int a, int b) {
		super(iT, rar, a, b);
		name = Formula.miscName();
	}

	public Misc(int rar, int mat, boolean metal) {
		super(rar, mat, metal);
		name = Formula.miscName();
	}
	
	public String getName() {
		return name;
	}

}
