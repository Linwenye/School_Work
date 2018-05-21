#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

void DFS(int node, int parent);
int *state, *discover_time, *back, *bridgeback;
int n = 0;
int global_clock = 0;
int root_TE = 0;
bool *res_point;
vector<int>* graph;
vector<int>* res_edge;
int main() {
	cin >> n;
	graph = new vector<int>[n];
	res_edge = new vector<int>[n];
	state = new int[n]();
	discover_time = new int[n]();
	back = new int[n]();
	bridgeback = new int[n]();
	res_point = new bool[n]();

	int num1 = 0, num2 = 0;
	while (cin>>num1&&cin>>num2)
	{
		graph[num1].push_back(num2);
		graph[num2].push_back(num1);

	}

	// DFS wrapper
	for (int i = 0; i < n; i++)
	{
		if (state[i] == 0)
		{
			DFS(i, -1);
		}
	}

	if (root_TE >= 2)
	{
		res_point[0] = 1;
	}

	cout << "wo yi yue du guan yu chao xi de shuo ming" << endl;
	// cout the point
	bool first = true;
	for (int i = 0; i < n; i++)
	{
		if (res_point[i])
		{
			if (first)
			{
				cout << i;
				first = false;
			}
			else {
				cout << endl << i;
			}
		}
	}
	// cout the edge
	for (int i = 0; i < n; i++)
	{
		sort(res_edge[i].begin(), res_edge[i].end());
		if (!res_edge[i].empty())
		{
			for (int t = 0; t < res_edge[i].size(); t++) {
				cout << endl << i << " " << res_edge[i][t];
			}
		}
	}
	delete[]state;
	delete[]graph;
	delete[]back;
	delete[]discover_time;
	delete[]bridgeback;
	delete[]res_edge;
	delete[]res_point;
	return 0;
}

void DFS(int node, int parent)
{
	discover_time[node] = global_clock++;
	state[node] = 1;
	back[node] = discover_time[node];
	for (int j = 0; j < graph[node].size(); j++)
	{
		if (graph[node][j] != parent)
		{
			if (state[graph[node][j]] == 0)
			{
				if (node == 0)
				{
					root_TE++;
				}
				DFS(graph[node][j], node);
				if (node != 0 && back[graph[node][j]] >= discover_time[node]) {
					res_point[node] = 1;
				}
				back[node] = min(back[node], back[graph[node][j]]);
				if (back[graph[node][j]] > discover_time[node])
				{
					if (node < graph[node][j])
					{
						res_edge[node].push_back(graph[node][j]);
					}
					else {
						res_edge[graph[node][j]].push_back(node);
					}
				}
			}
			else if (state[graph[node][j]] == 1)
			{
				back[node] = min(back[node], discover_time[graph[node][j]]);
			}
		}
	}
	state[node] = 2;
}
