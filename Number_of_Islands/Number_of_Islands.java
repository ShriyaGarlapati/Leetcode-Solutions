class Solution {
    public boolean isSafe(int i, int j, int r, int c)
    {
        if(i<r&&j<c&&i>=0&&j>=0)
        return true;
        else
        return false;
    }
    public int numIslands(char[][] grid) {
        
        int islands=0;
        int i,j,k;
        for(i=0;i<grid.length;i++)
        {
            for(j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]=='1')
                {
                    BFS(grid,i,j);
                    islands+=1;
                }
            }
        }
        return islands;
    }
    public void BFS(char[][] grid,int r,int c)
    {
        int i,j;
        int r1=grid.length;
        int c1=grid[0].length;
        Queue<Element> q=new LinkedList<Element>();
        Element s= new Element(r,c);
        q.add(s);
        while(!q.isEmpty())
        {
            Element y= q.poll();
            i=y.r;
            j=y.c+1;
            if(isSafe(i,j,r1,c1)&&grid[i][j]=='1')
            {
                grid[i][j]='2';
                q.add(new Element(i,j));

            }
            i=y.r;
            j=y.c-1;
            if(isSafe(i,j,r1,c1)&&grid[i][j]=='1')
            {
                grid[i][j]='2';
                q.add(new Element(i,j));

            }
            i=y.r+1;
            j=y.c;
            if(isSafe(i,j,r1,c1)&&grid[i][j]=='1')
            {
                grid[i][j]='2';
                q.add(new Element(i,j));

            }
            i=y.r-1;
            j=y.c;
            if(isSafe(i,j,r1,c1)&&grid[i][j]=='1')
            {
                grid[i][j]='2';
                q.add(new Element(i,j));

            }
        }

    }
}
public class Element{
    int r,c;
    Element(int r, int c)
    {
        this.r=r;
        this.c=c;
    }
}