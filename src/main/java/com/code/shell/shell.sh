#!/usr/bin/env bash


# 通过主机名称匹配链接数量
netstat -at | grep 'host' | wc -l
# 通过主机名称分组匹配链接数量
netstat -at | grep 'host' | awk '{print $5}' | uniq -c
# 查看网络类型
netstat -na | awk '/^tcp/ {++S[$NF]} END {for(a in S) print a, S[a]}'


# 分组统计固定格式字符出现次数
grep -o "正则表达式"  temp.txt | sort |uniq -c |sort -k1,1nr

#
cat a.txt | awk -F '|' '{print $5}' | sort

# 文件按行分割
split -l 5 super_user.txt

# 对第七列筛选后,读第六列统计
awk -F '|' '{count[$6]++;} END {for(i in count) {print i count[i]}}' test.txt
# 以第六列和第七列为分组统计第二行的累加值
awk -F '|' '{x[$6"-"$7] += $2} END {for(i in x) {print i, x[i]}}' test.txt



jstack 2702 | grep java.lang.Thread.State | awk '{print $2}' | sort | uniq -c
# 查看进程2702中线程状态统计









