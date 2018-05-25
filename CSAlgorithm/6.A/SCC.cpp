#include <iostream>
#include <vector>
#include <queue>
#include <stack>
#include <set>
#include <string>
using namespace std;

struct ConnectComponent
{
	set<int> neighbors;				//rearrange the order
	set<int> component_points;
	int accessable_num;
};

vector<int> my_split(string s);
void my_graph_reverse();
void DFS_explore(int i);
void init_stack();
void DFS_mark(int i, int component_count, ConnectComponent* connect_component);
void init_component();
void search_impact();
int DFS(int i);

int *state;
int n;
vector<vector<int>> graph;
vector<vector<int>> reverse_graph;
stack<int> point_stack;
vector<ConnectComponent*> connect_graph;
ConnectComponent* res;
int max_impact=0;
int main() {
	string line;
 	while (getline(cin, line))
	{
		graph.push_back(my_split(line));
	}
	n = graph.size();
	my_graph_reverse();
	init_stack();
	init_component();
	search_impact();
	cout << "I have read the rules about plagiarism punishment" << endl;
	cout << max_impact-1 << endl;
	for (set<int>::iterator it = res->component_points.begin(); it != res->component_points.end(); ++it) {
		cout << *it << " ";
	}
	return 0;
}

void init_stack() {
	state = new int[n]();

	// wrapper
	for (size_t i = 0; i < n; i++)
	{
		if (state[i] == 0)
		{
			DFS_explore(i);
		}
	}
	delete[]state;

}

void DFS_explore(int i) {
	state[i] = 1;
	for (int j = 0; j < graph[i].size(); j++) {
		int child = graph[i][j];
		if (state[child] == 0)
		{
			DFS_explore(child);
		}
	}
	point_stack.push(i);
	state[i] = 2;
}

void init_component() {
	state = new int[n]();

	int component_count = 1;
	// wrapper
	while (!point_stack.empty())
	{
		int node=point_stack.top();
		point_stack.pop();
		if (state[node]==0)
		{
			ConnectComponent* connect_component = new ConnectComponent;
			DFS_mark(node,component_count,connect_component);
			connect_graph.push_back(connect_component);
			component_count++;
		}
	}

	delete[]state;
}

void DFS_mark(int i,int component_count, ConnectComponent* connect_component) {
	state[i] = component_count;
	connect_component->component_points.insert(i);
	for (int j = 0; j < reverse_graph[i].size(); j++) {
		int child = reverse_graph[i][j];
		if (state[child] == 0)
		{
			DFS_mark(child,component_count,connect_component);
		}
		else if (state[child]!=component_count)
		{
			//connect_component->neighbors.insert(state[child]-1);
			connect_graph[state[child] - 1]->neighbors.insert(component_count - 1);
		}
	}
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
			if (i==s.size()-1)
			{
				split_res.push_back(atoi(tmp.c_str()));
			}
		}
	}
	return split_res;
}

void my_graph_reverse() {
	reverse_graph.resize(n);
	for (size_t i = 0; i < n; i++)
	{
		for (size_t j = 0; j < graph[i].size(); j++)
		{
			reverse_graph[graph[i][j]].push_back(i);
		}
	}
}

void search_impact() {
	for (size_t i = 0; i < connect_graph.size(); i++)
	{
		state = new int[connect_graph.size()]();
		int impact = DFS(i);
		if (impact>max_impact)
		{
			max_impact = impact;
			res = connect_graph[i];
		}
		delete[] state;
	}
}

int DFS(int i) {
	int res = connect_graph[i]->component_points.size();
	state[i] = 1;
	ConnectComponent* cc = connect_graph[i];

	for (set<int>::iterator it = cc->neighbors.begin(); it != cc->neighbors.end(); ++it) {
		if (state[*it]==0)
		{
			res+=DFS(*it);
		}
	}
	return res;
}