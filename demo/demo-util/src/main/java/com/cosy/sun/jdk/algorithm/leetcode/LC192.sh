#!/bin/bash

# 统计一个文本文件 words.txt 中每个单词出现的频率

cat ./LC114.java | tr -s ' ' '\n' | sort | uniq -c | sort -nr | awk '{print $2,$1}'
