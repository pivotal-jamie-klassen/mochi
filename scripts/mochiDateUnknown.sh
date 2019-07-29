#!/bin/bash

cf target -o piskandar -s development

cf set-env mochi-app MOCHI.KNOWNNEXTIN false

cf restart mochi-app
