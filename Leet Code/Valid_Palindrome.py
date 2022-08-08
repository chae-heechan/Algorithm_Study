import re


class Solution:
    def isPalindrome(self, s: str) -> bool:
        palindrome_sentence = ""
        s = s.upper()

        for i in s:
            if re.match('[A-Z0-9]', i):
                palindrome_sentence += i

        if (palindrome_sentence[::-1]) == palindrome_sentence:
            return True
        else:
            return False
