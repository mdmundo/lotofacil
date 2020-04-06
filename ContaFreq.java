public class ContaFreq {
	public int[][] conta(Object[][] bolas_1, int inicio, int fim){
		int[][] vet = new int[25][2];
		for (int i = 0; i < vet.length; i++) {
			vet[i][1] = i+1;
		}
		for (int i = inicio; i <= fim; i++) {
			for (int j = 1; j < bolas_1[i].length; j++) {
				switch (Integer.valueOf(bolas_1[i][j].toString())) {
				case 1:
					vet[0][0]++;
					break;
				case 2:
					vet[1][0]++;
					break;
				case 3:
					vet[2][0]++;
					break;
				case 4:
					vet[3][0]++;
					break;
				case 5:
					vet[4][0]++;
					break;
				case 6:
					vet[5][0]++;
					break;
				case 7:
					vet[6][0]++;
					break;
				case 8:
					vet[7][0]++;
					break;
				case 9:
					vet[8][0]++;
					break;
				case 10:
					vet[9][0]++;
					break;
				case 11:
					vet[10][0]++;
					break;
				case 12:
					vet[11][0]++;
					break;
				case 13:
					vet[12][0]++;
					break;
				case 14:	
					vet[13][0]++;
					break;
				case 15:
					vet[14][0]++;
					break;
				case 16:
					vet[15][0]++;
					break;
				case 17:
					vet[16][0]++;
					break;
				case 18:
					vet[17][0]++;
					break;
				case 19:	
					vet[18][0]++;
					break;
				case 20:
					vet[19][0]++;
					break;
				case 21:
					vet[20][0]++;
					break;
				case 22:
					vet[21][0]++;
					break;
				case 23:
					vet[22][0]++;
					break;
				case 24:
					vet[23][0]++;
					break;
				case 25:
					vet[24][0]++;
					break;
				}
			}
		}
		return vet;
	}
}
	
	
	