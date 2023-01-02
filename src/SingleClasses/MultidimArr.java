package SingleClasses;

public class MultidimArr {
    public static void main(String[] args){
        int[][] matrix = new int[3][5];
        for(int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                matrix[i][j] = i + j + 1;
            }
        }
        for (var line : matrix){
            for (int element : line){
                System.out.print(element + "\t");
            }
            System.out.println();
        }
    }
}
