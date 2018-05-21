//#include <iostream>
//#include <algorithm>
//using namespace std;
//
///*
//	邻接矩阵对于稀疏的图，内存占用过多
//*/
//
//void DFS(int node, int parent);
//int *state, *discover_time, *back, *bridgeback;
//bool **graph;
//int n = 0;
//int global_clock = 0;
//int root_TE = 0;
//bool *res_point, **res_edge;
////int main() {
////	cin >> n;
////
////	state = new int[n]();
////	discover_time = new int[n]();
////	back = new int[n]();
////	bridgeback = new int[n]();
////	res_point = new bool[n]();
////	graph = new bool *[n];
////	for (int i = 0; i < n; i++) {
////		graph[i] = new bool[n]();
////	}
////	res_edge = new bool *[n];
////	for (int i = 0; i < n; i++) {
////		res_edge[i] = new bool[n]();
////	}
////
////	int num1 = 0, num2 = 0;
////	for (int i = 0; i < n; i++)
////	{
////		cin >> num1;
////		cin >> num2;
////		graph[num1][num2] = 1;
////		graph[num2][num1] = 1;
////	}
////
////	// DFS wrapper
////	for (int i = 0; i < n; i++)
////	{
////		if (state[i] == 0)
////		{
////			DFS(i, -1);
////		}
////	}
////
////	if (root_TE >= 2)
////	{
////		res_point[0] = 1;
////	}
////
////	cout << "wo yi yue du guan yu chao xi de shuo ming" << endl;
////	// cout the point
////	for (int i = 0; i < n; i++)
////	{
////		if (res_point[i])
////		{
////			cout << i << endl;
////		}
////	}
////	// cout the edge
////	for (int i = 0; i < n; i++)
////	{
////		for (int j = 0; j < n; j++) {
////			if (res_edge[i][j])
////			{
////				cout << i << " " << j << endl;
////				res_edge[j][i] = 0;
////			}
////		}
////
////	}
////	delete[]state;
////	delete[]graph;
////	delete[]back;
////	delete[]discover_time;
////	delete[]bridgeback;
////	delete[]res_edge;
////	delete[]res_point;
////	return 0;
////}
//
//void DFS(int node, int parent)
//{
//	discover_time[node] = global_clock++;
//	state[node] = 1;
//	back[node] = discover_time[node];
//	for (int j = 0; j < n; j++)
//	{
//		if (node != j&&graph[node][j] && j != parent)
//		{
//			if (state[j] == 0)
//			{
//				if (node == 0)
//				{
//					root_TE++;
//				}
//				DFS(j, node);
//				if (node != 0 && back[j] >= discover_time[node]) {
//					res_point[node] = 1;
//				}
//				back[node] = min(back[node], back[j]);
//				if (back[j] > discover_time[node])
//				{
//					res_edge[j][node] = 1;
//					res_edge[node][j] = 1;
//				}
//			}
//			else if (state[j] == 1)
//			{
//				back[node] = min(back[node], discover_time[j]);
//			}
//		}
//	}
//	state[node] = 2;
//}
