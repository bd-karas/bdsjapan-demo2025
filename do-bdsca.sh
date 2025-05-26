
API_TOKEN=$TESTING_TOKEN

bash <(curl -sL https://detect.blackduck.com/detect10.sh) \
 --blackduck.url="https://sca.field-test.blackduck.com/" \
 --blackduck.api.token=$API_TOKEN \
 --detect.project.name=karas_test \
 --detect.project.version.name=test-maven01 \
  --detect.source.path="."