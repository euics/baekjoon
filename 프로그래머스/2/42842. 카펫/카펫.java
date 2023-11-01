class Solution {
    public int[] solution(int brown, int yellow) {
        
        for(int i = 1; i <= yellow; i++){
            for(int j = i; j <= yellow; j++){
                
                if(i * j == yellow){
                    
                    int row = i + 2;
                    int col = j + 2;
                    
                    if(row * col == yellow + brown)
                        return new int[]{col, row};
                    
                }
            }
        }
        
        return new int[]{0, 0};
    }
}

/*

yellow = 세로 * 가로

brown = 세로 

*/

/*
    n * m - yellow = brown;
    b b b b
    b y y b
    b b b b

    b b b b b b
    b y y y y b
    b y y y y b
    b y y y y b
    b y y y y b
    b y y y y b
    b y y y y b
    b b b b b b
*/