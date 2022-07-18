#!/usr/bin/env bash

set -eu

REPORT_DIR="${TEST_REPORT_DIR:=$PWD}"
## To be replaced with tag placeholder
export BROWSER="${BROWSER:-chrome-headless}"
export ENVIRONMENT="${ENVIRONMENT:-build}"
export NO_CHROME_SANDBOX=true

VALUES=$(aws ssm get-parameters-by-path --path "/fraud-cri-test" --region eu-west-2 | jq '.Parameters[]  .Value')
IFS=$'\n' read -r -d '' -A values < <( echo "$VALUES" && printf '\0' )
declare -p values

PARAMETERS=$(aws ssm get-parameters-by-path --path "/fraud-cri-test" --region eu-west-2 | jq '.Parameters[]  .Name' | cut -d "/" -f3 | sed 's/.$//')
IFS=$'\n' read -r -d '' -A names < <( echo "$PARAMETERS" && printf '\0' )
declare -p names

tLen=${#names[@]}
 for (( i=1; i<${tLen}; i++ ));
do
  eval $(echo "export ${names[$i]}=${values[$i]}")
done


pushd /home/gradle
gradle cucumber -P tags=@fraud_CRI
popd

cp -r /home/gradle/build/test-results "$REPORT_DIR"
