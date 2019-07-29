#!/bin/bash

cf target -o piskandar -s development

cf set-env mochi-app MOCHI.KNOWNNEXTIN true

cf set-env mochi-app MOCHI.NEXTIN 2019-08-01

cf restart mochi-app
