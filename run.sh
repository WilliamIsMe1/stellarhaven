#!/bin/bash

cd bin || exit
java -cp ../res/*:../bin/*:../lib/gson-2.13.1.jar:../lib/annotations-26.0.2.jar stellarhaven.Main $@
cd ..
