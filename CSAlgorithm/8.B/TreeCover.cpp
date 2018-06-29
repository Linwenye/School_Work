//#include <iostream>
//#include <string>
//#include <vector>
//using namespace std;
//
//vector<int> my_split(string s);
//int tree_DFS(int node);
//
//vector<vector<int>> graph;
//int res;
//int main() {
//	string line;
//	while (getline(cin, line))
//	{
//		graph.push_back(my_split(line));
//	}
//	cout << "I have read the rules about plagiarism punishment\n";
//	cout << tree_DFS(0);
//	return 0;
//}
//
//vector<int> my_split(string s) {
//	vector<int> split_res;
//	string tmp = "";
//	for (size_t i = 0; i < s.size(); i++)
//	{
//		if (s[i] == ' ')
//		{
//			split_res.push_back(atoi(tmp.c_str()));
//			tmp = "";
//		}
//		else {
//			tmp += s[i];
//		}
//	}
//	return split_res;
//}
//
//int tree_DFS(int node)
//{
//	int res_choose = 1;
//	int res_not_choose = 0;
//	// choose the node
//	for (size_t i = 1; i < graph[node].size(); i++)
//	{
//		res_choose += tree_DFS(graph[node][i]);
//	}
//
//	// not choose
//	res_not_choose = graph[node].size() - 1;
//	for (size_t i = 1; i < graph[node].size(); i++)
//	{
//		int child = graph[node][i];
//		for (size_t j = 1; j < graph[child].size(); j++)
//		{
//			res_not_choose += tree_DFS(graph[child][j]);
//		}
//	}
//	return res_choose < res_not_choose ? res_choose : res_not_choose;
//}
//
