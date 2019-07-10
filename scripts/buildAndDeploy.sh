#!/bin/bash

(cd web/mochi && ng build --prod)

./gradlew clean build

cf target -o piskandar -s development

cf push -f manifest.yml