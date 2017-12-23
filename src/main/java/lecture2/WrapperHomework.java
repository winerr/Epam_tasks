package lecture2;

import java.util.Random;

public class WrapperHomework {

    private final int matrixSize = 4;
    private Integer [][]matrix;
    private Random random;
    private Integer amountOverDiagonal;
    private Integer amountUnderDiagonal;

    public WrapperHomework(){
        this.matrix = new Integer[matrixSize][matrixSize];
        this.random = new Random();
        generateMatrix();
    }

    private void generateMatrix(){
        amountOverDiagonal = 0;
        amountUnderDiagonal = 0;
        for (int i=0; i<matrixSize; i++){
            for(int j=0; j<matrixSize; j++){
                if(j > i){
                    matrix[i][j] = random.nextInt(10) + 1;
                    amountOverDiagonal += matrix[i][j];
                }else if(i > j){
                    matrix[i][j] = random.nextInt(10) + 11;
                    amountUnderDiagonal += matrix[i][j];
                }else {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public void showMatrix(){
        for (Integer[] vector: matrix){
            for (Integer number: vector){
                System.out.print(number + "  ");
            }
            System.out.println();
        }
        System.out.println("Amount over diagonal: " + amountOverDiagonal);
        System.out.println("Amount under diagonal: " + amountUnderDiagonal);
    }

    public static void main(String[] args) {
        WrapperHomework wrapperHomework = new WrapperHomework();
        wrapperHomework.showMatrix();
    }

}
