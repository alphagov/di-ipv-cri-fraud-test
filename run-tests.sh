#!/usr/bin/env bash

set -eu
REPORT_DIR="${TEST_REPORT_DIR:=$PWD}"

pushd /home/gradle
## To be replaced with tag placeholder
gradle cucumber -P tags=@fraud_CRI
popd
cp -r /home/gradle/build/test-results "$REPORT_DIR"
