#!/bin/bash

clear

nameClassCup='ParserScriptingToJS'
nameSymCup='SymScriptingToJS'
nameLexema='LexemaScriptingToJS'

rm -f "$nameLexema.java" 

java -jar ../jflex-full-1.9.1.jar code.jflex 

rm -f "$nameClassCup.java" 
rm -f "$nameSymCup.java" 

java -jar ../java-cup-11b.jar -parser $nameClassCup -symbols $nameSymCup code.cup