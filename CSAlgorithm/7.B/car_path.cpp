#include <stdio.h>
#include <algorithm>
#include <vector>
#include <utility>
#include <stack>
#include <queue>
#include <functional>
using namespace std;

bool *state;
int n = 0;
int res = 0;
priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> edges;
vector<pair<int, int>>* graph;
int s, t;
bool* visited;

void DFS_explore(int i);
void caculate_distance();
int main() {
	scanf("%d", &n);
	scanf("%d", &s);
	scanf("%d", &t);

	graph = new vector<pair<int, int>>[n];
	visited = new bool[n]();
	int num1 = 0, num2 = 0, num3 = 0;
	while (scanf("%d %d %d", &num1, &num2, &num3) != EOF)
	{
		//num2,num3: next node; num1:weight
		pair<int, int> edge3(num1, num3);
		pair<int, int> edge2(num1, num2);
		graph[num2].push_back(edge3);
		graph[num3].push_back(edge2);
	}

	visited[s] = 1;
	for (int i = 0; i < graph[s].size(); ++i)
	{
		edges.push(graph[s][i]);
	}
	while (true)
	{
		res = edges.top().first > res ? edges.top().first : res;
		int next = edges.top().second;
		if (next == t)
		{
			break;
		}
		visited[next] = 1;
		edges.pop();
		for (int i = 0; i < graph[next].size(); i++)
		{
			if (!visited[graph[next][i].second])
			{
				edges.push(graph[next][i]);
			}
		}
	}

	printf("I have read the rules about plagiarism punishment\n");
	printf("%d", res);
	delete[]graph;
	return 0;
}

