package com.matrices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CountScores2 {

	public static void main(String[] args) throws IOException {
		int[] gradesArray = new int[] { 10, 9, 8, 7, 6, 5 };
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine().trim();
		
		int N = Integer.parseInt(line);
		int[] subjectArray = new int[N];
		for (int i = 0; i < N; i++) {
			line = br.readLine().trim();
			subjectArray[i] = Integer.parseInt(line);
		}
		
		int[][] scoreMatrix = getScoreMatrix(subjectArray, gradesArray);
		List<Integer> baseScoreList = new ArrayList<Integer>();
		baseScoreList.add(10);
		baseScoreList.add(9);
		baseScoreList.add(8);
		baseScoreList.add(7);
		baseScoreList.add(6);
		baseScoreList.add(5);
		System.out.println(countScores(scoreMatrix, baseScoreList));
	}
	
	private static int[][] getScoreMatrix(int[] subjectArray, int[] gradesArray) {
		int[][] scorematrix =new int[subjectArray.length][gradesArray.length];
		
		for (int i = 0; i < subjectArray.length; i++) {
			for (int j = 0; j < gradesArray.length; j++) {
				scorematrix[i][j] = subjectArray[i]*gradesArray[j];
			}
		}
		return scorematrix;
	}
	
	private static int countScores(int[][] scoreMatrix, List<Integer> baseScoreList) {
		List<Integer> tempScoresList = baseScoreList;
		for(int rLvl=1; rLvl< scoreMatrix.length; rLvl++ ){
			tempScoresList = countScores(scoreMatrix, tempScoresList, rLvl);
			if(rLvl==scoreMatrix.length){
				break;
			}
		}
		return tempScoresList.size();
	}

	private static List<Integer> countScores(int[][] scoreMatrix, List<Integer> baseScoreList, int rLvl) {
		List<Integer> tempScoresList = new ArrayList<Integer>();
		for (int base : baseScoreList) {
			for (int j = 0; j < 6; j++) {
				int tempScore = base + scoreMatrix[rLvl][j];
				if (!tempScoresList.contains(tempScore)) {
					tempScoresList.add(tempScore);
				}
			}
		}
		return tempScoresList;
	}

}
