package pl.gromada;

import java.util.ArrayList;
import java.util.List;

public class User {

	private String name;
	private List<Integer> userCells;

	public User(String name) {
		super();
		this.name = name;
		this.userCells = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Integer> getUserCells() {
		return userCells;
	}

	public void addCell(int x, int y) {
		int index = 0;
		if (x == 0) {
			index = x + y;
		} else if (x == 1) {
			index = x + y + 2;
		} else {
			index = x + y + 4;
		}
		this.userCells.add(index);
	}
}
