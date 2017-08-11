import java.util.*; 


class Matrix{ // Declare MatrixMethod class
	public static int nHSample = 0, nXSample = 0;
	public static int [] x = new int[20]; //Declare x array for holding samples of x(n)
	public static int [] h = new int[20]; //Declare h array for holding samples of h(n)

	public Matrix(int nXSampleP, int nHSampleP, int[] xP, int[] hP){
		nXSample = nXSampleP;
		nHSample = nHSampleP; 
		x = xP;
		h = hP;
	}

	public void allMethod() { // allMethod method


		paddZero(x,h,nXSample,nHSample);
		
		int [][] leftArray = new int [nXSample][nXSample]; // Left Array

		fillFirstCol(leftArray,x);

		int [] midCol = new int [20]; // To fill other columns

		int copy = nXSample*2; // Generating copy variable
		int k = 0;
		for (int i=0; i<copy ; i += 1) { // Initializing midCol array
			midCol[i] = x[k++];
			if(k==nXSample)
				k = 0;
		}

		generateOtherCol(leftArray,midCol);

		int [][] rightArray = new int [nXSample][1]; // Right array

		for (int i = 0; i < nXSample ; i += 1) { // Filling column
			rightArray[i][0] = h[i];
		}

		int finalArray[][] = new int [nXSample][nHSample]; // Initializing y(n) array

		matrixMultiplication(leftArray,rightArray,finalArray);

//**********printing...

        printAll(x,h,leftArray,rightArray,finalArray);
	}

	 void paddZero(int x[], int h[], int nXSample, int nHSample){
		if(nXSample != nHSample){ //constrain for checking no.of samples
			// int dif = Math.abs(nXSample - nHSample); //calculate difference
			if( nXSample < nHSample){ // constrain
				for (int i = nXSample ; i < nHSample ; i += 1) { // padding 0's
					x[nXSample] = 0;
				}
				nXSample = nHSample;
			}else{
				for (int i = nHSample ; i < nXSample ; i += 1) { // padding 0's
					h[nHSample] = 0;
				}
				nHSample = nXSample;
			}
		}
	}

	 void fillFirstCol(int leftArray[][], int x[]){
		for (int i=0; i<nXSample ; i += 1 ) { // Filling first column
			leftArray[i][0] = x[i];	
		}
	}

	 void generateOtherCol(int leftArray[][], int midCol[]){
		int dummy = nXSample-1; // Generating dummy variable
		for (int i = 0 ; i < nXSample-1 ; i += 1 ) { // Filling other columns
			for (int p = 0 ; p < nXSample ; p += 1 ) {
				leftArray[p][i+1] = midCol[dummy++];	
			}
			dummy = dummy - nXSample - 1;
		}
	}

	 void matrixMultiplication(int leftArray[][], int rightArray[][], int finalArray[][]){
		for (int a = 0; a < nXSample; a++) // Matrix Multiplication
        {
            for (int b = 0; b < 1; b++)
            {
                for (int c = 0; c < nXSample; c++)
                {
                    finalArray[a][b] = finalArray[a][b] + leftArray[a][c] * rightArray[c][b];
                }
            }
        }
	}

	 void printAll(int x[], int h[], int leftArray[][], int rightArray[][], int finalArray[][]){
        System.out.println("\n\n");
		System.out.print("x(n)={"+x[0]);// printing x(n)
		for (int f=1;f<nXSample ;f++ ) {
				System.out.print(","+x[f]);
		}        
		System.out.print("}\n");

		System.out.print("h(n)={"+h[0]);// printing h(n)
		for (int f=1;f<nXSample ;f++ ) {
				System.out.print(","+h[f]);
		}        
		System.out.print("}\n");

		for (int f=0;f<nXSample ;f++ ) { // LeftMatrix * RightMatix
			for (int g=0;g<nXSample ;g++ ) {
				System.out.print(leftArray[f][g] + "	");
			}			
			System.out.println("\t\t"+rightArray[f][0]);
		}

		System.out.print("y(n)={"+finalArray[0][0]);// printing y(n)
		for (int f=1;f<nXSample ;f++ ) {
				System.out.print(","+finalArray[f][0]);
		}
		System.out.print("}\n");
	}
}



class OverlapAddMethod extends Matrix{
	public OverlapAddMethod(int nXSampleP, int nHSampleP, int[] xP, int[] hP) {
		super(nXSampleP, nHSampleP, xP, hP);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
        System.out.println("\n\n");
		System.out.println("***************DIGITAL SIGNAL PROCESSING***************");
		System.out.println("******************OVERLAP ADD METHOD*****************");
		int m = 0;

		Scanner sc = new Scanner(System.in); // Creating object of Scanner class
		System.out.println("Enter how many samples will be there in x(n): ");// print
		int nXSample = sc.nextInt(); // Scan value in nXSample (no.of sample in x(n))

		int [] x = new int[nXSample*10]; //Declare x array for holding samples of x(n)
		System.out.println("Enter "+nXSample+" samples for x(n): "); //print 
		for (int i=0; i<nXSample ; i += 1 ) { //Getting value in array x
			x[i] = sc.nextInt();
		}

		System.out.println("Enter how many samples will be there in h(n): "); //print
		int nHSample = sc.nextInt(); // Scan value in nHSample (no.of sample in h(n))

		int [] h = new int[nHSample*10]; //Declare h array for holding samples of h(n)
		System.out.println("Enter "+nHSample+" samples for h(n): "); //print
		for (int i=0; i<nHSample ; i += 1 ) { //Getting value in array h
			h[i] = sc.nextInt();
		}

		m = h.length;
		
		Matrix matrix = new Matrix(nXSample, nHSample, x, h);
		matrix.allMethod();

		System.out.println("*****************COMPILERHARRIS***************");
		System.out.println("********************15DCO67*******************");
	}
}
