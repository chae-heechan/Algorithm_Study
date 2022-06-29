def solution(phone_book):
    phone_book.sort()
    for n1, n2 in zip(phone_book, phone_book[1:]):
        if n2.startswith(n1):
            return False
    return True