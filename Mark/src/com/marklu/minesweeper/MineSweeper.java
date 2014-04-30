package com.marklu.minesweeper;

import java.io.IOException;

public class MineSweeper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MineSweeperMap a = new MineSweeperMap(5, 5, 5);
		System.out.println(a.toString());
		while (true )
		{
			try {
				System.out.println(System.in.read());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
