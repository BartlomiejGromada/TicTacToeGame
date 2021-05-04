package pl.gromada;

public class Cell {
	
	private int x;
	private int y;
	private boolean clicked;
	
	public Cell() {}
	
	public Cell(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		this.clicked = false;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isClicked() {
		return clicked;
	}

	public void setClicked(boolean clicked) {
		this.clicked = clicked;
	}
}
