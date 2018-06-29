#include <stdio.h>
#include <algorithm>
#include <vector>
#include <tuple>
#include <stack>
using namespace std;

void DFS(int node, int parent);
int *longest_distance;
bool *state;
int n = 0;
int res = 0;
stack<int> point_stack;
vector<tuple<int, int>>* graph;

void init_stack();
void DFS_explore(int i);
void caculate_distance();

int main() {
	scanf("%d", &n);
	graph = new vector<tuple<int, int>>[n];
	int num1 = 0, num2 = 0, num3 = 0;
	while (scanf("%d %d %d", &num1,&num2,&num3)!=EOF)
	{
		//num2: next node; num3:weight
		tuple<int, int> edge(num2, num3);
		graph[num1].push_back(edge);
	}

	init_stack();

	longest_distance = new int[n]();
	caculate_distance();

	printf("I have read the rules about plagiarism punishment\n");
	for (int i=1;i<n;i++)
	{
		printf("%d ", longest_distance[i]);
	}
	delete[]graph;
	return 0;
}

void init_stack() {
	state = new bool[n]();

	// wrapper
	DFS_explore(0);
	delete[]state;

}

void DFS_explore(int i) {
	state[i] = 1;
	for (int j = 0; j < graph[i].size(); j++) {
		int child = get<0>(graph[i][j]);
		if (state[child] == 0)
		{
			DFS_explore(child);
		}
	}
	point_stack.push(i);
}


void caculate_distance() {
	while (!point_stack.empty())
	{
		int node = point_stack.top();
		point_stack.pop();
		for (int t=0;t<graph[node].size();++t)
		{
			int child = get<0>(graph[node][t]);
			int weight = get<1>(graph[node][t]);
			longest_distance[child] = max(longest_distance[node] + weight, longest_distance[child]);
		}
	}
}