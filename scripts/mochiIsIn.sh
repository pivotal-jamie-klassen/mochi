#!/bin/bash

cf target -o piskandar -s development

cf set-env mochi-app MOCHI_IN true

cf restart mochi-app
