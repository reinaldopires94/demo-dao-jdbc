package db;

public class DbExceptoion extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public DbExceptoion(String msg) {
		super(msg);
	}
}