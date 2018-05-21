#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

void DFS(int node, int parent);
int *state, *est, *crit, *eft, *task_time;
int n = 0;
int res = 0;
vector<int>* graph;
int main() {
	cin >> n;
	graph = new vector<int>[n];
	state = new int[n]();
	est = new int[n]();
	eft = new int[n]();
	crit = new int[n]();
	task_time = new int[n]();

	int num1 = 0, num2 = 0;
	for (int i = 0; i < n; i++) {
		cin >> num1;
		cin >> num2;
		task_time[num1 - 1] = num2;
	}
	while (cin >> num1&&cin >> num2)
	{
		graph[num1-1].push_back(num2-1);
	}

	// DFS wrapper
	for (int i = 0; i < n; i++)
	{
		if (state[i] == 0)
		{
			DFS(i, -1);
		}
	}

	cout << "I have read the rules about plagiarism punishment" << endl;
	cout << res;
	delete[]state;
	delete[]graph;
	delete[]est;
	delete[]eft;
	delete[]task_time;
	delete[]crit;
	return 0;
}

void DFS(int node, int parent)
{
	state[node] = 1;
	crit[node] = -1;
	for (int j = 0; j < graph[node].size(); j++)
	{
		int child = graph[node][j];
		if (child != parent)
		{
			if (state[child] == 0)
			{
				DFS(child, node);
				if (eft[child]>=est[node])
				{
					est[node] = eft[child];
					crit[node] = child;
				}
			}
			else if (eft[child]>=est[node])
			{
				est[node] = eft[child];
				crit[node] = child;
			}
		}
	}
	eft[node] = est[node] + task_time[node];
	if (eft[node]>res)
	{
		res = eft[node];
	}
	state[node] = 2;
}
