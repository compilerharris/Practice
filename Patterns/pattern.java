class P{
	public static void main(String[] args) {
		for (int i = 1 ; i <= 4 ; i += 1 ) {
			if (i%2 != 0) {
				for (int j = 1 ; j <= i ; j += 1 ) {
					System.out.print("\t"+j);	
				}
			}else{
				for (int j = i ; j >= 1 ; j -= 1) {
					System.out.print("\t"+j);
				}
			}
			System.out.println();
		}
		System.out.println();
	}
}