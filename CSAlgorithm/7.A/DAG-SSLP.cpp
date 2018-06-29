//#include <stdio.h>
//#include <algorithm>
//#include <vector>
//#include <stack>
//using namespace std;
//
//void DFS(int node, int parent);
//int *state, *longest_distance;
//int n = 0;
//int res = 0;
//stack<int> point_stack;
//vector<int>* graph;
//vector<int>* weights;
//void init_stack();
//void DFS_explore(int i);
//void caculate_distance();
//int main() {
//	scanf("%d", &n);
//	graph = new vector<int>[n];
//	weights = new vector<int>[n];
//	int num1 = 0, num2 = 0, num3 = 0;
//	while (scanf("%d", &num1) && (scanf("%d", &num2)) && (scanf("%d", &num3)))
//	{
//		//num2: next node; num3:weight
//		graph[num1].push_back(num2);
//		weights[num1].push_back(num3);
//	}
//
//	init_stack();
//
//
//	longest_distance = new int[n]();
//	caculate_distance();
//
//	printf("I have read the rules about plagiarism punishment\n");
//	for (int i = 1; i < n; i++)
//	{
//		printf("%d ", longest_distance[i]);
//	}
//	delete[]graph;
//	return 0;
//}
//
//void init_stack() {
//	state = new int[n]();
//
//	// wrapper
//	for (size_t i = 0; i < n; i++)
//	{
//		if (state[i] == 0)
//		{
//			DFS_explore(i);
//		}
//	}
//	delete[]state;
//
//}
//
//void DFS_explore(int i) {
//	state[i] = 1;
//	for (int j = 0; j < graph[i].size(); j++) {
//		int child = (graph[i][j]);
//		if (state[child] == 0)
//		{
//			DFS_explore(child);
//		}
//	}
//	point_stack.push(i);
//	state[i] = 2;
//}
//
//
//void caculate_distance() {
//	while (!point_stack.empty())
//	{
//		int node = point_stack.top();
//		point_stack.pop();
//		for (int t = 0; t < graph[node].size(); ++t)
//		{
//			int child = graph[node][t];
//			int weight = weights[node][t];
//			longest_distance[child] = max(longest_distance[node] + weight, longest_distance[child]);
//		}
//	}
//}