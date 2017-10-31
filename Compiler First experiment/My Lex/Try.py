import re


def first_scan(file_path):
    # temporary not care about report line number of error
    # temporary not use outer defined pattern and set '#' as comments signal

    comment_signal = '#'
    with open(file_path) as f:
        for line in f:
            # delete comment
            line = line[:line.find(comment_signal)]

            # delete space
            # .# line = ' '.join(line.split(' ')) --> can't recognize tab
            line = re.sub(r'\s+', ' ', line.strip())

            # check if null
            if not line.strip():
                continue

            print line
            # revoke the second scan to get lexical analyse


if __name__ == '__main__':
    first_scan('E:\GitHub\School_Work\First experiment\Python_file_for_test.py')
