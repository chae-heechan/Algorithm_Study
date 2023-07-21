from queue import PriorityQueue
from cStringIO import StringIO

def main():
    q = PriorityQueue()
    n = int(input())

    for _ in range(n):
        q.put(input())

    file_str = StringIO()
    for _ in range(n):
        file_str.write(q.get())

    print(file_str.getvalue())

main()