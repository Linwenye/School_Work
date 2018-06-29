#include <iostream>
#include <string>
#include <vector>
using namespace std;

vector<int> my_split(string s);
void tree_DFS(int node);

vector<vector<int>> graph;
int *res;
int main() {
	string line;
	while (getline(cin, line))
	{
		graph.push_back(my_split(line));
	}
	res = new int[graph.size()]();
	cout << "I have read the rules about plagiarism punishment\n";
	tree_DFS(0);
	cout << res[0];
	return 0;
}

vector<int> my_split(string s) {
	vector<int> split_res;
	string tmp = "";
	for (size_t i = 0; i < s.size(); i++)
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

void tree_DFS(int node)
{
	// choose the node
	int res_choose = 1;
	for (size_t i = 1; i < graph[node].size(); i++)
	{
		tree_DFS(graph[node][i]);
		res_choose += res[graph[node][i]];
	}

	// not choose
	int res_not_choose = graph[node].size() - 1;
	for (size_t i = 1; i < graph[node].size(); i++)
	{
		int child = graph[node][i];
		for (size_t j = 1; j < graph[child].size(); j++)
		{
			res_not_choose += res[graph[child][j]];
		}
	}
	res[node] = res_choose < res_not_choose ? res_choose : res_not_choose;
}

