#include <iostream>
#include <vector>
#include <map>
#include <string>
#include <tuple>
#include <algorithm>
using namespace std;
int main() {
	int n;
	cin >> n;
	map<string, tuple<string, int>> res_map;
	vector<string> res;
	for (int i = 0; i < n; i++)
	{
		string tmp;
		//scanf("%s", tmp);
		cin >> tmp;
		string sorted_identifier = tmp;
		sort(sorted_identifier.begin(), sorted_identifier.end());
		if (res_map.count(sorted_identifier)) // exist in res_map
		{
			tuple<string, int> &the_tuple = res_map[sorted_identifier]; // use & to get the reference, but not override the "="
			if (tmp < get<0>(the_tuple))
			{
				get<0>(the_tuple) = tmp;
			}
			get<1>(the_tuple) = 2;

		}
		else {
			tuple<string, int> tuple(tmp, 1);
			res_map[sorted_identifier] = tuple;
		}

	}

	// c++ 11 not supported by the OJ
/*	for (auto const &item : res_map)
	{
		if (get<1>(item.second) == 2)
		{
			res.push_back(get<0>(item.second));
		}
	}
*/
	for (map<string, tuple<string, int>>::iterator iter = res_map.begin(); iter != res_map.end(); ++iter)
	{
		if (get<1>(iter->second) == 2)
		{
			res.push_back(get<0>(iter->second));
		}
	}

	sort(res.begin(), res.end());

	cout << "wo yi yue du guan yu chao xi de shuo ming\n";
	cout << res.size();

	//for (auto const& item : res)
	//{
	//	cout << endl << item;
	//}

	for (vector<string>::iterator iter = res.begin(); iter != res.end(); ++iter)
	{
		cout << endl << *iter;
	}
	return 0;
}