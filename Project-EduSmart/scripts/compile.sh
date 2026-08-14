#!/usr/bin/env bash
set -e
rm -rf out
mkdir out
javac -d out $(find src/main/java -name "*.java")
java -cp out br.edu.edusmart.Main
