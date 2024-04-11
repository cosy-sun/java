#!/bin/bash

columns=$(head -n 1 ./LC194.s | wc -w);
for (( i = 1; i <= columns; i++ )); do
    awk '{print $'''$i'''}' ./LC194.s | xargs
done