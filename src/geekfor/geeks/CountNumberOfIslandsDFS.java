package geekfor.geeks;

import com.util.PrintUtil;

/**
 * Given a boolean 2D matrix, find the number of islands. A group of connected
 * 1s forms an island
 * {@link http://www.geeksforgeeks.org/find-number-of-islands/}
 */
public class CountNumberOfIslandsDFS {

	public static void main(String[] args) {
		int[][] island = new int[][] { { 1, 0, 0, 0, 1 }, { 0, 1, 0, 0, 1 }, { 0, 0, 1, 0, 0 }, { 1, 0, 0, 1, 0 },
				{ 1, 0, 0, 0, 1 } };
		PrintUtil.pritn2DMatrix(island);

		System.out.println(countIsland(island));

	}

	private static int countIsland(int[][] island) {
		boolean[][] visited = new boolean[island.length][island[0].length];
		int count = 0;
		for (int row = 0; row < island.length; row++) {
			for (int col = 0; col < island.length; col++) {
				if (island[row][col] == 1 && !visited[row][col]) {
					traverse(island, row, col, visited);
					count++;
				}
			}
		}
		return count;
	}

	private static void traverse(int[][] island, int row, int col, boolean[][] visited) {
		final int[] rowDef = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
		final int[] colDef = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };
		visited[row][col] = true;
		for (int i = 0; i < 8; i++) {
			if (shouldBeCounted(island, (row + rowDef[i]), (col + colDef[i]), visited)) {
				traverse(island, (row + rowDef[i]), (col + colDef[i]), visited);
			}

		}

	}

	private static boolean shouldBeCounted(int[][] island, int row, int col, boolean[][] visited) {
		return row >= 0 && row < island.length && col >= 0 && col < island[0].length
				&& (!visited[row][col] && island[row][col] == 1);
	}

}
