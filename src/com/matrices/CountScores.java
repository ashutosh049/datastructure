package com.matrices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountScores {

	public static void main(String[] args) {
		int[] subjectArray = new int[] { 1, 2, 3};
		int[] gradesArray = new int[] { 10, 9, 8, 7, 6, 5 };
		
		int[][] scoreMatrix = getScoreMatrix(subjectArray, gradesArray);
		print(scoreMatrix);
		List<Integer> baseScoreList = new ArrayList<Integer>();
		baseScoreList.add(10);
		baseScoreList.add(9);
		baseScoreList.add(8);
		baseScoreList.add(7);
		baseScoreList.add(6);
		baseScoreList.add(5);
		countScores(scoreMatrix, baseScoreList, 1);
	}

	/**
	 * @param subjectArray
	 * @param gradesArray
	 * @return
	 */
	private static int[][] getScoreMatrix(int[] subjectArray, int[] gradesArray) {
		int[][] scorematrix =new int[subjectArray.length][gradesArray.length];
		
		for (int i = 0; i < subjectArray.length; i++) {
			for (int j = 0; j < gradesArray.length; j++) {
				scorematrix[i][j] = subjectArray[i]*gradesArray[j];
			}
		}
		
		 /*
 
		┌───┐ ┌───┐ 
		|10 | | 1 | 
		├───┼ ├───┼ 
		| 9 | | 2 | 
		├───┼ ├───┼ 
		| 8 | | 3 | 
		├───┼ └───┴ 
		| 7 | 
		├───┼ 
		| 6 | 
		├───┼ 
		| 5 | 
		└───┴  

		 */
		/*
		┌────────────────────────────┐
		|10 | 9  |  8 | 7  | 6  | 5  |
		├───┼────┼────┼────┼────┼────|
		|20 | 18 | 16 | 14 | 12 | 10 |
		├───┼────┼────┼────┼────┼────|
		|30 | 27 | 24 | 21 | 18 | 15 |
		└───┴────┴────┴────┴────┴────
		 */
		return scorematrix;
	}

	private static int countScores(int[][] scoreMatrix, List<Integer> baseScoreList, int rLvl) {
		System.out.println("-----------rLvl : "+rLvl+" -------------------");
		List<Integer> tempScoresList = new ArrayList<Integer>();
		
		for (int base : baseScoreList) {
			for (int j = 0; j < 6; j++) {
				int tempScore = base + scoreMatrix[rLvl][j];
				if (!tempScoresList.contains(tempScore)) {
					tempScoresList.add(tempScore);
					System.out.println(tempScore);
				}
			}
		}
		rLvl++;
		while(rLvl < scoreMatrix.length ){
			rLvl = countScores(scoreMatrix, tempScoresList, rLvl);
			if(rLvl==scoreMatrix.length){
				break;
			}
		}
		return rLvl;
	}
	
	static void print(int[][] matrix){
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(" "+matrix[i][j]);
			}
			System.out.println();
		}
	}
	
	static void DLR(){
		
	}

}
