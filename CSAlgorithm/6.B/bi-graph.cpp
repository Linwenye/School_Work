#include <iostream>
#include <vector>
#include <queue>
#include <string>
using namespace std;
vector<int> my_split(string s);
void BFS();

bool* res;
int *state;
int n;
vector<vector<int>> graph;
queue<int> q;
int main() {
	string line;
	while (getline(cin, line))
	{
		graph.push_back(my_split(line));
	}
	n = graph.size();
	state = new int[n]();
	res = new bool[n]();

	BFS();
	cout << "wo yi yue du guan yu chao xi de shuo ming" << endl;
	cout << 0;
	for (int t = 1; t < n; t++) {
		if (!res[t]) {
			cout << endl << t;
		}
	}
	delete[]state;
	delete[]res;
}

vector<int> my_split(string s) {
	vector<int> split_res;
	string tmp = "";
	for (int i = 0; i < s.size(); i++)
	{
		if (s[i] == ' ')
		{
			split_res.push_back(atoi(tmp.c_str()));
			tmp = "";
		}
		else {
			tmp += s[i];
		}
	}
	return split_res;
}

void BFS() {
	q.push(0);
	res[0] = 0;
	state[0] = 1;
	while (!q.empty())
	{
		int i = q.front();
		q.pop();
		// assume that t line represent the t node
		for (int j = 0; j < graph[i].size(); j++) {
			int child = graph[i][j];
			if (child != i)
			{
				if (state[child] == 0)
				{
					state[child] = 1;
					res[child] = res[i] ? 0 : 1;
					q.push(child);
				}
			}
		}
		state[i] = 2;
	}

}