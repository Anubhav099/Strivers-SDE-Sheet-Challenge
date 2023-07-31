class Queen {
    int row;
    int col;
    Queen( int row, int col ) {
        this.row = row;
        this.col =col;
    }
}
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<Queen> ans = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        rec69( 1, n, ans, 0, res );
        return res;
    }

    void rec69( int col, int n, List<Queen> ans, int lastRow, List<List<String>> res ) {
        if( col == n+1 ) {
            List<String> actualAns = new ArrayList<>();
            for( Queen q: ans ) {
                StringBuilder s = new StringBuilder(".".repeat( n ));
                s.setCharAt( q.row-1, 'Q' );
                actualAns.add( s.toString() );
            }
            res.add(actualAns);
            if( ans.get(0).row != n || ans.get( ans.size() - 1 ).row != n ) {
                lastRow = ans.get( ans.size() - 1 ).row;
                ans.remove( ans.size() - 1 );
                rec69( col-1, n, ans, lastRow, res );
            }
            return;
        }
        for( int row = lastRow + 1 ; row <= n; row++ ) {
            lastRow = 0;
            if( check( row, col, ans, n ) ) {
                ans.add( new Queen( row, col ) );
                rec69( col+1, n, ans, lastRow, res );
                return;
            }
        }
        if( ans.size()==0 ) {
            return;
        }
        else lastRow = ans.get( ans.size() - 1 ).row;
        ans.remove( ans.size() - 1 );
        rec69( col-1, n, ans, lastRow, res );
    }

    boolean check( int row, int col, List<Queen> ans, int n ) {
        for( Queen q: ans )
            if( q.row == row || Math.abs( row - q.row ) == Math.abs( col -q.col ) )
                return false;
        return true;
    }
}
//TC: O( n^n ), SC: O( 2*n )