#!/bin/bash
kubectl apply -f mysql_volumes.yaml
kubectl apply -f postgres_volumes.yaml
kubectl apply -f deployment.yaml
kubectl apply -f service.yaml