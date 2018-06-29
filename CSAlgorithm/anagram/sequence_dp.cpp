#include <stdio.h>
#include <string>
#include <algorithm>

using namespace std;
string str_arr;
short **res;
int main() {
	str_arr = "";
	char tmp;
	while (scanf("%c", &tmp) != EOF)
	{
		if (tmp!=' '&&tmp!='\n')
		{
			str_arr.push_back(tmp);
		}
	}
	unsigned int n = str_arr.length();
	res = new short*[n];
	for (size_t i = 0; i < n; i++)
	{
		res[i] = new short[n]();
	}
	for (int i = n - 1; i >= 0; i--)
	{
		for (unsigned int j = i; j < n; j++)
		{
			if (j==i)
			{
				res[i][j] = 1;
			}
			else {
				if (str_arr[i]==str_arr[j])
				{
					res[i][j] = res[i + 1][j - 1] + 2;
				}
				else
				{
					res[i][j] = max(res[i + 1][j], res[i][j - 1]);
				}
			}
		}
	}

	printf("I have read the rules about plagiarism punishment\n");
	printf("%hu", res[0][n-1]);
}