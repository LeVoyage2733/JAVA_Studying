package B_MemoryAndArray;

public class MemoryAllocation {
    public static void main(String[] args) {
        // <배열 기본>
        // 1. 배열 선언하고 초기화하기
        // 자료형[] 배열명;
        // 자료형 배열명[];
        // 1.1. 선언과 동시에 값을 넣어 초기화
        // ex) int[] ages;                 정수형 배열 선언
        int[] ages = {20, 24, 19};  // 선언과 동시에 값을 넣어 초기화함
        String[] fruits = {"Apple", "Pear", "Peach"};
        // 1.2. 크기를 지정해 배열 생성
        String[] fruitArray = new String[4];
        fruitArray = new String[] {"Apple", "Pear", "Peach", "Orange"};

        // 2. 배열 접근하기
        // 인덱스 사용함
        int[] scoreArray = {80, 90, 100, 70};
        System.out.println("1번 학생의 점수: " + scoreArray[0]);
        System.out.println("2번 학생의 점수: " + scoreArray[1]);
        System.out.println("3번 학생의 점수: " + scoreArray[2]);
        System.out.println("4번 학생의 점수: " + scoreArray[3]);

        // 2.1. 배열의 값 변경
        scoreArray[0] = 95;
        System.out.println("1번 학생의 점수: " + scoreArray[0] + "\n");

        // 3. 배열에서 반복문 사용하기
        int[] ScoreArray = new int[4];
        ScoreArray[0] = 80;
        ScoreArray[1] = 90;
        ScoreArray[2] = 100;
        ScoreArray[3] = 70;
        for (int i=0; i<4; i++) {
            System.out.println(i+1 + "번째 학생의 점수: " + ScoreArray[i]);
        }

        // <이차원 배열>
        // 이차원 배열은 행과 열로 구성
        // 1. 이차원 배열 선언 & 초기화
        // 1.1. 배열 선언 시 직접 값 넣어 초기화
        int[][] arr2 = {{0,1,2}, {3,4,5}, {6,7,8}};
        // 1.2. 배열 크기로 생성
        // 자료형[][] 배열명 = new 자료형[행_크기][열_크기];
        int[][] arr3 = new int[3][3];
        // 2. 이차원 배열 접근
        // 배열명[행_인덱스][열_인덱스];
        arr2[2][1]= 10;
        // for문으로 이차원 배열 값 확인하기
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                System.out.print(arr2[i][j] + " ");
            }
            System.out.println(" ");
        }
        System.out.print("\n");

        for (int[] ints : arr2) {
            for (int j = 0; j < arr2.length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println(" ");
        }

        System.out.print("\n");

        int[][] matrix = new int[3][3];
        int x = 1;
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                matrix[i][j] = x;
                x++;
            }
        }
        for (int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(" ");
        }
    }
}
