#!/usr/bin/env bash

set -eu

REPORT_DIR="${TEST_REPORT_DIR:=$PWD}"

export BROWSER="${BROWSER:-chrome-headless}"
export ENVIRONMENT="${ENVIRONMENT:-build}"
export NO_CHROME_SANDBOX=true
export STACK_NAME="${CFN_StackName:-local}"
export JOURNEY_TAG=$(aws ssm get-parameter --name "/tests/${STACK_NAME}/TestTag" | jq -r ".Parameter.Value")

VALUES=$(aws ssm get-parameters-by-path --path "/tests/${STACK_NAME}/" --region eu-west-2 | jq '.Parameters[]  .Value')
IFS=$'\n' read -r -d '' -A values < <( echo "$VALUES" && printf '\0' )
declare -p values

PARAMETERS=$(aws ssm get-parameters-by-path --path "/tests/${STACK_NAME}/" --region eu-west-2 | jq '.Parameters[]  .Name' | cut -d "/" -f3 | sed 's/.$//')
IFS=$'\n' read -r -d '' -A names < <( echo "$PARAMETERS" && printf '\0' )
declare -p names

tLen=${#names[@]}
 for (( i=1; i<${tLen}; i++ ));
do
  eval $(echo "export ${names[$i]}=${values[$i]}")
done


pushd /home/gradle
gradle cucumber -P tags=${JOURNEY_TAG}
popd

cp -r /home/gradle/build/test-results "$REPORT_DIR"
