#!/bin/bash

javac -cp src:res:lib/gson-2.13.1.jar:lib/annotations-26.0.2.jar src/stellarhaven/*.java src/stellarhaven/model/*.java src/stellarhaven/model/entity/*.java src/stellarhaven/model/entity/brain/*.java src/stellarhaven/model/entity/genetics/*.java src/stellarhaven/model/structure/*.java src/stellarhaven/util/*.java src/stellarhaven/view/*.java src/stellarhaven/view/resources/*.java src/stellarhaven/view/resources/assets/*.java src/stellarhaven/view/scene/*.java src/stellarhaven/test/*.java -d bin/
