package com.code.leet;

/*

You are a product manager and currently leading a team to develop a new product. Unfortunately,
the latest version of your product fails the quality check.
Since each version is developed based on the previous version,
all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one,
which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad.
Implement a function to find the first bad version.
You should minimize the number of calls to the API.

Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
 */
public class L0278FirstBadVersion {

    public int firstBadVersion(int n) {
        long l = 1;
        long r = n;

        while(l <= r) {
            long mid = (l + r) / 2;
            if (isBadVersion((int)mid)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return (int)l;
    }

    boolean isBadVersion(int n) {
        return true;
    }

    public static void main(String[] args) {
        int i = new L0278FirstBadVersion().firstBadVersion(2126753390);
        System.out.println(i);

    }


}
