import java.util.ArrayList;
import java.util.List;


class B{
	List<List<Integer>> graph = new ArrayList<>();
	List<Integer> result = new ArrayList<>();

	public void buildGraph(int [][] edges,int n)
	{
	    for(int i=0;i<=n;i++)
	    {
	        graph.add(new ArrayList<>());
	    }
	    for(int []edge : edges)
	    {
	        graph.get(edge[0]).add(edge[1]);
	        graph.get(edge[1]).add(edge[0]);
	    }  
	}
		
	
	public void build_DFS(int src,boolean []visit)
	{
		List<Integer> temp = graph.get(src);
		visit[src]=true;
		result.add(src);
		for(int i:temp)
		{
			if(visit[i]==false)
			{
				build_DFS(i,visit);
			}
		}
	}
	

	public void print()
	{
		for(int i:result)
			System.out.print(i+" ");
	}
	
	
}
public class Build_Dfs {
	
	public static void main(String []ar)
	{
		int [][]edge = {{1,2},{1,4},{1,5},{2,3},{2,5},{3,5}};
		boolean []visited = new boolean[edge.length];
		for(int i=0;i<edge.length;i++)
		{
			visited[i]=false;
		}
		
		B a = new B();
		
		a.buildGraph(edge,edge.length);
		
		a.build_DFS(1,visited);
		
		a.print();
	}

}
