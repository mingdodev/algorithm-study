class Solution(object):
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        strx = str(x)
        l = len(strx)

        if x < 0:
            return False
        elif x == 0:
            return True
        else:
            for i in range(l//2):
                if strx[i] != strx[l-i-1]:
                    return False
            return True