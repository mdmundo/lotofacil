public class Ordenar {
	public Object[][] Ordenacao(Object[][] bolas, int inicio, int fim){
		
		Object[][] bolas_1 = new Object[bolas.length][bolas[0].length];
		
		for (int i = 0; i < bolas.length; i++) {
			for (int j = 0; j < bolas[i].length; j++) {
				bolas_1[i][j]=bolas[i][j];
			}
		}
		Object temp = new Object();
		for (int i = inicio - 1; i < fim; i++) {
			for (int j = 1; j < 16; j++) {
				for (int k = 1; k < 15; k++) {
					if (Integer.valueOf(bolas_1[i][k].toString()) > Integer.valueOf(bolas_1[i][k + 1].toString())) {
						temp = bolas_1[i][k];
						bolas_1[i][k] = bolas_1[i][k + 1];
						bolas_1[i][k + 1] = temp;
					}
				}
			}
		}
		return bolas_1;
	}
}