package com.marklu.minesweeper;

import java.util.Random;

public class MineSweeperMap {
	public int sizex;
	public int sizey;
	public int mines;

	public Mine[][] map;

	public boolean addMine(int x, int y) {

		if (map[x][y].state == State.EMPTY) {
			map[x][y].state = State.MINE;
			mines++;
			return true;
		}
		return false;
	}

	public MineSweeperMap(int x, int y, int mines) {
		if (x < 0 || y < 0 || mines < 0 || mines > x * y)
			throw new IllegalArgumentException("");
		sizex = x;
		sizey = y;

		map = new Mine[x][y];
		for (int i = 0; i < x; i++) 
			for (int j = 0; j < y; j++)
				map[i][j] = new Mine(i, j);
				
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				
				map[i][j].state = State.EMPTY;
				map[i][j].status = Status.COVERED;

				if (i - 1 >= 0 && j - 1 >= 0) {
					map[i][j].adj[Position.NE] = map[i - 1][j - 1];
				}
				if (j - 1 >= 0) {
					map[i][j].adj[Position.N] = map[i][j - 1];

				}
				if (i + 1 < x && j - 1 >= 0) {
					map[i][j].adj[Position.NW] = map[i + 1][j - 1];

				}
				if (i - 1 >= 0) {
					map[i][j].adj[Position.E] = map[i - 1][j];

				}
				if (i + 1 < x) {
					map[i][j].adj[Position.W] = map[i + 1][j];

				}
				if (i - 1 >= 0 && j + 1 < y) {
					map[i][j].adj[Position.SE] = map[i - 1][j + 1];
				}
				if (j + 1 < y) {
					map[i][j].adj[Position.S] = map[i][j + 1];

				}
				if (i + 1 < x && j + 1 < y) {
					map[i][j].adj[Position.SW] = map[i + 1][j + 1];

				}
			}
		}
		Random r = new Random(System.currentTimeMillis());
		while (this.mines < mines)
			addMine(r.nextInt(x),r.nextInt(y)); 

	}

	static class Mine {
		public int x, y;
		public Mine[] adj;
		public State state;
		public Status status;
		public int num;

		public Mine(int x, int y) {
			adj = new Mine[8];
			this.x = x;
			this.y = y;
		}
	}
}
