#!/bin/bash

cf target -o piskandar -s development

cf set-env mochi-app MOCHI_IN false

cf restart mochi-app
