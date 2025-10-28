#!/bin/bash
BASE=http://localhost:8080/api/v1
echo "Run checks:"
curl -s $BASE/health/run | jq
echo
echo "Targets:"
curl -s $BASE/health/targets | jq
