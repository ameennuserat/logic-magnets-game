package MyProject;

public class Level {

    public static Board level1(){
            char[][] board = {
                    {'-', '-','-','-'},
                    {'-', 'O','@','O'},
                    {'A', '-','-','-'}
            };
        return new Board(3,4,1,board);
    }
        public static Board level2(){
            char[][] board = {
                    {'-', '-', 'O', '-','-'},
                    {'-', '-', '@', '-','-'},
                    {'O', '@', 'O', '@','O'},
                    {'-', '-', '@', '-','-'},
                    {'A', '-', 'O', '-','-'},
            };
        return new Board(5,5,1,board);
    }
        public static Board level3(){
            char[][] board = {
                    {'X', 'X', 'X', 'O'},
                    {'-', '-', '@', '-'},
                    {'A', '-', '-', 'O'}
            };
        return new Board(3,4,2,board);
    }

    public static Board level4(){
        char[][] board = {
                {'O', '-', 'O'},
                {'X', '@', '-'},
                {'A', '-', '-'},
                {'X', '@', '-'},
                {'-', 'O', '-'}
        };
        return new Board(5,3,2,board);
    }

        public static Board level5(){
            char[][] board = {
                    {'O', 'X', 'O'},
                    {'M', 'X', 'M'},
                    {'@', 'X', '@'},
                    {'O', 'A', '-'}
            };
        return new Board(4,3,2,board);
    }

    public static Board level6(){
        char[][] board = {
                {'-', '-', '-','O','-'},
                {'-', '@', 'O','@','-'},
                {'A', '-', '-','O','-'},
        };
        return new Board(3,5,2,board);
    }


        public static Board level7(){
            char[][] board = {
                    {'O', '-', '-', '-'},
                    {'M', '-', '-', '-'},
                    {'@', 'A', '-', 'O'},
                    {'-', '@', 'M', '-'},
                    {'X', 'X', 'X', 'O'}
            };
        return new Board(5,4,2,board);
    }
        public static Board level8(){
            char[][] board = {
                    {'O', '-', 'O','-'},
                    {'-', '@', '@','-'},
                    {'A', '-', 'O','-'}
            };
        return new Board(3,4,2,board);
    }

        public static Board level9(){
            char[][] board = {
                    {'A', 'O', '-', 'M','-','@','O'}
            };
        return new Board(1,7,2,board);
    }

    public static Board level10(){
            char[][] board = {
                    {'A', '-', '-', '-'},
                    {'-', 'O', '-', 'O'},
                    {'-', '-', '@', '@'},
                    {'O', '@', '-', 'O'},
            };
        return new Board(4,4,2,board);
    }
    public static Board level11(){
            char[][] board = {
                    {'-', '@', 'O', '-'},
                    {'O', 'M', '@', '-'},
                    {'N', 'O', '-', 'R'}
            };
        return new Board(3,4,2,board);
    }
    public static Board level12(){
            char[][] board = {
                    {'X', '@', 'O', 'X'},
                    {'O', 'M', '@', 'X'},
                    {'N', 'O', 'X', 'R'}
            };
        return new Board(3,4,2,board);
    }

    public static Board level13(){
            char[][] board = {
                    {'-', '-', '-', 'O','O'},
                    {'-', '-', '@', '-','-'},
                    {'R', '-', '-', '-','A'},
                    {'-', '-', '@', '-','-'},
                    {'O', '-', '-', 'O','-'}
            };
        return new Board(5,5,3,board);
    }

    public static Board level14(){
        char[][] board = {
                {'-', '-','-','-'},
                {'@', 'O','-','O'},
                {'R', '-','-','-'}
        };
        return new Board(3,4,1,board);
    }

}

